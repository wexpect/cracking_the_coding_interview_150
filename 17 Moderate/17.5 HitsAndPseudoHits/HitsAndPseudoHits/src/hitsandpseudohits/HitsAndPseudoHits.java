/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hitsandpseudohits;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class HitsAndPseudoHits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String solu  = "RGBY";
        String guess = "YGRR";
        
        HitsAndPseudoHits nhp = new HitsAndPseudoHits();
        Container cont = nhp.getHits(solu, guess);
        
        System.out.println(cont.numHits + ", "+cont.numPseudoHits);  
    }
    
    public Container getHits(String sol, String gue){
        if( sol == null || gue == null || sol.length() != 4 || gue.length() != 4 )
            return null;
        
        char[] solu = sol.toCharArray();
        char[] guess = gue.toCharArray();
        
        Container cont = new Container();
        
        cont.numHits = countHits(solu, guess);
        cont.numPseudoHits = countPseudoHits(solu, guess);
        
        return cont;
    
    }
    
    public int countHits(char[] solu, char[] guess){
        int numHits = 0;
        for(int i = 0; i < solu.length; i++){
            if( solu[i] == guess[i] ){
                numHits++;
                solu[i] = ' ';
                guess[i] = ' ';                
            }            
        }
        return numHits;
    }
    
    public int countPseudoHits(char[] solu, char[] guess){
        HashMap<Character, Integer> soluNum = countCharNum(solu);
        HashMap<Character, Integer> guessNum = countCharNum(guess);
        
        return Math.min( soluNum.get('R'), guessNum.get('R') ) + Math.min( soluNum.get('Y'), guessNum.get('Y') ) + Math.min( soluNum.get('G'), guessNum.get('G') ) + Math.min( soluNum.get('B'), guessNum.get('B') );
    }
    
    public HashMap<Character, Integer> countCharNum(char[] arr){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('R', 0);
        hm.put('Y', 0);
        hm.put('G', 0);
        hm.put('B', 0);
        hm.put(' ', 0);
        
        for(int i = 0; i < arr.length; i++){
            hm.put( arr[i], hm.get(arr[i])+1 );
        }
        
        return hm;
    }
    
    public class Container{
        public int numHits = 0;
        public int numPseudoHits = 0;      
    }
}
