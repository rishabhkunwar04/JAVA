package Behavioural_Pattern.observerPattern;

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
