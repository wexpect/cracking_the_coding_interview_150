/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searcharraywithemptystrings;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class SearchArrayWithEmptyStrings{

    public static void main(String[] args){
        String[] arr = {"at","","","","ball","","","car","","","dad","","","go","","","","","","","","","","haha"};
        System.out.println( Arrays.toString(arr) );
        
        
        SearchArrayWithEmptyStrings test = new SearchArrayWithEmptyStrings();
        
        String target = "haha";
        System.out.println(  test.search(arr, target) );
      
    }
    
    public int search(String[] arr, String target){
        if( arr == null || target == null || target =="")
            return -1;
        else
            return search(arr, 0, arr.length - 1, target);
    }
    
    public int search(String[] arr, int left, int right, String target){
        if(left > right){                
            System.out.printf( "No solution.");
            return -1;        
        }
         
        
        int mid = (left + right)/2;
        System.out.println( "mid0 = "+mid );            

        if( arr[mid].isEmpty() ){
            int index = getClosestString(arr, left, right, mid);
            if( index == -1)
                return -1;
            else
                mid = index;
        }            
        System.out.println( "mid1 = "+mid );

        if( arr[mid].compareTo(target) == 0 ){
            System.out.println( "Find it! mid = " + mid );
            return mid;
        }
        else if( arr[mid].compareTo(target) > 0 ){
            System.out.printf( "Go to left: [%d %d] \n", left, mid - 1 );
            return search(arr, left, mid - 1, target);
        }
        else{
            System.out.printf( "Go to right: [%d %d] \n", mid + 1, right );
            return search(arr, mid + 1, right, target);
        }
        
        
    }
    
    public int getClosestString(String[] arr, int left, int right, int mid){
        int offset = 1;
        
        while( mid - offset >= left || mid + offset <= right){
            System.out.println( "offset = "+  offset );
            
            if( mid - offset >= left && !arr[mid-offset].isEmpty() )
                return mid - offset;
            else if( mid + offset <= right && !arr[mid+offset].isEmpty() )
                return mid + offset;
            else
                offset++;        
        }
        
        return -1;
    }
}