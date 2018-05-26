package runmethodsinorder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Rui
 */
public class FooWithoutFlag{
    private Lock lock2;
    private Lock lock3;

    private Condition method2ToGoCond;
    private Condition method3ToGoCond;
    
    public FooWithoutFlag(){

        lock2 = new ReentrantLock();
        lock3 = new ReentrantLock();

        method2ToGoCond = lock2.newCondition();
        method3ToGoCond = lock3.newCondition();
    }
    
    public void first(){
        System.out.println("first() runs");

        lock2.lock();
        method2ToGoCond.signalAll();    // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()
        lock2.unlock();

        System.out.println("first() signalAll second()");        
    }
    
    public void second() throws InterruptedException{
        lock2.lock();
        try{
            System.out.println("second() await");
            method2ToGoCond.await();  // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()            
            
            System.out.println("second() runs");
            
            lock3.lock();
            method3ToGoCond.signalAll();  // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()                            
            lock3.unlock();
            
            System.out.println("second() signalAll third()");
        }
        finally{
            lock2.unlock();
        }    
       
        
    }
    
    public void third() throws InterruptedException{
        lock3.lock();
        try{
            System.out.println("third() await");
            method3ToGoCond.await(); // To use await() and signalAll(), you must put them between their corresponding lock() and unlock()            
            
            System.out.println("third() runs");            
        }
        finally{
            lock3.unlock();
        }
    
    }

}