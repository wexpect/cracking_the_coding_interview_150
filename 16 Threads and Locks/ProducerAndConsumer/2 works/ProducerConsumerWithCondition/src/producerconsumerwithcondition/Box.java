/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerwithcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author Rui
 */
public class Box{
    private Queue<String> q;
    private Lock lock;          
    private Condition mesInCond;
    private Condition mesOutCond;
    
    public Box(){
        int queueCapacity = 5;
        q = new Queue<String>(queueCapacity);
        
        lock = new ReentrantLock();
        mesInCond = lock.newCondition();
        mesOutCond = lock.newCondition();
    }

    public boolean write(String mes) throws InterruptedException{
        lock.lock();
        boolean result = false;
        
        try{            
            while( q.isFull() ){
                System.out.println("P finds queue is full, await mesOutCond");                   
                mesOutCond.await(); // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()
            }
            
            q.enqueue(mes);            
            mesInCond.signalAll();  // To use await() and signalAll()s, you must put them between their corresponding lock() and unlock()
            System.out.println("P writes to queue, signallAll mesInCond");                   
            
            result = true;
                    
        }
        finally{
            lock.unlock();
        }
        
        return result;
    }

    public String read() throws InterruptedException{
        lock.lock();
        String mes = null;
        try{
            
            while( q.isEmpty() ){
                System.out.println("C finds queue is empty, await mesInCond");    
                mesInCond.await();  // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()          
            }
            
            mes = q.dequeue();    
            mesOutCond.signalAll(); // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()
            System.out.println("C reads from queue, signallAll mesOutCond");   
        }
        finally{
            lock.unlock();
        }
        
        return mes;    
    }
    
}
