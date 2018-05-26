/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runners;

/**
 *
 * @author Rui
 */
public class Runners {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        
        Runners r = new Runners();
        Node newHead = r.weave(n0);
        r.printList(newHead);
    }
    
    public Node weave(Node head){
        if( head == null )
            return null;
        
        if( head.next == null)
            return head;
        
        Node p1 = head;
        Node p2 = head.next;
        
        while(p2.next != null){
            if( p2.next.next == null)
                return null;
            
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        Node pa = head;
        Node pb = p1.next;
        
        Node newHead = null;
        Node tail = null;
        
        while( pb != null){
            System.out.println(pa.data);
            System.out.println(pb.data);
            
            if( newHead == null){
                newHead = pa;
                tail = pa;
            }
            else{
                tail.next = pa;
                tail = tail.next;
            }
            
            pa = pa.next;
            
            tail.next = pb;
            tail = tail.next;
            
            pb = pb.next;
        }
        
        return newHead;
    }
    
    public void printList(Node head){
        if( head == null)
            return;
        
        Node n = head;
        while( n != null){
            System.out.print( n.data + " " );
            n = n.next;
        }
        
    }
}
