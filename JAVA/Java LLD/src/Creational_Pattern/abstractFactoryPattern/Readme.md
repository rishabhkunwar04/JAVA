```java
// Abstract Products
interface Shape {
    void draw();
}

interface Color {
    void fill();
}

// Concrete Products
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Red");
    }
}

class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Blue");
    }
}

// Abstract Factory
interface AbstractFactory {
    Shape getShape();
    Color getColor();
}

// Concrete Factories
class ShapeFactory implements AbstractFactory {
    private final String shapeType;

    public ShapeFactory(String shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public Shape getShape() {
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }

    @Override
    public Color getColor() {
        return null; // ShapeFactory doesn't create colors
    }
}

class ColorFactory implements AbstractFactory {
    private final String colorType;

    public ColorFactory(String colorType) {
        this.colorType = colorType;
    }

    @Override
    public Shape getShape() {
        return null; // ColorFactory doesn't create shapes
    }

    @Override
    public Color getColor() {
        switch (colorType.toUpperCase()) {
            case "RED":
                return new Red();
            case "BLUE":
                return new Blue();
            default:
                return null;
        }
    }
}

// Factory Producer
class FactoryProducer {
    public static AbstractFactory getFactory(String choice, String type) {
        switch (choice.toUpperCase()) {
            case "SHAPE":
                return new ShapeFactory(type);
            case "COLOR":
                return new ColorFactory(type);
            default:
                return null;
        }
    }
}

// Client Code
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        // Get Shape Factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE", "CIRCLE");
        Shape shape = shapeFactory.getShape();
        shape.draw(); // Output: Drawing a Circle

        // Get Color Factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR", "RED");
        Color color = colorFactory.getColor();
        color.fill(); // Output: Filling with Red
    }
}

```