/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setofstacks;

import java.util.ArrayList;

/**
 *
 * @author Rui
 */

public class SetOfStacks{
    
    public static void main(String[] args) throws Exception{        
        SetOfStacks ss = new SetOfStacks();
        
        ss.printSetOfStacks();
        
        ss.push(1);
        ss.printSetOfStacks();        
        
        ss.push(2);
        ss.printSetOfStacks();      
        
        ss.push(3);
        ss.printSetOfStacks();      
                
        
        ss.push(4);
        ss.printSetOfStacks();      
        
        ss.push(5);
        ss.printSetOfStacks();      
        
        
        for(int i = 0; i < 2; i++){
            ss.pop();
            ss.printSetOfStacks();                        
        }
        
        
        
        ss.push(6);
        ss.printSetOfStacks();              
        
        
        ss.push(7);
        ss.printSetOfStacks();      
        
        ss.push(8);
        ss.printSetOfStacks();      
        
        ss.push(9);
        ss.printSetOfStacks();          
        
        
        ss.popAt(1);
        ss.printSetOfStacks();           

        ss.push(10);
        ss.printSetOfStacks();   
        
        ss.pop();
        ss.printSetOfStacks();   
        
        
        ss.popAt(1);
        ss.printSetOfStacks();                   

        ss.popAt(1);
        ss.printSetOfStacks();    
                
    }
    
    private ArrayList<Stack> array = new ArrayList<Stack>();
    private int currentIndex = -1;
    private Stack currentStack;
    
    public SetOfStacks(){
        addStack();
    }
    
    public void push(Object element) throws Exception{
        if( currentStack.isFull() ){
            addStack();
        }
        
        currentStack.push(element);        
    }
    
    public Object pop() throws Exception{
        while( currentStack.isEmpty() ){            
            
            if( currentIndex == 0 ){
                throw new Exception("SetOfStack is empty");
            }
            
            array.remove(currentIndex);
            currentIndex--;
            
            currentStack = array.get(currentIndex);
        }
        
        return currentStack.pop();
    }
    
    public void addStack(){                
        currentIndex++;
        currentStack = new Stack();
        array.add(currentStack);
    }
    
    public void printSetOfStacks(){        
        System.out.println("\nSetOfStack :");        
        for(int i = 0; i <= currentIndex; i++){
            System.out.println("Stack "+ i + " :");
            array.get(i).printStack();
        }        
    }
    
    
    public Object popAt(int index) throws Exception{
        if( index > currentIndex )
            throw new Exception("Index is out of bound.");
        
        return array.get(index).pop();    
    }
        
}