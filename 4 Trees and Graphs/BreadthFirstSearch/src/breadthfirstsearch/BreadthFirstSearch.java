/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breadthfirstsearch;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class BreadthFirstSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int numNodes = 10;
        
        ArrayList<Node> nList = new ArrayList<Node>();
        Node[] n = new Node[numNodes];
        for(int i = 0; i < numNodes; i++){
            n[i] = new Node(i);
            nList.add( n[i] );
        }
        
        int[][] nIndex = {{0, 1}, {1, 5}, {5, 2}, {5, 6}, {2, 3}, {2, 6}, {3, 6}, {3, 7}, {6, 7}, {0, 4}, {4, 8}, {4, 9}};
        ArrayList<Edge> eList = new ArrayList<Edge>();
        for( int i = 0; i < nIndex.length; i++){        
            eList.add( new Edge( n[ nIndex[i][0] ], n[ nIndex[i][1] ] )  );
        }
                
        Graph graph = new Graph(nList, eList, true);    
        
        graph.printNodes();
        graph.printEdges();
        
        
        BreadthFirstSearch  bfs = new BreadthFirstSearch();
        bfs.BFS(graph, n[0]);

    }
    
    
    public void BFS(Graph g, Node s){
        if( s == null)
            return;
        
        for(Node v : g.getNodes() ){
            v.state = State.unVisited;
            v.distance = Integer.MAX_VALUE;
            v.predecessor = null;
        }       
        

        s.state = State.visiting;        
        s.distance = 0;        
        s.predecessor = null;        
        visit(s);        
        
        
        Queue q = new Queue();
        q.enqueue(s);
                
        while( !q.isEmpty() ){
            Node u = q.dequeue();
            for( Node v : g.getAdjacentNodes(u) ){
                if( v.state == State.unVisited){
                    v.state = State.visiting;        
                    v.distance = u.distance + 1;                
                    v.predecessor = u;          
                    visit(v);
                    
                    q.enqueue(v);
                }
            }
            
            u.state = State.visited;
        }
    }
    
   public void visit(Node u){
       System.out.println("Visit "+ u + " d = "+ u.distance +" p = "+ u.predecessor);
   }    
}
