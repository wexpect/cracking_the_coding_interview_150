/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computeexpression;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class ComputeExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ComputeExpression ce = new ComputeExpression();
        
        String exp = "1^0|0|1";
        int value = 0;
        System.out.println( ce.count( exp, value ) );
    }
    
    public int count(String exp, int value){
        if( exp == null || exp.length() <= 0 || !(value == 0 || value == 1) )
            return -1;
        
        int count = 0;
        HashMap<String, Integer> expToValueMap = compute(exp);
        
        System.out.println( expToValueMap );
        
        for( String str : expToValueMap.keySet() ){
            if( expToValueMap.get( str ) == value )
                count++;
        }
        return count;
                    
    }
    
    public HashMap<String, Integer> compute(String exp){
        HashMap<String, Integer> expToValueMap = new HashMap<String, Integer>();
        
        if( exp.length() == 1){
            expToValueMap.put(exp, Integer.parseInt( exp ) );
            return expToValueMap;
        }
        
        for(int i = 1; i < exp.length(); i++){
            char c = exp.charAt(i);
            
            if(  c == '&' || c == '|' || c== '^' ){
                HashMap<String, Integer> leftExpToValueMap = compute( exp.substring(0, i) );
                HashMap<String, Integer> rightExpToValueMap = compute( exp.substring(i+1) );
                
                for( String leftExp : leftExpToValueMap.keySet() ){
                    int leftValue = leftExpToValueMap.get( leftExp );
                    
                    for( String rightExp : rightExpToValueMap.keySet() ){
                        int rightValue = rightExpToValueMap.get( rightExp );
                        
                        int value = operate(leftValue, c, rightValue);
                        
                        if( leftExp.length() > 1)
                            leftExp = '('+leftExp+')';
                        if( rightExp.length() > 1)
                            rightExp = '('+rightExp+')';
                                                
                        expToValueMap.put( leftExp+c+rightExp, value );                        
                    }                                
                }
            }        
        }
        return expToValueMap;
    }
    
    public int operate(int v1, char op, int v2){
        switch(op){
            case '&':
                return v1 & v2;
            case '|':
                return v1 | v2;
            case '^':                
                return v1 ^ v2;                
            default:
                return -1;                
        }
    }
}
