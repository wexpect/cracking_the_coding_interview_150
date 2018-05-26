/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsearchalgorithm;

/**
 *
 * @author Rui
 */
public class StringSearchAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String string = "This is a string search algorithm.";
        String subString = " str";
        
        char[] s = string.toCharArray();
        char[] t = subString.toCharArray();
        
        StringSearchAlgorithm ssa = new StringSearchAlgorithm();
        
        System.out.println( ssa.search(t, s) );
    }
    
    public boolean search(char[] t, char[] s){
        int m = t.length;
        int n = s.length;
        
        if( m == 0 || n == 0 || m > n)
            return false;
        

        for( int i = 0; i <= n - m; i++){  // the upper bount is  <= n - m
            boolean match = false;        
            
            for( int j = 0; j < m; j++){
                
                if( s[ i + j] == t[j] ){
                    match = true;
                }
                else{
                    match = false;
                    break;                
                }            
            }
            
            if( match )
                return true;        
        }
        
        return false;
    }
}
