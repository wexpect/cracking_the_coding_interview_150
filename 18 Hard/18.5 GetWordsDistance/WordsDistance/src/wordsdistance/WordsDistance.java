/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsdistance;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class WordsDistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WordsDistance wd = new WordsDistance();
        
        String[] arr = {"This","w1","is","to","find","w2","the","shortest","w1","distance","w1","between","w2","w1","two","words"};
        String w1 = "w1";
        String w2 = "w2";
        
        System.out.println("Solu 1:");
        System.out.println("Output: "+wd.shortestDistance(arr, w1, w2) );

        System.out.println("\nSolu 2:");
        System.out.println("Output: "+wd.shortestDistance2(arr, w1, w2) );        
        
        System.out.println("\nSolu 3:");
        System.out.println("Output: "+wd.shortestDistance3(arr, w1, w2) );
    }
    
    // Solu 1
    public int shortestDistance(String[] arr, String w1, String w2){
        if( arr == null || w1.equals(w2) )
            return -1;
        
        int ind1 = -1;
        int ind2 = -1;
        int dis = Integer.MAX_VALUE;
        int disMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            if( arr[i].equals( w1 ) || arr[i].equals( w2 ) ){
                if( arr[i].equals( w1 ) ){
                    ind1 = i;
                }
                else{
                    ind2 = i;
                }
                
                if( ind1 != -1 && ind2 != -1){
                    dis = Math.abs(ind1 - ind2 ) - 1;
                    if( dis < disMin ){
                        disMin = dis;
                        System.out.println(disMin);
                    }
                }
            }
        }
        
        if( ind1 != -1 && ind2 != -1){
            return disMin;
        }
        else
            return -1;
    
    }
    
    
    // Solu 2
    public int shortestDistance2(String[] arr, String w1, String w2){        
        
        HashMap<String, ArrayList<Integer>> hm = makeHM2(arr);                
        
        if( hm.containsKey( w1 ) && hm.containsKey( w2) )
            return getSD( hm.get(w1), hm.get(w2) );
        else
            return -1;        
    }
    
    public HashMap<String, ArrayList<Integer>> makeHM2(String[] arr){
        HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        
        for(int i = 0; i < arr.length; i++){
            String word = arr[i];
            
            if( hm.containsKey( word ) )
                hm.get(word).add(i);
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hm.put(word, list);
            }
        }
        
        return hm;                
    }
    
    public int getSD(ArrayList<Integer> list1, ArrayList<Integer> list2){
        
        System.out.println( list1 );
        System.out.println( list2 );
        
        int minDis = Integer.MAX_VALUE;
        int i1 = 0;
        int i2 = 0;
        
        while( i1 < list1.size() && i2 < list2.size() ){
            int dis = Math.abs( list1.get(i1) - list2.get(i2) ) -1;
            if( dis < minDis)
                minDis = dis;
            
            if( list1.get(i1) < list2.get(i2) )
                i1++;
            else 
                i2++;
        }
        return minDis;
    }
    
    //Solu 3
    public int shortestDistance3(String[] arr, String w1, String w2){
        if( arr == null || w1.equals(w2) )
            return -1;
        
        HashMap<WordPair, Integer> hm = makeHM(arr);
        
        WordPair wp = new WordPair(w1, w2);                
                
        if( hm.containsKey(wp) )
            return hm.get(wp);
        else
            return -1;            
    }
        
        
    public HashMap<WordPair, Integer> makeHM(String[] arr){
        HashMap<WordPair, Integer> hm = new HashMap<WordPair, Integer>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                WordPair wp = new WordPair(arr[i], arr[j]);
                int dis = j - i - 1;
                
                if( hm.containsKey(wp) ){
                    hm.put( wp, Math.min( hm.get(wp), dis) );
                }
                else{
                    hm.put( wp, dis );
                }
            }
        }
    
        return hm;
    }
    
    public class WordPair{
        public String w1;
        public String w2;
        
        public WordPair(String word1, String word2){
            w1 = word1;
            w2 = word2;
        }
        
        public int hashCode(){
            return w1.hashCode() + w2.hashCode();        
        }
        
        public boolean equals(Object o){
            WordPair wp = (WordPair)o;
            
            if( ( w1.equals(wp.w1) && w2.equals(wp.w2) ) || ( w1.equals(wp.w2) && w2.equals(wp.w1) ) )
                return true;
            else
                return false;
        }
    }
}
