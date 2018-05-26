import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedMemory extends UnicastRemoteObject implements RemoteObjectInterface{  // must extends UnicastRemoteObject, or object will not be serializable
                
    private int maxClient;
    
    private boolean[] idTaken;
    private Lock idLock;
    
    private Semaphore clientInSema;
    
    
    private Semaphore[] queueStoCSema;  // Counting Semaphore is used to decide control order: After A is done, it will notify B.
    private Lock[] queueStoCLock; // Lock is used to protect shared area: either A or B can access it first, then other will wait.
    private LinkedList<String>[] queueStoC;
    
    
    private Semaphore queueCtoSSema;        
    private Lock queueCtoSLock;
    private LinkedList<Message> queueCtoS;
    
    public SharedMemory(int maxClient) throws RemoteException{
        
        this.maxClient = maxClient;

        idTaken = new boolean[maxClient];  // default is false
        idLock = new ReentrantLock();
        
        clientInSema = new Semaphore(0);
        
        
        queueStoCSema = new Semaphore[maxClient];
        for(int i = 0; i < maxClient; i++){
            queueStoCSema[i] = new Semaphore(0);        
        }          
        
        queueStoCLock = new ReentrantLock[maxClient];
        for(int i = 0; i < maxClient; i++){
            queueStoCLock[i] = new ReentrantLock();        
        }        
        
        queueStoC = new LinkedList[maxClient];
        for(int i = 0; i < maxClient; i++){
            queueStoC[i] = new LinkedList<String>();        
        }        
        
        queueCtoSSema = new Semaphore(0);                
        queueCtoSLock = new ReentrantLock();
        queueCtoS = new LinkedList<Message>();    
    }
    
    public int getID(){            
        idLock.lock();
        try{
            for( int i = 0; i < maxClient; i++){
                if (!idTaken[i]){
                    idTaken[i] = true;
                    return i;
                }
            }        
            
            return -1;
        }
        finally{
            idLock.unlock();
        }
    }
    
    public void removeID(int id){
        idLock.lock();
        try{
            idTaken[id] = false;
        }
        finally{
            idLock.unlock();
        }
    }    
    
    public void acquireClientIn() throws InterruptedException{
        clientInSema.acquire();    
    }
    
    public void releaseClientIn(){
        clientInSema.release();    
    }    
    
    public void acquireMesCtoS() throws InterruptedException{
        queueCtoSSema.acquire();    
    }
    
    public void releaseMesCtoS(){
        queueCtoSSema.release();    
    }        

    public void acquireMesStoC(int id) throws InterruptedException{
        queueStoCSema[id].acquire();    
    }
    
    public void releaseMesStoC(int id){
        queueStoCSema[id].release();    
    }            
    
    public void writeMes(int from, int to, String str) throws InterruptedException{
        queueCtoSLock.lock();
        try{
            queueCtoS.addLast( new Message(from, to , str) );
        }
        finally{
            queueCtoSLock.unlock();
        }            
    }
    
    public String readMes(int id){       
        String messageToRead = null;
        queueStoCLock[id].lock();
        try{
            if( queueStoC[id].size() == 0){
                messageToRead = null;
            }
            else{
                messageToRead = queueStoC[id].removeFirst();
            }
        }
        finally{
            queueStoCLock[id].unlock();
        }                    
        
        return messageToRead;
    }    

    public void sendMes(){
        Message mes = null;
        
        queueCtoSLock.lock();
        try{
            if( queueCtoS.size() == 0 ){
                return;
            }
            else{
                mes =  queueCtoS.removeFirst();
            }
        }
        finally{
            queueCtoSLock.unlock();
        }  
        
        int toID = mes.to;
        String messageToSend = "Client "+mes.from +": " +mes.str;
        
        if( toID == -1){ // broadcast mes            
            for(int i = 0; i < maxClient; i++){
                if( idTaken[i] && (mes.from != i) ){
                    queueStoCLock[i].lock();
                    try{
                        queueStoC[i].addLast(messageToSend);
                    }
                    finally{
                        queueStoCLock[i].unlock();
                    }
                    
                    releaseMesStoC(i);
                }
            }
        }
        else{ // private
            if( idTaken[toID] ){
                    queueStoCLock[toID].lock();
                    try{
                        queueStoC[toID].addLast(messageToSend);
                    }
                    finally{
                        queueStoCLock[toID].unlock();
                    }                    
                    
                    releaseMesStoC(toID);            
            }            
        }    
    }
        
}
