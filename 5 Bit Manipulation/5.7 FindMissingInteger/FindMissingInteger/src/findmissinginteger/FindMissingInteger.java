/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findmissinginteger;

/**
 *
 * @author Rui
 */


public class FindMissingInteger{
    public static void main(String[] args){
        int n = 5;
        int[] arr = new int[n];
        /*   000
         *   001
         *   010
         *   011
         *   100 missing
         *   101
         */
        
        FindMissingInteger fmi = new FindMissingInteger();
        
        int missInt = fmi.findMissing(arr, n);
        System.out.println(missInt);
        System.out.println(Integer.toBinaryString(missInt));
    }

    
    // runing time is  O(nlog_2(n)). becuase = O(1) * n * bitsOfInteger, where bitsOfInteger = log_2(n)
    
    public int findMissing(int[] arr, int n){
        String numStr = "";
        
        for(int j = 0; j <= 2; j++){
            int bitj = getBitj(arr, n, j);
            
            numStr = bitj + numStr;
        
        }
        
        int num = Integer.parseInt(numStr, 2);
        
        return num;    
    }
    
    
    public int getBitj(int[] arr, int n, int j){
        int theDifj = getTheDifj(n, j);
        int realDifj = getRealDifj( arr, n, j);
        
        if( realDifj > theDifj ){
            return 1;            
        }
        else{
            return 0;
        }    
    }
    
    public int getTheDifj(int n, int j){
        int residue = ( n + 1) % ( 2 * (int)Math.pow(2, j) );
        
        if( residue <= (int)Math.pow(2, j) )
            return residue;
        else
            return (int)Math.pow(2,j) - (residue - (int)Math.pow(2,j) );                
    }
    
    public int getRealDifj(int[] arr, int n, int j){
        int count0j = 0;
        int count1j= 0;
        
        for( int i = 0; i < n; i++){
            int value = fetchBit(arr, i, j);
            
            if( value == 0)
                count0j++;
            else
                count1j++;
        }
        
        return count0j - count1j;    
    }
    
    public int fetchBit(int[] arr, int i, int j){
        switch(i){
            case 0:
                switch(j){
                    case 0: return 0;
                    case 1: return 0; 
                    case 2: return 0;
                }                
            case 1:
                switch(j){
                    case 0: return 1;
                    case 1: return 0; 
                    case 2: return 0;
                }                
            case 2:
                switch(j){
                    case 0: return 0;
                    case 1: return 1; 
                    case 2: return 0;
                }                
            case 3:
                switch(j){
                    case 0: return 1;
                    case 1: return 1; 
                    case 2: return 0;
                }                
            case 4:
                switch(j){
                    case 0: return 1;
                    case 1: return 0; 
                    case 2: return 1;
                } 
            default:
                return 0;
        }
    
    }
}
