/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepbarber;

import java.util.Random;

/**
 *
 * @author Rui
 */
public class Customer implements Runnable{
    
    private int id;
    private Shop shop;
    
    
    public Customer(int ID, Shop s){
        id = ID;
        shop = s;
    }
    
    public void run(){
        try{                                
            Random rg = new Random();
            int walkTime = rg.nextInt(5)+1;
            System.out.printf("Customer %d leaves home, will take %d secs to arrive\n", id, walkTime);
            Thread.sleep( walkTime * 1000 );
        
            System.out.printf("Customer %d arrives, waiting seat\n", id);
            shop.getSeat();

            System.out.printf("Customer %d gets seat, waiting chair\n", id);
            shop.getChair();

            System.out.printf("Customer %d gets chair, releases seat, call barber\n", id);
            shop.getBarber();
            
            System.out.printf("Customer %d gets barber, start to cut\n", id);
            shop.getHaircut();
            
            System.out.printf("Customer %d finishes cut, release chair\n", id);
        }
        catch(InterruptedException e){
        }        
    }



}