/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primelist;

import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class PrimeList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 17;
        
        PrimeList pl = new PrimeList();
        
        LinkedList<Integer> list = pl.getPrimes(n);               
        System.out.println(list);
    }
    
    public LinkedList<Integer> getPrimes(int n){
        if( n < 0)
            return null;
        
        boolean[] arr = new boolean[n+1];
        init(arr);
        
        for(int p = 2; p <= n; p++){
            if( arr[p] ){
                for( int k = 2; k * p <= n; k++){
                    if( arr[ k * p] )
                        arr[ k * p ] = false;
                }
            }
        }
    
        LinkedList<Integer> list = new LinkedList<Integer>();        
        
        for(int i = 2; i <= n; i++){
            if( arr[i] )
                list.add(i);
        }
        
        return list;
    }
    
    public void init( boolean[] arr ){
        int len = arr.length;
        
        if( len >= 1 )
            arr[0] = false;
        
        if( len >= 2)
            arr[1] = false;
        
        for( int i = 2; i < len; i++){
            arr[i] = true;
        }
    }
}
