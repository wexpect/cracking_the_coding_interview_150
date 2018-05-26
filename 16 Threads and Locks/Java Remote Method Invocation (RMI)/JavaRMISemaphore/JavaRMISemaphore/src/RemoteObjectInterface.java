import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RemoteObjectInterface extends Remote {
    
    // must add throws RemoteException, or can not compile due to Exception
    
    public void acquireClientIn() throws RemoteException, InterruptedException;
    
    public void releaseClientIn() throws RemoteException;
    
    public void acquireMesCtoS() throws RemoteException, InterruptedException;
    
    public void releaseMesCtoS() throws RemoteException;

    public void acquireMesStoC() throws RemoteException, InterruptedException;
    
    public void releaseMesStoC() throws RemoteException;
    
    public void writeMes(String m) throws RemoteException, InterruptedException;
    
    public String readMes() throws RemoteException, InterruptedException;
    
    public int getID() throws RemoteException;  
        
}