/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationofparentheses;

import java.util.HashSet;

/**
 *
 * @author Rui
 */
public class CombinationOfParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CombinationOfParentheses cop = new CombinationOfParentheses();
        
        int n = 3;        
        System.out.println( cop.getComb( n ) );
        
        
    }
    
    public HashSet<String> getComb(int n){
        if( n <= 0) 
            return null;
        
        if( n == 1){
            HashSet<String> newSet = new HashSet<String>();
            newSet.add("()");
            return newSet;
        }
        
        HashSet<String> oldSet = getComb(n-1);
        HashSet<String> newSet = new HashSet<String>();
    
        for(String str : oldSet){
            int length = str.length();
            
            for( int i = 0; i <= length; i++){
                String iStr = str.toString();  // this is improatnt, can not operate on the original str
                
                iStr = iStr.substring(0,i) + "(" + iStr.substring(i, length);  // this is improatnt, can not operate on the original str
                System.out.printf("i = %d, iStr = %s\n", i , iStr); 
                
                for( int j = i+1; j <= length + 1; j++){
                    String jStr = iStr.toString();  // this is improatnt, can not operate on the original str
                    
                    jStr = jStr.substring(0,j) + ")" + jStr.substring(j, length+1);  // this is improatnt, can not operate on the original str
                    System.out.printf("j = %d, jStr = %s\n", j , jStr); 
                
                    if( ! newSet.contains(jStr) ){  // actaully, do not need to check for duplicates, HashSet can automatically do that
                        newSet.add( jStr );
                    }
                }            
            }        
        }
        
        return newSet;
    
    }
    
    
}
