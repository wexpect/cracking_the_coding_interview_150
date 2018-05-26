/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stairways;

/**
 *
 * @author Rui
 */


public class StairWays{

    public static void main(String[] args){
    
        int n = 10;
        
        int[] numArr = new int[n+1];
        
        StairWays sw = new StairWays();
        System.out.println( sw.numWays(n, numArr) );
    }
    
    public int numWays(int stairIndex, int[] numArr){ 
        if(stairIndex < 0)
            return 0;
        else if(stairIndex == 0)
            return 1;
        else if(stairIndex == 1)
            return 1;
        else if(stairIndex == 2)
            return 2;        
        else if(stairIndex == 3)
            return 4;         
        else if( numArr[stairIndex] != 0)
            return numArr[stairIndex];
        else{ // where the last step come from: n - 1, n - 2, or n - 3
            numArr[stairIndex] = numWays(stairIndex-1, numArr) + numWays(stairIndex-2, numArr) + numWays(stairIndex-3, numArr);
            return numArr[stairIndex];
        }
    }
    
}