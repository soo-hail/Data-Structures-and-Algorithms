public class RodCutting {    
    // MEMOIZATION : 
    // dp[i][j] ---> REPRESENTS MAX-PROFIT WITH "I-SIZES" FOR  "J-ROD_LENGTH"  
    public static int getProfit(int len[], int price[], int rodLen, int indx, int dp[][]){

        // BASE-CASE.
        if(rodLen == 0 || indx == -1){
            return 0; 
        }

        if(dp[indx][rodLen] != 0){ // OPTIMIZATION-STEP : IF MAX-PROFIT IS ALREADY CALCULATED FOR SMALLER-PROBLEM.
            return dp[indx][rodLen];
        }

        int x = 0; int y=0;
        if(len[indx] <= rodLen){
            x = price[indx] + getProfit(len, price, rodLen-len[indx], indx, dp); // INCLUDE.
            // NOTE : DO NOT DECREMENT THE INDEX. BECAUSE A ROD ANY BE COT IN SAME SIZE IN N-TIMES.
        } 

         y = getProfit(len, price, rodLen, indx-1, dp); // EXCLUDE.

        return dp[indx][rodLen] = Math.max(x, y); // COMPARITION.
    }

    // TABULATION : 
    // dp[i][j] ---> REPRESENTS MAX-PROFIT WITH "I-SIZES" FOR  "J-ROD_LENGTH".
    public static int getProfit(int lenght[], int price[], int rodLen){

        // 1.CFREATE TABLE.
        int dp[][] = new int[price.length+1][rodLen+1];

        // 2.ASSIGN MEANING.
        // DP[I][J] ---> REPRESENTS MAX-PROFIT WITH "I-SIZES" FOR  "J-ROD_LENGTH".
        
        // 3.INITIALIZATION.
        // ROD-LENGHT == 0 ---> MAX-PROFIT = 0 
        // ITEM == 0(NO.ITEMS) ---> MAX-PROFIT = 0
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        // 4.START FILLING THE TABLE(START SOLVING SMALL-PROBLEMS TO LARGE-PROBLEM).
        for(int i=1; i<dp.length; i++){ // FOR ITEM(SIZE)
            for(int j=1; j<dp[0].length; j++){ // FOR ROD-LENGHT(DIVIDED INTO SMALLER)

                int x=0; int y=0;

                // NOTE : INDEX OF CURR-ITEM IN PRICE[] AND LENGTH[] IS "I-1". 
                if(lenght[i-1]<=j){ // VALID
                    x = price[i-1] + dp[i][j-lenght[i-1]]; // INCLUDE.
                      // MY-PRICE + MAX-PRICE WITH I-ITEMS(INCLUDING CURRENT-ITEM) OF J-LEN[I-1](REMANING) SIZE. 
                }

                y = dp[i-1][j]; // EXCLUDE.

                dp[i][j] = Math.max(x, y); // STORE MAX-PROFIT.
            }
        }// end forLoop.

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLen = 8;

        int dp[][] = new int[price.length][rodLen+1];

        System.out.println(getProfit(length, price, rodLen, price.length-1, dp));
        System.out.println(getProfit(length, price, rodLen));
    }
}
