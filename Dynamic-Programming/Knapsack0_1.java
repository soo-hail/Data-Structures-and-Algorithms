public class Knapsack0_1 {
    // SOLUTION USING RECURTION. T(n) = 2^n, where n = no. of items
    public static int getProfit(int profit[], int wt[], int w, int i){

        int x = 0, y = 0;
        if(w==0 || i == -1){ // base-case.
            return 0;
        }

        // if the weight of current item is "<=" remaining space in bag. then only we can include that item.
        if(wt[i] <= w){ // item-weight <= remaining-space in bag.
            x = profit[i] + getProfit(profit, wt, w-wt[i], i-1); // include.
            y = getProfit(profit, wt, w, i-1); // exclude.
        }
        else{ // remaining space in bag is less than weight of current item. 
            y = getProfit(profit, wt, w, i-1); // exclude and go for next item.
        }

        return Math.max(x, y);
       
    }

    // MEMOIZATION : T(n) = n*w.  
    // RECURSIVE FUNCTION HAS 4 PARAMETERS IN WHICH 2 ARE VARIABLE SO WE USE A 2D-ARRAY.
    // ROW ---> NO. OF ITEMS + 1
    // COL ---> CAPACITY-OF-BAG(W) + 1
    // DP[ROW][COL] ----> MAX_PROFIT WHEN THERE ARE "ROW-REMNAINING-ITEMS" AND "COL-REMAINING-SPACE-IN-BAG". 
    public static int getProfit(int wt[], int val[], int w, int i, int dp[][]){

        if(w<=0 || i==-1){
            return 0;
        }
        int x = 0;
        int y = 0;

        // OPTIMIZATION STEP.
        if(dp[i][w] != -1){
            return dp[i][w]; // THE MAXIMUM PROFIT WHEN THERE ARE "I-REMAINING-ITEMS" AND "W-REMAINING-SPACE".
        }

        if(wt[i] <= w){
            x = val[i] + getProfit(wt, val, w-wt[i], i-1, dp); // INCLUDE(ONLY WHEN THE ITEM CAN FIX IN BAG)
        }

        // IF ITEM CAN'T FIT IN BAG THEN DIRECTLY EXCLUDE THAT ITEM.
        y = getProfit(wt, val, w, i-1, dp); // EXCLUDE.

        return dp[i][w] = Math.max(x, y);
    }

    public static void printMatrix(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    // TABULATION
    public static int getProfit(int wt[], int val[], int w){
        // 1. CREATE TABLE
        int dp[][] = new int[wt.length+1][w+1];

        // 2. ASSIGN MEANING TO VERY INDEX/CELL OF THE TABLE.
        // ROW ---> COUNT OF ITEMS(NO. OF ITEMS)
        // COL ---> WEIGHT OF THE BAG(DIVIDED INTO SMALLER PROBLEM)
        // EACH CELL(DP[I][J]) ---> REPRESENTS THE MAX-PROFIT WHEN THERE ARE "I-ITEMS" AND "J-SPACE IN BAG" 

        // 3. INITIALIZE THE TABLE(BASE CONDITION IN RECURTION).
        // DP[I][J], WHEN ITEMS(I) == 0 ---> PROFIT = 0
                    // WEIGHT_OF_BAG(J) == 0 ---> PROFIT = 0

        for(int row = 0; row < dp.length; row++){
            dp[row][0] = 0;
        }

        for(int col = 0; col<dp[0].length; col++){
            dp[0][col] = 0;
        }

        // 4. START FILLING TABLE.

        for(int i=1; i<dp.length; i++){ // FOR ITEMS.
            for(int j=1; j<dp[0].length; j++){ // FOR WEIGHT OF BAG(DIVIDED INTO SMALLER)

                int x = 0; int y = 0;
                if(wt[i-1] <= j){
                    // "I-1" ---> REPRESENTS CURRENT-ITEM IN WT[] AND VAL[] ARRAYS. 
                    x = val[i-1] + dp[i-1][j-wt[i-1]]; // INCLUDE.
                        //  VAL(CURRENT-ITEM) + MAX-PROFIT IN "I-1 ITEMS" AND REMANING-SPACE AFTER TAKING CURRENT-ITEM. 
                }

                y = dp[i-1][j]; // EXCLUDE.

                dp[i][j] = Math.max(x, y); // STORE MAX-PROFET WHEN THERE ARE "I-ITEMS" AND "J-SPACE IN BAG"
            }
        }// end forLoop

        // printMatrix(dp);
        return dp[dp.length-1][dp[0].length-1];

    }



    public static void main(String[] args) {
        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int w = 7; // CAPACITY OF KNAPSACK.

        int dp[][] = new int[wt.length+1][w+1];
        
        // INITIALIZE 2D-ARRAY WITH "-1".
        for(int row=0; row<dp.length; row++){
            for(int col=0; col<dp[row].length; col++){
                dp[row][col] = -1;
            }
        }

        int p = getProfit(val, wt, w, wt.length-1);
        System.out.println(p);

        int profit = getProfit(wt, val, w, val.length-1, dp);
        System.out.println(profit);

        int x = getProfit(wt, val, w);
        System.out.println(x);

    }

}
