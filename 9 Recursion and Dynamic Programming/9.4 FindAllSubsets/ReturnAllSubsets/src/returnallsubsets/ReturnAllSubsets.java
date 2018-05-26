/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnallsubsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class ReturnAllSubsets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("\n\nSolu 1 Recursion, I like this."); 
        Integer[] set1 = {0,1,2,3,4,5};
        
        ReturnAllSubsets ras1 = new ReturnAllSubsets();
        
        ArrayList<ArrayList<Object>> subsets1 = ras1.getSubsets1(set1, set1.length - 1);
        for( ArrayList<Object> subset : subsets1){
            System.out.println( subset );
        }
        
        
        System.out.println("\n\nSolu 2 bitwise");        
        ArrayList<Integer> set2 = new ArrayList<Integer>();
        set2.add(2);
        set2.add(1);
        set2.add(0);
        
        ReturnAllSubsets ras2 = new ReturnAllSubsets();
        
        ArrayList<ArrayList<Integer>> subsets2 = ras2.getSubsets2(set2);
        for( ArrayList<Integer> subset : subsets2){
            System.out.println( subset );
        }        
        
        
        System.out.println("\n\nSolu 0"); 
        //Object[] set = {0,1,2,3,4,5};  // also works
        Integer[] set = {0,1,2,3,4,5};
        
        ReturnAllSubsets ras = new ReturnAllSubsets();
        
        ArrayList<Object[]> subsets = ras.getSubsets(set);
        for( Object[] subset : subsets){
            System.out.println( Arrays.toString(subset) );
        }        
    }


    // Solu 1: recursion 
    ArrayList< ArrayList<Object> > getSubsets1( Object[] set, int endIndex ){
        if( set == null || endIndex < -1)
            return null;
        
        if( endIndex == -1 ){
            ArrayList<Object> subset = new ArrayList<Object>();
            ArrayList< ArrayList<Object> > subsetsList = new ArrayList< ArrayList<Object> >();
            subsetsList.add( subset );
            
            System.out.println("first subset:" + subset );
            System.out.println("first subsetsList:" + subsetsList );
            
            return subsetsList;
        }
        
        ArrayList< ArrayList<Object> > subsetsList = getSubsets1( set, endIndex - 1);
        int currentSize = subsetsList.size(); // must calculate the size of subsetsList here first, because subsetList will keep growing; if not, error called "Concurrent Modification" will happen
        
        for( int i = 0; i < currentSize; i++){
            ArrayList<Object> subset = subsetsList.get(i);
            
            ArrayList<Object> newSubset = new ArrayList<Object>();
            newSubset.addAll(subset);   // addAll is important
            newSubset.add(set[endIndex]);
            subsetsList.add( newSubset);        
        }
        return subsetsList;        
    }        
    

    // Solu 2: bitwise
    ArrayList< ArrayList<Integer> > getSubsets2( ArrayList<Integer> set ){
    
        ArrayList< ArrayList<Integer> > allsubsets = new ArrayList< ArrayList<Integer> >();
        
        //int kMax = ( 1 << set.size() ) - 1;  // also works
        int kMax = (int)Math.pow(2, set.size() ) - 1;
        
        for(int k = 0; k <= kMax; k++){
            System.out.println("\nk0 = " + k);
            
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        
        return allsubsets;
    
    }

    ArrayList<Integer> convertIntToSet( int k, ArrayList<Integer> set){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = set.size() - 1;
        
        System.out.println("k = " + k);        
        for( int x = k; x > 0; x >>= 1){   // >>= means bitwise shift x to right, and assign the new value to x; >> means bitwise shift x to right, but NOT assign the new value to x
            System.out.println("x = " + x+", index = "+index);            
            
            if( (x & 1) == 1){
                System.out.println("add " + set.get( index )); 
                subset.add( set.get( index ) );                
            }
            index--;        
        }
        
        System.out.println("subset = " + subset+"\n");  
        return subset;
    }
    
    
    // Solu 0: not so good
    public ArrayList<Object[]> getSubsets(Object[] set){
        if( set == null )
            return null;
        
        ArrayList<Object[]> subsetList = new ArrayList<Object[]>();
        
        Object[] emptySubset = {};
        
        subsetList.add(emptySubset);
        
        int iList = 0;
        
        while( iList < subsetList.size() ){
            Object[] oldSubset = subsetList.get( iList );
            int lastIndex = getLastIndex( oldSubset, set);
            
            for( int j = lastIndex + 1; j < set.length; j++){
                Object[] newSubset = new Object[ oldSubset.length + 1];
                
                for( int k = 0; k < oldSubset.length; k++){
                    newSubset[k] = oldSubset[k];
                }
                newSubset[ oldSubset.length ] = set[j];
                
                subsetList.add( newSubset );
               
                //System.out.println( "oldSubset = " + Arrays.toString( oldSubset ) );
                //System.out.println( "newSubset = " + Arrays.toString( newSubset ) );
            }
            
            iList++;        
        }
        
        return subsetList;        
    }
    
    public int getLastIndex(Object[] oldSubset, Object[] set){
        if( oldSubset.length == 0 )
            return -1;
        
        for( int i = 0; i < set.length; i++){
            if( oldSubset[ oldSubset.length - 1] == set[i])
                return i;
        }       
        
        return -1;
    }
 
}
