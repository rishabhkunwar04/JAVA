package Behavioural_Pattern.statePattern;

public class HasMoneyState implements State {
    @Override
    public void insertMoney(VendingMachine vmc) {
        System.out.println("money already inserted");

    }

    @Override
    public void provideChangeMoney(VendingMachine vmc) {
        System.out.println("giving change money left after buying product");
      vmc.setState(new NoMoneyState());
    }

    @Override
    public void dispenseProduct(VendingMachine vmc) {
        System.out.println("please collect product");
        vmc.setState(new NoMoneyState());

    }
}
