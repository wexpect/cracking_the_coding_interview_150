/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waystoplacechesses;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class WaysToPlaceChesses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WaysToPlaceChesses wtc = new WaysToPlaceChesses();                

        // Solu 1: better than Solu 0
        int n = 4;
        
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        wtc.placeChess(n, 0, arrayList, new ArrayList<Integer>() );
        System.out.println( arrayList );
        
        
        // Solu 0:        
        System.out.println("\n Solu 0:");
        
        int colMax = 3;  // max Index
        int column = 3;  // col Index
        
        System.out.println( wtc.getWays( colMax, column) );
        
    }
    
    
    // Solu 1:    
    public void placeChess(int n, int i, ArrayList<ArrayList<Integer>> arrayList, ArrayList<Integer> list){
        if( n <= 0 || i < 0 || list == null)
            return;
        
        if( i == n ){
            arrayList.add(list);
            return;
        }
        
        for(int j = 0; j < n; j++){
            if( isValid(n, i, j, list) ){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.addAll(list);
                newList.add(j);
                
                placeChess(n, i+1, arrayList, newList);            
            }        
        }
    }
    
    public boolean isValid(int n, int i, int j, ArrayList<Integer> list){
        for(int colIndex : list){
            if( j == colIndex)
                return false;
        }
        
        for(int k = 0; k < list.size(); k++){
            if(  ( k + list.get(k) == i + j ) || ( (k-0) + (n-1 - list.get(k)) == (i-0)+(n-1 - j) ) ){
                return false;
            }            
        }               
            
        return true;
    }
    
    
    
    // Solu 0: 
    public ArrayList<ArrayList<Integer>> getWays(int m, int c){
        
        System.out.println( "c = "+c );
        
        if (m == 0)
            return null;
        
        // can NOT do    return new ArrayList<ArrayList<Integer>>();
        // must initialize a newSolu, so that it is EMPYT, but not NULL; 
        // then add newSolu to newWays, so that newWays is EMPTY
        if ( c == -1){   
            ArrayList<Integer> newSolu = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> newWays = new ArrayList<ArrayList<Integer>>();
            newWays.add(newSolu);
            return newWays;
        }
        
        ArrayList<ArrayList<Integer>> oldWays = getWays(m, c - 1);
        ArrayList<ArrayList<Integer>> newWays = new ArrayList<ArrayList<Integer>>();
        

        System.out.println( "c = "+c +" oldWays = "+oldWays);           
        
        
        // if oldSolu == null, then will skip this for loop
        for(ArrayList<Integer> oldSolu : oldWays){
            
            System.out.println( "c = "+c +" oldSolu = "+ oldSolu); 
            
            for( int r = 0; r <= m; r++){
                if( findSpot(m, oldSolu, c, r) ){
                    ArrayList<Integer> newSolu = new ArrayList<Integer>();
                    newSolu.addAll(oldSolu);
                    newSolu.add(r);
                    System.out.println( "c = "+c +" add r = "+ r); 
                    newWays.add(newSolu);                
                }
            
            }
        }
    
        return newWays;
    }
    
    public boolean findSpot(int m, ArrayList<Integer> oldSolu, int c, int r){
        
        // oldSolu is empty, but is not NULL
        if ( oldSolu.isEmpty() ){
            System.out.println( "oldSolu is empty"); 
            return true;
        }
        
        for( int col = 0; col < oldSolu.size(); col++){
            int row = oldSolu.get(col);
            
            // same row
            if( row == r)
                return false;
            
            // same diagonal: same distance to (col, row) = (0,0) or (m,0)
            if(  ( (col + row ) == ( c + r) )  ||  ( (Math.abs( col - m ) + Math.abs( row - 0 )) == (Math.abs( c - m ) + Math.abs( r - 0 )) )    )
                return false;      
        } 
        
        return true;
    }
    
}
