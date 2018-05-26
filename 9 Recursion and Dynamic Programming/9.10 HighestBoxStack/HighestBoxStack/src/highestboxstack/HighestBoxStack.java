/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highestboxstack;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class HighestBoxStack {

   public static void main(String[] args){
        
        int num = 8;
        Box[] arr = new Box[num];
        arr[0] = new Box(65,100, 10);
        arr[1] = new Box(70,150, 20);
        arr[2] = new Box(56,90, 20);
        arr[3] = new Box(75,190, 30);
        arr[4] = new Box(60,95, 40);
        arr[5] = new Box(68,110, 50);
        arr[6] = new Box(67,200, 60);
        arr[7] = new Box(57,96, 70);
        
        HighestBoxStack hbs = new HighestBoxStack();
        
        System.out.println("Original sequence is:");                
        hbs.printSeq(arr);        
        
        Box[] highestStack = hbs.getHighestStack( arr );
        System.out.println("Final sequence is:");                        
        hbs.printSeq(highestStack);        
    }    
    
    public Box[] getHighestStack(Box[] arr){
        if( arr.length == 0)
            return null;
        
        if( arr.length == 1)
            return arr;
        
        
        sortByHeight( arr ); // from high to low
        System.out.println("After sort by height from high to low, sequence is:");                        
        printSeq(arr);
        
        
        for( int i = 1; i < arr.length; i++){
            for( int j = 0; j < i; j++){
                if( arr[i].width < arr[j].width && arr[i].depth < arr[j].depth && (arr[i].totalHeight - arr[i].height) < arr[j].totalHeight ){  // be careful about the <, not >
                    arr[i].predecessor = arr[j];
                    arr[i].totalHeight = arr[i].height + arr[j].totalHeight;
                    arr[i].count = arr[j].count + 1;
                }
            }
            
            // this is important
            if( arr[i].predecessor != null)
                System.out.printf("Box (%d, %d, %d) totalHeight = %d, count = %d, predecessor = (%d, %d, %d)\n", arr[i].height, arr[i].width, arr[i].depth, arr[i].totalHeight, arr[i].count,arr[i].predecessor.height, arr[i].predecessor.width, arr[i].predecessor.depth);
            else
                System.out.printf("Box (%d, %d, %d) totalHeight = %d, count = %d, has no predecessor\n", arr[i].height, arr[i].width, arr[i].depth, arr[i].totalHeight, arr[i].count);
        }   
        
        Box topBox = null;  // even if no initial value, still need to initialize with null
        int maxHeight = 0;
        int maxCount = 0;
        for( int i = 0; i < arr.length; i++){
            if( arr[i].totalHeight > maxHeight){  
            	maxHeight = arr[i].totalHeight;
                topBox = arr[i];
                maxCount = arr[i].count;
            }
        }
        System.out.printf("maxCount = %d, topBox = (%d, %d, %d)\n", maxCount, topBox.height, topBox.width, topBox.depth);
        
        Box[] highestStack = new Box[maxCount]; // from high to low
        highestStack[maxCount - 1] = topBox;
        for(int i = maxCount - 2; i>= 0; i--){
            highestStack[i] = highestStack[i+1].predecessor;
        }
        
        return highestStack;
    
    }
    
    public void sortByHeight(Box[] arr){
        Arrays.sort(arr, new MyComparator() );      
    }           
    
    public void printSeq(Box[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("(%d, %d, %d) ", arr[i].height, arr[i].width, arr[i].depth);
        }
        System.out.println();
    }
}
