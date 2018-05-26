/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author Rui
 */

public class ProducerConsumer{
    
    public static void main(String[] args){
       
        Box box = new Box();
        
        Producer p = new Producer(0, box);
        Consumer c = new Consumer(0, box);
        
        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        
        tp.start();
        tc.start();
}

}