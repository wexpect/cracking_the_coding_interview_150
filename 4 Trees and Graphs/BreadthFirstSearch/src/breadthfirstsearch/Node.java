/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breadthfirstsearch;

/**
 *
 * @author Rui
 */
public class Node {
    
    public int id;
    
    public State state;

    public Node predecessor;    

    public int distance; // BFS    
    
    public int dTime; // DFS
    public int fTime;
    
    public Node(int id){
        this.id = id;
        
        state = State.unVisited;
        
        distance = Integer.MAX_VALUE;        
        
        dTime = Integer.MAX_VALUE;
        fTime = Integer.MAX_VALUE;        
    }

    public String toString(){
        return Integer.toString(id);
    }        
}
