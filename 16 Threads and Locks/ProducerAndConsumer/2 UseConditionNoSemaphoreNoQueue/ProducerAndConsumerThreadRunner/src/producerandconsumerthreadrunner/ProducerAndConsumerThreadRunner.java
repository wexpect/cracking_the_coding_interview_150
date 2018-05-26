/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumerthreadrunner;

/**
 *
 * @author Rui
 */
public class ProducerAndConsumerThreadRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ProducerAndConsumer pc = new ProducerAndConsumer();
        
        Runnable prodRunnable = new ProducerRunnable(pc, 6);
        
        Runnable consu1Runnable = new ConsumerRunnable(pc, 10);
        Runnable consu2Runnable = new ConsumerRunnable(pc, 5);
        
        Thread prodThread = new Thread( prodRunnable );
        
        Thread consu1Thread = new Thread( consu1Runnable );
        Thread consu2Thread = new Thread( consu2Runnable );
        
        consu1Thread.start();
        consu2Thread.start();
        
        Thread.sleep(1000);
        
        prodThread.start();
        
        Thread.sleep(1000);
        
        prodRunnable = new ProducerRunnable(pc, 10);
        prodThread = new Thread( prodRunnable );
        prodThread.start();
    }
}
