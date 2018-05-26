/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerinonefile;

/**
 *
 * @author Rui
 */
public class ProducerConsumerInOnefile {

    private int count = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // the object must be final here, so that Thread can use it.
        
        final ProducerConsumerInOnefile pcio = new ProducerConsumerInOnefile();
         
        
         new Thread() {
            public void run(){
                while(true)
                    pcio.produce();
            }
        }.start();

         
         class CThread extends Thread{
            public void run(){
                while(true)
                    pcio.consume();
            }
         } 
         
         Thread cThread = new CThread();
         cThread.start();
         
    }
    
    public void produce(){
        count++;          
        System.out.println("++");
    }
    
    public void consume(){
        count--;
        System.out.println("--");        
    }    
    
}
