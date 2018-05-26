import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;
 
public class Client { 

    private RemoteObjectInterface shm = null; 
 
    private int id;
       
    public Client(){
        try { 
           shm = (RemoteObjectInterface)Naming.lookup("//localhost/SharedMemory");
            
           id = shm.getID();
                           
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

                System.out.printf("Client %d enters message:", id);
                Scanner s = new Scanner(System.in);
                String mes = s.nextLine();
                
            
                System.out.printf("Tring to send message ...\n");                
                shm.writeMes(mes);
                System.out.printf("Message sent. Release MesCtoS\n");
                shm.releaseMesCtoS();
            
            }
            
        }
        catch(Exception e){
        }        
    }    

         
}