/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparestrings;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class CompareStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "aaabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+1234567890";
        String s2 = "aaabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+1234567890";        
       
        CompareStrings cs = new CompareStrings();
        
        System.out.println(cs.compareStrings(s1, s2));
        
        System.out.println(cs.compareStringsCount(s1, s2));      
        
    }
    
    public boolean compareStrings(String s1, String s2)
    {
        if( s1.length() != s2.length() )
        {
            return false;
        }
                
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();        
        System.out.println(c1);
        System.out.println(c2);
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println(c1);        
        System.out.println(c2);

        
        // this does not work
        // return c1.equals(c2);  
        
        
        // Code 1
        return Arrays.equals(c1, c2);
        
        
        // Code 2
//        for(int i=0; i < c1.length; i++)
//        {
//            if( c1[i] != c2[i] )
//            {
//                return false;
//            }
//        }
//         return true;        
        
        
        // Code 3
//        String s1n = new String(c1);
//        String s2n = new String(c2);     
//        return s1n.equals(s2n);
                
    }
    

    public boolean compareStringsCount(String s1, String s2)
    {
        if( s1.length() != s2.length() )
        {
            return false;
        }
        
        return Arrays.equals( stringCount(s1), stringCount(s2) );
    }
        
    private int[] stringCount(String s)
    {
        char[] charArray = s.toCharArray();
        int[] strCount = new int[256];  // assume ASCII string
        
        for(char c : charArray)
        {
            strCount[c]++;            
        }
        
        System.out.println( Arrays.toString(strCount) );
        
        return strCount;
    }
    
    
    
}
