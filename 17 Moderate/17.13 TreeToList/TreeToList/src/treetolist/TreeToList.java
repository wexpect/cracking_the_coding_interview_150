/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treetolist;

/**
 *
 * @author Rui
 */
public class TreeToList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        BiNode n1 = new BiNode(1);
        BiNode n2 = new BiNode(2);
        BiNode n3 = new BiNode(3);
        BiNode n4 = new BiNode(4);
        BiNode n5 = new BiNode(5);
        
        // root is n3
        n1.node2 = n2;
        
        n3.node1 = n1;
        n3.node2 = n5;
        
        n5.node1 = n4;               

        TreeToList tl = new TreeToList();    
        
        // Solu 2: works
//        BiNode head = tl.convert(n3);
        
        // Solu 3: better
        BiNode head = tl.getConvert3(n3);        
        
        tl.printList(head);
    }
    
    // Solu 3: better
    public BiNode getConvert3(BiNode n){
        if( n == null)
            return null;
        
        BiNode head = convert3(n);
        head.node1 = null;
        return head;                   
    }
    
    public BiNode convert3(BiNode n){
        if( n == null)
            return null;
        
        BiNode leftHead = convert3(n.node1);
        if( leftHead != null){
            BiNode leftTail = leftHead.node1;
            leftTail.node2 = n;
            n.node1 = leftTail;
        }
        else
            leftHead  = n;
        
        BiNode rightHead = convert3(n.node2);
        if( rightHead != null){
            BiNode rightTail = rightHead.node1;
            rightHead.node1 = n;
            n.node2 = rightHead;
        
            leftHead.node1 = rightTail;
        }
        else
            leftHead.node1 = n;
         
        return leftHead;
    }
    
    
    // Solu 2:
    public BiNode convert(BiNode n){
        if( n == null )
            return null;
        
        if( n.node1 == null && n.node2 == null)
            return n;
        
        BiNode h = null;
        
        if( n.node1 != null){
           BiNode h1 = convert(n.node1);
           BiNode t1 = getTail(h1);
           t1.node2 = n;
           n.node1 = t1;
           h = h1;           
        }
        else{
            h = n;
        }
        
        if( n.node2 != null){
            BiNode h2 = convert(n.node2);
            n.node2 = h2;
            h2.node1 = n;
        }
        
        return h;
    }
    
    public BiNode getTail(BiNode n){                
        while( n.node2 != null){
            n = n.node2;
        }
        return n;
    }

    public void printList(BiNode n){
        while( n!= null){
            
            if( n.node1 != null )
                System.out.print(n.node1.data);
            else
                System.out.print("NULL");

            System.out.print(" <- "+n.data + " ->");

            if( n.node2 != null )
                System.out.print(n.node2.data);
            else
                System.out.print("NULL");            
            
            System.out.println();
            
            n = n.node2;
        }
    }
}
