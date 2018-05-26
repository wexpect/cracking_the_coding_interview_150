/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] arr = {"Now","lived","won","silent","Own", "liv","dev","Devil","listen"};
        
        System.out.println(Arrays.toString(arr));
        
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(arr);
        
        System.out.println(Arrays.toString(arr));        
    }
    
    public void groupAnagrams(String[] arr){
        
        HashMap<String, LinkedList<String>> hashMap = new HashMap<String, LinkedList<String>>();
    
        for(String str : arr){
            String key = RadixSortString(str);
            System.out.printf("Key of \"%s\" is \"%s\"\n", str, key);
            
            
            if( !hashMap.containsKey(key) )
                hashMap.put(key, new LinkedList<String>() );
            
            hashMap.get(key).addFirst(str);        
        }
        
        int i = 0;
        for( LinkedList<String> list : hashMap.values() ){
            System.out.print("List has: ");
            for(String str : list){
                System.out.print(str + " ");
                arr[i++] = str;
            }        
            System.out.println();            
        }    
    }
    
    public String RadixSortString(String strUnSorted){
        
        char[] arr = strUnSorted.toLowerCase().toCharArray();  // remrmber toLowerCase()
      
        int numBuckets = 256; // assume extended ASCII characters                                 
        
        ArrayList<Character>[] bucket = new ArrayList[numBuckets];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<Character>();
        }
                
        for(int i = 0; i < arr.length; i++){
            bucket[ arr[i] ].add( arr[i] );                        
        }

        int i2 = 0;
        for(ArrayList<Character> b : bucket){
            for(Character ch : b){
                arr[i2++] = ch;
            }

            b.clear();  // this is very important
        }        
        
        return new String(arr);
    }
    
    
}
