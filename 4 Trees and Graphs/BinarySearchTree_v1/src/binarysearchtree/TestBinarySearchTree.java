/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author Rui
 */
public class TestBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        
        BinarySearchTree BST = new BinarySearchTree();
        
        int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        for(int key : keyArray){
            BST.insert(BST.root, new NodeData(key)); 
            BST.inOrderTraverse(BST.root);
            System.out.println();
        }                    
        

        
//        BST.delete(BST.root, new NodeData(9));        
//        BST.search(BST.root, new NodeData(9)); 
        
//        BST.delete(BST.root, new NodeData(10));        
//        BST.search(BST.root, new NodeData(10));         
//        BST.search(BST.root, new NodeData(11));         
        
        BST.delete(BST.root, new NodeData(12));        
        BST.search(BST.root, new NodeData(12));         
        BST.search(BST.root, new NodeData(13));                 
        
        System.out.println("Right child is " +((NodeData)(BST.search(BST.root, new NodeData(8)).right.data )).getKey()   );
        
//        System.out.println("Left child is " +((NodeData)(BST.search(BST.root, new NodeData(14)).left.data )).getKey()   );
        
        
//        BST.delete(BST.root, new NodeData(10));        
//        BST.search(BST.root, new NodeData(10)); 
//        BST.search(BST.root, new NodeData(11)); 
        
//        BST.delete(BST.root, new NodeData(4));        
//        BST.search(BST.root, new NodeData(4)); 
//        BST.search(BST.root, new NodeData(5));         
        
            
        
        
        
//        BST.delete(BST.root, new NodeData(9));
//        BST.search(BST.root, new NodeData(9));        
//
//                          
//        BST.delete(BST.root, new NodeData(20));

        
        

        
    }
    
    
    
    
}
