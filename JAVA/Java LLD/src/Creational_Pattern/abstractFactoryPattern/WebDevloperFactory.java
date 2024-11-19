package Creational_Pattern.abstractFactoryPattern;

public class WebDevloperFactory  extends  EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new Webdevloper();
    }
}
