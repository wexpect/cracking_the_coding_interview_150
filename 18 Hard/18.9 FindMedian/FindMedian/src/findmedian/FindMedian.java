/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findmedian;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Rui
 */
public class FindMedian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                        
        double[] testArr = {9,0,5,1,2,8,4,3,7,6};
        
        FindMedian fm = new FindMedian();
        
     
        // Solu 2:
        System.out.println("Solu 2:");
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(11, new MyMaxHeapComparator());
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
        for(double num : testArr ){
            System.out.println( "median = " + fm.getMedian2(maxHeap, minHeap, num));
        }
        
                
        // Solu 1:
        System.out.println("Solu 1:");
        ArrayList<Double> arrayList = new ArrayList<Double>();        
        System.out.println("arrList = "+ arrayList.toString() );
        for(double num : testArr){
            System.out.println( "median = " + fm.getMedian(arrayList, num)+", arrList = "+ arrayList.toString() );
        }
    }
        
    
    // Solu 2: heap
    public Double getMedian2(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap, Double num){
        if( maxHeap == null || minHeap == null)
            return null;
        
        if( maxHeap.size() == 0 ){
            maxHeap.offer( num );
            return maxHeap.peek();
        }
        
        if( num <= maxHeap.peek() )
            maxHeap.offer( num );
        else
            minHeap.offer( num );
        
        return balance( maxHeap, minHeap);
    }
    
    public Double balance(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap){
        int difSize = maxHeap.size() - minHeap.size();
        
        if( difSize == 2){
            minHeap.offer( maxHeap.poll() );
            return ( maxHeap.peek() + minHeap.peek() ) / 2;
        }
        else if( difSize == 1)
            return maxHeap.peek();
        else if( difSize == 0)
            return ( maxHeap.peek() + minHeap.peek() ) / 2;
        else if( difSize == -1 )
            return minHeap.peek();
        else {
            maxHeap.offer( minHeap.poll() );
            return ( maxHeap.peek() + minHeap.peek() ) / 2;                  
        }
    }
    
    // Solu 1: maintain sorted ArrayList    
    public double getMedian(ArrayList<Double> arrayList, double num){
        
        if( arrayList.size() == 0 ){
            arrayList.add(num);
            return num;
        }

        int indexInsert = binarySearch(arrayList, 0, arrayList.size() - 1, num);
        arrayList.add(indexInsert, num);
                
        int lastIndex = arrayList.size() - 1;
        if( lastIndex % 2 == 0 )
            return arrayList.get( lastIndex / 2 );
        else
            return  ( arrayList.get( lastIndex / 2 ) + arrayList.get( lastIndex / 2 + 1)) / 2;        
    }
    
    public int binarySearch(ArrayList<Double> arrayList, int left, int right, double num){
        
        int mid = (left + right) / 2;
        
        if( mid == left ){
            if( num <= arrayList.get(mid) )
                return mid;
            else
                return mid + 1;
        }
        
        if( arrayList.get(mid) == num ){
            return mid;
        }
        else if( num < arrayList.get(mid) )
            return binarySearch(arrayList, left, mid - 1, num);
        else
            return binarySearch(arrayList, mid + 1, right, num);
    }
            
}
