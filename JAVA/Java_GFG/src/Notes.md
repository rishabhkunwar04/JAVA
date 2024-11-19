
[Java Tutorial Link](https://www.javatpoint.com/java-tutorial)
### week_1
* Function overloading, operator overloading, and method overloading are examples of compile-time polymorphism
* Method overriding is an example of runtime polymorphism. The method that gets invoked is determined during the execution of the program, typically using pointers or references to base classes.
* in abstract class we can have abstract and Non-abstract members but in interface we cant have non abstract members
* if we don't add any access modifier then by default class members are package private inside package  we can access it nut not outside of package
### week_2
* we can access class static member without  help of object
* non-static member allocated memory once obj is created but static member initialized in memory once class comes in existence.
* static member access via reference of classname 
* non-static members can access static member because they are already present in memory but static member cant always access the non-static member because they may not be present in memory
* ` difference b/w throw and throws: https://www.javatpoint.com/difference-between-throw-and-throws-in-java`
* `Difference b/w final,finally,finalize`
*  Final variables: When a variable is declared as final, its value cannot be changed once it has been initialized. This is useful for declaring constants or other values that should not be modified.
* Final methods: When a method is declared as final, it cannot be overridden by a subclass. This is useful for methods that are part of a class’s public API and should not be modified by subclasses.
* Final classes: When a class is declared as final, it cannot be extended by a subclass. This is useful for classes that are intended to be used as is and should not be modified or extended.
* ##### Interaction Between JDK, JRE, and JVM
  Development: When developers write Java code, they use the JDK, which includes the compiler (javac). The compiler converts the source code into bytecode.
  Execution: To run the compiled bytecode, users need the JRE. The JRE contains the JVM, which executes the bytecode. The JVM converts the bytecode into machine code that can be understood by the hardware.
  Runtime: During execution, the JVM manages memory, handles exceptions, and performs JIT compilation to optimize performance.

