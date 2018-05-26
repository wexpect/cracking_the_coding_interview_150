/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computeintegerrank;

/**
 *
 * @author Rui
 */
public class TreeNodeData implements Comparable{
    private int key;
    
    public TreeNodeData(int k){
        key = k;
    }   
        
    public int compareTo(Object o){
        TreeNodeData obj = (TreeNodeData)o;
        
        if( key < obj.key )
            return -1;
        else if( key == obj.key)
            return 0;
        else 
            return 1;    
    }

    public int getKey(){
        return key;
    }
    
}