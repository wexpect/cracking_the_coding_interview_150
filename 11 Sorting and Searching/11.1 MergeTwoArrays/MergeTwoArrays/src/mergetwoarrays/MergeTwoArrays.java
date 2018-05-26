/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergetwoarrays;

import java.util.Arrays;

/**
 *
 * @author Rui
 */

public class MergeTwoArrays{
    
    public static void main(String[] args){
        int[] arrA = new int[10];
        int[] arrAElement = {1,3,5,7,9};
        for( int i = 0; i < 5; i++){
            arrA[i] = arrAElement[i];
        }
        
        int[] arrB = {-2,4,6,8,10};
        
        System.out.println( Arrays.toString(arrA));
        System.out.println( Arrays.toString(arrB));        
        
        MergeTwoArrays mta = new MergeTwoArrays();
        mta.mergeFromRear(arrA, 4, arrB);
        
        System.out.println( Arrays.toString(arrA));        
    }

    
    public void mergeFromRear(int[] arrA, int indexLastElementInA, int[] arrB){
        int i = indexLastElementInA;
        int j = arrB.length - 1;
        int k = (i+1)+(j+1)-1;

        while( i >= 0 && j >= 0){
            if( arrA[i] >= arrB[j]){
                arrA[k] = arrA[i];
                k--;
                i--;
            }
            else{
                arrA[k] = arrB[j];
                k--;
                j--;
            }            
        }

        if( i == -1 ){
            while( j >= 0 ){
                arrA[k] = arrB[j];
                k--;
                j--;        
            }    
        }
        
    }
}
