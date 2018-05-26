
package checkbalancedtree;


public class CheckBalancedTree{
    
    public static void main(String[] args){
        BinarySearchTree BST = new BinarySearchTree();
        
        int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15,16,17};
        for(int key : keyArray){
            BST.insert(BST.root, new NodeData(key)); 
            BST.inOrderTraverse(BST.root);
            System.out.println();
        }              
        
        
        CheckBalancedTree cbt = new CheckBalancedTree();
        System.out.println( cbt.isBalanced( BST.root ) );
        
    }
    
    
    public int getHeight(Node n){
        if( n == null)
            return 0;
        
        int leftHeight = getHeight(n.left);
        if(leftHeight < 0)
            return -1;
        
        int rightHeight = getHeight(n.right);
        if(rightHeight < 0)
            return -1;
        
        int diffHeight = Math.abs( leftHeight - rightHeight);
        if( diffHeight > 1)
            return -1;
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public boolean isBalanced(Node n){
        int nHeight = getHeight(n);
        
        if( nHeight < 0)
            return false;
        else 
            return true;
    }
    
}