/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class RadixSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //--------------------------------------------------------------------
        // LSD RadixSort for Intergers        
        System.out.println("\n\nLSD RadixSort for Integers.");
        
        // Method 1:        
        //int[] array = {7, 9, 6, 2, 5, 0, 1, 4, 8, 3};    
        int[] array = {295, 68, 595, 72, 35, 550, 81, 64, 18, 32};  

        
        // Method 2:
//        int arraySize = 10000;        
//        int[] array = new int[arraySize];
//
//        Random generator = new Random();
//        generator.setSeed(1);        
//        for(int i = 0; i < arraySize; i++){
//            array[i] = generator.nextInt(1000000);
//        }                

        
        
        System.out.println( Arrays.toString( array ) );   
        
        RadixSort rs = new RadixSort();

        
        
        long startTime = System.currentTimeMillis();
        
        rs.radixSort(array, 10);
        
        long endTime = System.currentTimeMillis();
        
        
        
        System.out.println( Arrays.toString( array ) );        
        
        System.out.println( "Elapsed time: " + (endTime - startTime) + " ms." ); 
        
        
        
        //--------------------------------------------------------------------        
        // LSD RadixSort for Strings
        System.out.println("\n\nLSD RadixSort for Strings.");
        
        String[] arr1 = {"abe","Ac","b","ab","dac","bf","col","ac","Dac","bfgh", "can",  ""," "," b", "!", "#","+","-","*","/" };        
        System.out.println( Arrays.toString( arr1 ) );   
        
        RadixSort rs1 = new RadixSort();

        
        
        long startTime1 = System.currentTimeMillis();
        
        rs1.radixSort(arr1);
        
        long endTime1 = System.currentTimeMillis();
        

        
        
        System.out.println( Arrays.toString( arr1 ) );        
        
        System.out.println( "Elapsed time: " + (endTime1 - startTime1) + " ms." );         
       
        //--------------------------------------------------------------------        
        // MSD RadixSort for Strings
        System.out.println("\n\nMSD RadixSort for Strings.");        
        String[] arr2 = {"abe","Ac","b","ab","dac","bf","col","ac","Dac","bfgh", "can","", " "," b", "!", "#","+","-","*","/" };        
        System.out.println( Arrays.toString( arr2 ) );   
        
        RadixSort rs2 = new RadixSort();

        
        
        long startTime2 = System.currentTimeMillis();
        
        rs2.radixSortMSD(arr2);
        
        long endTime2 = System.currentTimeMillis();
        

        
        
        System.out.println( Arrays.toString( arr2 ) );        
        
        System.out.println( "Elapsed time: " + (endTime2 - startTime2) + " ms." );             
        
    }
    
    // LSD for Intergers
    public void radixSort(int[] arr, int radix){
        int maxEle = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if( maxEle < arr[i]){
                maxEle = arr[i];
            }
        }
        System.out.println("maxEle = "+maxEle);
        
        int k = 0;
        while( maxEle / (int)Math.pow( radix, k) != 0 ){
            k++;
        }
        System.out.println("k = "+ k);
        
        
        //can not use: ArrayList<Integer>[] bucket = new ArrayList<Integer>[radix];        
        ArrayList<Integer>[] bucket = new ArrayList[radix];
        for(int b = 0; b < radix; b++){
            bucket[b] = new ArrayList<Integer>();
        }
        
        
        for(int kth = 0; kth < k; kth++){

            for(int i = 0; i < arr.length; i++){
                bucket[ arr[i] / (int)Math.pow( radix, kth) % radix  ] .add( arr[i] ); 
            }
        
            int i = 0;
            for( int b = 0; b < radix; b++){
                for(int e : bucket[b] ){
                    arr[i++] = e;
                }

                bucket[b].clear();  // this is very important
            }            
            
            System.out.println("kth ="+ kth +" arr = "+ Arrays.toString( arr ) ); 
        } 
        
    }
    
    
    // LSD for Strings
    public void radixSort(String[] arr){
        int numBuckets = 256; // assume extended ASCII characters
        
        
        int maxStrLength = arr[0].length();
        for(String str : arr){
            if( maxStrLength < str.length() )
                maxStrLength = str.length();        
        }
        System.out.println("maxStrLength = "+ maxStrLength);        
       
        ArrayList<String>[] strByLength = new ArrayList[ maxStrLength + 1 ];
        for(int i = 0; i < strByLength.length; i++){
            strByLength[i] = new ArrayList<String>();
        }     
        // Do NOT use the following code, it does now work ( maybe because this is initialization)
        /*
        for(ArrayList<String> list : strByLength){
            list = new ArrayList<String>();
        }
        */        
        System.out.println("strByLength.length = "+ strByLength.length);                
        
        
        for(String str : arr){
            strByLength[ str.length() ].add( str );
        }
        
        int i1 = 0;        
        for(ArrayList<String> list : strByLength){
            for(String str : list){
                arr[i1++] = str; 
            }            
        }
        System.out.println("After strByLength, array = "+ Arrays.toString( arr ) );           
        
        
        ArrayList<String>[] bucket = new ArrayList[numBuckets];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<String>();
        }
                
        int arrStartIndex = arr.length;
        for(int charIndex = maxStrLength -1 ; charIndex >= 0; charIndex--){
            arrStartIndex -= strByLength[ charIndex + 1].size();
            
            System.out.println("charIndex = "+ charIndex + ", arrStartIndex = "+ arrStartIndex + ", array = "+ Arrays.toString( arr ) );               
            
            for(int j = arrStartIndex; j < arr.length; j++){
                //bucket[ arr[j].charAt(charIndex) ].add( arr[j] );    // condiser letter case
                bucket[ arr[j].toLowerCase().charAt(charIndex) ].add( arr[j] );  // ignore letter case
            }
        
            int i2 = arrStartIndex;
            for(ArrayList<String> b : bucket){
                for(String str : b){
                    arr[i2++] = str;
                }
                
                b.clear();  // this is very important
            }
            System.out.println("After this pass, array = "+ Arrays.toString( arr ) );               
            
        }
    
    }
    
    
    
    private String[] arrGlobal;
    private int iGlobal = 0;
    private int numBuckets = 256;    
    
    private int level = 0;
 
    public void radixSortMSD(String[] arr){
        if( arr.length == 0)
            return;
        
        arrGlobal = arr;
        
        ArrayList<String>[] buckets = new ArrayList[numBuckets];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<String>();
        }        
        
        int indexChar = 0;
        for(String str : arr){
            if( (str.length() - 1) < indexChar)
                arrGlobal[iGlobal++] = str;
            else{                        
                //buckets[ str.charAt(indexChar) ].add(str);               // consider letter case
                buckets[ str.toLowerCase().charAt(indexChar) ].add(str);   // ignore letter case
                
                //System.out.println("bucket " +str.charAt(indexChar)+ " adds:   "+ str);            
            }
        }
        
        System.out.println("indexChar = " + indexChar);
        
        for(ArrayList<String> b : buckets ){
            if( b.size() > 0){
                System.out.println("b = " + b );                   
            }
        }
        
        
        for(ArrayList<String> b : buckets ){
            if( b.size() > 0 )                
                radixSortHelper(b, indexChar + 1);
        }
    }
    
    public void radixSortHelper(ArrayList<String> list, int indexChar){
        
        System.out.println("indexChar = " + indexChar +" list = "+ list);        
        
        ArrayList<String>[] buckets = new ArrayList[numBuckets];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<String>();
        }              
        
        for(String str : list){
            if( (str.length() - 1) < indexChar){
                arrGlobal[iGlobal++] = str;
                System.out.println("arr = "+ Arrays.toString(arrGlobal) );
            }
            else{
                //buckets[ str.charAt(indexChar) ].add(str);        // consider letter case
                buckets[ str.toLowerCase().charAt(indexChar) ].add(str);       // ignore letter case
            }
        }
        
        for(ArrayList<String> b : buckets ){
            if( b.size() > 0)
                radixSortHelper(b, indexChar + 1);
        }        
        
    }
    
    
}
