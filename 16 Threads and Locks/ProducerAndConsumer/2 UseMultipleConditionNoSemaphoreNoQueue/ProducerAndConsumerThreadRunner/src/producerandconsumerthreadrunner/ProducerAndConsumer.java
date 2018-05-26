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
    private int countMax;
    
    private Lock lock;
    private Condition sufficientCountCond;
    private Condition sufficientSpaceCond;
    
    public ProducerAndConsumer(){
        count = 0;
        countMax = 20;
        
        lock = new ReentrantLock();
        sufficientCountCond = lock.newCondition();
        sufficientSpaceCond = lock.newCondition();
    }
    
    public void produce(int amount) throws InterruptedException{
        lock.lock();
        
        try{
            while( count + amount > countMax){
                System.out.println("pause produce");
                sufficientSpaceCond.await();
            }
            
            count += amount;            
            System.out.println(amount +" produced");
            
            sufficientCountCond.signalAll();
        }
        finally{
            lock.unlock();
        }    
    }
    
    public void consume(int amount) throws InterruptedException{
        lock.lock();
        
        try{
            while( count < amount ){                
                System.out.println("pause consume");                
                sufficientCountCond.await();                
            }
                        
            count -= amount;            
            System.out.println(amount +" consumed");     
            
            sufficientSpaceCond.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    
}
