public class TargetSumSubset {

    public static void printDP(boolean dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // RECURTION
    public static int getCount(int num[], int sum, int i){
        if(i == -1){ // BASE-CASE
            return 0;
        }

        if(sum - num[i] == 0){ // REQUIRED CONDITION.
            return 1;
        }

        int x=0; int y=0;
        if(num[i] <= sum){ // CHECK WHETHER CURRENT NUMBER FIT IN SUM.
            x = getCount(num, sum-num[i], i-1); // INCLUDE
        }

        y = getCount(num, sum, i-1); // EXCLUDE

        return x+y;
    }

    // TABULATION
    public static boolean getCount(int nums[], int target){
        // 1. CREATE A TABLE
        boolean dp[][] = new boolean[nums.length+1][target+1];

        // 2. ASSIGN MEANING TO EVERY INDEX/CELL OF TABLE.
        // ROW ---> COUNT OF NUMBERS.
        // COL ---> SUM(DIVIDED INTO SMALLER-PROBLEM).
        // CELL DP[I][J] ---> SUM OF I-ITEMS. 

        // 3. INITIALIZE
        for(int i=0; i<dp.length; i++){ // WHEN SUM = 0 ---> ANY SET CAN FORM SUBSET WHOSE SUM = 0.
            dp[i][0] = true;
        }

        for(int j=1; j<dp[0].length; j++){ // WHEN THERE ARE ZERO-ITEMS AND SUM>0. THEN WE CAN'T FORM A SET WHOSE SUM EQUALS TO "SUM"
            dp[0][j] = false;
        }

        // 4. START FILLING TABLE.
        boolean x = false; boolean y = false;
        for(int i=1; i<dp.length; i++){ // FOR ELEMENTS IN ARRAY.
            for(int j=1; j<dp[0].length; j++){ // FOR SUM(DIVIDED INTO SMALLER-PROBLEMS).
                if(nums[i-1] <= j){ // CAN INCLUDE.
                    // INCLUDE 
                    x = dp[i-1][j-nums[i-1]]; // DP[I-1][J-NUMS[I-1]] == REMAINING-REQUIRED-VALUE. IF IT CAN BE FORMED BY "I-1" ITEMS THEN SUB-SUM CAN BE ACHIVED.
                }
                y = dp[i-1][j]; // EXCLUDE.

                dp[i][j] = x || y; // EVEN ONE IS TRUE ---> USING "I-ITEMS" J-SUM CAN BE FORMED.
            }
        }
        // printDP(dp);
        return dp[dp.length-1][dp[0].length-1]; // COVERS ALL-ELEMENTS OF ARRAY AND COVERS WHOLE SUM.
    }
    public static void main(String[] args) {
        int numbers[] = {4,2,7,1,3};  
        int target = 10;

        int x = getCount(numbers, target, numbers.length-1);
        System.out.println(x); 

        boolean y = getCount(numbers, target);
        System.out.println(y);

        int dp[][] = new int[numbers.length+1][target+1];

        // int z = getCount(numbers, target, numbers.length-1, dp);
        // System.out.println(z);
    }
}