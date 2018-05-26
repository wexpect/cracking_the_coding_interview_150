/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depthfirstsearch;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class DepthFirstSearch {
    
   public static void main(String[] args){
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
        
        
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.DFS(graph);        
        //dfs.DFSVisit(graph, n[0]);
   }
   
   
   
   private int timeStamp;   
   
   public void DFS(Graph g){
       for(Node u : g.getNodes() ){
           u.state = State.unVisited;
           u.predecessor = null;
       }
       
       timeStamp = 0;
       
       for(Node u : g.getNodes() )
           if( u.state == State.unVisited )
               DFSVisit(g, u);
   }
   
   public void DFSVisit(Graph g, Node u){
       if( u == null)
           return;
       
       u.state = State.visiting;
       u.dTime = ++timeStamp;
       visit(u);       
       
       for(Node v : g.getAdjacentNodes(u) ){
           if( v.state == State.unVisited ){
               v.predecessor = u;
               DFSVisit(g, v);
           }
       }
       
       u.state = State.visited;
       u.fTime = ++timeStamp;
       visit(u);              
   }   
   
   public void visit(Node u){
       System.out.println("Visit "+ u + " dTime = "+ u.dTime + " fTime = "+ u.fTime +" p = "+ u.predecessor);
   }  
   
}
