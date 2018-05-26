/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sortstack;

/**
 *
 * @author Rui
 */

public class SortStack{             
    
    public static void main(String[] args) throws Exception{
        
        Stack st = new Stack();
        st.push(4);
        st.push(1);
        st.push(7);
        st.push(8);
        st.push(3);
        st.push(10);
        st.push(9);
        st.push(2);
        st.push(6);
        st.push(5);

        
        st.printStack();
        
        
        SortStack ss = new SortStack();
        
        Stack stSort = ss.sort(st);
        stSort.printStack();        
    }
    
    
    // this takes O(nlgn) time ( each recursion is 2n time and a total of lgn recursion levels) and O(n) space
    public Stack sort(Stack s) throws Exception{               
        
        if( s.isEmpty() )
            return s;
        
        int pivot = s.pop();
        Stack small = new Stack();
        Stack bigEq = new Stack();
        
        while( !s.isEmpty () ){
            if( s.peek() < pivot )                                  
                small.push( s.pop() );
            else
                bigEq.push( s.pop() );                    
        }
        
        
        Stack smallSort = sort( small );        
        Stack bigEqSort = sort( bigEq );
        
        Stack bigEqReverse = new Stack();
        while( !bigEqSort.isEmpty() ){              
            bigEqReverse.push( bigEqSort.pop() );
        }        
        
                
        smallSort.push(pivot);
                
        while( !bigEqReverse.isEmpty() ){
            smallSort.push( bigEqReverse.pop() );        
        }
        
        return smallSort;
                
    }
       
    
}