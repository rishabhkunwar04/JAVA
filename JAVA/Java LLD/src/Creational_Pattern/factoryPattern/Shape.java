package Creational_Pattern.factoryPattern;


/*
1.We use factory design pattern when there is super class and multiple subclass, we want to use subclasses
based on input or requirement
2. It  Provides loose coupling and more robust code
3. Focus on creating  obj for interface rather than its  implementation

Factory Pattern
The Factory Pattern provides a way to create objects without specifying the exact class to instantiate.
 It defines a method (often called create or get) that subclasses or specific implementations override to produce an object.

Purpose
Used when you need a single factory method to create related objects based on certain inputs or conditions.
*/
public interface Shape {
    public void draw();
}
