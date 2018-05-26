/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pickmintegerfromn;

import java.util.Random;

/**
 *
 * @author Rui
 */
public class PickMIntegerFromN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PickMIntegerFromN pm = new PickMIntegerFromN();
        
        int[] arr = new int[52];
        for(int i = 0; i < 52; i++){
            arr[i] = i;
            System.out.print( arr[i] + " ");
        }       
        System.out.println();
        
        int m = 5;
        
        int[] set = pm.pick(arr, m);
        for(int i = 0; i < m; i++){
            System.out.print( set[i] + " ");
        }        
        
    }

    public int[] pick(int[] arr, int m){
        if( arr == null || arr.length < m)
            return null;
        
        int n = arr.length;
        
        Random rand = new Random();        
        int k = 0;
        
        int[] set = new int[m];
        int j = 0;
        
        for(int i = n-1 ; i >= (n-m); i--){
            k = rand.nextInt(i+1);
            
            set[j++] = arr[k];
            
            arr[k] = arr[i];
        }
        
        return set;
    }
  
}
