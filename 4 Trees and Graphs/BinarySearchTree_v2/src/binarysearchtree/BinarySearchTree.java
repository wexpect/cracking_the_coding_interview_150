/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author Rui
 */
public class BinarySearchTree{
    public TreeNode root;
    
    public TreeNode search(TreeNode n, Comparable obj){
        if( n == null){
            System.out.println("Search: can not find "+ ((TreeNodeData)obj).getKey() );
            return null;            
        }
        
        int result = n.data.compareTo(obj);
        
        if( result == 0){
            if( n.parent != null)
                System.out.println("Search: find " + ((TreeNodeData)obj).getKey() + " as child of " + ((TreeNodeData)(n.parent.data)).getKey() );            
            else 
                System.out.println("Search: find " + ((TreeNodeData)obj).getKey() + " as root.");
            
            return n;
        }
        else if(result > 0)
            return search(n.left, obj);
        else 
            return search(n.right, obj);        
    }
    
    public void insert(TreeNode n, Comparable obj){
        if( n == null){             
            root = new TreeNode(obj);           
            System.out.println("Insert: "+ ((TreeNodeData)obj).getKey() +" as root.");            
            return;        
        }        
        
        int result = n.data.compareTo(obj);
        if( result >= 0){
            if( n.left == null){
                n.left = new TreeNode(obj);
                n.left.parent = n;
                System.out.println("Insert: "+ ((TreeNodeData)obj).getKey() +" as left child of "+((TreeNodeData)(n.data)).getKey());                 
            }
            else
                insert(n.left, obj);
        }
        else{
            if( n.right == null){
                n.right = new TreeNode(obj);
                n.right.parent = n;                
                System.out.println("Insert: "+ ((TreeNodeData)obj).getKey() +" as right child of "+((TreeNodeData)(n.data)).getKey());
            }
            else
                insert(n.right, obj);
        }            
    }

    public TreeNode delete(TreeNode n, Comparable obj){
        TreeNode nDelete = search(n, obj);

        if( nDelete == null){
            System.out.println("Delete: delete nothing.");
            return null;
        }
                        
        if( nDelete.left == null && nDelete.right == null){  // case 1
            if(nDelete.parent.left == nDelete)
                nDelete.parent.left = null;    
            else
                nDelete.parent.right = null;          

            System.out.println("Delete: delete " +  ((TreeNodeData)(nDelete.data)).getKey() ); 
            return nDelete;            
        }        
        else if( nDelete.left == null || nDelete.right == null){  // case 2
            TreeNode nChild;
            
            if(nDelete.left != null)
                nChild = nDelete.left;
            else
                nChild = nDelete.right;
            
            if(nDelete.parent.left == nDelete)
                nDelete.parent.left = nChild;
            else
                nDelete.parent.right = nChild;

            nChild.parent = nDelete.parent;                
                
            System.out.println("Delete: delete " +  ((TreeNodeData)(nDelete.data)).getKey() ); 
            return nDelete;
        }
        else{ // case 3: find left-most in right subtree and copy the data
            TreeNode nSuccessor = nDelete.right;
            while(nSuccessor.left != null)
                nSuccessor = nSuccessor.left;
            
            System.out.println("Delete: copy data from " +  ((TreeNodeData)(nSuccessor.data)).getKey() + " to "+((TreeNodeData)(nDelete.data)).getKey()); 
            nDelete.data = nSuccessor.data;
            
            if(nSuccessor.parent.left == nSuccessor){
                if( nSuccessor.right == null )
                    nSuccessor.parent.left = null;
                else{
                    nSuccessor.parent.left = nSuccessor.right;
                    nSuccessor.right.parent = nSuccessor.parent;                    
                }
            }                            
            else
                nSuccessor.parent.right = null;
            
            System.out.println("Delete: delete " +  ((TreeNodeData)(nSuccessor.data)).getKey() ); 
            return nSuccessor;
        }        
    }
    
    public void inOrderTraverse(TreeNode n){
        if( n == null)
            return;
        
        inOrderTraverse(n.left);
        System.out.print( ( (TreeNodeData)(n.data) ).getKey() + " ");
        inOrderTraverse(n.right);
    }
       
    
}