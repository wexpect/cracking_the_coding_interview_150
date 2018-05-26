/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maxsubmatrixsum;

/**
 *
 * @author Rui
 */
public class MaxSubmatrixSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaxSubmatrixSum ms = new MaxSubmatrixSum();
        
        int[][] arr = { {-1,1, 3,-4},
                        {-1,1, 3, 4},
                        {-1,1, 3, 4},
                        {-1,1, 3, 4}};
        
        // Solu 1: better
        Matrix maxMatrix1 = ms.getMaxSubmatrix1(arr);
        System.out.println("(" + maxMatrix1.i + ", "+maxMatrix1.j +"), ("+maxMatrix1.k+ ", " +maxMatrix1.l+"), sum = "+maxMatrix1.sum);         
        
        // Solu 0: 
        Matrix maxMatrix = ms.getMaxSubmatrix(arr);
        System.out.println("(" + maxMatrix.i + ", "+maxMatrix.j +"), ("+maxMatrix.k+ ", " +maxMatrix.l+"), sum = "+maxMatrix.sum); 
    }
    
    // Solu 1
    public Matrix getMaxSubmatrix1(int[][] arr){
        if( arr == null || arr.length != arr[0].length)
            return null;
        
        int[][] sum = makeSum(arr);
        Matrix subMatrix = new Matrix(-1, -1, -1, -1, Integer.MIN_VALUE);
        
        for(int i1 = 0; i1 < arr.length; i1++){
            for(int j1=0; j1 < arr[0].length; j1++){
                for(int i2 = 0; i2 < arr.length; i2++){
                    for(int j2=0; j2 < arr[0].length; j2++){
                        int subSum = getSum(sum, i2, j2) - getSum(sum, i1-1, j2) - getSum(sum,i2, j1-1) + getSum(sum,i1-1, j1-1);
                        
                        if( subSum > subMatrix.sum ){
                            subMatrix = new Matrix(i1, j1, i2, j2, subSum);             
                        }
                    }
                }
            }
        }
        return subMatrix;
    }
    
    public int[][] makeSum(int[][] arr){
        int[][] sum = new int[arr.length][arr[0].length];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if( i == 0 && j == 0)
                    sum[i][j] = arr[i][j];
                else if( i == 0 && j!= 0)
                    sum[i][j] = sum[i][j-1] + arr[i][j];
                else if( i != 0 && j== 0)
                    sum[i][j] = sum[i-1][j] + arr[i][j];                
                else
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }
        
        return sum;
    }
    
    public int getSum(int[][] sum, int i, int j){
        if( i < 0 || i > sum.length-1 || j < 0 || j > sum[0].length-1)
            return 0;
        else
            return sum[i][j];
    }
    
    // Solu 0
    public Matrix getMaxSubmatrix(int[][] arr){
        if( arr == null )
            return null;
        
        int rLeng = arr.length;
        int cLeng = arr[0].length;
        
        if( rLeng != cLeng )
            return null;
        
        Matrix maxMatrix = new Matrix();
        
        for(int i = 0; i < rLeng; i++){
            for( int j = 0; j < cLeng; j++){                
                
                for( int k = i; k < rLeng; k++){
                    int sum = 0;
                    
                    for( int l = j; l < cLeng; l++){
                        sum += getPartialSum(arr, i, j, k, l);
                    
                        if( sum > maxMatrix.sum ){
                            maxMatrix.i = i;
                            maxMatrix.j = j;
                            maxMatrix.k = k;
                            maxMatrix.l = l;
                            maxMatrix.sum = sum;
                        }                
                    }
                }
            
            }
        }
        
        return maxMatrix;
    }
    
    public int getPartialSum(int[][] arr, int i, int j, int k, int l){
        
        int colSum = 0;
        for(int r = i; r <= k; r++){
            colSum += arr[r][l];
        }
        
        return colSum;
    }
    
    public class Matrix{
        public int i;
        public int j;
        public int k;
        public int l;
        public int sum = Integer.MIN_VALUE;
        
        public Matrix(){
        }
        
        public Matrix(int i1, int j1, int i2, int j2, int sum){
            i = i1;
            j = j1;
            k = i2;
            l = j2;
            this.sum = sum;
        }
    }
}
