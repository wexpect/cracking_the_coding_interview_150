
package wordtoword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class WordToWord {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WordToWord wtw = new WordToWord();
        
        String word1 = "DAMP";
        String word2 = "LIKE";
        
        
        // Solu 3
        HashSet<String> dicSet = new HashSet<String>();
        dicSet.add("DAMP");
        dicSet.add("LAMP");
        dicSet.add("LIMP");
        dicSet.add("LIME");
        dicSet.add("LIKE");                
        
        
        LinkedList<String> finalList3 = wtw.transform3( dicSet, word1, word2);
        System.out.println(finalList3.toString());
                
        
        // Solu 1 and 2: assume each step can only change to the letters which exist in the final word
        HashMap<String, String> hashMapDictionary = new HashMap<String, String>();
        hashMapDictionary.put("DAMP", "unVisited");
        hashMapDictionary.put("LAMP", "unVisited");
        hashMapDictionary.put("LIMP", "unVisited");
        hashMapDictionary.put("LIME", "unVisited");
        hashMapDictionary.put("LIKE", "unVisited");
        
        
        
        // Solu 1: DFS                
        wtw.clearDictionary( hashMapDictionary );
        
        String options = "LIKE";
        LinkedList<String> list = new LinkedList<String>();
        
        LinkedList<String> finalList = wtw.transform( hashMapDictionary, word1, word2, options, list);
        System.out.println(finalList.toString());
        
        
        // Solu 2: BFS
        wtw.clearDictionary( hashMapDictionary );
        
        LinkedList<String> finalList2 = wtw.wordToWord( hashMapDictionary, word1, word2);
        System.out.println(finalList2.toString());
    }
    
    
    // Solu 3:
    HashSet<String> visitedSet = new HashSet<String>();
    HashMap<String, String> backTrackMap = new HashMap<String, String>();    
    
    public LinkedList<String> transform3(HashSet<String> dicSet, String word1, String word2){
        
        if( dicSet == null || word1 == null || word2 == null || word1.length() != word2.length() || !dicSet.contains(word1) || !dicSet.contains(word2))
            return null;       

        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();        
        
        if( word1.equals(word2) ){
            LinkedList<String> list = new LinkedList<String>();
            list.addFirst(word2);
            list.addFirst(word1);            
            return list;
        }    
     
        // Solu 3.1: BFS, works
        if( BFS(word1, word2, dicSet) )
            return getOutput(word2);
        else
            return null;
        
        // Solu 3.2: DFS, works
//        if( DFS(word1, word2, dicSet) )
//            return getOutput(word2);
//        else
//            return null;        
    }
                
    // Solu 3.1
    public boolean BFS(String word1, String word2, HashSet<String> dicSet){
    
        visitedSet.add( word1 );                
        
        LinkedList<String> queue = new LinkedList<String>();        
        queue.addLast( word1 );
        
        while( !queue.isEmpty() ){
            String pWord = queue.removeFirst();
            
            for(String word : getAdjacentWords( pWord, dicSet ) ){                
                if( !visitedSet.contains( word ) ){
                    visitedSet.add( word );
                    backTrackMap.put( word, pWord);

                    if( word.equals( word2 ) ){
                        return true;
                    }
                    else{
                        queue.addLast( word );
                    }                    
                }
            }
        }
        
        return false;
    }                
    
    // Solu 3.2
    public boolean DFS(String w1, String w2, HashSet<String> dicSet){
            
        visitedSet.add( w1 );                
        
        if( w1.equals(w2) )
            return true;        
        
        for(String v : getAdjacentWords(w1, dicSet) ){
            if( !visitedSet.contains(v) ){
                backTrackMap.put(v, w1);
                if( DFS( v, w2, dicSet) )
                    return true;
            }
        }
        return false;
    }
    
    public LinkedList<String> getAdjacentWords( String pWord, HashSet<String> dicSet ){
        LinkedList<String> list = new LinkedList<String>();
        
        for(int i = 0; i < pWord.length(); i++){
            for( char c = 'A'; c <= 'Z'; c++){
                if( c != pWord.charAt(i) ){
                    String word = pWord.substring(0, i) + c + pWord.substring(i+1);
                    
                    if( dicSet.contains( word ) ){
                        list.add( word );
                    }                    
                }            
            }
        }
        
        return list;    
    }
    
    public LinkedList<String> getOutput(String w2){
        LinkedList<String> list = new LinkedList<String>();
        String w = w2;
        while( backTrackMap.containsKey(w) ){
            list.addFirst( w );
            w = backTrackMap.get( w );
        }
        list.addFirst(w);
        
        return list;
    }
    
    
    
    
    // Solu 1 and Solu 2
    
    public void clearDictionary(HashMap<String, String> hashMapDictionary){
        for( String word : hashMapDictionary.keySet() )
            hashMapDictionary.put( word, "unVisited");
    }
    
    
    // Solu 1
    public LinkedList<String> transform(HashMap<String, String> hashMapDictionary, String word1, String word2, String options, LinkedList<String> list){
        if( hashMapDictionary == null || word1 == null || word2 == null || word1.length() != word2.length() || !hashMapDictionary.containsKey(word1) || !hashMapDictionary.containsKey(word2))
            return null;       
        
        if( word1.equals(word2) ){
            list.add(word2);
            return list;
        }
        
        hashMapDictionary.put(word1, "visiting");
        list.add(word1);
        
        for(int i = 0; i < options.length(); i++){
            char c = options.charAt(i);
            if( ! (c == ' ') ){
                String newWord = word1.substring(0,i) + c + word1.substring(i+1);

                    if( hashMapDictionary.containsKey( newWord ) ){

                        if( hashMapDictionary.get( newWord ).equals("unVisited") ){

                            String newOptions = options.substring(0,i) + ' '+options.substring(i+1);

                            LinkedList<String> newList = new LinkedList<String>();
                            newList.addAll(list);

                            LinkedList<String> finalList = transform(hashMapDictionary, newWord, word2, newOptions, newList);

                            if( finalList != null )
                                return finalList;               
                        }                                
                }
                
            }
        }
                                        
        hashMapDictionary.put(word1, "visited");                             
        
        return null;            
    }
    
       
    // Solu 2:
    public LinkedList<String> wordToWord(HashMap<String, String> hashMapDictionary, String w1, String w2){
        if( hashMapDictionary == null || w1 == null || w2 == null || w1.length() != w2.length() || !hashMapDictionary.containsKey(w1) || !hashMapDictionary.containsKey(w2))
            return null;
        
        
        Node n1 = new Node( w1 );
        n1.options = w2;
        
        Node n2 = new Node( w2 );
        n2.options = "    ";        
        
        Node finalNode = transform2(hashMapDictionary, n1, n2);
        
        if( finalNode != null){
            LinkedList<String> list = new LinkedList<String>();        
            Node n = finalNode;
            
            while( n != null ){
                list.addFirst( n.data );
                n = n.predecessor;
            }
            
            return list;
        }
        else
            return null;
    }
    
    public Node transform2(HashMap<String, String> hashMapDictionary, Node n1, Node n2){
                
        hashMapDictionary.put(n1.data, "visiting");        
        
        if( n1.data.equals(n2.data) ){
            return n1;
        }
        
        Queue queue = new Queue();        
        queue.enqueue( n1 );
        
        while( !queue.isEmpty() ){
            Node n = queue.dequeue();
        
            String word = n.data;
            String options = n.options;        

            for(int i = 0; i < options.length(); i++){
                char c = options.charAt(i);
                if( ! (c == ' ') ){
                    String newWord = word.substring(0,i) + c + word.substring(i+1);

                    if( hashMapDictionary.containsKey( newWord ) ){

                        if( hashMapDictionary.get( newWord ).equals("unVisited") ){

                            String newOptions = options.substring(0,i) + ' '+ options.substring(i+1);

                            Node newNode = new Node(newWord);
                            newNode.options = newOptions;
                            newNode.predecessor = n;

                            hashMapDictionary.put( newWord, "visiting");
                            if( newNode.data.equals(n2.data) ){
                                return newNode;
                            }                            
                            
                            queue.enqueue( newNode );           
                        }                                
                    }                
                }
            }            
            
            hashMapDictionary.put( n.data, "visited");            
        }                                                                        
        
        return null;            
    }
    
}


