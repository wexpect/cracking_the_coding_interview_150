/*
 * To change this template, choose Tools | Templates
 * and open Hthe template in the editor.
 */
package depthfirstsearch;

/**
 *
 * @author Rui
 */
public class Queue {
    private ListNode head;
    private ListNode tail;

    
    
    public void enqueue(Node graphNode){        
        ListNode n = new ListNode(graphNode);
        
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
        if( head != null){
            Node tmp = head.data;
            head = head.next;
            return tmp;
        }
        else 
            return null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public ListNode peek(){
        if( head != null)
            return head;
        else
            return null;
    
    }
    
    public void printQ(){
        ListNode n = head;
        System.out.print("Queue: ");
        while(n != null){
            System.out.print(n.data + " ");
        }
        System.out.print(" End.\n");        
    }
    
    
    
    
    
}
