package Creational_Pattern.singleton;
/*
==> The Singleton Design Pattern is a creational pattern that ensures a class has only one instance and provides a global point of access to that instance.


1.  if constructor is private client cannot create obj of class
2. get instance method is static because for nonstatic method we need obj to invoke it
3. instance variable is static because in static method getinstance we have to use static variable
*/


////*** Lazy Initialization *** //
//// 1. lazy initialization is not thread safe
//
//public class Singleton {
//    private static Singleton instance;
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        if(instance==null){
//            instance=new Singleton();
//
//        }
//        return instance;
//    }
//}

////*** Eager Initialization *** //

//// 1. eager initialization waste space it create obj in advance when class loaded,
//// lets suppose client didnt need any obj to use then its just space wastage
/// final prevents the instance from being reassigned after initialization.
//
//public class Singleton {
//    private static  final Singleton instance=new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//
//        return instance;
//    }
//}


///*** Thread safe lazy Initialization *** //

///This is achieved by making the getInstance() method synchronized ensuring only one thread can execute this method at a time.

///When a thread enters the synchronized method, it acquires a lock on the class object. Other threads must wait until the method is executed.
/// this design has overhead when getinstance call frequenctly because all thread are getting blocked

/*
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){

                if (instance == null) {
                    instance = new Singleton();
                }
        return instance;
    }
}

*/

/// *** Double-Checked Locking  ***//

///This approach minimizes performance overhead from synchronization by only synchronizing when the object is first created.
///It uses the volatile keyword to ensure that changes to the instance variable are immediately visible to other threads.



public class Singleton {
    private static Singleton instance;
    private Singleton(){}
        public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}

////** ENUM Singleton ** //
//The Enum Singleton pattern is the most robust and concise way to implement a singleton in Java.
/*
public enum Enumsingleton{
    INSTANCE;

    public void doSomething(){

    }
}
 */