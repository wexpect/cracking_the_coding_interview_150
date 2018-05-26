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
public class FindPath {

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
        
        int[][] nIndex = {{0, 1}, {1, 5}, {5, 2}, {5, 6}, {2, 3}, {2, 6}, {3, 6}, {3, 7}, {6, 7}, {0, 4}, {4, 8}, {4, 9}};
        ArrayList<Edge> eList = new ArrayList<Edge>();
        for( int i = 0; i < nIndex.length; i++){        
            eList.add( new Edge( n[ nIndex[i][0] ], n[ nIndex[i][1] ] )  );
        }
                
        Graph graph = new Graph(nList, eList, true);    
        
        graph.printNodes();
        graph.printEdges();        
        
        FindPath fp = new FindPath();
        
        // Solu 1
        System.out.println( fp.BFS(graph, n[0], n[9] ) );

        // Solu 2.1
        System.out.println( fp.DFS1(graph, n[0], n[9] ) );            
        
        // Solu 2
        System.out.println( fp.DFS(graph, n[0], n[9] ) );        
    }
    
    // Solu 1: BFS    
    public boolean BFS(Graph g, Node s, Node t){
        if( s == null || t == null)
            return false;
        
        if( s == t)
            return true;
        
        
        for(Node v : g.getNodes() ){
            v.state = State.unVisited;
            v.distance = Integer.MAX_VALUE;
            v.predecessor = null;
        }       
        

        s.state = State.visiting;        
        s.distance = 0;        
        s.predecessor = null;        
        visitBFS(s);        
        
        
        Queue q = new Queue();
        q.enqueue(s);
                
        while( !q.isEmpty() ){
            Node u = q.dequeue();
            for( Node v : g.getAdjacentNodes(u) ){
                if( v.state == State.unVisited){                                              
                    v.state = State.visiting;        
                    v.distance = u.distance + 1;                
                    v.predecessor = u;          
                    visitBFS(v);
                    
                    if( v == t){
                        System.out.println("Find it!");
                        return true;              
                    }
                    
                    q.enqueue(v);
                }
            }
            
            u.state = State.visited;
        }
        
        return false;
        
    }
    
   public void visitBFS(Node u){
       System.out.println("Visit "+ u + " d = "+ u.distance +" p = "+ u.predecessor);
   }   
   
   

   
   // Solu 2.1: DFS, simplier than Solu 2
   private int timeStamp1 = -1;   
   
   public boolean DFS1(Graph g, Node s, Node target){      

        if( g == null || s == null || target == null)
            return false;
        
        if( s == target)
            return true;        
       
       for(Node u : g.getNodes() ){
           u.state = State.unVisited;
           u.predecessor = null;
       }       
       
       return DFSVisit1(g, s, target);       
   }
   
   public boolean DFSVisit1(Graph g, Node u, Node t){       

        if( g == null || u == null || t == null)
            return false;
        
        if( u == t){
            System.out.println("Find it!");                   
            return true;     
        }       
       
       u.state = State.visiting; 
       u.dTime = ++timeStamp;               
       visit(u);       
       
       for(Node v : g.getAdjacentNodes(u) ){
           if( v.state == State.unVisited ){
               v.predecessor = u;
              
               if( DFSVisit1(g, v, t)){                   
                   return true;
               }               
           }
       }                     
       
       u.state = State.visited;
       u.fTime = ++timeStamp;
       visit(u);              
              
       return false;
   }   
   
   
   
   // Solu 2: DFS
   private int timeStamp;  
   private Node target;
   private boolean found = false;
   
   public boolean DFS(Graph g, Node s, Node tt){
       
       target = tt;

        if( s == null || target == null)
            return false;
        
        if( s == target)
            return true;
        
       
       for(Node u : g.getNodes() ){
           u.state = State.unVisited;
           u.predecessor = null;
       }
       
       timeStamp = 0;
      
       DFSVisit(g, s);
       if( found )
           return true;
       else
           return false;
   }
   
   public void DFSVisit(Graph g, Node u){
       
       if( u == null)
           return;
       
       u.state = State.visiting;
       u.dTime = ++timeStamp;
       visit(u);       
       
       for(Node v : g.getAdjacentNodes(u) ){
           if( !found && v.state == State.unVisited ){
               v.predecessor = u;
              
               if( v == target){
                   System.out.println("Find it!");
                   found = true;
                   return;
               }
               
               DFSVisit(g, v);
           }
       }
       
              
       if( found ) 
           return;
       
       u.state = State.visited;
       u.fTime = ++timeStamp;
       visit(u);              
       
       
       return;
   }   
   
   public void visit(Node u){
       System.out.println("Visit "+ u + " dTime = "+ u.dTime + " fTime = "+ u.fTime +" p = "+ u.predecessor);
   }     
   
}
