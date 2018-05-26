/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepbarber;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Rui
 */
public class Shop{
    private int numCustomer;
    private int count;
    
    private Semaphore seat;
    private Semaphore chair;
    private Semaphore barber;
    private Semaphore haircut;
    
    public Shop(int numCus, int numSeat){
        numCustomer = numCus;
        count = 0;
        
        seat = new Semaphore(numSeat);
        chair = new Semaphore(1);
        barber = new Semaphore(0);
        haircut = new Semaphore(0);
    }
    
    public void getSeat() throws InterruptedException{
        seat.acquire();
    }
    
    public void getChair() throws InterruptedException{
        chair.acquire();
        seat.release();
    }    
    
    public void getBarber() throws InterruptedException{
        barber.release();
    }    
    
    public void getHaircut() throws InterruptedException{
        haircut.acquire();
        chair.release();
    }
    
    public void waitCustomer() throws InterruptedException{
        barber.acquire();
    }
     
    public void cutHair() throws InterruptedException{        
        Random rg = new Random();
        int cutTime = rg.nextInt(3)+1;
        System.out.printf("Barber wake up and will cut hair for %d sec\n", cutTime);        
        Thread.sleep( cutTime * 1000 );
        haircut.release();
        count++;
    }     
    
    public boolean doneWithAllCustomer(){
        return (count >= numCustomer);    
    }


}