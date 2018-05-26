/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author Rui
 */
public class ReverseLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node n6 = new Node(6);
                
        Node n5 = new Node(5);        
        n5.next = n6;
        
        Node n4 = new Node(4);
        n4.next = n5;
        
        Node n3 = new Node(3);
        n3.next = n4;
        
        Node n2 = new Node(2);
        n2.next = n3;
        
        Node n1 = new Node(1);  
        n1.next = n2;
        
        ReverseLinkedList rll = new ReverseLinkedList();
        
        rll.printList(n1);
        
        // Solu 1: recursion
        //Node newHead = rll.reverse1(n1);
        
        // Solu 2: iteration
        Node newHead = rll.reverse2(n1);
        
        rll.printList(newHead);        
    }
    
    // Solu 1: recursion
    public Node reverse1(Node head){
        if( head == null)
            return null;
        
        if( head.next == null)
            return head;
        
        Node n = head;
        
        Node newHead = reverse1(n.next);
        Node newTail = getTail(newHead);
        newTail.next = n;
        
        n.next = null; // this is a MUST, to make the tail.next as null, because n.next actually point to its next node
        
        return newHead;                            
    }
    
    public Node getTail(Node head){
        if( head == null)
            return null;
        
        if( head.next == null)
            return head;
        
        Node n = head;
        while( n.next != null){
            n = n.next;
        }
        
        return n;
    }
 
    // Solu 2: iteration
    public Node reverse2(Node head){
        if( head == null)
            return null;
        
        Node n = head;
        Node newHead = null;
        Node next = null;
        
        while( n != null){
            next = n.next;
            n.next = newHead;
            newHead = n;
            n = next;    
        }
        
        return newHead;
    }
    
    
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
