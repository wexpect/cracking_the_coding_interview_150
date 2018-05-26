/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package largestwordrectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Rui
 */
public class LargestWordRectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LargestWordRectangle lwr = new LargestWordRectangle();
        
        String[] arr = { "abcdefgh","klmnopqrst", "pqrst","uvwxy",

                         "abcde",
                         "fghij",
                         "klmno",

                         "fak",
                         "gbl",
                         "hcm",
                         "idn",
                         "jeo"};        

        System.out.println( lwr.getLargestRec(arr) );
    }
    
    // Solu 1
    public ArrayList<String> getLargestRec(String[] arr){
        HashSet<String> wordSet = getWordSet(arr);
        HashMap<Integer, ArrayList<String>> lenToWordMap = groupWordByLen( arr );
        
        int maxNum = Integer.MIN_VALUE;
        ArrayList<String> maxList = new ArrayList<String>();
        
        for(int len : lenToWordMap.keySet() ){
            ArrayList<String> wordList = lenToWordMap.get( len );
            
            ArrayList< ArrayList<String> > permutationArrList = getPermutation(wordList, wordList.size()-1 );     
                        
            System.out.println( wordList );
            System.out.println( permutationArrList );            
            
            for(ArrayList<String> comList : permutationArrList){
                for(int rowMax = comList.size()-1; rowMax >= 0; rowMax--){
                    boolean valid = true;
                    for(int col = 0; col < len; col++){
                        String word = "";
                        for(int r = 0; r <= rowMax; r++){
                            word += comList.get(r).charAt(col);
                        }
                        if( !wordSet.contains( word) ){
                            valid = false;
                            break;
                        }
                    }
                    if(valid){
                        int num = (rowMax + 1) * len;
                        if( num > maxNum){
                            maxNum = num;
                            
                            maxList.clear();
                            for(int i = 0; i <= rowMax; i++){
                                maxList.add( comList.get(i) );
                            }
                        }
                        
                        break;
                    }
                }                
            }
        }
    
        return maxList;
    }
    
    public HashSet<String> getWordSet(String[] arr){
        HashSet<String> wordSet = new HashSet<String>();
        for(String word : arr){
            wordSet.add(word);
        }
        return wordSet;
    }
    
    public HashMap<Integer, ArrayList<String>> groupWordByLen(String[] arr){
        HashMap<Integer, ArrayList<String>> lenToWordMap = new HashMap<Integer, ArrayList<String>>();
        for(String word : arr){
            int len = word.length();
            
            if( lenToWordMap.containsKey(len) ){
                lenToWordMap.get(len).add(word);
            }
            else{
                ArrayList<String> wordList = new ArrayList<String>();
                wordList.add( word );
                lenToWordMap.put(len, wordList);
            }
        
        }
        return lenToWordMap;
    }
    
    public ArrayList<ArrayList<String>> getPermutation(ArrayList<String> wordList, int ind){
        if( ind == 0){
            ArrayList<String> newList = new ArrayList<String>();
            newList.add( wordList.get(ind) );
            
            ArrayList<ArrayList<String>> permArrList = new ArrayList<ArrayList<String>>();
            permArrList.add(newList);
            
            return permArrList;
        }
        
        ArrayList<ArrayList<String>> prePermArrList = getPermutation(wordList, ind - 1);
        ArrayList<ArrayList<String>> permArrList = new ArrayList<ArrayList<String>>();
        
        for(ArrayList<String> prePermList : prePermArrList ){
            for(int i = 0; i <= prePermList.size(); i++){
                ArrayList<String> permList = new ArrayList<String>();
                permList.addAll(prePermList);

                permList.add(i, wordList.get(ind)); // works when  ind == size()
                
                permArrList.add(permList);            
            }
        }
        return permArrList;
    }
    
    
    
}
