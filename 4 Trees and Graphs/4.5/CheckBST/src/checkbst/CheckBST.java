/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbst;

/**
 *
 * @author Rui
 */
public class CheckBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree BST = new BinarySearchTree();
        
        int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15,16,17};
        for(int key : keyArray){
            BST.insert(BST.root, new NodeData(key)); 
            BST.inOrderTraverse(BST.root);
            System.out.println();
        }              
        
        CheckBST cb = new CheckBST();        
        System.out.println( cb.isBST(BST.root) );
        
        
        
        
        
        Node newNode = BST.search(BST.root, new NodeData(4));
        ((NodeData)newNode.data ).setKey(100);
        BST.inOrderTraverse(BST.root);                

        CheckBST cb2 = new CheckBST();  // so that  preObj == null
        System.out.println();
        System.out.println(cb2.isBST(BST.root) );        
    }
    
    Comparable preObj;
    
    public boolean isBST(Node n){
        if( n == null)
            return true;
        
        if(  !isBST(n.left) )
            return false;
        
        if( preObj != null){
            int result = n.data.compareTo(preObj);
            if( result < 0){
                System.out.printf("Return at n = %d, preObj = %d\n", ((NodeData)n.data).getKey(), ((NodeData)preObj).getKey());                
                return false;
            }
        }
        preObj = n.data;
        System.out.printf("preObj = %d\n", ((NodeData)preObj).getKey());
        
        if( !isBST(n.right) )
            return false;
        
        return true;
    }
}
