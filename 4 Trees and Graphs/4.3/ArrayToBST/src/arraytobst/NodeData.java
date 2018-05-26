/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytobst;

/**
 *
 * @author Rui
 */
public class NodeData implements Comparable{
    private int key;
    
    public NodeData(int k){
        key = k;
    }   
        
    public int compareTo(Object o){
        NodeData obj = (NodeData)o;
        
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