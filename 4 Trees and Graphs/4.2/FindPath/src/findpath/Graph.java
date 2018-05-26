/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findpath;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class Graph{
    
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    
    private boolean isDirected;
    
    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges, boolean isDirected){
        this.nodes = nodes;
        this.edges = edges;
        this.isDirected = isDirected;    
    }
   
    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
        this.isDirected = true;    
    }

    
    public void setDirected(){
        isDirected = true;
    }
    
    public void setUnDirected(){
        isDirected = false;
    }    
    
    
    
    
    public void printNodes(){
        System.out.println(nodes);
    }
    
    public ArrayList<Node> getNodes(){
        return nodes;
    }
        
    public ArrayList<Node> getAdjacentNodes(Node n){
        ArrayList<Node> adjNodes = new ArrayList<Node>();
        
        for( Edge e : edges ){
            if( e.source == n )
                adjNodes.add(e.destination);
            if( !isDirected && e.destination == n )
                adjNodes.add(e.source);                        
        }
        return adjNodes;
    }    
    

    public int indexOfNode(int nID){
        for( int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).id == nID)
                return i;
        }
        return -1;
    }
    
    public Node getNode(int nID){
        int i = indexOfNode(nID);
        if( i >= 0)
            return nodes.get(i);
        else
            return null;
    }

    public int addNode(Node n){
        nodes.add(n);
        return nodes.size()-1;
    }

    public void removeNode(Node n){
        nodes.remove(n);        
        
//        int i = indexOfNode(n.id);
//        
//        if( i >= 0)
//            nodes.remove(i);
//        else
//            System.out.println("Node does not exist.");
    }
    
    

    
    public void printEdges(){
        System.out.println(edges);
    }        
    
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    
    public int indexOfEdge( Node nS, Node nD ){
        Edge e;
        for( int i = 0; i < edges.size(); i++){
            e = edges.get(i);
            
            if( e.source == nS && e.destination == nD)
                return i;

            if( !isDirected && e.source == nD && e.destination == nS)
                return i;            
        }        
        return -1;    
    }

    public int addEdge(Edge e){
        edges.add(e);
        return edges.size()-1;
    }
    
    // need to consider directed or not, so can not use 'edge' directly
    public void removeEdge(Node nS, Node nD){
        int i = indexOfEdge(nS, nD);
        if( i >= 0)
            edges.remove(i);
        else
            System.out.println("Edge does not exist.");            
    }    
    
    

    
    public int[][] getAdjacencyMatrix(){
        int size = nodes.size(); // this line is not always correct. Actually, size must be larger than the largest Node ID.
        int[][] adjMatrix = new int[size][size];
        
        int s,d;
        for(Edge e : edges){
            s = e.source.id;
            d = e.destination.id;
            
            adjMatrix[s][d] = e.weight;
            
            if( !isDirected )
                adjMatrix[d][s] = e.weight;
        }
        return adjMatrix;        
    }    
    
    public void printAdjacencyMatrix(){
        int[][] adjMatrix = getAdjacencyMatrix();        
        System.out.println("Adjacency Matrix:");                    
        for( int r = 0; r < adjMatrix.length; r++){
            for( int c = 0; c < adjMatrix.length; c++){
                System.out.printf("%1d ", adjMatrix[r][c]);
            }
            System.out.println();            
        }            
    }
}
