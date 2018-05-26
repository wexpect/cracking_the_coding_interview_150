/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalqueue;

/**
 *
 * @author Rui
 */
public class Queue {
    private Node head;
    private Node tail;

    
    
    public void enqueue(Animal element, int t){        
        Node n = new Node(element, t);
        
        if( head == null){
            head = n;
            tail = head;
        }
        else{
            tail.next = n;
            tail = n;
        }
    }
    
    public Animal dequeue(){
        if( head != null){
            Animal tmp = head.data;
            head = head.next;
            return tmp;
        }
        else 
            return null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public Node peek(){
        if( head != null)
            return head;
        else
            return null;
    
    }
    
    public void printQ(){
        Node n = head;
        System.out.print("Queue: ");
        while(n != null){
            System.out.print(n.data.id + " ");
            n = n.next;
        }
        System.out.println();        
    }
    
    
    
    
    
}
