/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpairsequence;

/**
 *
 * @author Rui
 */
public class Person{
    public int height;
    public int weight;
    public int count;
    public Person predecessor;

    public Person(int h, int w){
        height = h;
        weight = w;
        count = 1;
        predecessor = null; // even if no initial value, still need to initialize with null
    }    
}
