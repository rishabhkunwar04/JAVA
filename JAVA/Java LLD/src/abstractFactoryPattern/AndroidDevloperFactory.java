package abstractFactoryPattern;

public class AndroidDevloperFactory extends EmployeeAbstractFactory {
    @Override
    public Employee createEmployee() {
        return new AndroidDevloper();
    }
}
