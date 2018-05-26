/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class SelectionSort {

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
        
        SelectionSort ss = new SelectionSort();


        
        long startTime = System.currentTimeMillis();
        
        ss.selectionSort(array);
        
        long endTime = System.currentTimeMillis();
        
        
        
        System.out.println( Arrays.toString( array ) );        
        
        System.out.println( "Elapsed time: " + (endTime - startTime) + " ms." );               
    }
    
    public void selectionSort(int[] array){
        for( int i = 0; i < array.length - 1; i++){
            int minIndex = i;
                    
            for( int j = i + 1; j < array.length; j++){
                if (array[minIndex] > array[j])
                        minIndex = j;                
            }
            
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;        
            
//            System.out.println( Arrays.toString( array ) ); 
        }
    }
    
    
}
