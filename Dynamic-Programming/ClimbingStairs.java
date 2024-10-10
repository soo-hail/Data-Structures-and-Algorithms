import java.util.Arrays;
public class ClimbingStairs {
    
    // 1. RECURTION.
    public static int getWays(int stairs, int n){
        if(n > stairs){
            return 0;
        }

        if(n == stairs){ // REACHED LAST STAIR. 
            return 1;
        }

        return getWays(stairs, n+1) + getWays(stairs, n+2);
    }

    // 2. MEMOIZATIONS.
    public static int getWays(int stairs, int n, int dp[]){
        
        if(stairs == n){ // REACHED LAST STAIR.
            return 1;
        }

        if(n > stairs){ // INVALID CONDITION.
            return 0;
        }

        if(dp[n] != -1){ // WAYS OF PERTICULAR STAIR IS ALREADY FOUND.   
            return dp[n]; 
        }

        return dp[n] = getWays(stairs, n+1, dp) + getWays(stairs, n+2, dp); // STORE AND RETURNS POSSIBLE WAYS OF CLIMBING PERTICULAR STAIR. 
        
    }

    // TABULATION.
    public static int getWays(int stairs){
        // CREATE A TABLE.
        int dp[] = new int[stairs + 1];

        // INITIALIZATION.
        return 1;
    }
    public static void main(String[] args) {
        int stairs = 5;
        int dp[] = new int[stairs]; 
        Arrays.fill(dp, -1);
        // System.out.println(getWays(stairs, 0));
        System.out.println(getWays(stairs, 0, dp));
    }
}
