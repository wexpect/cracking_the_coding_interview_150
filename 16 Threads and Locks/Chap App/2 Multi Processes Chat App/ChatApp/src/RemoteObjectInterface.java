import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RemoteObjectInterface extends Remote {
    
    // must add throws RemoteException, or can not compile due to Exception
    
    public int getID() throws RemoteException;  
    public void removeID(int id) throws RemoteException;  
            
    public void acquireClientIn() throws RemoteException, InterruptedException;
    
    public void releaseClientIn() throws RemoteException;
    
    public void acquireMesCtoS() throws RemoteException, InterruptedException;
    
    public void releaseMesCtoS() throws RemoteException;

    public void acquireMesStoC(int id) throws RemoteException, InterruptedException;
    
    public void releaseMesStoC(int id) throws RemoteException;
    
    public void writeMes(int from, int to, String str) throws RemoteException, InterruptedException;
    
    public String readMes(int id) throws RemoteException;
            
    public void sendMes() throws RemoteException;           
        
}