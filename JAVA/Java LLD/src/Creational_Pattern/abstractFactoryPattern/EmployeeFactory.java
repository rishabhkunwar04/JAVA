package Creational_Pattern.abstractFactoryPattern;

public class EmployeeFactory {

    public static Employee getEmployee(EmployeeAbstractFactory factory){
        return factory.createEmployee();

    }
}
