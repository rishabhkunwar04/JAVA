
## Factory Pattern
The Factory Pattern provides a way to create objects without specifying the exact class to instantiate.
 It defines a method (often called create or get) that subclasses or specific implementations override to produce an object.

* Purpose
Used when you need a single factory method to create related objects based on certain inputs or conditions.

* We use factory design pattern when there is super class and multiple subclass, we want to use subclasses
based on input or requirement
*  It  Provides loose coupling and more robust code
*  Focus on creating  obj for interface rather than its  implementation


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