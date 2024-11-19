package Behavioural_Pattern.observerPattern;

// Create the ConcreteObserver class
public class Investor implements StockObserver {
    public String Name;
    public Investor(String Name){
        this.Name=Name;
    }
    @Override
    public void update(int price, String StockName) {
        System.out.println(Name+" updated price of: "+StockName+ "by :"+ price);

    }
}
