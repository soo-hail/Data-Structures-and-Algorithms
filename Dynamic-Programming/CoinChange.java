public class CoinChange {
    
    // Q. THERE ARE GIVEN SET OF COINS USING WHICH WE HAVE TO FIND IN NO. OF WAYS WE CAN MAKE A "SUM OF AMOUNT".

    // RECURTION.
    public static int getWays(int coins[], int sum, int indx){

        if(indx == 0){ // BASE-CASE.
            return sum%coins[indx] == 0? 1:0; // IF SUM%COINS[0] ---> CAN COINS AT INDEX ZERO FORM A CURRENT-SUM.
        }

        if(sum == 0){
            return 1;
        }

        int x=0; int y=0;
        if(coins[indx] <= sum){
            x = getWays(coins, sum-coins[indx], indx); // INCLUDE-CASE.
            // NOTE : 
            // DO NOT DECREMENT THE INDEX. BECAUSE WE CAN TAKE A ITEM "N-NO.OF TIMES"
        }
        
        y = getWays(coins, sum, indx-1); // EXCLUDE

        return x+y;
    }

    // MEMOIZATION.
    // dp[i][j] ---> TO STORE NO.OF WAYS WHEN THERE ARE I-ITEMS AND SUM == J.
    public static int getWays(int coins[], int sum, int indx, int dp[][]){

        // BASE CASES
        if(indx == 0){
            return sum%coins[0]==0? 1:0;
        }

        if(sum == 0){
            return 1;
        }

        if(dp[indx][sum] != 0){ // OPTIMIZATION-STEP.
            return 1;
        }

        int x=0; int y=0;
        if(coins[indx] <= sum){ // VALID
            x = getWays(coins, sum-coins[indx], indx, dp); // INCLUDE
            // DO NOT DECREMENT INDEX. BECAUSE WE CAN USE SAME COIN(ITEM) N-NO. OF TIMES.
        }

        y = getWays(coins, sum, indx-1, dp); // EXCLUDE AND SEARCH IN INDEX-1 ITEMS.

        return dp[indx][sum] = x+y; // STROING SOLUTION FOR SMALL PROBLEM.
    }

    // TABULATION
    public static int getWays(int coins[], int sum){
        // 1. CREATE A TABLE
        int dp[][] = new int[coins.length+1][sum+1];

        // 2. EACH CELL I.E. DP[I][I] ---> REPRESENTS HOW WAYS "J-SUM" CAN BE FORMED USING "I-ITEMS".

        // 3. INITIALIZE
        // SUM == 0 ---> 1-WAY.
        for(int row=0; row<dp.length; row++){
            dp[row][0] = 1;
        }

        // 4. START FILLING TABLE(START SOLVING-TABLE)
        for(int i=1; i<dp.length; i++){ // I-REPRESENTS ---> ITEMS
            for(int j=1; j<dp[0].length; j++){ // J-REPRESENTS ---> SUM(DIVIDED INTO SMALLER PARTS) 
                int ratio = j/coins[i-1]; 
                int ways = 0;
                while(ratio >= 0){
                    int rem = j - (ratio*coins[i-1]);
                    ways = ways + dp[i-1][rem];
                    ratio--;
                }

                dp[i][j] = ways;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int coins[] = {5,1,2,3};
        int sum = 4;

        int x = getWays(coins, sum, coins.length-1);
        System.out.println(x);

        int dp[][] = new int[coins.length][sum+1];
        int y = getWays(coins, sum, coins.length-1, dp);

    }
}
