/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class ClientReadMesThread implements Runnable{
    private int id;
    private RemoteObjectInterface shm;
    
    public ClientReadMesThread(int id, RemoteObjectInterface shm){
        this.id = id;
        this.shm = shm;
    }
    
    public void run(){
        try{
            while(true){
                //System.out.printf("Client %d: wait for message\n", id);                  
                shm.acquireMesStoC(id);

                String mes = shm.readMes(id);
                System.out.printf("\nMessage: %s\n", mes); 
                //System.out.printf("\nClient %d receives message: %s\n", id, mes);  
            }
        }
        catch(Exception e){
        }            
    }
    
}
