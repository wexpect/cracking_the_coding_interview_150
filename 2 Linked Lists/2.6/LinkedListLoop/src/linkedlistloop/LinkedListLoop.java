/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistloop;

import java.util.HashSet;

/**
 *
 * @author Rui
 */

public class LinkedListLoop{
   
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args){
        // TODO code application logic here
        
        Node n7 = new Node(7, null);   
        
        Node n6 = new Node(6, n7);        
        
        Node n5 = new Node(5, n6);
        
        Node n4 = new Node(4, n5);
                
        Node n3 = new Node(3, n4);
        
        Node n2 = new Node(4, n3);
        
        Node n1 = new Node(1, n2);        
        
        n7.next = n4;
        
        
        LinkedListLoop listLoop = new LinkedListLoop();      
        
        Node beginNode = listLoop.findLoopNode(n1);
        if( beginNode != null )
            System.out.println( beginNode.data );
        else
            System.out.println("No loop");
        
        System.out.println( listLoop.checkLoop(n1) );        
    }
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }    
    
    // Solu 1: hash table
    public Node findLoopNode(Node head){
        
        HashSet<Node> hashSet = new HashSet<Node>();
        
        Node n = head;
        
        while( n != null ){

            System.out.println( n.data + " " + n + " "+ n.hashCode() );            
            
            if( hashSet.contains(n) )
                return n;
            else{
                hashSet.add( n );
                n = n.next;
            }
        }
        
        return null;        
    }
    
    
    // Solu 2: only check if loop exist, can not return the node at beginning of loop
    public boolean checkLoop(Node head){
        Node fastPointer = head;
        Node slowPointer = head;
        int count = 0;
        
        while(fastPointer.next != null){
            fastPointer = fastPointer.next;
            count++;
            
            if( slowPointer == fastPointer )
                return true;                
                         
            if( count == 2){
                slowPointer = slowPointer.next;
                count = 0;
            }
        }
        return false;
    }
}

