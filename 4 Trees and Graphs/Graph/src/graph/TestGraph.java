/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class TestGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numNodes = 10;
        
        ArrayList<Node> nList = new ArrayList<Node>();
        Node[] n = new Node[numNodes];
        for(int i = 0; i < numNodes; i++){
            n[i] = new Node(i);
            nList.add( n[i] );
        }
        
        int[][] nIndex = {{0, 1}, {1, 5}, {5, 2}, {5, 6}, {2, 3}, {2, 6}, {3, 6}, {3, 7}, {6, 7}, {0, 4}};
        ArrayList<Edge> eList = new ArrayList<Edge>();
        for( int i = 0; i < nIndex.length; i++){        
            eList.add( new Edge( n[ nIndex[i][0] ], n[ nIndex[i][1] ] )  );
        }
                
        Graph graph = new Graph(nList, eList, false);

        
        
        graph.printAdjacencyMatrix();        
        
        
        
        graph.printNodes();        
        
        System.out.println( graph.getAdjacentNodes( n[2] ) );
        
        System.out.println(graph.getNode( 6 ));
        
        graph.addNode( new Node(12) );
        System.out.println(graph.getNode( 12 ));
        graph.printNodes();
        
        graph.removeNode( n[2] );
        System.out.println(graph.getNode( 2 ));
        graph.printNodes();
        
        
        
        graph.printEdges();
        
        graph.addEdge( new Edge( n[4], n[5] ));
        graph.printEdges();        

        graph.removeEdge( n[5], n[1] );
        graph.printEdges();        
        
        
    }
}
