/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortedmatrix;

/**
 *
 * @author Rui
 */
public class SearchSortedMatrix{

    public static void main(String[] args){
        int[][] arr = {{1, 2,3,4,5,6},{7,8,9,10,17,18},{8,9,10,16,17,18},{19,20,21,22,23,24}};
        for( int i = 0; i < arr.length; i++){
            for( int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();            
        }
        
        SearchSortedMatrix ssm = new SearchSortedMatrix();
        
        int target = 7;
               
        ElementCoordinate eCoord = ssm.searchSortedMatrix(arr, target);
        System.out.println("Coordinate is ("+eCoord.iR +", "+ eCoord.iC+").");
    }
    
    
    public ElementCoordinate searchSortedMatrix(int[][] arr, int target){
        System.out.println( searchSortedMatrix( arr, 0, arr[0].length-1, 0, arr.length-1, target) );
        return eleCoord;    
    }
    
    
    private ElementCoordinate eleCoord = new ElementCoordinate();  // must initialzie when declare, or will get null pointer exception

    public boolean searchSortedMatrix(int[][] arr, int left, int right, int top, int bottom, int target){
        System.out.printf("\ntop = %d, bottom = %d, left = %d, right = %d\n", top, bottom, left, right );
        
        //if( top <= bottom && left <= right ){ // this also works in this code
        if( isInBound(arr, left, right, top, bottom) ){
            int midR = (top + bottom)/2;
            int midC = (left + right)/2;
            
            
            System.out.printf("midR = %d, midC = %d, \n", midR, midC );
            System.out.println("Compare "+ arr[midR][midC]+" with target = "+ target);
            
            if( arr[midR][midC] == target){
                System.out.println("Found it!");
                eleCoord.iR = midR;
                eleCoord.iC = midC;

                return true;
            }
            else if( arr[midR][midC] < target){
                System.out.println("Smaller than target.");
                return searchSortedMatrix( arr, left, right, midR + 1, bottom, target) 
                        || searchSortedMatrix(arr, midC + 1, right, top, midR, target);
            }
            else{
                System.out.println("Larger than target.");
                return searchSortedMatrix( arr, left, right, top, midR - 1, target) 
                        || searchSortedMatrix(arr, left, midC - 1, midR, bottom, target);                
            }
        }
        else{
            System.out.println("Out of range.\n");
        }
        
        return false;
    }
    
    public boolean isInBound(int[][] arr,int left, int right, int top, int bottom){
        if(    0<=left && left <= arr[0].length
            && 0<=right && right <= arr[0].length    
            && left <= right 
            && 0<=top && top <= arr.length
            && 0<=bottom && bottom <= arr.length
            && top <= bottom )
            return true;
        else
            return false;
    }
    
    public class ElementCoordinate{
        public int iR = -1;     
        public int iC = -1;   
    }
}