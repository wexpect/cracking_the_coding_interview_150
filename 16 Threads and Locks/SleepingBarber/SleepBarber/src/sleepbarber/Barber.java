/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepbarber;

/**
 *
 * @author Rui
 */
public class Barber implements Runnable{

    private Shop shop;
    
    public Barber(Shop s){
        shop = s;
    }

    public void run(){
        try{
            while( ! shop.doneWithAllCustomer() ){
                System.out.println("Barber is sleeping");
                shop.waitCustomer();

                shop.cutHair();
                System.out.println("Barber is done with one customer, go back to sleep");
            }        
            
            System.out.println("Barber is done with all customers, go home");
        }
        catch(InterruptedException e){
        }
    }
    
}