/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package largestsumsequence;

/**
 *
 * @author Rui
 */
public class LargestSumSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LargestSumSequence lss = new LargestSumSequence();
        
        // both test cases work well
//        int[] arr = {2, -8, 3, -2, 4, -10};
        int[] arr = {-3, -8, -3, -2, -4, -10};  
        
        // Solu 2
        lss.getLargestSum(arr);
        
        // Solu 3: better
        lss.getLargestSum(arr);        
    }
    
    // Solu 2:
    public int getLargestSum(int[] arr){
        if( arr == null )
            return Integer.MIN_VALUE;
        
        if( arr.length == 1)
            return arr[0];
        
        int largestSum = Integer.MIN_VALUE;
        int largestStart = 0;
        int largestEnd = 0;
        
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum = 0;
            for(int j = i ; j < arr.length; j++){
                sum += arr[j];
                
                if( sum > largestSum){
                    largestSum = sum;
                    largestStart = i;
                    largestEnd = j;
                }
            }
        }
        
        System.out.println("start = " + largestStart +", end ="+largestEnd);
        
        for(int i = largestStart; i <= largestEnd; i++){
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("\nsum = " + largestSum);
        
        return largestSum;            
    }
    
    // Solu 3
    public int getLargestSum3(int[] arr){    
        if( arr == null )
            return Integer.MIN_VALUE;        
        
        int maxSum = Integer.MIN_VALUE;
        int maxStart = -1;
        int maxEnd = -1;
        
        int sum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        
        for(int i = 0; i < arr.length; i++){
            if( sum <= 0){
                sum = arr[i];
                start = i;
                end = i;
            }
            else{
                sum += arr[i];
                end = i;
            }
            
            if( sum > maxSum){
                maxSum = sum;
                maxStart = start;
                maxEnd = end;
            }
        }    
        
        System.out.println("start = " + maxStart +", end ="+ maxEnd);
        
        for(int i = maxStart; i <= maxEnd; i++){
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("\nsum = " + maxSum);        
        
        return maxSum;
    }    
//    // Solu 3
//    public int getLargestSum3(int[] arr){    
//        if( arr == null )
//            return Integer.MIN_VALUE;
//        
//        if( arr.length == 1)
//            return arr[0];
//        
//        int maxSum = arr[0];
//        int maxStart = 0;
//        int maxEnd = 0;
//        
//        int sum = arr[0];
//        int start = 0;
//        int end = 0;
//        
//        for(int i = 1; i < arr.length; i++){
//            if( sum <= 0){
//                sum = arr[i];
//                start = i;
//                end = i;
//            }
//            else{
//                sum += arr[i];
//                end = i;
//            }
//            
//            if( sum > maxSum){
//                maxSum = sum;
//                maxStart = start;
//                maxEnd = end;
//            }
//        }    
//        
//        System.out.println("start = " + maxStart +", end ="+ maxEnd);
//        
//        for(int i = maxStart; i <= maxEnd; i++){
//            System.out.print(arr[i] + " ");
//        }
//        
//        System.out.println("\nsum = " + maxSum);        
//        
//        return maxSum;
//    }
    
}
