/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerwithcondition;

import java.util.Random;

/**
 *
 * @author Rui
 */
public class Consumer implements Runnable{

    private int ID;
    private int count;
    private Box box;
    private static final int basicWait = 1;

    public Consumer(int ID, Box box){
        this.ID = ID;
        count = 0;
        this.box = box;
    }
    
    public void run(){
        try{
            Random rg = new Random();
            
            while(true){
                
                System.out.println("C "+ID+" tries to read mes"); 
                String mes = box.read();
                
                System.out.println("C "+ID+" succeed to read mes.");                  
                
                processMes(mes);
                
                int waitTime = rg.nextInt(2) +  basicWait;
                System.out.println("C "+ID+" waits "+ waitTime +" secs.");                  
                Thread.sleep(waitTime * 1000);                        
            }
        }
        catch(InterruptedException e){
        }
    }
    
    public void processMes(String mes){
        count++;
        System.out.printf("\nC %d consumes message: %s \n\n", ID, mes);
    } 
}
