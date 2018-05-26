/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shifoperator;

/**
 *
 * @author Rui
 */
public class ShifOperator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        System.out.println( "\nCase 1:");
//        
//        String str = "+1111101010101010101010101010110";  
//        int n = Integer.parseInt(str, 2);  // 32-bit
//        
//        System.out.println( "str =    " + str );
//        System.out.println( "n = " + n );
//        System.out.println(  "n =       " + Integer.toBinaryString( n ) );
//        System.out.println(  "n << 1 = " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =  " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =   " +Integer.toBinaryString( n >> 1) );   
//        
//        
//        str = "-1111101010101010101010101010110";  
//        n = Integer.parseInt(str, 2);  // 32-bit
//        
//        System.out.println( "str =    " + str );
//        System.out.println( "n = " + n );
//        System.out.println(  "n =      " + Integer.toBinaryString( n ) );
//        System.out.println(  "n << 1 =      " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 = " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 = " +Integer.toBinaryString( n >> 1) );   
//        
//        
//        
//        System.out.println( "\nCase 2:");
//               
//        str = "+101";  
//        n = Integer.parseInt(str, 2);  // 32-bit
//        
//        System.out.println( "str =    " + str );
//        System.out.println( "n = " + n );
//        
//        
//        System.out.println( );
//        System.out.println(  "n =       " + Integer.toBinaryString( n ) );
//        System.out.println(  "n =       " + Integer.parseInt(Integer.toBinaryString( n ), 2)  );
//        
//        System.out.println( );
//        System.out.println(  "n << 1 = " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =  " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =   " +Integer.toBinaryString( n >> 1) );   
//        
//        
//        str = "-101";  
//        n = Integer.parseInt(str, 2);  // 32-bit
//        
//        System.out.println( "str =    " + str );
//        System.out.println( "n = " + n );
//        
//        System.out.println(  "n << 1 =      " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =      " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =      " +Integer.toBinaryString( n >> 1) );  
//        
//        
//        
//        
//        
//        System.out.println(  "n =           " + Integer.toBinaryString( n ) );
//        
//        System.out.println( );
//        System.out.println(  "n =       " + Integer.toBinaryString( n ) );
//        System.out.println(  "n =       " + Integer.parseInt(Integer.toBinaryString( n ), 2)  );
//        
//        
//        System.out.println(  "n << 1 =      " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =      " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =      " +Integer.toBinaryString( n >> 1) );  
//        
//        
//        
//                
//        System.out.println( "\nCase 3:");        
//
//        n = 5;  // 32-bit
//        
//        System.out.println( "n = " + n );
//        System.out.println(  "n =       " + Integer.toBinaryString( n ) );
//        System.out.println(  "n << 1 = " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =  " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =   " +Integer.toBinaryString( n >> 1) );   
//        
//        
//
//        n = -5;  // 32-bit
//        
//        System.out.println( "n = " + n );
//        System.out.println(  "n =       " + Integer.toBinaryString( n ) );
//        System.out.println(  "n << 1 =  " + Integer.toBinaryString( n << 1) );
//        System.out.println(  "n >>> 1 =  " + Integer.toBinaryString( n >>> 1) );                
//        System.out.println(  "n >> 1 =  " +Integer.toBinaryString( n >> 1) );     
        
        
   
        System.out.println( "\nCase 2:");
               
        String str = "+101";  
        System.out.println( "str =    " + str );
        
        int n = Integer.parseInt(str, 2);  // 32-bit
        System.out.println( "n = " + n );
        
        
        System.out.println( );

        System.out.println(  "n << 1 = " + ( n << 1) );
        System.out.println(  "n >>> 1 =  " + ( n >>> 1) );                
        System.out.println(  "n >> 1 =   " +( n >> 1) );   
        

        
        System.out.println( "\n");
        
        str = "-101";  
        System.out.println( "str =    " + str );
        
        n = Integer.parseInt(str, 2);  // 32-bit
        System.out.println( "n = " + n );
        
        
        System.out.println( );

        System.out.println(  "n << 1 = " + ( n << 1) );
        System.out.println(  "n >>> 1 =  " + ( n >>> 1) );                
        System.out.println(  "n >> 1 =   " +( n >> 1) );      
        
        
        

        System.out.println( "\n");
        
        str = "+1111101010101010101010101010110";  
        System.out.println( "str =    " + str );
        
        n = Integer.parseInt(str, 2);  // 32-bit
        System.out.println( "n = " + n );
        
        
        System.out.println( );

        System.out.println(  "n << 1 = " + ( n << 1) );
        System.out.println(  "n >>> 1 =  " + ( n >>> 1) );                
        System.out.println(  "n >> 1 =   " +( n >> 1) );       
        
        
        

        
        System.out.println("\n Try this");        
        
        int allOnes = ~0;
        
        System.out.println( "n = " + allOnes );
        System.out.println(  "n =       " + Integer.toBinaryString( allOnes ) );
        
        
        int i = 2;
        int j = 6;
        
        
        System.out.println(  "n =       " + Integer.toBinaryString( allOnes >>> ( 31 - (i - 1)) ) );
        System.out.println(  "n =       " + Integer.toBinaryString( allOnes << ( (j + 1) - 0 ) ) );
        System.out.println(  "n =       " + Integer.toBinaryString( allOnes >>> ( 31 - (i - 1)) | allOnes << ( (j + 1) - 0 ) ) );
        
        
        System.out.println(  "n =       " + Integer.toBinaryString(   ~(  (1 << (j + 1)) -1)  )  );
        System.out.println(  "n =       " + Integer.toBinaryString( (  (1 << i) - 1  ) ) );
        System.out.println(  "n =       " + Integer.toBinaryString( (   ~(  (1 << (j + 1)) -1)  ) | (  (1 << i) - 1  ) ) );
        
      
    }
  

}
