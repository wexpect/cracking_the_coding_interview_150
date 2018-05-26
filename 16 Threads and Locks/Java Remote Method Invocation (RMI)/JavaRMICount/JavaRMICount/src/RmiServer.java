import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
 
public class RmiServer extends UnicastRemoteObject implements RmiServerIntf {
    public static final String MESSAGE = "Hello world";
    
    public int count = 0;
    
 
    public RmiServer() throws RemoteException {
    }
 
    public String getMessage() {
        return MESSAGE;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int c){
        count = c;
    }
    
 
    public static void main(String args[]) {
        System.out.println("RMI server started");
 
        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
            System.out.println("Security manager installed.");
        } else {
            System.out.println("Security manager already exists.");
        }
 
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
 
        try {
            //Instantiate RmiServer
            RmiServer obj = new RmiServer();
 
            // Bind this object instance to the name "RmiServer"
            Naming.rebind("//localhost/RmiServer", obj);
 
            System.out.println("PeerServer bound in registry");
            

            while(true){
                Thread.sleep(1000);
                System.out.println("count = "+ obj.getCount());
//                for(int i = 0; i < 100000; i++){
//                    for(int j = 0; j < 100000; j++){
//                        System.out.println("count = "+ obj.getCount());
//                    }
//                }        
            }
        
        } catch (Exception e) {
            System.err.println("RMI server exception:" + e);
            e.printStackTrace();
        }
        
        

        
    }
}