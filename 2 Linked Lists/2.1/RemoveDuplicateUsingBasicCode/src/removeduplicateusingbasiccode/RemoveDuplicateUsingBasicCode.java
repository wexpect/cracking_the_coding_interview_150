/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicateusingbasiccode;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Rui
 */

public class RemoveDuplicateUsingBasicCode{
    
    public static void main(String[] args){
        
        Node n6 = new Node(6, null);
                
        Node n5 = new Node(5, n6);
        
        Node n4 = new Node(4, n5);
        
        Node n3 = new Node(6, n4);
        
        Node n2 = new Node(1, n3);
        
        Node n1 = new Node(1, n2);      
        
        
        RemoveDuplicateUsingBasicCode rm = new RemoveDuplicateUsingBasicCode();
        
        rm.printList(n1);
                
        // Solu 1
        // rm.removeDup(n1);
        
        // Solu 2
        rm.removeDupInPlace(n1);
        
        rm.printList(n1);               
    }
    
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    // Solu 1
    public Node removeDup(Node head){
        
        Node n = head;
        Node previous = null;
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        while( n != null ){            // n != null, this command is important
            if( hashSet.contains(n.data) ){
                previous.next = n.next;
            }
            else{
                hashSet.add(n.data);
                previous = n;
            }                   
            
            n = n.next;
        }                
        
        return head;
    }
    
    // Solu 2
    public Node removeDupInPlace(Node head){
        Node current = head;
        Node runner = null;
        Node previous = current;
        
        while( current != null){
            runner = current.next;
            
            while( runner != null){
                if( runner.data == current.data )
                    previous.next = runner.next;
                else
                    previous = runner;
                
                runner = runner.next;
            }
            
            current = current.next;            
        }
        
        return head;
    }
    
    
}