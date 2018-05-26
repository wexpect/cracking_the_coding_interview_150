/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumerthreadrunner;

/**
 *
 * @author Rui
 */
public class ConsumerRunnable implements Runnable{
    private ProducerAndConsumer pc;
    
    private int amount;
    
    public ConsumerRunnable(ProducerAndConsumer pc, int amount){
        this.pc = pc;
        this.amount = amount;
    }
    
    public void run(){
        try{
            pc.consume(amount);    
        }
        catch(Exception e){
        }        
    }    
}
