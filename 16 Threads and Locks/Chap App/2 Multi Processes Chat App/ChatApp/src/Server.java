/*

javac Server.java
 	rmic RmiServer (No need since Java 5.0, used before Java 5.0)

java -Djava.security.policy=no.policy Server  ( java -Djava.security.policy=server.policy Server )
 

javac Client.java

java -Djava.security.policy=no.policy Client (java -Djava.security.policy=client.policy Client)


If does not connect, try
    no.policy

 */


import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.*; 
 

public class Server{
    
    private SharedMemory shm;
    
    public Server(SharedMemory shm){
        this.shm = shm;
    }
    

    public static void main(String args[]) {
        System.out.println("Server starts");
 
        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
            System.out.println("Security manager installed.");
        } 
        else {
            System.out.println("Security manager already exists.");
        }
 
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);   //default regsitry runs on TCP port 1099
            System.out.println("java RMI registry created.");
        } 
        catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
 
        
        try {
            //String serverIP = "129.25.36.245";  // ip of Drexel desktop, works
            String serverIP = "localhost";
            
            int maxClient = 10;
            
            //Instantiate shm
            SharedMemory shm = new SharedMemory(maxClient);
            System.out.println("Create shm");            
                        
            // Bind this object instance to the name "RmiServer"
            //Naming.rebind("//localhost/SharedMemory", shm);
            //Naming.rebind("//129.25.36.245/SharedMemory", shm);
            Naming.rebind("//"+ serverIP +"/SharedMemory", shm);
            
            System.out.println("shm bound in registry");


            Server server = new Server(shm);
            server.connectThread();
        } 
        catch (Exception e) {
            System.err.println("Server exception:" + e);
            e.printStackTrace();
        }
    }
    
    
    public void connectThread(){

        try{
            System.out.println("Server: start");
            
            Runnable smr = new ServerMesThread(shm);
            Thread smt = new Thread( smr);
            smt.start();            
            
            
            while( true ){
                System.out.println("Server: wait for new client");
                shm.acquireClientIn();
                System.out.println("Server: new client is in");
            }


        }
        catch(InterruptedException e){
        }
    }    
    
    
}