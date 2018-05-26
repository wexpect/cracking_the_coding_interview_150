import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RmiServerIntf extends Remote {
    public String getMessage() throws RemoteException;
    
    public int getCount() throws RemoteException;  // must add throws RemoteException, or can not compile due to Exception
    
    public void setCount(int c) throws RemoteException;    
}