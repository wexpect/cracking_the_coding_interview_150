
package linepasspoints;

import java.util.HashMap;

public class LinePassPoints{
    
    public static void main(String[] args){
        Point[] arr = new Point[5];
        arr[0] = new Point(3,1);
        arr[1] = new Point(1,1);
        arr[2] = new Point(2,2);
        arr[3] = new Point(3,3);
        arr[4] = new Point(4,1);
        
        LinePassPoints lpp = new LinePassPoints();
        
        // Solu 1:
        //Line line = lpp.getLine(arr);
        
        // Solu 2:
        Line line = lpp.getLine2(arr);
        
        System.out.println(line);
    }

    // Solu 1: time complexity O(n^3), space complexity O(1)
    public Line getLine(Point[] arr){
        if( arr == null || arr.length == 0)
            return null;
        if( arr.length == 1)
            return new Line(arr[0], arr[0]);
        
        int countMax = 0;
        Line lineMax = null;
        
        for(int i = 0; i <= arr.length - 2; i++){
            Line line = new Line(arr[i], arr[i+1]);
            int count = 2;
            
            for(int j = i+2; j<= arr.length -1; j++){
                if( line.passes( arr[j]) )
                    count++;                
            }
            
            if( count > countMax){
                countMax = count;
                lineMax = line;
            }
        }
        
        return lineMax;
    }
    
    
        // Solu 2: time complexity O(n^2), space complexity O(n^2)
    public Line getLine2(Point[] arr){
        if( arr == null || arr.length == 0)
            return null;
        if( arr.length == 1)
            return new Line(arr[0], arr[0]);
        
        int countMax = 0;
        Line lineMax = null;
        
        HashMap<Line, Integer> hash = new HashMap<Line, Integer>();
                
        for(int i = 0; i <= arr.length - 2; i++){            
            for(int j = i+1; j<= arr.length - 1; j++){
                
                Line line = new Line(arr[i], arr[j]);
                int count = 0;                
                
                if( hash.containsKey( line ) ){
                    count = hash.get( line );
                    hash.put( line, ++count);
                    
                    System.out.println(count);
                }
                else{
                    hash.put( line, ++count);
                }
                
                if( count > countMax){
                    countMax = count;
                    lineMax = line;
                }                                    
            }
        }   
        return lineMax;
    }
}