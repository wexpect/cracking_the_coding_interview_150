/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spacereplace;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class SpaceReplace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "Mr John Smith             end";        
        SpaceReplace sr1 = new SpaceReplace();        
        System.out.println(sr1.spaceReplace(s));
        
        
        char[] str = s.toCharArray();
        SpaceReplace sr2 = new SpaceReplace();        
        sr2.spaceReplaceInPlace(str, 13);
           

    }
    
    // Solu 1: not "in place" method
    public String spaceReplace(String s)
    {
        return s.replace(" ", "%20");
    }
    
    // Solu 2: "in place" method
    public void spaceReplaceInPlace(char[] str, int trueLength)
    {                    
        int spaceCount = 0;
        for(int i = 0; i < trueLength; i++)
        {
            if( str[i] == ' ')
            {
                spaceCount++;
            }
        }
        System.out.println(spaceCount);        
        
        int newIndex = trueLength + 2 * spaceCount;
        for(int i = trueLength - 1; i >= 0; i--)
        {
            if( str[i] == ' ')
            {      
                str[--newIndex] = '0';
                str[--newIndex] = '2';
                str[--newIndex] = '%';                   
            }
            else
            {
                str[--newIndex] = str[i];
            }            
        }
        
        System.out.println(str);
        
    }
    
}
