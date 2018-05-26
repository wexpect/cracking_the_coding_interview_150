/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checksubtree;

/**
 *
 * @author Rui
 */
public class CheckSubtree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree BT1 = new BinarySearchTree();
        
        int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15,16,17};
        for(int key : keyArray){
            BT1.insert(BT1.root, new NodeData(key)); 
            BT1.inOrderTraverse(BT1.root);
            System.out.println();
        }       
        


        Node newNode = BT1.search(BT1.root, new NodeData(5));
        ((NodeData)newNode.data ).setKey(9);
        
        newNode = BT1.search(BT1.root, new NodeData(7));
        ((NodeData)newNode.data ).setKey(11);    
        
        newNode = BT1.search(BT1.root, new NodeData(6));
        ((NodeData)newNode.data ).setKey(100);        
        
        BT1.inOrderTraverse(BT1.root);          
        
        
        
        
        
        BinarySearchTree BT2 = new BinarySearchTree();
        
        int[] keyArray2 = {10,9,11};
        for(int key2 : keyArray2){
            BT2.insert(BT2.root, new NodeData(key2)); 
            BT2.inOrderTraverse(BT2.root);
            System.out.println();
        }       
        
        CheckSubtree cs = new CheckSubtree();
        System.out.println(cs.isSubTree(BT1.root, BT2.root));        
        
    }
        
    
    public boolean isSubTree(Node rootTree1, Node rootTree2){        
        if(rootTree2 == null)
            return false;
        else
            return matchTree(rootTree1, rootTree2);
    }
    
    public boolean matchTree(Node n1, Node rootTree2){
        if( n1 == null)
            return false;
        
        if( n1.data.compareTo(rootTree2.data) == 0){
            if( matchTreeHelper( n1, rootTree2) )
                return true;
        }            
        
        return  matchTree(n1.left, rootTree2) || matchTree(n1.right, rootTree2) ; 
    }
    
    public boolean matchTreeHelper(Node n1, Node n2){
        if( n1 == null && n2 == null)
            return true;
        if( n1 == null || n2 == null)
            return false;
        
        if( n2.data.compareTo(n1.data) != 0 )
            return false;
        
        return  matchTreeHelper(n1.left, n2.left) && matchTreeHelper(n1.right, n2.right) ;
    }
    
}
