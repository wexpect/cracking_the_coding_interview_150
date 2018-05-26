/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtoword;

/**
 *
 * @author Rui
 */
public class Queue{
    
    public Node head = null;
    public Node tail = null;
    
    public void enqueue(Node n){
        if( head == null){
            head = n;
            tail = head;
        }
        else{
            tail.next = n;
            tail = n;
        }
    }
    
    public Node dequeue(){
        if( head == null )
            return null;
        else{
            Node tmp = head;
            head = head.next;
            return tmp;
        }        
    }
    
    public boolean isEmpty(){
        return head == null;
    }
}
