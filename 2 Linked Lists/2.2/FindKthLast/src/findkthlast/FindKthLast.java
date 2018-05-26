/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findkthlast;

/**
 *
 * @author Rui
 */

public class FindKthLast{
    public static void main(String[] args){

        Node n6 = new Node(6, null);
                
        Node n5 = new Node(5, n6);
        
        Node n4 = new Node(4, n5);
        
        Node n3 = new Node(6, n4);
        
        Node n2 = new Node(1, n3);
        
        Node n1 = new Node(1, n2);      
        
        
        FindKthLast find = new FindKthLast();
        find.printList(n1);
        
        System.out.println( find.getKthLast(n1, 2).data );
        
        System.out.println( find.getKthLastSolu2(n1, 2).data );
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
    public Node getKthLast(Node head, int k){
        Node current = head;
        Node kthLast = null;
        int count = 0;
        
        while( current != null){
            count++;
            
            if( count == k ){
                kthLast = head;
            }
            if( count > k ){
                kthLast = kthLast.next;
            }
            
            current = current.next;
        }
        
        if( kthLast != null)
            return kthLast;
        else 
            return null;
    }
    
    // Solu 2
    public Node getKthLastSolu2(Node head, int k){
        Node p1 = head;
        Node p2 = head;
        
        for(int i = 1; i < k; i++){
            if( p2 != null){
                p2 = p2.next;
            }
            else
                return null;                              
        }
        
        while( p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }        
        return p1;        
    }
    
}
