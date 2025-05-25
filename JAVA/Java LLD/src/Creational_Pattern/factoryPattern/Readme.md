
## Factory Pattern
It is a creational design pattern used to create objects without exposing the instantiation logic to the client, and instead using a common interface. It's a key pattern when you want to encapsulate object creation, particularly when object construction is complex or varies based on some conditions

* Used when you need a single factory method to create related objects based on certain inputs or conditions.
* We use factory design pattern when there is super class and multiple subclass, we want to use subclasses
based on input or requirement
*  It  Provides loose coupling and more robust code
* it encapsulate object creation logic
- **Example:** In a movie booking system, creating different types of seats (Normal, Premium) with dynamic pricing and status.
- **Disadvantage**
    1. Complexity of code
    2. Hidden object creation logic so harder to debug


```java

public interface Shape {
    public void draw();
}


public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Square");

    }
}


public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println(" Drawing Circle");

    }
}

public class ShapeFactory {
   Shape getShape(String input){
        switch(input){
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
        }

       return new Square();
    }
}

public class Test {
    public static void main(String[] args) {

        ShapeFactory obj1=new ShapeFactory();
        Shape obj2=obj1.getShape("Square");
        obj2.draw();

    }
}



```