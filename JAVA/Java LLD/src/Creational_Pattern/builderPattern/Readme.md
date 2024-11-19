
 ## Builder Design Pattern 
* it is a creational design pattern that solves problems related to creating complex objects with multiple configurations. It provides a systematic way to construct an object step-by-step while ensuring that the construction process is independent of the object's representation.

```agsl
## Without Builder Pattern (Telescoping Constructor Problem)

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private boolean sunroof;

    // Telescoping constructor
    public Car(String make, String model, int year, String color, boolean sunroof) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.sunroof = sunroof;
    }

    @Override
    public String toString() {
        return "Car{" + "make='" + make + '\'' + ", model='" + model + '\'' +
               ", year=" + year + ", color='" + color + '\'' + ", sunroof=" + sunroof + '}';
    }
}

// Usage
Car car = new Car("Toyota", "Camry", 2022, "Blue", true);
System.out.println(car);

Problems:
Adding or removing parameters requires changes in all constructors.
Hard to read and understand which parameter represents what.

## With Builder Pattern

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private boolean sunroof;

    // Private constructor to enforce the use of the builder
    private Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
    }

    @Override
    public String toString() {
        return "Car{" + "make='" + make + '\'' + ", model='" + model + '\'' +
               ", year=" + year + ", color='" + color + '\'' + ", sunroof=" + sunroof + '}';
    }

    // Static inner builder class
    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private String color;
        private boolean sunroof;

        public CarBuilder(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

// Usage
public class BuilderPatternExample {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("Toyota", "Camry")
                        .year(2022)
                        .color("Blue")
                        .sunroof(true)
                        .build();

        System.out.println(car);
    }
}
```