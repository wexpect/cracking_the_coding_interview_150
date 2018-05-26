import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedMemory extends UnicastRemoteObject implements RemoteObjectInterface{  // must extends UnicastRemoteObject, or object will not be serializable
                
    private int maxClient;
    
    private boolean[] idTaken;
    private Lock idLock;
    
    private Semaphore clientInSema;
    
    
    private Semaphore[] mesStoCSema;
    private String[] mesStoC;
    
    
    private Semaphore mesCtoSSema;
        
    private Semaphore queueCtoSSema;
    private Message mesCtoS;            
    
    public SharedMemory(int maxClient) throws RemoteException{
        
        this.maxClient = maxClient;

        idTaken = new boolean[maxClient];  // default is false
        idLock = new ReentrantLock();
        
        clientInSema = new Semaphore(0);
        
        
        mesStoCSema = new Semaphore[maxClient];
        for(int i = 0; i < maxClient; i++){
            mesStoCSema[i] = new Semaphore(0);        
        }        
        
        mesStoC = new String[maxClient];
        
        
        mesCtoSSema = new Semaphore(0);
                
        queueCtoSSema = new Semaphore(1);
        mesCtoS = new Message();        
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
        mesCtoSSema.acquire();    
    }
    
    public void releaseMesCtoS(){
        mesCtoSSema.release();    
    }        

    public void acquireMesStoC(int id) throws InterruptedException{
        mesStoCSema[id].acquire();    
    }
    
    public void releaseMesStoC(int id){
        mesStoCSema[id].release();    
    }            
    
    public void writeMes(int from, int to, String str) throws InterruptedException{
        queueCtoSSema.acquire();
        mesCtoS = new Message(from, to, str);
        queueCtoSSema.release();
    }
    
    public String readMes(int id){                
        return mesStoC[id];                        
    }    

    public void sendMes(){
        Message mes = mesCtoS;
        int toID = mes.to;
        
        if( toID == -1){ // broadcast mes
            for(int i = 0; i < maxClient; i++){
                if( idTaken[i] && (mes.from != i) ){
                    mesStoC[i] = "Client "+mes.from +": " +mes.str;
                    releaseMesStoC(i);
                }
            }
        }
        else{ // private
            if( idTaken[toID] ){
                    mesStoC[toID] = "Client "+mes.from +": " +mes.str;
                    releaseMesStoC(toID);            
            }            
        }    
    }
        
}
