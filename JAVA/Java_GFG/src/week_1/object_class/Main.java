package week_1.object_class;

public class Main {
    public static void main(String[] args) {


//        SuperCar sc=new SuperCar("Buggati","black",500000000);
//        sc.getInfo(); // it will print the super class get info


//        Car sc=new SuperCar("Buggati","black",500000000);
//        /* sc obj can only access common members of both classes or members of car class not of super class
//           it basically provides abstraction, it hides  info of child class which is not common
//         */
//        sc.getInfo();

        Engine e=new ElectricEngine();
        e.start();
        Engine ee=new PetrolEngine();
        ee.start();
        // it provide abstration we dont know how start of electric and petrol engine is written.

    }
}