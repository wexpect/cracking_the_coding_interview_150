/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

/**
 *
 * @author Rui
 */
public class ClientMesThread implements Runnable{
    private int id;
    private SharedMemory shm;
    
    public ClientMesThread(int id, SharedMemory shm){
        this.id = id;
        this.shm = shm;
    }
    
    public void run(){
        try{
            while(true){
                System.out.printf("Client %d: wait for message\n", id);                  
                shm.acquireMesStoC();

                String mes = shm.readMes();
                System.out.printf("Client %d: receive Message: %s\n", id, mes);  
            }
        }
        catch(InterruptedException e){
        }            
    }
    
}
