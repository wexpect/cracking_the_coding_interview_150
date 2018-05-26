/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integerpairs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class IntegerPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    // The code is not finished, but idea is right
    public ArrayList<Pair> getPairs(int[] arr, int value){
        if( arr == null || arr.length <= 1)
            return null;
        
        HashMap<Integer, Integer> hm = makeHM(arr);
        ArrayList<Pair> list = new ArrayList<Pair>();
        
        for(Integer a : hm.keySet() ){
            int numa = hm.get(a);
            
            if(numa != 0){
                int b = value - a;
                
                if( a != b){
                    if( hm.containsKey(b) ){
                        Pair p = new Pair(a,b, numa * hm.get(b));
                        hm.put(a, 0);
                        hm.put(b,0);
                        list.add(p);
                    }
                }
                else{ // a == b
                    if( numa >= 2){
                        int numPair = getPairNum(numa);
                        Pair p = new Pair(a,a,numPair);
                        hm.put(a,0);
                        list.add(p);
                    }                
                }            
            }        
        }
        
        return list;                    
    }
    
    public HashMap<Integer, Integer> makeHM(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int n : arr){
            if( hm.containsKey(n) )
                hm.put(n, hm.get(n)+1);
            else
                hm.put(n, 1);
        }
        return hm;    
    }
    
    public int getPairNum(int n){
        // do  C(n,2)
        // C(n,k) = n!/( k! * (n-k)! )
    }
}
