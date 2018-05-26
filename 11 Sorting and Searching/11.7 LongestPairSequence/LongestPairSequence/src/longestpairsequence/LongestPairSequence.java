/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpairsequence;

/**
 *
 * @author Rui
 */

public class LongestPairSequence{
    public static void main(String[] args){
              
        int num = 8;
        Person[] arr = new Person[num];
        arr[0] = new Person(65,100);
        arr[1] = new Person(70,150);
        arr[2] = new Person(56,90);
        arr[3] = new Person(75,190);
        arr[4] = new Person(60,95);
        arr[5] = new Person(68,110);
        arr[6] = new Person(67,200);
        arr[7] = new Person(57,96);
        
        LongestPairSequence lps = new LongestPairSequence();
        
        System.out.println("Original sequence is:");                
        lps.printSeq(arr);        
        
        Person[] longestSeq = lps.getLongestSeq( arr );
        System.out.println("Final sequence is:");                        
        lps.printSeq(longestSeq);        
    }    
    
    public Person[] getLongestSeq(Person[] arr){
        if( arr.length == 0)
            return null;
        
        if( arr.length == 1)
            return arr;
        
        
        sortByHeight( arr );
        System.out.println("After sort by height, sequence is:");                        
        printSeq(arr);
        
        
        for( int i = 1; i < arr.length; i++){
            for( int j = 0; j < i; j++){
                if( arr[i].weight > arr[j].weight && arr[i].count <= arr[j].count ){  // be careful about the <=, not >=
                    arr[i].predecessor = arr[j];
                    arr[i].count = arr[j].count + 1;
                }
            }
            
            // this is important
            if( arr[i].predecessor != null)
                System.out.printf("Person (%d, %d) count = %d, predecessor = (%d, %d)\n", arr[i].height, arr[i].weight, arr[i].count,arr[i].predecessor.height, arr[i].predecessor.weight);
            else
                System.out.printf("Person (%d, %d) count = %d, has no predecessor\n", arr[i].height, arr[i].weight, arr[i].count);
        }
        
        Person lastPerson = null;  // even if no initial value, still need to initialize with null
        int maxCount = 0;
        for( int i = 0; i < arr.length; i++){
            if( arr[i].count >= maxCount){
                maxCount = arr[i].count;
                lastPerson = arr[i];
            }
        }
        System.out.printf("maxCount = %d, lastPerson = (%d, %d)\n", maxCount, lastPerson.height, lastPerson.weight);
        
        Person[] longestSeq = new Person[maxCount];
        longestSeq[maxCount - 1] = lastPerson;
        for(int i = maxCount - 2; i>= 0; i--){
            longestSeq[i] = longestSeq[i+1].predecessor;
        }
        
        return longestSeq;
    
    }
    
    public void sortByHeight(Person[] arr){
        // Can use radixSort for O(logn) if Height are integers
        
        // Here I use quickSort for expected O(nlogn)
        quickSort(arr, 0, arr.length -1);        
    }
    
    public void quickSort(Person[] arr, int left, int right){
        if( left >= right )
            return;

        int pivotIndex = partition( arr, left, right);
        quickSort( arr, left, pivotIndex -1);
        quickSort( arr, pivotIndex + 1, right);
    }
    
    public int partition(Person[] arr, int left, int right){                
        int p = right;
        
        int i = left;
        for( int k = left; k <= ( right -1 ); k++){
            if( arr[k].height < arr[p].height ){
                Person tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                
                i++;            
            }
        }
        
        Person tmp = arr[i];
        arr[i] = arr[p];
        arr[p] = tmp;                        
        
        return i;
    }    
    
    public void printSeq(Person[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("(%d, %d) ", arr[i].height, arr[i].weight);
        }
        System.out.println();
    }
    
}
