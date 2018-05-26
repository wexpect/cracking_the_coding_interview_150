package kthnumber;

import java.util.ArrayList;
import java.util.Arrays;

public class KthNumber{

    public static void main(String[] main){
        KthNumber kn = new KthNumber();
        
        int k = 10;
        
        System.out.println( kn.getkth(k) );
    }
    
    public int getkth(int k){
        if( k <= 0 )
            return -1;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add( 3 * 5 * 7 );       
        
        while( list.size() < k){
            int lastNum = list.get( list.size() - 1);
            int next = Integer.MAX_VALUE;
                        
            for(int i = 0; i < list.size(); i++){
                int num = list.get(i);
                
                int[] arr = {3,5,7};
                for(int m : arr){
                    int newNum = num * m;
                    
                    if( newNum > lastNum && newNum < next){
                        next = newNum;
                        break;
                    }                
                }
            }
            
            list.add(next);
        }
     
        return list.get( k-1 );        
    }
}
