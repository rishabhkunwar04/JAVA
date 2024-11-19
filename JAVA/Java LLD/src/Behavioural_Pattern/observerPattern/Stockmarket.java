package Behavioural_Pattern.observerPattern;


//subject interface
public interface Stockmarket {
    public void notifyObservers(int Price,String Name);
    public void setStockPrice(int Price,String Name);
    public void addObserver(StockObserver observer);
    public void removeObserver(StockObserver observer);

}
