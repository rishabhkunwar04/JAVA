package factoryPattern;

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
