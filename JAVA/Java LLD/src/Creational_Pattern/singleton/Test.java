package Creational_Pattern.singleton;

public class Test {
    public static void main(String []args){

       Singleton obj1 = Singleton.getInstance();
        System.out.println("first obj hashcode:"+obj1.hashCode());

        Singleton obj2 = Singleton.getInstance();
        System.out.println("second obj hashcode:"+obj2.hashCode());


    }
}
