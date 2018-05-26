/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpalindrome;

/**
 *
 * @author Rui
 */

public class CheckPalindrome{
    
    public static void main(String[] args){
        Node n7 = new Node(1, null);   
        
        Node n6 = new Node(2, n7);        
        
        Node n5 = new Node(3, n6);
        
        Node n4 = new Node(4, n5);
                
        Node n3 = new Node(3, n4);
        
        Node n2 = new Node(2, n3);
        
        Node n1 = new Node(1, n2);  
        
        CheckPalindrome cp = new CheckPalindrome();
        cp.printList(n1);
        
        // Solu 1
        System.out.println(cp.isPalindrome(n1));
        
        // Solu 2 
        System.out.println(cp.isPalindromeSolu2(n1));
        
        
    }
    
    public void printList(Node head){
        Node n = head;
        
        while( n != null){
            System.out.print(n.data + " ");
            n = n.next;
            
        }
        System.out.println();
    }        
    
    // Solu 1: reverse whole list and compare the first halfs
    public boolean isPalindrome(Node head){
        
        Node n = head;
        Node head2 = null;
        int count = 0;

      
        while( n != null){
            Node tmp = new Node(0, null);
            tmp.data = n.data;
            tmp.next = head2;
            head2 = tmp;

            count ++;            
            n = n.next;
        }
      

        n = head;
        Node n2 = head2;
        
        printList(head);
        printList(head2);
        
        for( int i = 1; i <= Math.ceil( count/2); i++){
            if( n.data != n2.data )
                return false;
            
            n = n.next;
            n2 = n2.next;            
        }
        return true;        
    }
    
    //Solu 2: revere first half and compare with second half
    public boolean isPalindromeSolu2(Node head){
        
        Node fast = head;
        Node slow = head;
        
        Node head2 = null;
        
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            
            Node tmp = new Node(0,null);
            tmp.data = slow.data;
            tmp.next = head2;
            head2 = tmp;
            
            slow = slow.next;
        }
                  
        printList(head2);        
        
        
        if( fast.next != null){
            Node tmp = new Node(0,null);
            tmp.data = slow.data;
            tmp.next = head2;                        
            head2 = tmp;
        }            
        
        slow = slow.next;
                                
        printList(head2);        
        
        Node n2 = head2;
        while( n2 != null){
            if( n2.data != slow.data)
                return false;
            
            n2 = n2.next;
            slow = slow.next;
        }
        return true;
        
    }
    
}