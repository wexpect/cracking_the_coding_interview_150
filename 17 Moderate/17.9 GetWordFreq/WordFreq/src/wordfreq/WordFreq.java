/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfreq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Rui
 */
public class WordFreq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WordFreq wf = new WordFreq();
        
        String book = "  This is a Copy of Book...";
        String word = "book";
                       
        // Solu 1: does not work when str ends without symbols, e.g.: "the end of sentence'
        System.out.println("\nFrequency is: "+ wf.getFreq(word, book) );
        
        // Solu 2: better
        System.out.println("\nFrequency is: "+ wf.getFreq2(book, word) );
    }
      
    // Solu 2: better    
    public int getFreq2(String book, String word){
        if( book == null || word == null)
            return -1;
        
        HashMap<String, Integer> hm = makeHashMap(book);
        
        word = word.toLowerCase();
        if( hm.containsKey(word) )
            return hm.get(word);
        else
            return 0;
    }
    
    public HashMap<String, Integer> makeHashMap(String str){
        HashMap<String, Integer> hm = new HashMap<String, Integer>();        
        
        boolean foundStart = false;
        int startInd = -1;
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if( ( 'A' <= c && c <= 'Z' ) || ( 'a' <= c && c <= 'z'  ) ){                
                if( !foundStart){
                    startInd = i;
                    foundStart = true;
                }
            }
            else{
                if( foundStart){
                    String word = str.substring(startInd, i).toLowerCase();
                    if( hm.containsKey(word) )
                        hm.put( word, hm.get(word)+1);
                    else
                        hm.put(word, 1);
                    
                    foundStart = false;
                }
            }
        }
        
        // In case the str ends without symbols, e.g.: "the end of sentence'
        if( foundStart){
            String word = str.substring(startInd, str.length()).toLowerCase();
            if( hm.containsKey(word) )
                hm.put( word, hm.get(word)+1);
            else
                hm.put(word, 1);

            foundStart = false;
        }
        
        return hm;        
    }
    
    // Solu 1:
    public int getFreq(String word, String book){
        if( book == null)
            return -1;
        
        ArrayList<String> list = convertBookToList(book);
        for(String str : list)
            System.out.println(str);        
        
        HashMap<String, Integer> hm = makeHM(list);
        
        word = word.toLowerCase();
        if( hm.containsKey(word) )
            return hm.get(word);
        else
            return 0;
    }
    
    // Solu 0: use Java StringTokenizer may also work to some extent
    // Solu 1: my method
    public ArrayList<String> convertBookToList(String book){
        if( book == null)
            return null;
               
        HashSet<Character> hs = new HashSet<Character>();
        hs.add(' ');
        hs.add(',');
        hs.add('.');
        hs.add('!');
        
        int i = 0;
        int j = 1;
        ArrayList<String> list = new ArrayList<String>();
        
        while( j <= book.length() ){
            if( hs.contains( book.charAt(i)) ){
                list.add( book.substring(i, i+1) );
                i++;
                j = i + 1;
            }
            else if( hs.contains( book.charAt(j)) ){
                list.add( book.substring(i, j) );
                
                i = j;
                j++;
            }
            else
                j++;                    
        }
        
        return list;
    }    

    public HashMap<String, Integer> makeHM(ArrayList<String> list){
        if( list == null )
            return null;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(String word : list){
            word = word.toLowerCase();
            if( hm.containsKey(word) ){
                hm.put( word, hm.get(word) + 1);
            }
            else
                hm.put( word, 1);            
        }
        
        return hm;
    }
}
