/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // Method 1:        
//        int[] array = {7, 9, 6, 2, 5, 0, 1, 4, 8, 3};    

        // Method 2:
        int arraySize = 10000;        
        int[] array = new int[arraySize];

        Random generator = new Random();
        generator.setSeed(1);        
        for(int i = 0; i < arraySize; i++){
            array[i] = generator.nextInt(1000000);
        }                

        
        
        System.out.println( Arrays.toString( array ) );   
        
        MergeSort ms = new MergeSort();

        
        
        long startTime = System.currentTimeMillis();
        
        ms.mergeSort(array, 0, array.length - 1);
        
        long endTime = System.currentTimeMillis();
        
        
        
        System.out.println( Arrays.toString( array ) );        
        
        System.out.println( "Elapsed time: " + (endTime - startTime) + " ms." ); 
        
    }
    
    public void mergeSort(int[] arr, int left, int right){
        if( left < right){
            int middle = (left + right)/2; // Math.floor( (left+right)/2 );
            
            //System.out.printf("\nleft = %d, middle = %d, right = %d\n", left, middle, right );
                    
            
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            
            merge(arr, left, middle, right);
        }
    
    }
    
    public void merge(int[] arr, int left, int middle, int right){
        /*
        System.out.println( "\nMerge:");                        
        for(int i = left; i <= middle; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();        
        
        for(int i = middle + 1; i <= right; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        */
        
        
        int nLeft = middle - left + 1;
        int nRight = right - (middle + 1) + 1;
        
        int[] arrLeft = new int[ nLeft + 1];
        int[] arrRight = new int[ nRight + 1];
        
        for( int i = 0; i < nLeft; i++){
            arrLeft[i] = arr[left + i];
        }
        arrLeft[ nLeft ] = Integer.MAX_VALUE;
        
        for( int j = 0; j < nRight; j++){
            arrRight[j] = arr[middle + 1 + j];
        }        
        arrRight[ nRight ] = Integer.MAX_VALUE;
        
        
        int i = 0;
        int j = 0;
        for( int k = left; k <= right; k++){
            if( arrLeft[i] <= arrRight[j] ){
                arr[k] = arrLeft[i];
                i++;
            }
            else{
                arr[k] = arrRight[j];
                j++;
            }                
        }                
    }
    
}

//10000 
//
// SelectionSort                       10^8        140    
// MergeSort          10000 log 10000 = 40000       16       2500     8.75
// QuickSort                                        6                 23.3
// RadixSort                          10000         35