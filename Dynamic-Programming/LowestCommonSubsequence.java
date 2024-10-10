public class LowestCommonSubsequence {
    // LONGEST COMMON ANCESTOR.
    // Q. FIND THE LENGTH OF LONGEST-COMMON-ANCESTOR BETWEEN TWO STRINGS.

    public static int getLCA(String str1, String str2, int n, int m){

        if(n == -1 || m == -1){ // IF ANY ONE STRING IS COMPLETLY TRAVERSED. THEN THERE IS NO CHANCE THERE WILL BE COMMON SUBSEQUENCE. 
            return 0;
        }

        int x=0; // ANSWER.
        if(str1.charAt(n) == str2.charAt(m)){ // IF LAST-CHARACTERS OF TWO STRINGS ARE SAME.
            x = 1 + getLCA(str1, str2, n-1, m-1); // INCLUDE COUNT-OF-CURRENT CHARACTER AND CALL FOR NEXT.
        }
        else{ // IF NOT SAME.
            // THERE WE WILL HAVE TWO OPTIONS.
            int y = getLCA(str1, str2, n-1, m); // IGNORE LAST-CHARACTER OF 1st STRING.
            int z = getLCA(str1, str2, n, m-1);  // IGNORE LAST-CHARATER OF 2nd STRING.

            x = Math.max(y, z); // LONGEST SUBSEQUENCE IS CONSIDERED
        }

        return x;
    }

    // MEMOIZATION
    public static int getLCA(String str1, String str2, int n, int m, int dp[][]){
        // NOTE : SINCE TWO PARAMETRS ARE CHANGING ---> WE USE 2D ARRAY.
        // DP[I][J] ---> REPRESENTS LONGEST-COMMON-SUBSEQUENCE WHEN THERE ARE I-CHARCTER_OF_1st_STRING AND J-CHARACTERS_OF_2nd_STRING. 

        if(n == -1 || m == -1){
            return 0;
        }

        if(dp[n][m] != 0){ // OPTIMIZATION STEP.
            return dp[n][m]; // IF SOLUTION IS ALREADY EXIST FOR SMALLER PPROBLEM. THEN DIRECTLY RETURN THE SOLUTION.
        }

        int x = 0;
        if(str1.charAt(n) == str2.charAt(m)){ // IF LAST CHARACTERS OF TWO STRINGS ARE SAME.
            x = 1 + getLCA(str1, str2, n-1, m-1, dp); // INCLUDE CURRENT-CHARACTER AND CALL FOR REMAINING STRING.
        }
        else{
            int y = getLCA(str1, str2, n-1, m, dp); // IGNORE LAST-CHARACTER OF STRING-1.
            int z = getLCA(str1, str2, n, m-1, dp); // IGNORE LAST-CHARACTER OF STRING-2.   
            x = Math.max(y, z);
        }

        return dp[n][m] = x;
    }

    // TABULATION.
    public static int getLCA(String str1, String str2){

        // 1.CREATE TABLE
        int dp[][] = new int[str1.length()+1][str2.length()+1]; 

        // 2. ASSIGN MEANING TO EVERY INDEX (OR) CELL OF TABLE.
        // DP[I][J] ---> LONGEST SUBSEQUENCE FOR I-CHARCTER_OF_1st_STRING AND J-CHARACTERS_OF_2nd_STRING.

        // 3. INITIALIZATION.
        // SIZE_OF_STRING-1 == 0 ---> NOT POSSIBLE TO GET A COMMON_SUBSEQUENCE ---> DP[0][ANYTHING] = 0
        //  SIZE_OF_STRING-2 == 0 ---> NOT POSSIBLE TO GET A COMMON_SUBSEQUENCE ---> DP[ANYTHING][0] = 0

        // WE DON'T NEED TO INITIALIZE WITH ZERO TO ANY CELL IN JAVA BUT IT IS BETTER TO INITIAZE FOR BETTER UNDERSTANDING.
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        // 4. START FILLING TABLE(SOLVING SMALL-PROBLEM TO BIG-PROBLEM) ---> BOTTOM-UP.
        // BOTTOM-UP ---> BECAUSE SMALL PROBLEMS ARE SOLVED FIRST.

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int x = 0;
                if(str1.charAt(i-1) == str2.charAt(j-1)){ // SAME
                    // NOTE : INDEX OF CURRENT-CHARACTER IN STRING IS "I-1" AND "J-1"
                    x = 1 + dp[i-1][j-1];
                }
                else{
                    x = Math.max(dp[i-1][j], dp[i][j-1]); // LONGEST-COMMON-SUBSEQUENCE IN 
                }

                dp[i][j] = x; // STORE LONGEST-COMMON-SUBSEQUENCE WHEN SIZE_OF_STRING-1 IS I AND SIZE_OF_STRING-2 IS J.
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args) {
        String str1 = "abcdge"; String str2 = "abedg";

        int x = getLCA(str1, str2, str1.length()-1, str2.length()-1);
        System.out.println(x);

        int dp[][] = new int[str1.length()][str2.length()];
        System.out.println(getLCA(str1, str2, str1.length()-1, str2.length()-1, dp));

        System.out.println(getLCA(str1, str2));
    }
}
