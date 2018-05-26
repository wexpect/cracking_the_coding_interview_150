/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionlist;

/**
 *
 * @author Rui
 */


public class PartitionList{
    public static void main(String[] args){
        Node n6 = new Node(6, null);
                
        Node n5 = new Node(5, n6);
        
        Node n4 = new Node(4, n5);
        
        Node n3 = new Node(3, n4);
        
        Node n2 = new Node(2, n3);
        
        Node n1 = new Node(1, n2);    
        
        PartitionList pl = new PartitionList();
        pl.printList(n1);
        
        pl.printList( pl.toPartList(n1, 3) );
        
    }
    

    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public Node toPartList(Node head, int x){
        if(head == null)
            return head;
        
        Node n = head;      
        Node next = null;
        Node h1 = null;
        Node t1 = null;
        Node h2 = null;
        
        while( n != null){
            next = n.next;
            
            if( n.data < x){
                if( h1 == null){
                    t1 = n;
                }
                
                n.next = h1;
                h1 = n;                
            }
            else{
                n.next = h2;
                h2 = n;
            }
            
            n = next;
        }
        
        
        if( h1 != null){
            t1.next = h2;
            return h1;
        }
        else
            return h2;
    }
}
