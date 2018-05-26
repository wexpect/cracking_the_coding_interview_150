/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findpermutations;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */

public class FindPermutations{

    public static void main(String[] args){
    
        //String str = "string";
        String str = "123";

        FindPermutations fp = new FindPermutations();
        
        System.out.println( "Permutation is: "+ fp.getPerm(str, 0) );
       
        
    }

    // this general solution not only works for String, but also for other Object types.
    ArrayList<LinkedList<Character>> getPerm(String str, int startIndex){
        if( str == null || startIndex >= str.length() )
            return null;
        
        if( startIndex == str.length() - 1 ){
            LinkedList<Character> linList = new LinkedList<Character>();
            linList.add(str.charAt(startIndex));
            
            ArrayList<LinkedList<Character>> arrList = new ArrayList<LinkedList<Character>>();
            arrList.add(linList);
            
            System.out.println("first list: "+ linList );
            
            return arrList;
        }
        
        ArrayList<LinkedList<Character>> arrList = getPerm(str, startIndex + 1);
        ArrayList<LinkedList<Character>> newArrList = new ArrayList<LinkedList<Character>>();
        
        for( LinkedList<Character> linList : arrList ){
            for( int i = 0; i <= linList.size(); i++){ // also consider i == linList.size()
                LinkedList<Character> newLinList = new LinkedList<Character>();
                newLinList.addAll( linList );
                newLinList.add(i, str.charAt(startIndex) );
                newArrList.add( newLinList );                        
                
                System.out.println(newLinList );
            }    
        }
        return newArrList;
    
    }
}




