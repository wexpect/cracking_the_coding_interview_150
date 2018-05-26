/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addlist;

/**
 *
 * @author Rui
 */


public class AddList{
    public static void main(String[] args){

        AddList al = new AddList();        
        
        
        // 2.5                
        Node n6 = new Node(8);  //8                
        Node n5 = new Node(9);
        Node n4 = new Node(5);       
        
        Node n3 = new Node(6);        
        Node n2 = new Node(1);                
        Node n1 = new Node(7);            
        
        n5.next = n6;
        n4.next = n5;        
        
        n2.next = n3;
        n1.next = n2;
        
        al.printList(n1);
        al.printList(n4);        
        
        System.out.println("Answer");
        al.printList( al.toAddList(n1, n4)  );
        
        
        // Follow up
        n6 = new Node(8);  //8                
        n5 = new Node(9);
        n4 = new Node(5);       
        
        n3 = new Node(6);        
        n2 = new Node(1);                
        n1 = new Node(7);   

        n6.next = n5;
        n5.next = n4;        
        
        n3.next = n2;
        n2.next = n1;
        
        al.printList(n6);
        al.printList(n3);        
        
                
        // Follow up, Solu 1: recursion
        //System.out.println("Follow up, Solu 1");
        //al.printList( al.addLists1(n6, n3)  );                
        
        // Follow up, Solu 2: iteration
        System.out.println("Follow up, Solu 2");
        al.printList( al.addLists2(n6, n3)  );        
        
    }
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public Node toAddList(Node head1, Node head2){
        
        int a = 0, b = 0, c = 0, sum = 0;

        Node n1 = head1;
        Node n2 = head2;
        Node head = null, tail = null;
        
        while( (n1 != null ) || (n2 != null) || ( c == 1)){  // need to consider also execute when c == 1
            if( n1 != null){
                a = n1.data;
                n1 = n1.next;
            }
            else
                a = 0;
            
            if( n2 != null){
                b = n2.data;
                n2 = n2.next;
            }
            else
                b = 0;            
            
            sum = (a + b + c) % 10;
            c = (int) (( a + b + c) / 10) ;
            
            if( head == null){
                head = new Node(sum);
                tail = head;
            }
            else{
                tail.next = new Node(sum);
                tail = tail.next;
            }            
        }
                    
        return head;
                
    }
    
   
    
    
    // Follow Up, Solu 1: recursion
    public Node addLists1(Node h1, Node h2){
        Node rh1 = reverse1(h1);
        Node rh2 = reverse1(h2);
    
        Node rh = toAddList(rh1, rh2);
        
        Node h = reverse1(rh);
        return h;
    }
    
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
 
    // Follow Up, Solu 2: iteration
    public Node addLists2(Node h1, Node h2){
        Node rh1 = reverse2(h1);
        Node rh2 = reverse2(h2);
    
        Node rh = toAddList(rh1, rh2);
        
        Node h = reverse2(rh);
        return h;
    }
    
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
        
    
}