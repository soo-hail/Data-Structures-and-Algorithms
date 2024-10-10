public class CatalanNumber {
    
    // CATALAN-NUMBER IS LIKE FEBONACII-NUMBER.
    // WHERE, C(0) = 1, C(1) = 1 AND C(2) = C(0)*C(1)+C(1)*C(0)

    // GENERAL-FORMULA
    // C(N) = C(0)*C(N-1) + C(1)*C(N-2) + C(2)*C(N-3)....C(N-1)*C(0)

    // MEMOIZATION : 1D-ARRAY IS USED SINCE THE VARIABLE PARAMETER IS ONLY ONE.
    public static long getCatalanNum(int n, long dp[]){

        // BASE-CASE.
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != 0){ // OPTIMIZATION-STEP.
            return dp[n]; 
        }

        long catNum = 0;
        for(int i=0; i<n; i++){
            catNum = catNum + getCatalanNum(i, dp) * getCatalanNum(n-(i+1), dp);
            // HERE RECURION PLAYS VERY IMPORTANT-ROLE.
            // FOR C(N-1) AT FIRST-ITERATION. IT WILL CALCULATE ALL CATALAN-NUMBERS SO WE STORE THAT ANSWER IN "DP".
        }

        return dp[n] = catNum; // STORE VALUE IN DP(TABLE)
    }

    // TABULATION
    public static int getCatalanNum(int n){

        // 1. CREATE TABLE
        int dp[] = new int[n+1]; // SINCE THERE IS ONLY ONE-PARAMETER IS VARIABLE.

        // 2. ASSIGN MEANING.
        // DP[I] ---> REPRESENTS CATALAN-NUMBER OF "I"

        // 3. INITIALIZE 
        // WE KNOW C(0)=1 AND C(1)=1
        dp[0] = dp[1] = 1;


        // 4. START SOLVING PROBLEM(BOTTOM-UP---> SMALL TO LARGE PROBLEM)
        // GENARAL-FORMULA : C(N) = C(0)*C(N-1) + C(1)*C(N-2) + C(2)*C(N-3)....C(N-1)*C(0) 
        for(int i=2; i<=n ; i++){ // TO SOLVE FOR "N" FIRT WE NEED TO SOLVE FOR SMALLER PROBLEMS
            int catNum = 0;
            for(int j=0; j<i; j++){ // FOR EVERY "I" WE NEED TO FIND CATALAN-NUMBER FROM C(0) TP C(I-1).
                catNum = catNum + dp[j]*dp[i-(j+1)];
            }
            dp[i] = catNum;
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 4;

        long dp[] = new long[n+1]; // SINCE VARIABLE-PARAMETER IS ONLY ONE(I.E. "N")
        System.out.println(getCatalanNum(n, dp));

        System.out.println(getCatalanNum(n)); // TABULATION
    }
}
