public class BuySellStocks {

    public static int getProfit(int stockPrice[]){
        int maxProfit = 0; 

        int bPrice = stockPrice[0]; //BUYING PRICE. NOTE : FIRST DAY YOU CAN ONLY BUY STOCK.
        for(int i=1;i<stockPrice.length;i++){ //FROM 2ND DAY WE CAN SELL STOCKS.
            int sPrice = stockPrice[i]; //SELLING PRICE.
            
            if(stockPrice[i] < bPrice){ //IF STOCKPRICE < BUYING-PRICE THEN BEST TIME TO BUY A STOCK 
                bPrice = stockPrice[i];
            }
            else{ //IF STOCKPRICE > BUYING-PRICE THEN CALCULATE PROFITE OF THE DAY AND MAX-PROFITE.
                int profit =sPrice - bPrice; //TODAY'S PROFITE.
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
    
    public static void main(String[] args) {
        int price[] = {7,1,5,3,6,4};
        
        System.out.println(getProfit(price));
    }
}
