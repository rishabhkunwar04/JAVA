package week_1.object_class;

import week_1.object_class.Car;

public class SuperCar extends Car {


    public SuperCar(String name, String colour, Integer price) {
        super(name, colour, price); // this is required if there is no any default constructor mentioned in Parent class
    }

    @Override
    public void getInfo() {
//        super.getInfo();
        System.out.println("Inside super class");
    }


    public void SuperCarMethod(){
        System.out.println("method of  SuperCar class");

    }
}
