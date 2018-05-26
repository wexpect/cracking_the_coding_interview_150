/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerwithcondition;

/**
 *
 * @author Rui
 */
public class Queue<T>{
    
    public Node<T> head = null;
    public Node<T> tail = null;
    
    public int capacity;
    public int count;
    
    public Queue(int capacity){
        this.capacity = capacity;
    }
    
    public void enqueue(T obj){
        count++;
        
        Node<T> n = new Node<T>(obj);
        
        if( head == null){
            head = n;
            tail = head;        
        }
        else{
            tail.next = n;
            tail = n;
        }    
    }
    
    public boolean isFull(){
        return (count >= capacity);
    }
    
    public T dequeue(){             
        if( head != null){                    
            count--;
            
            T tmp = head.data;
            head = head.next;
            return tmp;        
        }
        else
            return null;            
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
}
