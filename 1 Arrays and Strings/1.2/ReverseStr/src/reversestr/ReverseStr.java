/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestr;

/**
 *
 * @author Rui
 */
public class ReverseStr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ss = "abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+1234567890";
        
        ReverseStr rs = new ReverseStr();
        
        System.out.println(rs.reverseStr(ss));
                        
        System.out.println(rs.reverseStrRecursion(ss));        
    }
    
    public String reverseStr(String s)  // Note: ss and s are two differrent object references refering to the same object
                                            // so, change s will NOT change ss.
    {        
        char[] charArray = s.toCharArray();
        
        int head = 0;
        int tail = s.length() - 1;
        char tmp;
        
        while( head < tail)
        {
            tmp = charArray[head];
            charArray[head] = charArray[tail];
            charArray[tail] = tmp;
            
            head++;
            tail--;
        }
        
        return new String(charArray);        
    }
    
    public String reverseStrRecursion(String s)
    {
        if(s.length() <= 1)
        {
            return s;
        }        
        return s.charAt(s.length()-1) + reverseStrRecursion( s.substring(0, s.length()-1) ) ;        
    }
    
    
}

