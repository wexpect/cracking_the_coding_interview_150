/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumerthreadrunner;

/**
 *
 * @author Rui
 */
public class ProducerRunnable implements Runnable{
    private ProducerAndConsumer pc;
            
    private int amount;
    
    public ProducerRunnable(ProducerAndConsumer pc, int amount){
        this.pc = pc;
        this.amount = amount;        
    }
    
    public void run(){
        pc.produce(amount);    
    }
}
