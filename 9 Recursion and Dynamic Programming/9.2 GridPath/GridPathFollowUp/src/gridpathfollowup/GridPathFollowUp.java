/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gridpathfollowup;

import java.util.LinkedList;

import java.util.HashMap;
/**
 *
 * @author Rui
 */
public class GridPathFollowUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int xD = 4;  // result should be 6
        int yD = 3;
        boolean[][] arrBlocked = new boolean[xD+1][yD+1];
        
        arrBlocked[2][0] = true;
        arrBlocked[2][2] = true;
        arrBlocked[4][2] = true;  
        arrBlocked[1][3] = true;  
        
        
        
        
        // Solu 3: BFS, code on paper
        // Solu 4: DFS, code on paper        
        
        
        // Solu 1
        LinkedList<Point> list = new LinkedList<Point>();

        int[][] findArr = new int[xD+1][yD+1];     
        
        GridPathFollowUp gp = new GridPathFollowUp();
        
        if( gp.findPath(0, 0, xD, yD, arrBlocked, list, findArr) )        
            System.out.println(list);
        else
            System.out.println("No path.");
        
        
        // Solu 2: using HashMap to replace findArr
        LinkedList<Point> list2 = new LinkedList<Point>();
  
        HashMap<Point, Boolean> findArr2 = new HashMap<Point, Boolean>();
        
        GridPathFollowUp gp2 = new GridPathFollowUp();
        
        if( gp2.findPathViaHashMap(0, 0, xD, yD, arrBlocked, list2, findArr2) )        
            System.out.println(list);
        else
            System.out.println("No path.");
        
    }        
    
        public boolean findPath(int x, int y, int xD, int yD, boolean[][] arrBlocked, LinkedList<Point> list, int[][] findArr){
        if( x == xD && y == yD){
            list.addFirst(new Point(x,y) );
            return true;
        }
        
        else if( x <= xD && y <= yD && !isBlocked(arrBlocked, x, y) ){
            if( findArr[x][y] == 1 ){
                return true;
            }
            else if( findArr[x][y] == -1 ){
                return false;
            }            
            else{
                boolean found = findPath( x+1, y, xD, yD,arrBlocked,list, findArr) || findPath( x, y+1, xD, yD,arrBlocked,list, findArr);
                if( found ){
                    findArr[x][y] = 1;
                    list.addFirst( new Point(x,y) );
                    return true;
                }
                else{
                    findArr[x][y] = -1;
                    return false;                
                }
            }
        }

        return false;
    
    }
        
        
        public boolean findPathViaHashMap(int x, int y, int xD, int yD, boolean[][] arrBlocked, LinkedList<GridPathFollowUp.Point> list, HashMap<Point, Boolean> findArr){
        if( x == xD && y == yD){
            list.addFirst(new GridPathFollowUp.Point(x,y) );
            return true;
        }
        
        else if( x <= xD && y <= yD && !isBlocked(arrBlocked, x, y) ){
            
            Point p = new Point(x,y);
            
            if( findArr.containsKey( p ) ){
                return findArr.get( p );
            }                        
            else{
                boolean found = findPathViaHashMap( x+1, y, xD, yD,arrBlocked,list, findArr) || findPathViaHashMap( x, y+1, xD, yD,arrBlocked,list, findArr);
                if( found ){
                    findArr.put(p, true);
                    list.addFirst( new GridPathFollowUp.Point(x,y) );
                    return true;
                }
                else{
                    findArr.put(p, false);
                    return false;                
                }
            }
        }

        return false;
    
    }
        

    public boolean isBlocked(boolean[][] arrBlocked, int x, int y){
        return arrBlocked[x][y];
    }
    
    
    public class Point{
        private int x;
        private int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return "("+x+", "+y+")";            
        }
    }
    

    
}

