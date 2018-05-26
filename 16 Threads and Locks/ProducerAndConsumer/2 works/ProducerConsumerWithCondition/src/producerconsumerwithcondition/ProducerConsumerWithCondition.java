/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerwithcondition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class ProducerConsumerWithCondition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Solu 1:

        // the object must be final here, so that Thread can use it.
        
//        final Box box = new Box();        
        
//        new Thread(){
//            @Override
//            public void run(){
//                while(true){
//                    try {
//                        box.write(" ");
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ProducerConsumerWithCondition.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }.start();
//        
//        new Thread(){
//            @Override
//            public void run(){
//                while(true){
//                    try {
//                        box.read();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ProducerConsumerWithCondition.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }.start();        
        

        // Solu 2:
        
        Box box = new Box();
        
        Producer p = new Producer(0, box);
        Consumer c = new Consumer(0, box);
        
        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        
        tp.start();
        tc.start();
    }
}
