/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findcommonancestor;

/**
 *
 * @author Rui
 */
public class FindCommonAncestor {

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
        
        
        

        int key1 = 12;
        int key2 = 17;
        
        Node node1 = BST.search(BST.root, new NodeData(key1));
        Node node2 = BST.search(BST.root, new NodeData(key2));

        FindCommonAncestor fca = new FindCommonAncestor();        
        Node ancestor = fca.getCommonAncestor(BST.root, node1, node2);
        
        if( ancestor != null)
            System.out.printf("Common ancestor of %d and %d is %d\n", key1, key2, ((NodeData)(ancestor.data)).getKey()  );
        else
            System.out.printf("Common ancestor of %d and %d does not exist.\n",  key1, key2 );                
    }
    
    
    private Node n1;
    private Node n2;
    private Node commonAncestor;
    
    public Node getCommonAncestor(Node n, Node node1, Node node2){
        n1 = node1;
        n2 = node2;
        
        int count = getCommonAncestorHelper(n);
        if( count == 2 )
            return commonAncestor;
        else
            return null;
    }
    
    public int getCommonAncestorHelper(Node n){
        if( n == null)
            return 0;
        
        int cl = getCommonAncestorHelper(n.left);
        if( cl == 2)
            return 2;
        
        int cr = getCommonAncestorHelper(n.right);
        if( cr == 2)
            return 2;
        
        if( (cl + cr) == 2){
            commonAncestor = n;
            return 2;
        }
        
        int cn = 0;
        if( n == n1 || n == n2)
            cn = 1;
        
        if( (cl + cr + cn  ) == 2){
            if( n.parent != null){
                commonAncestor = n.parent;
                return 2;
            }
            else 
                return 0;                
        }
        else
            return cl + cr + cn;
    }
}

