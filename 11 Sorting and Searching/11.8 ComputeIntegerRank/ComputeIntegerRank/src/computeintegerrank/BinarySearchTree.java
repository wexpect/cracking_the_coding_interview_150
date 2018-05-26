/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computeintegerrank;

/**
 *
 * @author Rui
 */
public class BinarySearchTree{
    public TreeNode root = null;
    

    public void track(int key){
        Comparable obj = new TreeNodeData(key);
        insert(root, obj);       
    }
    
   public void insert(TreeNode n, Comparable obj){
        if( n == null){             
            root = new TreeNode(obj);           
            System.out.println("Insert: "+ ((TreeNodeData)obj).getKey() +" as root.");            
            return;        
        }        
        
        int result = n.data.compareTo(obj);
        
        n.count++;
        
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
   
   
    private int rankOfK = 0;
    public int getRankOfNum(int key){        
        Comparable obj = new TreeNodeData(key);
        rankOfK = 0;  // must initialzie for each key
        
        search(root, obj);
       
        return rankOfK;
    }
      
    public int getRank(TreeNode n){
        int rankOfN = n.count - 1;
        
        if( n.right != null)
            rankOfN -= n.right.count;
    
        return rankOfN;
    }
       
    public TreeNode search(TreeNode n, Comparable obj){
        if( n == null){
            System.out.println("Search: can not find "+ ((TreeNodeData)obj).getKey() );
            return null;            
        }
        
        int result = n.data.compareTo(obj);
        
        if( result == 0){
            rankOfK = rankOfK + getRank(n);
            
            if( n.parent != null)
                System.out.println("Search: find " + ((TreeNodeData)obj).getKey() + " as child of " + ((TreeNodeData)(n.parent.data)).getKey() );            
            else 
                System.out.println("Search: find " + ((TreeNodeData)obj).getKey() + " as root.");
            
            return n;
        }
        else if(result > 0)
            return search(n.left, obj);
        else {
            rankOfK = rankOfK + getRank(n) + 1;
            return search(n.right, obj);        
        }
    }
    
 

    public TreeNode delete(TreeNode n, Comparable obj){
        TreeNode nDelete = search(n, obj);

        if( nDelete == null){
            System.out.println("Delete: delete nothing.");
            return null;
        }
                        
        if( nDelete.left == null && nDelete.right == null){
            if(nDelete.parent.left == nDelete)
                nDelete.parent.left = null;    
            else
                nDelete.parent.right = null;          

            System.out.println("Delete: delete " +  ((TreeNodeData)(nDelete.data)).getKey() ); 
            return nDelete;            
        }        
        else if( nDelete.left == null || nDelete.right == null){
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
        else{
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
        System.out.printf( "%d(%d) ",( (TreeNodeData)(n.data) ).getKey(), n.count);
        inOrderTraverse(n.right);
    }
       
    
}