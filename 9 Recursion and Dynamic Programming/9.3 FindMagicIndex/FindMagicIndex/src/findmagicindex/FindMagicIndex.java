/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findmagicindex;

/**
 *
 * @author Rui
 */
public class FindMagicIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //-1 0 3 4 5 6 7 11 12 12 12 13 14 14 14 16
        // 0 1 2 3 4 5 6  7  8  9 10 11 12 13 14 15
        
        int[] arr = {-1, 0, 3, 4, 5, 6, 7, 11, 12, 12, 12, 13, 14, 14, 14, 16};
        
        FindMagicIndex fmi = new FindMagicIndex();
        System.out.println( fmi.getMagicInd(arr,0, arr.length - 1) );
        
    }
    
    public int getMagicInd(int[] arr, int left, int right){
        if( arr == null || left > right || left < 0 || right > arr.length -1 )
            return -1;
        
        int mid = (left + right)/2;
        
        if( arr[mid] == mid )
            return mid;
        else if( arr[mid] > mid){
            int result = getMagicInd(arr, left, mid - 1);
            if( result != -1)
                return result;
            
            result = getMagicInd(arr, arr[mid] , right);
            if( result != -1)
                return result;
            
            return -1;        
        }
        else{
            int result = getMagicInd(arr, left, arr[mid]);
            if( result != -1)
                return result;
            
            result = getMagicInd(arr, mid + 1 , right);
            if( result != -1)
                return result;
            
            return -1;        
        }               
        
    }
    
}
