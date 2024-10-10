public class UnboundedKnapsack {
    // Q. SAME AS 0_1-KNAPSACK BUT ONE-ITEM CAN BE TAKEN MULTIPLE-TIMES(MORE THEN ONE TIME).

    public static int getProfit(int wt[], int val[], int w){
        // CREATE TABLE.
        int dp[][] = new int[wt.length+1][w+1];

        // ASSIGN MEANING TO EVERY-CELL.
        // DP[I][J] ---> MAX-PROFIT WITH "I-ITEMS" WITH "J-SPACE IN BAG".

        // INITIALIZE.
        // WHEN THERE ARE ZER0-ITEMS I.E. I=0 ---> MAX-PROFIT = 0
        // WHEN THERE IS ZERO(NO) SPACE IN BAG I.E. J = 0 ---> MAX-PROFIT = 0
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        // START FILLING TABLE(ACTUAL PROBLEM).
        for(int i=1; i<dp.length; i++){ // REPRESENTS ITEMS
            for(int j=1; j<dp[0].length; j++){ // REPRESENTS WEIGHT OF BAG(DIVIDED INTO SMALLER-PROBLEM)
                int ratio = j/wt[i-1];
                // 'I-1' REPRESENTS INDEX OF ITEM IN WT[] AND VAL[] ARRAY.

                int x=0; int y=0; // TO STORE TWO DIFFERENT PROFITS(INCLUDE & EXCLUDE)
                if(ratio > 0){ // VALID CONDITION.
                    int z = ratio * val[i-1]; // PROFIT CAUSED BY CURRENT-ITEM
                    int spoc = ratio * wt[i-1]; // SPACE OCCUPIED BY CURRENT-ITEM.
                    
                    x = z + dp[i-1][j- spoc]; // INCLUDE.
                }
                    y = dp[i-1][j]; // EXCLUDE.
                    
                    dp[i][j] = Math.max(x, y);
            }
        }// end forLoop.

        return dp[dp.length-1][dp[0].length-1];
    }

    // USING GREEDY APPROACH.
    public static int getProfit(int wt[], int val[], int w, int duplicate){
        int maxProfit = 0;


        return maxProfit;
    }

    public static void main(String[] args) {
        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int w = 7; // CAPACITY OF KNAPSACK.

        int ans = getProfit(wt, val, w);
        System.out.println(ans);
    }
}
