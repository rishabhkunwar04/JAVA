package factoryPattern;


/*
1.We use factory design pattern when there is super class and multiple subclass, we want to use subclasses
based on input or requirement
2. It  Provides loose coupling and more robust code
3. Focus on creating  obj for interface rather than its  implementation
*/
public interface Shape {
    public void draw();
}
