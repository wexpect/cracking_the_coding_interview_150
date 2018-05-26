import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
 
public class RmiClient { 
    // "obj" is the reference of the remote object
    RmiServerIntf obj = null; 
 
    
    public static void main(String args[]) throws RemoteException {
        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
 
        RmiClient cli = new RmiClient();
 
        try{
        
        System.out.println(cli.getMessage());
        
        Thread.sleep(5000);
        
        
        System.out.println(" count = " + cli.getCountValue() );                
        Thread.sleep(5000);
        
        
        int newCount = 10;
        cli.setCountValue(newCount);
        System.out.println(" count set to " + newCount );
        Thread.sleep(5000);
        
        
        
        System.out.println(" count = " + cli.getCountValue() );
        Thread.sleep(5000);
        
        
        
        newCount = 20;
        cli.setCountValue(newCount);
        System.out.println(" count set to " + newCount );
        Thread.sleep(5000);
        
        
        System.out.println(" count = " + cli.getCountValue() );        
        Thread.sleep(5000);
        
        }
        catch (Exception e) {
            
        }
        
        
    }    
    
    
    public String getMessage() { 
        try { 
            obj = (RmiServerIntf)Naming.lookup("//localhost/RmiServer");
            return obj.getMessage(); 
        } catch (Exception e) { 
            System.err.println("RmiClient exception: " + e); 
            e.printStackTrace(); 
 
            return e.getMessage();
        } 
    }
    
    public int getCountValue() throws RemoteException{
        return obj.getCount();    
    }
    
    public void setCountValue(int c) throws RemoteException{
        obj.setCount(c);
    }
         

}