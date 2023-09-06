public class Stock{
    String symbol = "";
    String name = "";
    double previousClosingPrice = 0.00;
    double currentPrice = 0.00;
    Stock(String symbolIn, String nameIn, double previousClosingPriceIn, double currentPriceIn){
        symbol = symbolIn;
        name = nameIn;
        previousClosingPrice = previousClosingPriceIn;
        currentPrice = currentPriceIn;
    }
    //returns the change percentage of the stock in a day
    double getChangePercent(){
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}