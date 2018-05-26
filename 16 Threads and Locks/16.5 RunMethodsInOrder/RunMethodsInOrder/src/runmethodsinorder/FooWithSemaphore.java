/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runmethodsinorder;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Rui
 */

public class FooWithSemaphore{

    Semaphore sema2;
    Semaphore sema3;
    
    public FooWithSemaphore(){
        sema2 = new Semaphore(0);
        sema3 = new Semaphore(0);
    }
    
    public void first(){
        System.out.println("first() runs");
        
        System.out.println("first() releases sema2");
        sema2.release();    
    }
    
    public void second() throws InterruptedException{
        System.out.println("second() waits for sema2");
        sema2.acquire();
        
        System.out.println("second() acquires sema2, and runs");
        
        System.out.println("second() releases sema3");
        sema3.release();    
    }    

    public void third() throws InterruptedException{
        System.out.println("third() waits for sema3");
        sema3.acquire();
        
        System.out.println("third() acquires sema3, and runs");        
    }    
    
}
