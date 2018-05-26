/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawline;

/**
 *
 * @author Rui
 */
public class DrawLine{
    
    public static void main(String[] args){
        byte[] screen = new byte[16];
        int width = 32;
        int x1 = 10;
        int x2 = 26;
        int y = 2;
        
        DrawLine dl = new DrawLine();
        dl.draw(screen, width, x1, x2, y);
        
        for( int r = 0; r <= 3; r ++){
            for( int c = 0; c <= 3; c++){
                System.out.print(screen[ r*4 + c ] + " ");
            }
            System.out.println();
        }

        System.out.println();
        
        for( int r = 0; r <= 3; r ++){
            for( int c = 0; c <= 3; c++){
                System.out.print(  Integer.toBinaryString( (int)screen[ r*4 + c ] ) + " ");
            }
            System.out.println();
        }        
        
    }

    public void draw(byte[] screen, int width, int xx1, int xx2, int y){
        int x1 = Math.min(xx1, xx2);
        int x2 = Math.max(xx1, xx2);
        
        if( x1 < 0 | x1 >= width | x2 < 0 | x2 >= width){
            return;
        }
        
        if( (y * width + x2 ) > screen.length * 8 -1 )
            return;
        
        
        int index1 = y * width + x1;
        int index2 = y * width + x2;
        
        int i = index1 / 8;
        byte iResidue = (byte) (index1 % 8);
        
        int j = (index2 + 1 ) / 8;
        byte jResidue = (byte) (( index2 + 1 ) % 8);
        
        if( i == j ) {
            screen[i] = (byte) (( 0xff >>> iResidue ) & ( 0xff << ( 8 - jResidue) ) | screen[i]);
        }
        else{
            screen[i] = (byte) ( ( 0xff >>> iResidue ) | screen[i]);
            screen[j] = (byte) ( ( 0xff << ( 8 - jResidue) ) | screen[j]);
            
            for( int k = i+1; k <= j-1; k++){
                screen[k] = (byte) 0xff;
            }
        }
    }
    
}
