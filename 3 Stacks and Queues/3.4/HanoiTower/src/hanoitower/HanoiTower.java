/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

/**
 *
 * @author Rui
 */

public class HanoiTower{
        
    public static void main(String[] args) throws Exception{
        Stack left = new Stack("Left");
        Stack middle = new Stack("Middle");        
        Stack right = new Stack("Right");
        
        HanoiTower ht = new HanoiTower();
        
        //int n = Integer.parseInt(args[0]);        
        int n = 4;
        
        for(int i = 0; i < n; i++){
            left.push(n-i);
        }
                
        ht.printTower(left, middle, right);
        
        ht.move(left, right, middle, n);
        
        ht.printTower(left, middle, right);        
    }

    public void move(Stack s, Stack d, Stack m, int n) throws Exception{
        if( n < 1)
            return;        
        else if( n == 1){
            int tmp = s.pop();
            d.push(tmp);
            System.out.println("Move from " + s.position + " to "+ d.position);
        }
        else{
            move(s, m, d, n-1);
            move(s,d,m,1);
            move(m,d,s, n-1);        
        }    
    }

    public void printTower(Stack L, Stack M, Stack R){
        System.out.println("\nTower:");
        L.printStack();
        M.printStack();
        R.printStack();        
    }
    
}