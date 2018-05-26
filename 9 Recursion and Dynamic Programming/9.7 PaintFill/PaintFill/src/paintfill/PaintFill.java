/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintfill;

import java.awt.Color;

/**
 *
 * @author Rui
 */
public class PaintFill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Color[][] cMatrix = {{Color.RED,    Color.RED,   Color.RED,   Color.GREEN},
                             {Color.GREEN,  Color.GREEN, Color.GREEN, Color.BLUE},
                             {Color.GREEN,  Color.GREEN, Color.GREEN, Color.BLUE},
                             {Color.YELLOW, Color.GREEN, Color.BLUE,  Color.GREEN}, };
        
        PaintFill pf = new PaintFill();
        
        // in graphical problem, x is horizon axis (column), and y is vertical axis (row)
        int x = 3;  // column
        int y = 0;  // row
        Color oldC = Color.GREEN;
        Color newC = Color.BLACK;   // RGB (0,0,0)            
        
        pf.fill(cMatrix, x, y, oldC, newC);
        
        for(int i = 0; i < cMatrix[0].length; i++){
            for(int j = 0; j < cMatrix.length; j++){
                System.out.print(cMatrix[i][j]+" ");
            }                        
            System.out.println();
        }
        
    }
    
    public void fill(Color[][] cMatrix, int x, int y, Color oldC, Color newC){
        
        if( cMatrix == null )
            return;
        
        
        int xMax = cMatrix[0].length - 1;
        int yMax = cMatrix.length - 1;
        
        
        if( x < 0 || x > xMax || y < 0 || y > yMax)
            return;
        
        // the use of [y, x] is important here
        if( cMatrix[y][x] != oldC )  
            return;
        
        cMatrix[y][x] = newC;
     
        fill(cMatrix, x, y - 1, oldC, newC);
        fill(cMatrix, x, y + 1, oldC, newC);
        fill(cMatrix, x - 1, y, oldC, newC);
        fill(cMatrix, x + 1, y, oldC, newC);    
    }
    

}
