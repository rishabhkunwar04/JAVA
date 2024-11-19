package Behavioural_Pattern.statePattern;

public class NoMoneyState implements State {
    @Override
    public void insertMoney(VendingMachine vmc) {
        System.out.println("Inserting money to purchase product");
        vmc.setState(new HasMoneyState());

    }

    @Override
    public void provideChangeMoney(VendingMachine vmc) {
        System.out.println("no money to return ");
    }

    @Override
    public void dispenseProduct(VendingMachine vmc) {
        System.out.println("No product to return ! insert money to purchase the item");

    }
}
