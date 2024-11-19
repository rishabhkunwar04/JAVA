package Behavioural_Pattern.statePattern;

interface State {
    public void  insertMoney(VendingMachine vmc);
    public void  provideChangeMoney(VendingMachine vmc);
    public void dispenseProduct(VendingMachine vmc);
}
