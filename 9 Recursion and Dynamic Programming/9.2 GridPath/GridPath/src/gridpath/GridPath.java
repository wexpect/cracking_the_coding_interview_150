
//---------------------------------------------------------------------

// Solu 1
// Dynamic Programming

package gridpath;

/**
 *
 * @author Rui
 */


public class GridPath{
    
    public static void main(String[] args){
    
        int xD = 15;  // result should be 6
        int yD = 15;
        int[][] numArr = new int[xD+1][yD+1];
        
        GridPath gp = new GridPath();
        System.out.println( gp.numPath(0, 0, xD, yD, numArr) );
        
    }

    
    public int numPath(int x, int y, int xD, int yD, int[][] numArr){
        if( xD < 0 || yD < 0 )
            return 0;
        else if( x == xD || y == yD )
            return 1;
        else if( numArr[x][y] != 0 )
            return numArr[x][y];
        else{
            numArr[x][y] = numPath(x+1, y, xD, yD, numArr) + numPath(x, y+1, xD, yD, numArr);
            return numArr[x][y];
        }
            
    }
}



//---------------------------------------------------------------------
// Solu 2:
// The following is using recursion, so very slow

//package gridpath;
//
//public class GridPath{
//    
//    public static void main(String[] args){
//    
//        int xD = 15;  // result should be 6
//        int yD = 15;
//        
//        GridPath gp = new GridPath();
//        System.out.println( gp.numPath(0, 0, xD, yD) );
//        
//    }
//
//    
//    public int numPath(int x, int y, int xD, int yD){
//        if( xD < 0 || yD < 0 )
//            return 0;
//        else if( x == xD || y == yD )
//            return 1;
//        else{
//             return numPath(x+1, y, xD, yD) + numPath(x, y+1, xD, yD);             
//        }
//            
//    }
//}