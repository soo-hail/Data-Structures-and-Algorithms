import java.util.Stack;
public class StockSpanProblem {

    // STOCK-SPAN : NO.OF DAYS STOCK-PRICE(PRESENT)>=PREVIOUS STOCK-PRICES{INCLUDING TODAY}.
    public static void main(String[] args) {
        int stocks[] = {100,80,60,75,80,85,100};    

        int span[] = new int[stocks.length]; // TO STORE SPAN OF ALL STOCKS.
        // WE USE "STACK" TO STORE INDEX OF HIGHTEST-STOCK PRICES FOR NEXT STOCKS.   

        Stack<Integer> index = new Stack<>();

        // GO TO EVERY STOCK AND FIND SPAND OF IT.
        // FOR FIRST STACK.
        span[0] = 1; // INCLUDING TODAY.
        index.push(0); // PUSH INDEX 0 IN STACK FOR NEXT-STOCKS.
        for(int i=1;i<stocks.length;i++){
            while(!(index.isEmpty()) && stocks[i]>=stocks[index.peek()]){ // REMOVE ALL STOCKS WHICH ARE SMALLER THAN CURRENT-STOCK FROM STACK(INDEX). 
                index.pop();
            }

            if(index.isEmpty()){
                span[i] = i+1; // STOCK IS GREATER THAN ALL THE STOCKS.
                continue; 
            }

            span[i] = i - index.peek(); // SPAN = CURR-STOCK-INDEX - LAST-HIGHEST-STOCK-INDEX
            index.push(i); // FOR NEXT-STOCKS.
            
            // NOTE : 
            // ADVANTAGE OF USING STOCKS IS ALL SMALLER STOCKS BETWEEN TWO LARGE STOCK ARE GETTING REMOVED.

        }

          // PRINT SPAN   
            for(int x : span){
                System.out.print(x + " ");
            }

            System.out.println();
    }
}
