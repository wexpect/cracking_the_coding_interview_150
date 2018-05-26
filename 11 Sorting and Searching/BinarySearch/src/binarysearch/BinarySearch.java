/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author Rui
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        
        int target = 6;
        
        BinarySearch bs = new BinarySearch();
        
        // Solu 1        
        System.out.println( bs.binarySearchRecursion(arr, 0, arr.length -1, target) );
                    
        // Solu 2
        System.out.println( bs.binarySearchIteration(arr, target) );
        
    }
    
    // Solu 1
    public int binarySearchRecursion(int[] arr, int left, int right, int target){
        
        if( left <= right){
            int mid = (left + right) / 2;
            
            if( arr[mid] == target )
                return mid;
            else if( arr[mid] > target )
                return binarySearchRecursion( arr, left, mid - 1, target);
            else
                return binarySearchRecursion( arr, mid+1, right, target);            
        }
        else
            return -1;
    }
    
    // Solu 2    
    public int binarySearchIteration(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;  // be careful
        
        while( left <= right){
            int mid = (left + right)/2;
            
            if( arr[mid] == target)
                return mid;
            else if( arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
