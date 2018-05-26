/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findkthsmallestnum;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author Rui
 */
public class FindKthSmallestNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FindKthSmallestNum f = new FindKthSmallestNum();
        
        int[] arr = {10,2, 6, 5,7,9,8,3,1,12,11,4};
        int k = 5;
        
        // Solu 2:        
        System.out.println(f.getHeap(arr, k));        
        
        // Solu 3: better
        //int[] list = f.getFirstKSmallest(arr, k);
        //System.out.println(Arrays.toString(list));        
    }
    
    // Solu 2
    public PriorityQueue<Integer> getHeap(int[] arr, int k){
        if( arr == null || arr.length < k || k <= 0)
            return null;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new MyMaxHeapComparator() );
        
        for(int i : arr){
            if( maxHeap.size() < k ){
                maxHeap.add(i);
            }
            else{
                if( i < maxHeap.peek() ){
                    maxHeap.poll();
                    maxHeap.offer(i);
                }
            }
        
        }
        
        System.out.println( maxHeap.poll() );
        System.out.println( maxHeap.poll() );
        System.out.println( maxHeap.poll() );
        System.out.println( maxHeap.poll() );
        System.out.println( maxHeap.poll() );
        
        return maxHeap;        
    }
    
    
    // Solu 3:
    public int[] getFirstKSmallest(int[] arr, int k){
        if( arr == null || k <= 0 || arr.length < k)
            return null;
        
        int index = selectKthNum(arr, 0, arr.length - 1, k);
        System.out.println("index = "+index);
        
        int[] list = new int[k];
        for(int i = 0; i <= index; i++){
            list[i] = arr[i];
        }

        return list;
    }
    
    public int selectKthNum(int[] arr, int left, int right, int k){
        int index = partition(arr, left, right);
        
        if( k == index + 1 )
            return index;
        else if( k < index + 1)
            return selectKthNum(arr, left, index - 1, k);
        else
            return selectKthNum(arr, index + 1, right, k );       
    }
        
    public int partition(int[] arr, int left, int right){
        int pivot = right;
        int i = left;
        for(int j = left; j <= right - 1; j++){
            if( arr[j] < arr[pivot] ){
                swap(arr, i, j);
                i++;
            }
        }
        
        swap(arr, i, pivot);
        return i;    
    }
    
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
