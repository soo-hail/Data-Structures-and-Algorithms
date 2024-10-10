import java.util.Arrays;
public class ClimbingStairsVariation {
    // FIND NUMBER OF WAYS. THE PERSON CAN CLIMB 1 OR 2 OR 3 STARIRS AT A TIME.

    public static int getWays(int stairs, int n, int dp[]){
        if(n == stairs){ // REACHED 'N'th STAIR.
            return 1;
        }

        if(n > stairs){ // CASE HANDLING.
            return 0;
        }

        // DP LOGIC.
        if(dp[n] != -1){ // ALREADY CALCULATED.
            return dp[n];
        }

        // FIND AND STORE RESULT IN ARRAY.
        dp[n] = getWays(stairs, n+1, dp) + getWays(stairs, n+2, dp) + getWays(stairs, n+3, dp);
        return dp[n];

    }
    public static void main(String[] args) {
        int stairs = 4;
        int dp[] = new int[stairs+1];
        Arrays.fill(dp, -1);
        System.out.println(getWays(stairs, 0, dp));
    }
}
