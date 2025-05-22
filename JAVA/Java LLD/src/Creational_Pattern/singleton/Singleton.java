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
//
//public class Singleton {
//    private static Singleton instance=new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//
//        return instance;
//    }
//}


//*** Thread safe lazy Initialization *** //

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

////** ENUM Singleton
////The Enum Singleton pattern is the most robust and concise way to implement a singleton in Java.
//public enum Enumsingleton{
//    INSTANCE;
//
//    public void doSomething(){
//
//    }
//}