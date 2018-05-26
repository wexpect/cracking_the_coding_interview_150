/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchstringarraysinstring;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class SearchStringArraysInString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SearchStringArraysInString ss = new SearchStringArraysInString();
        
        String str = "bibs";
        String[] arr = {"bi","ib","s","abc","bibsab"};
        
        boolean[] result = ss.search(str, arr);
        System.out.println(Arrays.toString(result));
    }    
    
    public boolean[] search(String str, String[] arr){
        if( str == null || str.length() == 0 || arr == null || arr.length == 0)
            return null;
        
        Node n = new Node(' ');
        
        for(int i = 0; i < str.length(); i++){
            String substr = str.substring(i);
            treeInsert(n, substr, 0);
        }
        
        boolean[] result = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = treeSearch(n, arr[i], 0);
        }
        
        return result;
    }
    
    public boolean treeInsert(Node n, String str, int i){
    
        char currentChar = str.charAt(i);
        
        if( n.childHashMap.containsKey(currentChar) ){
            if( i + 1 > str.length()-1 )
                return true;
            
            Node child = n.childHashMap.get(currentChar);
            return treeInsert(child, str, i+1);        
        }
        else{
            Node child = new Node(currentChar);
            n.childHashMap.put( currentChar, child);
            
            if( i + 1 > str.length()-1 )
                return true;
            
            return treeInsert(child, str, i+1);                    
        }    
    }
    
    public boolean treeSearch(Node n, String str, int i){
        char currentChar = str.charAt(i);
        
        if( ! n.childHashMap.containsKey(currentChar) ){
            return false;            
        }
        else{
            Node child = n.childHashMap.get(currentChar);
            
            if( i + 1 > str.length()-1 )
                return true;
            
            return treeSearch(child, str, i+1);                    
        }            
    }
    
    public class Node{
        public char data;
        public HashMap<Character, Node> childHashMap;
        
        public Node(char data){
            this.data = data;
            childHashMap = new HashMap<Character, Node>();
        }
    }
}
