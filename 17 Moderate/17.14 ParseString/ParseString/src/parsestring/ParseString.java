/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsestring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class ParseString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ParseString ps = new ParseString();
        
        HashSet<String> dicSet = new HashSet<String>();
        
        // eg1: works well
        dicSet.add("looked");
        dicSet.add("just");
        dicSet.add("like");
        dicSet.add("her");
        dicSet.add("brother");
        dicSet.add("look");
        dicSet.add("the");
        String str = "jesslookedjustliketimherbrother";
        
        // eg2: works
//        dicSet.add("i");
//        dicSet.add("it");
//        dicSet.add("hit");
//        String str = "thit";        
        
        // Solu 0: slow for eg1, fast for eg2
        //System.out.println( ps.parse0(str, dicSet) );
        
        // Solu 1: fast for both eg1 and eg2
        Wrapper wrap = ps.minNum(str, 0, 0, dicSet);        
        System.out.println( wrap.str );
    }        
    
    //Solu 0: brute force (only works for n <= 32). There might be a space after each character, so try 2^(n-1) space combinations and check each resulting string. 
    //        running time O( (2^n) * n  ), space complexity O(n)
    public String parse0(String str, HashSet<String> dicSet){
        if( str == null || dicSet == null)
            return null;
        
        int n = str.length();
        int minNum = Integer.MAX_VALUE;
        String minStr = null;
        
        for(int k = 0; k <= Math.pow(2,n)-1; k++){
            int[] bitArr = intToBitArr(k, n);            

            System.out.println(k);            
            for(int i = 0; i < n; i++){
                System.out.print( bitArr[i] + " ");            
            }
            System.out.println();            
            
            StringBuffer strBuf = new StringBuffer();
            int num = 0;
            String word = "";
            
            for(int i = 0; i < n; i++){
                if( bitArr[i] == 0 ){
                    word += str.charAt(i);
                }
                else{
                    word += str.charAt(i);
                    if( dicSet.contains( word) ){
                        strBuf.append(word + " ");
                    }
                    else{
                        strBuf.append(word.toUpperCase() + " ");
                        num += word.length();
                    }
                    word = "";
                }
            }
            
            // This is important
            if( dicSet.contains( word) ){
                strBuf.append(word + " ");
            }
            else{
                strBuf.append(word.toUpperCase() + " ");
                num += word.length();
            }                        
            
            if( num < minNum){
                minNum = num;
                minStr = strBuf.toString();
            }
        }
        return minStr.trim();    
    }
    
    public int[] intToBitArr(int k, int n){
        int[] bitArr = new int[n];
        
        // method 1: works
//        for(int i = n-1; i >= 0; i--){
//            bitArr[i] = k & 0x01;            
//            k = k >>> 1;            
//        }
        
        // method 2: better. works
        int i = n-1;
        while( k > 0 ){
            bitArr[i] = k & 0x01;
            i--;
            k = k >>> 1;
        }
        
        return bitArr;    
    }
            
    
    //Solu 1: running time might be O(2^n), not sure; space complexity O(n)
                      // [i,j] of str has no space in between                 
    
    // Solu 1 for eg1, becomes from slow to fast after adding Dynamic Programming    
    // meaning starting from this specific index, what is the corresponding wrapper for the rest of the string
    HashMap<Integer, Wrapper> cacheMap = new HashMap<Integer, Wrapper>();
    
    public Wrapper minNum(String str, int i, int j, HashSet<String> dicSet){ 
    
        if( i == j){
            if( cacheMap.containsKey( i ) ){
                return cacheMap.get( i );
            }
        }
        
        if( j == str.length()-1 ){
            if( dicSet.contains( str.substring(i,j+1) ) ){
                int num = 0;                
                
                Wrapper wrap = new Wrapper(num, str.substring(i,j+1) );
                
                return wrap;
            }
            else{
                int num = j-i+1;                
                
                Wrapper wrap = new Wrapper(num, str.substring(i,j+1).toUpperCase() );
                
                return wrap;                
            }
        }
        
        String str1Left = str.substring(i, j+1);
        int num1Left;
        boolean str1LeftInDic;
        if( dicSet.contains( str1Left ) ){
            num1Left = 0;
            str1LeftInDic = true;
        }
        else{
            num1Left = j-i+1;
            str1LeftInDic = false;
        }
        
        Wrapper wrap1Right = minNum(str, j+1, j+1, dicSet);
        int num1 = num1Left + wrap1Right.num;
        
        Wrapper wrap2 = minNum(str, i, j+1, dicSet);
        int num2 = wrap2.num;
        
        if( num1 < num2){
            String newStr = null;
            if( str1LeftInDic)
                newStr = str1Left + " " + wrap1Right.str;
            else
                newStr = str1Left.toUpperCase() + " " + wrap1Right.str;
            
            Wrapper wrap = new Wrapper( num1, newStr);
            
            if( i == j)
                cacheMap.put(i, wrap);
            
            return wrap;
        }
        else{
            if( i == j)
                cacheMap.put(i, wrap2);
            
            return wrap2;        
        }
            
    }    
    
    public class Wrapper{    
        public int num;
        public String str;
        
        public Wrapper(int n, String string){
            num = n;
            str = string;
        }        
    }
    
        
}
