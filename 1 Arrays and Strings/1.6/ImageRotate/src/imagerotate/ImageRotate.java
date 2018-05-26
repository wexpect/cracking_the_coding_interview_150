/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagerotate;

/**
 *
 * @author Rui
 */
public class ImageRotate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int N = 10;
        int[][] im = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                im[i][j] = 10 * i + j;
            }
        }
        
        ImageRotate ir = new ImageRotate();
        
        ir.printIm(im);
        
        System.out.println();
        
        
        // Solu 2:
        ir.imageRotate2(im);

        // Solu 1:
        //ir.imageRotate(im);        
        
        ir.printIm(im);
        
    }
    
    // Solu 2: actually same as Solu 1
    public void imageRotate2(int[][] im)
    {
        if( im == null)
            return;        
        
        int rM = im.length - 1;
        int cM = im[0].length - 1;
        
        if( rM != cM || rM == 0)
            return;
                
        int tmp;
                
        for(int r = 0; r <= rM/2; r++)
        {
            for(int c = r; c <= cM - r - 1; c++)
            {
                tmp = im[r][c];
                im[r][c] = im[c][rM-r];
                im[c][rM-r] = im[rM-r][rM-c];
                im[rM-r][rM-c] = im[rM-c][r];
                im[rM-c][r] = tmp;
            }
        }       
    }
    
    // Solu 1:
    public void imageRotate(int[][] im)
    {
        int N = im.length;
        int tmp;
                
        for(int i = 0; i < N/2; i++)
        {
            for(int j = i; j <= N - 1 - 1 - i; j++)
            {
                tmp = im[i][j];
                im[i][j] = im[j][N-1-i];
                im[j][N-1-i] = im[N-1-i][N-1-j];
                im[N-1-i][N-1-j] = im[N-1-j][i];
                im[N-1-j][i] = tmp;
            }
        }       
    }
    
    public void printIm(int[][] im)
    {
        int N = im.length;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(im[i][j] + " ");
            }            
            System.out.println();
        }        
    }
    
}
