import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;


public class SharedMemory extends UnicastRemoteObject implements RemoteObjectInterface{  // must extends UnicastRemoteObject, or object will not be serializable
    
    private Semaphore clientIn;
    private Semaphore mesCtoS;
    private Semaphore mesStoC;
    
    private Semaphore mesSema;
    private String mes;
    
    
    public int currentID;    
    
    public SharedMemory() throws RemoteException{
        clientIn = new Semaphore(0);
        mesCtoS = new Semaphore(0);
        mesStoC = new Semaphore(0);
        
        mesSema = new Semaphore(1);
        mes = null;
        
        currentID = 0;
    }
    
    public void acquireClientIn() throws InterruptedException{
        clientIn.acquire();    
    }
    
    public void releaseClientIn(){
        clientIn.release();    
    }    
    
    public void acquireMesCtoS() throws InterruptedException{
        mesCtoS.acquire();    
    }
    
    public void releaseMesCtoS(){
        mesCtoS.release();    
    }        

    public void acquireMesStoC() throws InterruptedException{
        mesStoC.acquire();    
    }
    
    public void releaseMesStoC(){
        mesStoC.release();    
    }            
    
    public void writeMes(String m) throws InterruptedException{
        mesSema.acquire();
        mes = m;
        mesSema.release();
    }
    
    public String readMes() throws InterruptedException{                
        mesSema.acquire();
        String m = mes;                        
        mesSema.release();
        return m;
    }
    

    
    public int getID(){
        currentID++;
        return currentID;
    }
    
}
