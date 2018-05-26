/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchrotatedarray;

/**
 *
 * @author Rui
 */
public class SearchRotatedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] arr = {0,1,2,3,4,5,6,7,8,9};
        //int[] arr = {4,4,5,6,7,8,9,0,1,2,3,4,4};
        //int[] arr = {4};
        int[] arr = { 4,4,5,6,7,8,9,9,9,0,1,2,3,4,4};
        
        int target = 8;
        
        SearchRotatedArray sra = new SearchRotatedArray();             
        
        // Solu 0: worse than linear search
        System.out.println( sra.searchRotatedArray(arr,target) );

        // Solu 1: better
        System.out.println( sra.search(arr,0, arr.length-1, target) );
    }
    
    // Solu 1: time complexity O(logn)
    public int search(int[] arr, int left, int right, int e){
        if( arr == null || left < 0 || right > arr.length - 1 || left > right)
            return -1;
        
        int mid = (left + right)/2;
        if ( arr[mid] == e)
            return mid;
        
        if ( arr[left] <= arr[mid-1] ){
            if( arr[left] <= e && e <= arr[mid-1])
                return search(arr, left, mid-1, e);
            else
                return search(arr, mid+1,right, e);
        }
        else{
            if( arr[mid+1] <= e && e<= arr[right])
                return search(arr, mid+1,right, e);
            else
                return search(arr, left, mid-1, e);
        }
    }
    
    
    //                          find iMax   + binary search
    // Solu 0: time complexity O(  n         + logn ), so not good. becuase only linear search is already O(n)
    public int searchRotatedArray(int[] arr, int target){                
        
        boolean rotated = false;        
        int indexMax = arr.length - 1;
        
        // this considers the case where arr only has one element
        for( int i = 0; i <= arr.length - 2; i++){
            if( arr[i] > arr[i+1]){
                indexMax = i;
                rotated = true;
                break;
            }        
        }        
        System.out.println("rotated = "+rotated+", indexMax ="+indexMax);
        
        if( rotated ){
            if( target >= arr[0])
                return binarySearch(arr, 0, indexMax, target);
            else
                return binarySearch(arr, indexMax + 1, arr.length-1, target);        
        }
        else
            return binarySearch(arr, 0, arr.length-1, target);    
    }
    
    
    public int binarySearch(int[] arr, int left, int right, int target){
        
        if( left <= right){
            int mid = (left + right) / 2;
            
            if( arr[mid] == target )
                return mid;
            else if( arr[mid] > target )
                return binarySearch( arr, left, mid - 1, target);
            else
                return binarySearch( arr, mid+1, right, target);            
        }
        else
            return -1;
    }    
}
