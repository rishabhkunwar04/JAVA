package abstractFactoryPattern;

public class Client {
    public static void main(String[] args) {
      Employee e1=EmployeeFactory.getEmployee(new WebDevloperFactory());

      e1.name();

    }
}
