/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

/**
 *
 * @author Rui
 */
public class Server implements Runnable{
    
    private SharedMemory shm;
    
    public Server(SharedMemory shm){
        this.shm = shm;
    }
    
    public void run(){

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
