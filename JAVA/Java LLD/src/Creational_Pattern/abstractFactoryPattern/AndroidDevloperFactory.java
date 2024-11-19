package Creational_Pattern.abstractFactoryPattern;

public class AndroidDevloperFactory extends EmployeeAbstractFactory {
    @Override
    public Employee createEmployee() {
        return new AndroidDevloper();
    }
}
