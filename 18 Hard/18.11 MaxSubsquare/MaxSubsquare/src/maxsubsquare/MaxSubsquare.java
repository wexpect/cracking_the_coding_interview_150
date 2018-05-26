/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maxsubsquare;

/**
 *
 * @author Rui
 */
public class MaxSubsquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaxSubsquare ms = new MaxSubsquare();
        char[][] arr = {{'W','W','W','B'},
                        {'W','B','B','B'},
                        {'W','B','W','B'},
                        {'W','B','B','B'},};
        
        // Solu 1: better
        Square sq1 = ms.getMax(arr);
        System.out.println("("+ sq1.r +", "+sq1.c+"), k = "+sq1.k);
                
        
        // Solu 0
        Square sq = ms.getMaxSquare(arr);
        System.out.println("("+ sq.r +", "+sq.c+"), k = "+sq.k);        
    }
    
    // Solu 1
    public Square getMax(char[][] arr){
        if( arr == null || arr.length != arr[0].length )
            return null;
        
        for(int d = arr.length-1; d >= 0 ; d--){
            for(int i = 0; i + d <= arr.length-1; i++){
                for(int j = 0; j + d <= arr[0].length-1; j++){
                    if( isValid(arr, i, j, d) ){
                        Square subsquare = new Square(i,j,d);
                        return subsquare;
                    }                        
                }
            }
        }
        return null;
    }
    
    public boolean isValid(char[][] arr, int i, int j, int d){
        for(int l = j; l <= j+d; l++){
            if( arr[i][l] != 'B' )
                return false;
        }
        
        for(int l = j; l <= j+d; l++){
            if( arr[i+d][l] != 'B' )
                return false;
        }        
        
        for(int l = i+1; l <= i+d-1; l++){
            if( arr[l][j] != 'B' )
                return false;
        }        
        
        for(int l = i+1; l <= i+d-1; l++){
            if( arr[l][j+d] != 'B' )
                return false;
        }           
        
        return true;
    }
    
    // Solu 0
    public Square getMaxSquare(char[][] arr){
        
        if( arr == null )
            return null;                
        
        int rowLeng = arr.length;
        int colLeng = arr[0].length;
        
        if( rowLeng != colLeng)
            return null;
        
        Square maxSquare = new Square(-1, -1, Integer.MIN_VALUE);
        
        for(int i = 0; i < rowLeng; i++){
            for( int j = 0; j < colLeng; j++){
            
                for( int k = Math.min( rowLeng-1-i, colLeng-1-j ); k >= 0 && k > maxSquare.k; k--){
                    if( bordersAreBlack(arr, i, j, k) ){
                        maxSquare.r = i;
                        maxSquare.c = j;
                        maxSquare.k = k;
                        
                        break;
                    }                                
                }
            
            }
        }
        
        if( maxSquare.r == -1 )
            return null;
        else        
            return maxSquare;    
    }
    
    public boolean bordersAreBlack(char[][] arr, int i, int j, int k){
        if( k == 0)
            return arr[i][j] == 'B';
        
        if( k == 1)
            return arr[i][j] == 'B' && arr[i][j+1] == 'B' && arr[i+1][j] == 'B' && arr[i+1][j+1] == 'B';
        
        for(int l = 0; l <= k; l++){
            if( arr[i][j+l] == 'W' || arr[i+k][j+l] == 'W')
                return false;        
        }
        
        for(int l = 1; l <= k-1; l++){
            if( arr[i+l][j] == 'W' || arr[i+l][j+k] == 'W')
                return false;        
        }        
        
        return true;
    }
    
        
    public class Square{
        public int r;
        public int c;
        public int k;
        
        public Square(int i, int j, int d){
            r = i;
            c = j;
            k = d;
        }
    }
}
