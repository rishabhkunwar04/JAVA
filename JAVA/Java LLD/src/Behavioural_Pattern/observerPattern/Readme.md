* The Observer design pattern is a behavioral design pattern, used to create a one-to-many dependency between objects so that when one object (the subject) changes its state, all its dependents (observers) are notified and updated automatically. In this blog post, we will delve into the Observer design pattern, explore its components, and implement Stock Market Monitoring.

##### Components of the Observer Design Pattern
* Subject: The subject maintains a list of observers and notifies them of state changes.
* Observer: The observer interface defines the contract for concrete observer classes.
* ConcreteSubject: A class that implements the subject interface and manages the observers.
* ConcreteObserver: A class that implements the observer interface and receives notifications.

```java


// Observer Interface
public interface StockObserver {
    public void update(int price,String StockName);
}


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

//subject interface
public interface Stockmarket {
    public void notifyObservers(int Price,String Name);
    public void setStockPrice(int Price,String Name);
    public void addObserver(StockObserver observer);
    public void removeObserver(StockObserver observer);

}

public class StockMarketImpl  implements  Stockmarket{

    public List<StockObserver> observerList=new ArrayList<>();
    @Override
    public void notifyObservers(int Price, String Name) {
        for(StockObserver observer:observerList){
            observer.update(Price,Name);

        }

    }

    @Override
    public void addObserver(StockObserver observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(StockObserver observer) {
        observerList.remove(observer);

    }

    // Simulate stock price changes
    public void setStockPrice(int StockPrice,String stockName) {
        notifyObservers(StockPrice, stockName);
    }
}

public class Main {
    public static void main(String[] args) {
        Stockmarket stockMarket = new StockMarketImpl();

        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");

        stockMarket.addObserver(investor1);
        stockMarket.addObserver(investor2);
        stockMarket.setStockPrice(1250,"INFY"); // Both investors receive updates
        stockMarket.setStockPrice(2500,"TCS"); // Both investors receive updates

        stockMarket.removeObserver(investor1);

        stockMarket.setStockPrice(700,"WIPRO"); // Only investor2 receives the update
    }
}
```