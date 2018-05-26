/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findsucceccor;

/**
 *
 * @author Rui
 */
public class FindSucceccor {

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
        
        /*
        Node newNode = BST.search(BST.root, new NodeData(4));
        ((NodeData)newNode.data ).setKey(100);
        BST.inOrderTraverse(BST.root);          
        */
        
        
        int givenKey = 17;
        Node givenNode = BST.search(BST.root, new NodeData(givenKey));
        FindSucceccor fs = new FindSucceccor();
        Node givenNodeSuccessor = fs.getSuccessor(givenNode);
        if( givenNodeSuccessor != null)
            System.out.printf("Successor of %d is %d\n", givenKey, ((NodeData)(givenNodeSuccessor.data)).getKey()  );
        else
            System.out.printf("Successor of %d does not exist.\n", givenKey );
        
    }
    
    public Node getSuccessor(Node n){
        if( n == null)
            return null;
        
        if(n.right != null){
            n = n.right;
            
            while( n.left != null)  
                n = n.left;
            
            return n;
        }
        else{
            while( n.parent != null){
                if( n == n.parent.left)
                    return n.parent;
                else
                    n = n.parent;            
            }
            
            return null;        
        }
    }
    
}
