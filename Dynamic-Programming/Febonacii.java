public class Febonacii {
    public static long febo(int n, long array[]){
        // BASE CASE.
        if(n == 0 || n == 1){
            return n;
        }

        if(array[n] != 0){ // FEBO(n) IS ALREADY CALCULATED.
            return array[n]; // RETURN ALREADY CALCULATED VALUE.
        }
        // IF BEBONACII IS NOT ALREADY CALCULATED.
        array[n] = febo(n-1, array) + febo(n-2, array); // STORING FEBONACII OF 'n'.
        return array[n]; 
    }

    // DYNAMIC PROGRAMMING USING TABULATION.
    public static int febo(int n){ 
        // CREATE TABLE.
        int dp[] = new int[n+1];

        // INITIALIZATION (BASE-CASE IN RECURTION).
        dp[0]=0; dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1]; // SOLVING SUB-PROBLEMS FIRST.
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        long array[] = new long[n+1]; // TO STORE VALUES OF RECURSIVE FUNCTIONS.
        System.out.println(febo(n, array));
        System.out.println(febo(n));

    }    
}