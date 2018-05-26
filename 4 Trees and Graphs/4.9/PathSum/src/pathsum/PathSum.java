/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */

public class PathSum{
    
    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        
        n5.left = n3;
        n5.right = n7;
    
        n3.left = n1;
        n3.right = n4;        
        
        n7.left = n6;
        n7.right = n8;
        
        n1.right = n2;
        
        PathSum ps = new PathSum();
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int sum = 3;
        
        // Solu 1: only call the method once. runnning time: O(nlgn), space: O(nlg).
        ps.pathToN(arrList, sum, n5, 0);
        
        // Solu 2: will call the medhod multiple times, so will preprocess, running time is hard to compute, space is O(nlgn).
        //         After preprocess, for each search: running time O(1)
        ps.buildSumToPathArrHM(n5);
        System.out.println( ps.getPaths(sum) );
    }
    
    // Solu 1
    public void pathToN(ArrayList<Integer> arrList, int sum, Node n, int depth){
        if( arrList == null || depth < 0)
            return;
        
        if( n == null )
            return;
        
        if( depth <= arrList.size()-1 )
            arrList.set( depth, n.data); // must use  set() here, to update
        else
            arrList.add( n.data );
        
        int total = 0;
        for(int i = depth; i >= 0; i--){
            total += arrList.get(i);
            if( total == sum)
                print(arrList, i, depth);
        }
        
        pathToN(arrList, sum, n.left, depth+1);
        pathToN(arrList, sum, n.right, depth+1);        
    }
    
    public void print(ArrayList<Integer> arrList, int i, int j){
        for(int k = i; k <= j; k++){
            System.out.print(arrList.get(k) + " ");
        }
        System.out.println();
    }
   
        
    
    // Solu 2    
    public HashMap<Integer, ArrayList<LinkedList<Integer>> > sumToPathArrHM = new HashMap<Integer, ArrayList<LinkedList<Integer>> >();
    
    public void buildSumToPathArrHM(Node n){
        getPathFromNHM(n);
    }
    
    public HashMap< LinkedList<Integer>, Integer> getPathFromNHM(Node n){
        if( n == null){
            return new HashMap< LinkedList<Integer>, Integer>();
        }
        
        HashMap< LinkedList<Integer>, Integer> pathFromNHM = new HashMap< LinkedList<Integer>, Integer>();
        LinkedList<Integer> pathFromNodeList = new LinkedList<Integer>();
        pathFromNodeList.add( n.data);
        pathFromNHM.put( pathFromNodeList, n.data);
    
        HashMap< LinkedList<Integer>, Integer>[] pathFromChildrenHM = new HashMap[2];
        pathFromChildrenHM[0] = getPathFromNHM(n.left);
        pathFromChildrenHM[1] = getPathFromNHM(n.right);
        
        for(HashMap< LinkedList<Integer>, Integer> pathFromChildHM : pathFromChildrenHM){
            for( LinkedList<Integer> pathFromChildList : pathFromChildHM.keySet() ){
                int sumFromChildList = pathFromChildHM.get( pathFromChildList );
                
                LinkedList<Integer> pathFromNList = new LinkedList<Integer>();
                pathFromNList.addAll( pathFromChildList );
                pathFromNList.addFirst( n.data );
                pathFromNHM.put( pathFromNList, n.data + sumFromChildList);
            }                        
        }
        
        for( LinkedList<Integer> pathFromNList : pathFromNHM.keySet() ){
            int sumFromNList = pathFromNHM.get( pathFromNList );
            
            if( sumToPathArrHM.containsKey( sumFromNList ) ){
                sumToPathArrHM.get( sumFromNList ).add( pathFromNList );
            }
            else{
                ArrayList< LinkedList<Integer> > arrList = new ArrayList< LinkedList<Integer> >();
                arrList.add( pathFromNList );
                sumToPathArrHM.put( sumFromNList, arrList );
            }        
        }
        
        return pathFromNHM;
    }
    
    public ArrayList< LinkedList<Integer>> getPaths(int sum){
        if( sumToPathArrHM.containsKey( sum ) )
            return sumToPathArrHM.get( sum );
        else
            return null;
    }
    
}


