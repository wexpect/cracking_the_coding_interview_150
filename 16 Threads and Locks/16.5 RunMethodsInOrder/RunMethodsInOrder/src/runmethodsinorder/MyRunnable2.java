package runmethodsinorder;

/**
 *
 * @author Rui
 */
public class MyRunnable2 implements Runnable{

    private FooWithoutFlag f;
    private int id;
        
    public MyRunnable2(FooWithoutFlag foo, int ID){
        f = foo;
        id = ID;    
    }
    
    public void run(){
//        switch(id){
//            case 1: f.first();                
//                    break;            
//            case 2: f.second();            
//                    break;
//            case 3: f.third();
//                    break;
//            default: break;                                    
//        }
        
        if( id == 1){
            f.first();
        }
        else if( id == 2){
            try{
                f.second();
            }
            catch(InterruptedException e){
            }
        }
        else if( id == 3){
            try{
                f.third();
            }
            catch(InterruptedException e){
            }
        }    
    }

}