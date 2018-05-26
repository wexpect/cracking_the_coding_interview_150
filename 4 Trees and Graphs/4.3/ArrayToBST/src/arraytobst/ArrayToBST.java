/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytobst;

/**
 *
 * @author Rui
 */
public class ArrayToBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayToBST atb = new ArrayToBST();        
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        
        // Solu 1        
        System.out.println("\nSolu 1:");
        BinarySearchTree BST = new BinarySearchTree();                
        atb.arrayToBST(BST, array, 0, array.length - 1);                        
        BST.inOrderTraverse(BST.root);        
        
        // Solu 2
        System.out.println("\n\n\n\nSolu 2:");
        BinarySearchTree BST2 = new BinarySearchTree();                
        Node root2 = atb.arrayToBSTSolu2(array, 0, array.length - 1);                        
        BST2.inOrderTraverse(root2);        
        

    }
    
    // Solu 1
    public void arrayToBST(BinarySearchTree BST, int[] array, int arrayLeft, int arrayRight){
        System.out.println("\nLeft = "+arrayLeft +", Right = "+ arrayRight);

        if(arrayLeft > arrayRight)            
            return;                
        else if(arrayLeft == arrayRight){
            BST.insert(BST.root, new NodeData( array[arrayLeft] ) );
            return;
        }
        
        int arrayMiddle = (arrayLeft + arrayRight) / 2;
        System.out.println("Middle = "+arrayMiddle +"\n");
        
        BST.insert(BST.root, new NodeData( array[arrayMiddle] ) );        
        arrayToBST(BST, array, arrayLeft, arrayMiddle - 1);
        arrayToBST(BST, array, arrayMiddle + 1, arrayRight);
    }
    
    // Solu 2
    public Node arrayToBSTSolu2(int[] array, int arrayLeft, int arrayRight){
        System.out.println("\nLeft = "+arrayLeft +", Right = "+ arrayRight);

        if(arrayLeft > arrayRight)            
            return null;                
        else if(arrayLeft == arrayRight)
            return new Node( new NodeData( array[arrayLeft] ) );            
                
        int arrayMiddle = (arrayLeft + arrayRight) / 2;
        System.out.println("Middle = "+arrayMiddle +"\n");
        
        Node n = new Node( new NodeData( array[arrayMiddle] ) );        
        n.left = arrayToBSTSolu2(array, arrayLeft, arrayMiddle - 1);
        n.right = arrayToBSTSolu2(array, arrayMiddle + 1, arrayRight);
        
        return n;
    }    
    
    
}
