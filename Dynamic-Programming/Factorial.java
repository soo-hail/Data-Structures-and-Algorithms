public class Factorial {

    // DYNAMIC-PROGRAMMING IS NOT APPLIED ON THIS-PROBLEM(I.E. FACTORIAL) BECAUSE IN THIS PROBLEM SUB-PROBLEMS WILL NOT OVERLAP 
    
    // TABULATION(NO USE!---> BECAUSE TIME AND SPACE COMPLEXITIES ARE SAME AS RECURTION).
    public static int fact(int n){
        // 1. CREATE TABLE
        int dp[] = new int[n+1];

        dp[0] = 1; // INITIALIZATION.

        // BOTTOM-UP
        for(int i=1; i<dp.length; i++){
            dp[i] = i * dp[i-1]; 
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
