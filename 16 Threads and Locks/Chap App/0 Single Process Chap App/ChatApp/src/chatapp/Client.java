/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rui
 */
public class Client implements Runnable {
    private int id;
    private SharedMemory shm;
    
    public Client(int id, SharedMemory shm){
        this.id = id;
        this.shm = shm;
    }
    
    public void run(){
        try{
            System.out.printf("Client %d: start\n", id);
            shm.releaseClientIn();
            
            Runnable cmr = new ClientMesThread(id, shm);
            Thread cmt = new Thread( cmr);
            cmt.start();    

            while(true){
                // Solu 1
//                Random rg = new Random();
//                int waitTime = rg.nextInt(4)+1;
//                Thread.sleep(waitTime * 1000);                
//                String mes = "Message: Client "+id +"'s info";
                
                // Solu 2
                System.out.printf("Client %d: enter message:\n", id);
                Scanner s = new Scanner(System.in);
                String mes = s.nextLine();
                
            
                
                System.out.printf("Client %d: tries to send message %s\n", id, mes);                
                shm.writeMes(mes);
                System.out.printf("Client %d: succeed sending message, and release MesCtoS\n", id);
                shm.releaseMesCtoS();
            
            }
            
        }
        catch(InterruptedException e){
        }        
    }
}
