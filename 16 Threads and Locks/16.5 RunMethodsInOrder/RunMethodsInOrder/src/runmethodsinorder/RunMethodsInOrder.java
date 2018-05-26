/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runmethodsinorder;

/**
 *
 * @author Rui
 */
public class RunMethodsInOrder{

    public static void main(String[] args) throws InterruptedException{
        
        // Solu 1:
//        Foo f = new Foo();
//
//        Runnable r1 = new MyRunnable(f, 1);
//        Runnable r2 = new MyRunnable(f, 2);
//        Runnable r3 = new MyRunnable(f, 3);
        
        
        // Solu 2: better than Solu 1
//        FooWithoutFlag f = new FooWithoutFlag();        
//        
//        Runnable r1 = new MyRunnable2(f, 1);
//        Runnable r2 = new MyRunnable2(f, 2);
//        Runnable r3 = new MyRunnable2(f, 3);        
        
        
        // Solu 3: I like this most
        FooWithSemaphore f = new FooWithSemaphore();        
        
        Runnable r1 = new MyRunnable3(f, 1);
        Runnable r2 = new MyRunnable3(f, 2);
        Runnable r3 = new MyRunnable3(f, 3);   
        
        
        
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        
        t3.start();
        
        Thread.sleep(1000);
        t2.start();
        
        Thread.sleep(1000);
        t1.start();

    }

}