package Behavioural_Pattern.statePattern;

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
