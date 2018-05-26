/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insertsortedarray;

/**
 *
 * @author Rui
 */
public class InsertSortedArray {

     public static void main(String[] args) {

        //int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] arr = {0,1,2,3,4,5,6,8,9};        
        
        // Insert target into i when target <= arr[i]        
        int target = 7;
        
        InsertSortedArray bs = new InsertSortedArray();
        
        // Solu 1        
        System.out.println( bs.binarySearchRecursion(arr, 0, arr.length -1, target) );
                    
        // Solu 2
        System.out.println( bs.binarySearchIteration(arr, target) );
        
    }
    
    // Solu 1
    public int binarySearchRecursion(int[] arr, int left, int right, int target){
                        
        if( left > right){   
            System.out.println( left +" "+right );            
            return left;  // meaning return the physical index which is larger 
            // when it comes to this step( left > right), target > arr[left-1] == arr[right] and target target < arr[right+1] == arr[left],
            // meaning arr[right] < target < arr[left], so return left
        }
                
        int mid = (left + right) / 2;

        if( target == arr[mid]  )
            return mid;
        else if( target < arr[mid]  )
            return binarySearchRecursion( arr, left, mid - 1, target);
        else
            return binarySearchRecursion( arr, mid+1, right, target);                    
    }
    
    

    // Solu 2    
    public int binarySearchIteration(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;  // be careful
        
        while( left <= right){
            int mid = (left + right)/2;
            
            if( arr[mid] == target)
                return mid;
            else if( target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
                            
        System.out.println( left +" "+right );  
        return left;
    }    
}
