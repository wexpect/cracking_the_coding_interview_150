/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breadthfirstsearch;

/**
 *
 * @author Rui
 */
public class Edge {
    public Node source;
    public Node destination;
    public int weight;

    public Edge(Node source, Node destination){
        this.source = source;
        this.destination = destination;
        this.weight = 1;
    }    

    public Edge(Node source, Node destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString(){
        return source + " -- "+destination;        
        //return source + " -("+weight+")- "+destination;
    }        
        
}
