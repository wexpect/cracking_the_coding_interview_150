/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

/**
 *
 * @author Rui
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        SharedMemory shm = new SharedMemory();
        
        Runnable sr = new Server(shm);
        Thread st = new Thread(sr);
        st.start();
        
        Thread.sleep(1000);
        
        Runnable cr0 = new Client(0, shm);
        Thread ct0 = new Thread(cr0);
        ct0.start();

//        Runnable cr1 = new Client(1, shm);
//        Thread ct1 = new Thread(cr1);
//        ct1.start();        
    }
}
