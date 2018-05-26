/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class ServerMesThread implements Runnable{
    private SharedMemory shm;
    
    public ServerMesThread(SharedMemory shm){
        this.shm = shm;
    }    
    
    public void run(){
        try{
            while(true){
                //System.out.println("Server: wait for new message");
                shm.acquireMesCtoS();            
                System.out.println("Server: new message come in, broadcast message (release MesStoC)");

                shm.releaseMesStoC();
            }
        }
        catch(InterruptedException e){
        }
    }    
}
