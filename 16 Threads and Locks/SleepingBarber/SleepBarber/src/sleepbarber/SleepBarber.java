/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepbarber;

/**
 *
 * @author Rui
 */
public class SleepBarber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numCustomer = 10;
        int numSeat = 4;
                
        Shop shop = new Shop(numCustomer, numSeat);
        Runnable b = new Barber(shop);
        Thread tb = new Thread(b);
        tb.start();
        
        Runnable[] c = new Runnable[numCustomer];
        Thread[] tc = new Thread[numCustomer];
        for(int i = 0; i < numCustomer; i++){
            c[i] = new Customer(i, shop);
            tc[i] = new Thread( c[i] );
            tc[i].start();
        }
    }
}
