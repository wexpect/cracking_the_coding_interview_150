/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zeromatrix;

/**
 *
 * @author Rui
 */
public class ZeroMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matrix = {{0,2,0,4,5},{6,7,0,9,10},{11,12,13,14,15}};        
        
        ZeroMatrix zm = new ZeroMatrix();
       
        zm.zeroMatrix(matrix);
                
        zm.zeroMatrixBetter(matrix);                       
    }
    
    // Solu 1
    public int[][] zeroMatrix(int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;
        

        int[][] newMatrix = new int[M][N];
        for(int r = 0; r < M; r++)
        {
            for(int c = 0; c < N; c++)
            {
                newMatrix[r][c] = matrix[r][c];
            }   
        }
        printMatrix(matrix);
        printMatrix(newMatrix);
        
        
        boolean[] rowSet = new boolean[M];
        boolean[] colSet = new boolean[N];
        
        for(int r = 0; r < M; r++)
        {
            for(int c = 0; c < N; c++)
            {
                if( matrix[r][c] == 0 )
                {
                    if( !rowSet[r] )
                    {
                        for(int j = 0; j < N; j++)
                        {
                            newMatrix[r][j] = 0;    
                        }
                        rowSet[r] = true;
                    }
                   
                    if( !colSet[c] )
                    {
                        for(int i = 0; i < M; i++)
                        {
                            newMatrix[i][c] = 0;    
                        }                
                        colSet[c] = true;
                    }

                }
        
            }
    
        }
        
        printMatrix(matrix);         
        printMatrix(newMatrix);
        
        return newMatrix;
    }
    
    

    // Solu 2
    public void zeroMatrixBetter(int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;
        
        printMatrix(matrix);
        
        boolean[] rowSet = new boolean[M];
        boolean[] colSet = new boolean[N];
        
        for(int r = 0; r < M; r++)
        {
            for(int c = 0; c < N; c++)
            {
                if( matrix[r][c] == 0 )
                {                  
                    rowSet[r] = true;                   
                    colSet[c] = true;                 
                }
            }    
        }
        
        for(int r = 0; r < M; r++)
        {
            for(int c = 0; c < N; c++)
            {
                if( rowSet[r] || colSet[c] )
                {                  
                    matrix[r][c] = 0;
                }
            }    
        }        
        
        printMatrix(matrix);                       
    }
    
    
    public void printMatrix(int[][] im)
    {
        int M = im.length;
        int N = im[0].length;
        
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(im[i][j] + " ");
            }            
            System.out.println();
        }                            
        System.out.println();
    }    
}
