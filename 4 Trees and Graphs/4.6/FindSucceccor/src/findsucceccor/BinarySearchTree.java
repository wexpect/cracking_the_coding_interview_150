
package findsucceccor;

/**
 *
 * @author Rui
 */
public class BinarySearchTree{
    public Node root;
    
    public Node search(Node n, Comparable obj){
        if( n == null){
            System.out.println("Search: can not find "+ ((NodeData)obj).getKey() );
            return null;            
        }
        
        int result = n.data.compareTo(obj);
        
        if( result == 0){
            if( n.parent != null)
                System.out.println("Search: find " + ((NodeData)obj).getKey() + " as child of " + ((NodeData)(n.parent.data)).getKey() );            
            else 
                System.out.println("Search: find " + ((NodeData)obj).getKey() + " as root.");
            
            return n;
        }
        else if(result > 0)
            return search(n.left, obj);
        else 
            return search(n.right, obj);        
    }
    
    public void insert(Node n, Comparable obj){
        if( n == null){             
            root = new Node(obj);           
            System.out.println("Insert: "+ ((NodeData)obj).getKey() +" as root.");            
            return;        
        }        
        
        int result = n.data.compareTo(obj);
        if( result >= 0){
            if( n.left == null){
                n.left = new Node(obj);
                n.left.parent = n;
                System.out.println("Insert: "+ ((NodeData)obj).getKey() +" as left child of "+((NodeData)(n.data)).getKey());                 
            }
            else
                insert(n.left, obj);
        }
        else{
            if( n.right == null){
                n.right = new Node(obj);
                n.right.parent = n;                
                System.out.println("Insert: "+ ((NodeData)obj).getKey() +" as right child of "+((NodeData)(n.data)).getKey());
            }
            else
                insert(n.right, obj);
        }            
    }

    public Node delete(Node n, Comparable obj){
        Node nDelete = search(n, obj);

        if( nDelete == null){
            System.out.println("Delete: delete nothing.");
            return null;
        }
                        
        if( nDelete.left == null && nDelete.right == null){
            if(nDelete.parent.left == nDelete)
                nDelete.parent.left = null;    
            else
                nDelete.parent.right = null;          

            System.out.println("Delete: delete " +  ((NodeData)(nDelete.data)).getKey() ); 
            return nDelete;            
        }        
        else if( nDelete.left == null || nDelete.right == null){
            Node nChild;
            
            if(nDelete.left != null)
                nChild = nDelete.left;
            else
                nChild = nDelete.right;
            
            if(nDelete.parent.left == nDelete)
                nDelete.parent.left = nChild;
            else
                nDelete.parent.right = nChild;

            nChild.parent = nDelete.parent;                
                
            System.out.println("Delete: delete " +  ((NodeData)(nDelete.data)).getKey() ); 
            return nDelete;
        }
        else{
            Node nSuccessor = nDelete.right;
            while(nSuccessor.left != null)
                nSuccessor = nSuccessor.left;
            
            System.out.println("Delete: copy data from " +  ((NodeData)(nSuccessor.data)).getKey() + " to "+((NodeData)(nDelete.data)).getKey()); 
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
            
            System.out.println("Delete: delete " +  ((NodeData)(nSuccessor.data)).getKey() ); 
            return nSuccessor;
        }        
    }
    
    public void inOrderTraverse(Node n){
        if( n == null)
            return;
        
        inOrderTraverse(n.left);
        System.out.print( ( (NodeData)(n.data) ).getKey() + " ");
        inOrderTraverse(n.right);
    }
       
    
}