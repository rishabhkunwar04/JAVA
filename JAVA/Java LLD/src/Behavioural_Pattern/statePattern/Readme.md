
```java

interface State {
    public void  insertMoney(VendingMachine vmc);
    public void  provideChangeMoney(VendingMachine vmc);
    public void dispenseProduct(VendingMachine vmc);
}
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
public class VendingMachine {
    private State currentState;
            public VendingMachine(){
                currentState = new NoMoneyState();

            }
            public void setState (State state){
                this.currentState=state;
            }
            public void insertMoney(){
                currentState.insertMoney(this);
            }
            public void provideChangeMoney(){
                currentState.provideChangeMoney(this);
            }
            public void dispenseProduct(){
                currentState.dispenseProduct(this);
            }
}
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

```