/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class QuickSort {

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
        
        QuickSort qs = new QuickSort();

        
        
        long startTime = System.currentTimeMillis();
        
        qs.quickSort(array, 0, array.length - 1);
        
        long endTime = System.currentTimeMillis();
        
        
        
        System.out.println( Arrays.toString( array ) );        
        
        System.out.println( "Elapsed time: " + (endTime - startTime) + " ms." ); 
        
    }
    
    public void quickSort(int[] arr, int left, int right){
        if( left < right) {
            int pivotIndex = partition( arr, left, right);
            quickSort( arr, left, pivotIndex -1);
            quickSort( arr, pivotIndex + 1, right);
        }    
    }
    
    public int partition(int[] arr, int left, int right){                
//        System.out.println( "\n Before partition:");                        
//        for(int i = left; i <= right; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println(); 
        

        int p = right;
        
        int i = left;
        for( int k = left; k <= ( right -1 ); k++){
            if( arr[k] < arr[p] ){
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                
                i++;            
            }
        }
        
        int tmp = arr[i];
        arr[i] = arr[p];
        arr[p] = tmp;        
        
        
//        System.out.println( "After partition:");                        
//        for(int j = left; j <= right; j++){
//            System.out.print(arr[j] + " ");
//        }
//        System.out.println();         
        
        
        return i;
    }
    
}
