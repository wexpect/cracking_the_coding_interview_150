/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Method 1:        
//        int[] array = {7, 6, 2, 5, 0, 1, 4, 8, 3, 9};    

        // Method 2:
        int arraySize = 10000;        
        int[] array = new int[arraySize];

        Random generator = new Random();
        generator.setSeed(1);        
        for(int i = 0; i < arraySize; i++){
            array[i] = generator.nextInt(1000000);
        }                

        
        
        System.out.println( Arrays.toString( array ) );   
        
        BubbleSort bs = new BubbleSort();


        
        long startTime = System.currentTimeMillis();
        
        bs.bubbleSort(array);
        
        long endTime = System.currentTimeMillis();
        
        
        
        System.out.println( Arrays.toString( array ) );        
        
        System.out.println( "Elapsed time: " + (endTime - startTime) + " ms." );                
    }
    
    public void bubbleSort(int[] array){
        for(int k = array.length-2; k >= 0; k--){
            boolean swapped = false;
            
            for(int i = 0; i <= k; i++){
                if( array[i] > array[i+1]){                    
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    
                    swapped = true;
                }
                //System.out.println( Arrays.toString( array ) );                
            }                    
                    
            if( !swapped )
                return;            
        }
    }
    
}
