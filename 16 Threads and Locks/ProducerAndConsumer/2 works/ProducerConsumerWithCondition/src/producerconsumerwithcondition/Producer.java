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
public class Producer implements Runnable{

    private int ID;
    private int count;
    private Box box;
    private static final int basicWait = 1;

    public Producer(int ID, Box box){
        this.ID = ID;
        count = 0;
        this.box = box;
    }
    
    public void run(){
        try{
            Random rg = new Random();
            
            while(true){
                String mes = generateMes();
                System.out.println("P "+ID+" tries to write Mes "+count);
                
                box.write(mes);                                
            
                int waitTime = rg.nextInt(2) +  basicWait;
                System.out.println("P "+ID+" succeeds to write Mes "+count+", wait "+ waitTime +" secs.");                
                Thread.sleep(waitTime * 1000);                        
            }
        }
        catch(InterruptedException e){
        }
    }

    public String generateMes(){
        count++;
        System.out.printf("P "+ ID +" produces Mes "+ count+"\n");
        return "P "+ ID +"'s Mes "+ count;
    }    
}