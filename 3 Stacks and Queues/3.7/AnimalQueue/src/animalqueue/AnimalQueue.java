/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalqueue;

/**
 *
 * @author Rui
 */


public class AnimalQueue{
    
    public static void main(String[] args){
    
        Animal a1 = new Animal("cat",1);
        Animal a2 = new Animal("dog",2);
        Animal a3 = new Animal("dog",3);
        Animal a4 = new Animal("cat",4);
        Animal a5 = new Animal("dog",5);
        Animal a6 = new Animal("cat",6);                
        
        AnimalQueue aq = new AnimalQueue();        
        aq.enqueue(a1);
        aq.enqueue(a2);
        aq.enqueue(a3);
        aq.enqueue(a4);
        aq.enqueue(a5);        
        aq.enqueue(a6);        
        
        aq.printQ();
        
        aq.dequeueAny();
        aq.printQ();
        
        aq.dequeueCat();
        aq.printQ();
        
        aq.dequeueDog();        
        aq.printQ();        
        
        aq.dequeueAny();
        aq.printQ();

        
        aq.dequeueAny();
        aq.printQ();
        
        aq.dequeueAny();
        aq.printQ();
        
        aq.dequeueAny();
        aq.printQ();        
    }

    private int timestamp = 0;
    private Queue catQ = new Queue();
    private Queue dogQ = new Queue();
    
    public void enqueue(Animal ani){                        
        timestamp++;            
            
        if(ani.type.equals("cat"))
            catQ.enqueue(ani, timestamp);                        
        else if(ani.type.equals("dog"))
            dogQ.enqueue(ani, timestamp);        
    }
    
    public Animal dequeueAny(){
        if( !catQ.isEmpty() && !dogQ.isEmpty() ){
            if( catQ.peek().time < dogQ.peek().time  )
                return catQ.dequeue();
            else
                return dogQ.dequeue();
        }        
        else if( !catQ.isEmpty() )
            return catQ.dequeue();
        else if( !dogQ.isEmpty() )
            return dogQ.dequeue();
        else 
            return null;
    }
    
    public Animal dequeueCat(){
        return catQ.dequeue();
    }

    public Animal dequeueDog(){
        return dogQ.dequeue();
    }    
    
    public void printQ(){
        System.out.println("Animal Queues:");
        catQ.printQ();
        dogQ.printQ();
        System.out.println("Animal Queues End.\n");        
    }
    
    
}