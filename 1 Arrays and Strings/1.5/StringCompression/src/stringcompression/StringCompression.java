/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcompression;

/**
 *
 * @author Rui
 */
public class StringCompression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "aabcccccaaab";
        
        System.out.println( new StringCompression().stringCompression(s) );
    }
    
    public String stringCompression(String s)
    {
        StringBuffer sb = new StringBuffer();
        
        char currentChar = s.charAt(0);                
        int charCount = 1;
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) == currentChar)
            {
                charCount++;
            }
            else
            {
                sb.append(currentChar);
                sb.append(charCount);
                
                currentChar = s.charAt(i);
                charCount = 1;
            }            
        }                        
        sb.append(currentChar);  // these two lines are necessary, do not forget      
        sb.append(charCount);
       
        String sNew = sb.toString();
        
        if(sNew.length() >= s.length())
            return s;
        
        return sNew;        
    }
}
