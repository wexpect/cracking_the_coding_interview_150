/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author Rui
 */
public class Box{
    private Queue<String> q;
    private Lock lock;          
    
    public Box(){
        int queueCapacity = 5;
        q = new Queue<String>(queueCapacity);
        
        lock = new ReentrantLock();
    }

    public boolean write(String mes){
        lock.lock();
        boolean result = false;
        
        try{
            if( ! q.isFull() ){
                q.enqueue(mes);
                result = true;
            }        
        }
        finally{
            lock.unlock();
        }
        
        return result;
    }

    public String read(){
        lock.lock();
        String mes = null;
        try{
            if( !q.isEmpty() ){
                mes = q.dequeue();
            }            
        }
        finally{
            lock.unlock();
        }
        
        return mes;    
    }
    
}
