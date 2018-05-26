/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deletemiddle;

/**
 *
 * @author Rui
 */

public class DeleteMiddle{
    public static void main(String[] args){
 
        Node n6 = new Node(6, null);
                
        Node n5 = new Node(5, n6);
        
        Node n4 = new Node(4, n5);
        
        Node n3 = new Node(6, n4);
        
        Node n2 = new Node(1, n3);
        
        Node n1 = new Node(1, n2);      
        
        
        
        DeleteMiddle dm = new DeleteMiddle();
                        
        dm.printList(n1);
        
        //Solu 0
        // dm.printList( dm.toDeleteMidSolu0(n1) );

        /*
        // Solu 1
        dm.toDeleteMidSolu1( n3 );
        dm.printList(n1);
        */
        
        // Solu 2
        dm.toDeleteMid( n4 );
        dm.printList(n1);        
        
    }
    
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }


    //Solu 0: Given head
    public Node toDeleteMidSolu0(Node head){
        if( head == null )
            return null;
        
        Node p1 = head;
        Node p2 = head;
        Node preP1 = null;
        
        if(p2.next == null)
            return null;
        if(p2.next.next == null)
            return p1.next;
        
        int count = 0;
        while( p2.next != null){
            p2 = p2.next;
            
            count++;
            if(count == 2){
                preP1 = p1;
                p1 = p1.next;
                count = 0;
            }                       
        }
        preP1.next = p1.next;
        return head;               
    }
    
    // Solu 1
    public void toDeleteMidSolu1(Node midNode){
        if(midNode == null)
            return;
        
        Node n = midNode;        
        
        //can not handle    if(n.next == null) 
        
        Node previous = null;
        while( n.next != null){
            n.data = n.next.data;
            previous = n;
            n = n.next;            
        }
        previous.next = null;
        
    }
    
    // Solu 2
    public void toDeleteMid(Node midNode){
        if (midNode == null)
            return;
        
        Node n = midNode;
        
        //can not handle    if(n.next == null) 
        
        if(n.next != null){
            n.data = n.next.data;
            n.next = n.next.next;
        }
    }
    
}