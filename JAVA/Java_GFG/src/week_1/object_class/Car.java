package week_1.object_class;

public class Car {

    public String name;
    public String colour;
    public Integer price;

    public  Car(){ // un parametrized constructor

    }

    public Car(String name,String colour,Integer price){
        this.colour=colour;
        this.name=name;
        this.price=price;
    }
     public void getInfo(){
         System.out.println("Inside Car class");
         System.out.println("Name of car:"+this.name);
     }

    public void CarMethod(){
        System.out.println("method of  Car class");

    }

}
