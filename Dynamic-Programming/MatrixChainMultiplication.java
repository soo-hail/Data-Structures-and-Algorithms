import java.util.Arrays;

public class MatrixChainMultiplication {

    // MEMOIZATION.
    public static int getMinCost(int array[], int i, int j, int dp[][]){
        // I == START-MATRIX
        // J == LAST-MATRIX 

        // NOTE : SIZE OF ANY-MATRIX(Ith) WILL BE "array[i-1] X array[i]"
        // MATRIX COUNT WILL START FROM 1 TO "N-1" 

        if(i == j){ // SINGLE-MATRIX LEFT(DON'T NEED TO MULTIPLY)
            return 0; // SO, NO. OF OPERATIONS WILL BE "ZERO"
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE; // TO STORE MIN-COST(MIN NO.OF OPERATIONS FOR MULTIPLE CURRRENT-"I TO J"-MATRICES)
        for(int k=i; k<j; k++){ // TO PARTITION MATRICES
            // "K" SHOULD BE LESS THAN "J". BECAUSE "K+1" SHOULD NOT CROSS "J"

            int leftSide = getMinCost(array, i, k, dp); // RETURNS MIN-OPERATION REQUIRED TO MULTIPLE MATRICES FROM "I TO k". 
            int rightSide = getMinCost(array, k+1, j, dp); // RETURNS MIN-OPERATION REQUIRED TO MULTIPLE MATRICES FROM "k+1 TO J".
            // SMALLEST PROBLEM WILL BE MULTIPLING 2 MATRICES.

            // NOW, CALCULATE THE NO. OF OPERATIONS REQUIRED WHEN WE MULTIPLY RESULTENT MATRIX OF LEFT-SIDE AND RIGHT-SIDE. 
            // NOTE : SIZE OF RESULTENT-MATRIX WHEN WE ARE MULTIPING 2 OR MORE WILL BE (ROW_OF_1ST_MATRIX X COL_OF_LAST_MATRIX)  
            // R1 = array[i-1] X array[k];// SIZE OF RESULTENT MATRIX OF LEFT-SIDE. 
            // R2 = array[k](k+1-1) X array[k+1] // SIZE OF RESULTENT MATRIX OF RIGHT-SIDE.

            int x = array[i-1] * array[k] * array[j]; // TO CALCULATE NO.OF OPERATIONS FOR MULTIPLYING "I TO J" MATRICES. 

            int total = leftSide + rightSide + x; // TOTAL NUMBER OF OPERATIONS.
             
            minCost = Math.min(minCost, total); // FROM DIFFERNT COMBINATIONS.MIN-COST IS STORE FOR THIS PERTICULAR RANGE OF MATRICES.
        }

        return dp[i][j] = minCost;
    }

    // TABULATION
    public static int getMinCost(int array[]){

        // 1. CREATE TABLE
        int dp[][] = new int[array.length][array.length];

        // 2. ASSIGN MEANING
        // dp[i][j] ---> STORES MIN-COST(MIN-OPERATIONS) FOR MULTIPLING MATRICES OF RANGE "I TO J".

        // 3.INITIALIZATION
        // WHEN I == J(SINGLE-MATRIX CASE) ---> DP[I][J] = 0(ZERO OPERATIONS) BECAUSE WE DON'T NEED TO MULTIPLY SAME MATRIX.
        for(int i=1; i<array.length; i++){
            dp[i][i] = 0;
        }

        // START-SOLVING-PROBLEM(BOTTOM-UP)
        for(int len=2; len<array.length; len++){ // SOLVE FOR ALL LENGTHS(SMALLER-PROBLEM) ---> SMALLEST-PROBLEM(SIZE) = 2 AND LARGEST-PROBLEM(SIZE) = "ARRAY.LENGTH-1"
            for(int row = 1; row<=array.length - len; row++){
                // COL = ROW+LEN-1(LOGICALLY)
                int col = row+len-1;
                // LENGTH OF ANY MATRIX(I) FROM ARRAY IS array[I-1] X array[I]  

                int minCost = Integer.MAX_VALUE; // TO STORE MIN-COST FOR CURENT-CELL(SMALL-PROBLEM) 
                for(int k=row; k<col; k++){ // TO PARTITION MATRICES.
                    int leftCost = dp[row][k]; // MIN-COST FOR MULTIPLING LEFT-SIDE OF PARTITION.
                    int rightSide = dp[k+1][col]; // MIN-COST FOR MULTIPLYING RIGHT-SIDE OF PARTITION.

                    // SIZE-OF-LEFT MATRIX = array[row-1] X array[k] ("COLUMNS OF FIRST-MATRIX AND ROWS OF SECOND-MATRIX")
                    // SIZE-OF-RIGHT MATRIX = array[k] X array[col]
                    int x = array[row-1] * array[k] * array[col]; // TO CALCULATE NO. OF OPERTATIONS FOR MULTIPLING MATRICES OF LEFT AND RIGHT SIDE.

                    int finalCost = leftCost + rightSide + x;
                    minCost = Math.min(minCost, finalCost);
                }// end forLoop

                dp[row][col] = minCost;
            }
        }

        return dp[1][array.length-1];
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,3}; // ARRAY REPRESENTS THE SIZE OF "N-1" MATRICES.

        int dp[][] = new int[array.length][array.length]; // TO STORE "N-1" MATRICES MIN-COST FOR MULTIPLYING
        // DP[I][J] ---> STORES THE MIN-COST(OPERTATION) TO MULTIPLY "I TO J" RANGE OF MATRICES.

        // INITIALIZE DP(TABLE) WITH "-1"
        for(int row=0; row<array.length; row++){
            Arrays.fill(dp[row], -1); // TO INITIALIZE A ARRAY WITH SINGLE-VALUE.
        }

        System.out.println(getMinCost(array, 1, array.length-1, dp));
        System.out.println(getMinCost(array));
    }    
}