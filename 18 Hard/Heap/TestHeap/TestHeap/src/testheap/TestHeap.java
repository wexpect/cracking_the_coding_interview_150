/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testheap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author Rui
 */
public class TestHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double[] arr = {9,0,5,1,2,8,4,3,7,6};
        System.out.println("arr = "+ Arrays.toString( arr )  );

        
        
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>();                
        for(double num : arr)
            minHeap.offer( num );
        
        System.out.print("minHeap = ");
        while( !minHeap.isEmpty() )
            System.out.print( minHeap.poll() + ", ");
        
        
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(11, new MyMaxHeapComparator());               
        
        for(double num : arr)
            maxHeap.offer( num );
        
        System.out.print("\nmaxHeap = ");
        while( !maxHeap.isEmpty() )
            System.out.print( maxHeap.poll() + ", ");
    }
}
