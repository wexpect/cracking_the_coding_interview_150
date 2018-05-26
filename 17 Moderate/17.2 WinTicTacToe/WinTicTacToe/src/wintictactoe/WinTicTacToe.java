/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wintictactoe;

/**
 *
 * @author Rui
 */
public class WinTicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] board = {{-1, -1,  1},
                         { 0, -1,  1},
                         { 0,  0,  1} };
        
        WinTicTacToe wttt = new WinTicTacToe();
        
        // Solu 1:
        System.out.println( wttt.hasWon(board) );
        
        // Solu 2:
        System.out.println( wttt.hasWon2(board) );        
    }
    
    // Solu 1: 3*3 board, need 3 connected together in line
    public boolean hasWon(int[][] board){
        if( board == null || board.length != 3 || board[0].length != 3)
            return false;
        
        for(int r = 0; r <= 2; r++){
            for( int c = 0; c <= 2; c++){
                int value = board[r][c];
                
                if( value != 0){
                    if( check(board, value, r, c, 0, 1, 1) || check(board, value, r, c, 1, 0, 1) || check(board, value, r, c, 1, 1, 1) || check(board, value, r, c, 1, -1, 1)  )
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean check(int[][] board, int value0, int r0, int c0, int dr, int dc, int count){
        int r = r0 + dr;
        int c = c0 + dc;
    
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length )
            return false;
        
        int value = board[r][c];
        
        if( value != value0 )
            return false;
        
        count++;
        if( count == 3 )
            return true;
        
        return check(board, value, r, c, dr, dc, count);
    }
    
    // Solu 2: N*N board, need 3 connected together in line    
    public boolean hasWon2(int[][] arr){
        
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if( isValid( arr, i, j+2 ) && arr[i][j] != 0 && arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i][j+2])
                    return true;
                
                if( isValid( arr, i+2,j ) && arr[i][j] != 0 && arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i+2][j])
                    return true;
                
                if( isValid( arr, i+2, j+2 ) && arr[i][j] != 0 && arr[i][j] == arr[i+1][j+1] && arr[i][j] == arr[i+2][j+2])
                    return true;                
                
                if( isValid( arr, i+2, j-2 ) && arr[i][j] != 0 && arr[i][j] == arr[i+1][j-1] && arr[i][j] == arr[i+2][j-2])
                    return true;                                
            }
        }
        
        return false;    
    }
    
    public boolean isValid(int[][] arr, int i, int j){
        if( i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
            return false;
        else
            return true;
    }
}
