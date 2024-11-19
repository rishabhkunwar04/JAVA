package Behavioural_Pattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

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
