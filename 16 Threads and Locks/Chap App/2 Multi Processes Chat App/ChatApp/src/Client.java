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
import java.util.Scanner;
 
public class Client { 

    private RemoteObjectInterface shm = null; 
 
    private int id;
       
    public Client(){
        try { 
            
            //String serverIP = "129.25.36.245"; // ip of Drexel desktop, works
            String serverIP = "localhost";
            
           //shm = (RemoteObjectInterface)Naming.lookup("//localhost/SharedMemory");
           //shm = (RemoteObjectInterface)Naming.lookup("//129.25.36.245/SharedMemory"); 
           shm = (RemoteObjectInterface)Naming.lookup("//"+ serverIP +"/SharedMemory"); 
            
           
           id = shm.getID();
           
           if( id == -1 ){
               System.out.println( "Chat room is full. Exit.");
               System.exit(0);
           }           
                           
            System.out.println( "Client "+id+" is connected." );            
        } 
        catch (Exception e) { 
           System.err.println("Client exception: " + e); 
           e.printStackTrace(); 
            
           System.out.println( e.getMessage() ); 
        }         

    }
    
    
    public static void main(String args[]) throws RemoteException {
        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
 
        Client client = new Client();
 
        client.writeMesThread();                
    }    
    

    public void writeMesThread(){
        try{
            Runnable clientReadRunnable = new ClientReadMesThread(id, shm);
            Thread clientReadThread = new Thread( clientReadRunnable);
            clientReadThread.start();    
            
            
            System.out.printf("Client %d release ClientIn\n", id);
            shm.releaseClientIn();
            

            while(true){
                Scanner s = new Scanner(System.in);  
                
                // Solu 1:
                System.out.printf("toClientID message:");                
                int toID = s.nextInt();                
                String str = s.nextLine();
                                                
                // Solu 2:
//                System.out.printf("To client:", id);                
//                int toID = s.nextInt();                
//                                
//                s.nextLine(); // This line consumes the \n character from the above input
//                
//                System.out.printf("\nEnter message:");                
//                String str = s.nextLine();
                
     
                if( str.trim().equals("exit") ){                    
                    shm.removeID(id);
                    System.out.println("Remove ID. Exit.");
                    System.exit(0);
                }
                
            
                //System.out.printf("Tring to send message ...\n");                
                shm.writeMes(id, toID, str);
                //System.out.printf("Message sent. Release MesCtoS\n");
                shm.releaseMesCtoS();
            
            }
            
        }
        catch(Exception e){
            System.err.println("Client exception:" + e);
            e.printStackTrace();
        }        
    }    

         
}