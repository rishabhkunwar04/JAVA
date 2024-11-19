package Behavioural_Pattern.statePattern;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney();
        vendingMachine.dispenseProduct();
        System.out.println("------------------");

        vendingMachine.insertMoney();
        vendingMachine.insertMoney();
        vendingMachine.provideChangeMoney();
        vendingMachine.dispenseProduct();

        System.out.println("------------------");

        vendingMachine.insertMoney();
        vendingMachine.dispenseProduct();
        vendingMachine.provideChangeMoney();


    }
}
