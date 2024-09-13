package factoryPattern;

public class Test {
    public static void main(String[] args) {

        ShapeFactory obj1=new ShapeFactory();
        Shape obj2=obj1.getShape("Square");
        obj2.draw();

    }
}
