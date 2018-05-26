/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strhasunichar;

import java.util.HashSet;

/**
 *
 * @author Rui
 */
public class StrHasUniChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        String s = "abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+1234567890";
       
        StrHasUniChar sh = new StrHasUniChar();
        
        // Solu 1
        System.out.println( sh.hasUniChar(s) );
        
        // Solu 3
        System.out.println( sh.hasUniCharHash(s) );        

    }
    
    
    // assume the string is ASCII string 
    public boolean hasUniChar(String s)
    {
        if( s.length() > 256)
        {
            return false;
        }
        
        boolean[] hasChar = new boolean[256];
        int charValue;
        for(int i = 0; i < s.length(); i++)
        {
            charValue = s.charAt(i);
            if( hasChar[charValue] )
            {
                return false;
            }
            hasChar[charValue] = true;
        }
        
        return true;
    }

    
    public boolean hasUniCharHash(String s)
    {
        HashSet<Character> hs = new HashSet<Character>();
        
        for(int i = 0; i< s.length(); i++)
        {
            boolean notContained = hs.add(s.charAt(i));
            if( ! notContained )
            {
                return false;
            }                    
        }
        return true;
    }    
}
