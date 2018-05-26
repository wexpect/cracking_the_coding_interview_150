/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumerthreadrunner;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Rui
 */
public class ProducerAndConsumer {
    private int count;
    
    private Lock lock;
    private Condition cond;
    
    public ProducerAndConsumer(){
        count = 0;
        
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    
    public void produce(int amount){
        lock.lock();
        
        try{
            count += amount;            
            System.out.println(amount +" produced");
            
            cond.signalAll();
        }
        finally{
            lock.unlock();
        }    
    }
    
    public void consume(int amount) throws InterruptedException{
        lock.lock();
        
        try{
            while( count < amount ){
                cond.await();
                System.out.println(amount +" get lock");                
            }
                        
            count -= amount;            
            System.out.println(amount +" consumed");            
        }
        finally{
            lock.unlock();
        }
    }
    
}
