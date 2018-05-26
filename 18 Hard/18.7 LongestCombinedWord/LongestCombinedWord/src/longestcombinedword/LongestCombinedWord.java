/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcombinedword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;
/**
 *
 * @author Rui
 */
public class LongestCombinedWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LongestCombinedWord lcw = new LongestCombinedWord();       
        
        String[] arr = {"cat","cat", "banana", "dog", "nana","dogcatwalker","dogeatsbanana","cateatsbanana","walk","walker","dogwalker"};
        
        System.out.println( lcw.getLongest( arr ) );
        
    }
    
    public String getLongest(String[] arr){
        if( arr == null )
            return null;
        
        Arrays.sort(arr, new MyComparator() );
        
        HashSet<String> wordSet = new HashSet<String>();
        for(String word : arr){
            wordSet.add( word );               
        }
        
        HashMap<String, Boolean> cacheMap = new HashMap<String, Boolean>();
        
        for(int i = 0; i < arr.length; i++){
            String word = arr[i];           
            
            wordSet.remove( word ); // this is very important
            if( isCombined( word, wordSet, cacheMap ) ){
                wordSet.add( word ); // this is very important
                return word;
            }                    
        }
        return null;    
    }
    
    public boolean isCombined(String str, HashSet<String> wordSet, HashMap<String, Boolean> cacheMap){
        if( cacheMap.containsKey(str) ){
            System.out.println("DP works.");
            return cacheMap.get( str);
        }
        
        if( str.isEmpty() )
            return true;
        
        for(int i = 0; i < str.length(); i++){
            String newStr = str.substring(0,i+1);
            
            if( wordSet.contains( newStr) ){
                if( isCombined( str.substring(i+1), wordSet, cacheMap) ){      
                    
                    cacheMap.put(str, true);                    
                    return true;            
                }
            }        
        }
        
        cacheMap.put(str, false);
        return false;
    }
        
    public class MyComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            if( s1.length() > s2.length() )
                return -1;
            else if( s1.length() == s2.length() )
                return 0;
            else
                return 1;        
        }    
    }
}
