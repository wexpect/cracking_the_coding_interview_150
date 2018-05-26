/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myqueuewithtwostacks;

/**
 *
 * @author Rui
 */


public class MyQueueWithTwoStacks{

    private Stack s1 = new Stack();
    private Stack s2 = new Stack();
    
    public static void main(String[] args) throws Exception{
        
        MyQueueWithTwoStacks mq = new MyQueueWithTwoStacks();
        
        mq.printQueue();
        
        mq.enqueue(1);
        mq.printQueue();
        
        mq.enqueue(2);
        mq.printQueue();

        mq.enqueue(3);
        mq.printQueue();

        mq.dequeue();
        mq.printQueue();
        
        mq.dequeue();
        mq.printQueue();        
        
        mq.enqueue(4);
        mq.printQueue();        
        
        mq.dequeue();
        mq.printQueue();
        
        mq.dequeue();
        mq.printQueue();        
        

    }

    public void enqueue(int element){
        s1.push(element);
    }
    
    public int dequeue() throws Exception{
        if( s2.isEmpty() ){
            while( !s1.isEmpty() ){
                s2.push( s1.pop() );
            }
        }
        
        return s2.pop();
    }
    
    public void printQueue(){
        System.out.println("\nQueue:");
        s1.printStack();
        s2.printStack();        
    }
    
}