/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordrotation;

/**
 *
 * @author Rui
 */
public class WordRotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        String s3 = "waterbott";
        
        WordRotation wr = new WordRotation();
                
        System.out.println(wr.isRotation(s2, s1));        
        System.out.println(wr.isRotation(s3, s1));                
    }
    
    public boolean isRotation(String s2, String s1)
    {
        if(s2.length() != s1.length())  // this is import, or else even if the S2 is subtring of twoS1, may not be rotation of S1
            return false;
        
        String str = s1 + s1;
        return isSubstring(s2, str);
    }
    
    public boolean isSubstring(String word, String str)
    {
        return str.contains(word);
    }
            
}
