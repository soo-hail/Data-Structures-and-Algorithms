public class LongestCommonSubstring {
    
    // Q. FIND THE LENGTH OF LONGEST-COMMON-SUBSTRING AMONG GIVEN TWO STRINGS.

    public static int getLCS(String str1, String str2){

        int max = 0; //LONGEST COMMON SUBSTRING.
        
        // 1.CREATE TABLE
        int dp[][] = new int[str1.length()+1][str2.length()+1]; 

        // 2. ASSIGN MEANING
        // dp[i][j] ---> TO STORE LONGEST_COMMON_SUBSTRING WHEN ARE I-CHAR_IN_STRING-1 AND J-CHARACTERS_IN_STRING-2

        // 3. INITIALIZE
        // WHEN I = 0 (SIZE OF STR-1 IS ZERO) ---> THEN LCS CAN'T BE FORMED SO, DP[J][I] = 0
        // WHEN J = 0 (SIZE OF STR-2 IS ZERO) ---> THEN LCS CAN'T BE FORMED SO, DP[J][I] = 0

        // NOTE : IN JAVA ALL CELLS ARE AUTOMATICALLY INITIALIZED WITH ZERO.

        // 4. START SOLVING PROBLEM(BOTTOM-UP)
        for(int i=1; i<dp.length; i++){ // INDEX FOR STRING-1
            for(int j=1; j<dp[0].length; j++){ // INDEX FOR STRING-2

                if(str1.charAt(i-1) == str2.charAt(j-1)){ // NOTE : "I-1" AND "J-1" REPRESENTS INDEX OF CURRENT-CHARACTERS IN STR-1 AND STR-2 RESPECTIVELY.
                    // IF BOTH ARE SAME THEN CHECK FOR STRING SIZES "I-1" AND "J-1"
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // FOR LONGEST-SUBSTRING A DIAGONAL IS FORMED

                    max = Math.max(max, dp[i][j]); // STORE LONGEST-COMMON-SUBSTRING.
                }
                else{
                    // IF NOT EQUAL STORE 0 IN DP[I][J] ---> BECAUSE SUBSTRING IS CONTINIOUS-PART OF STRING.
                    dp[i][j] = 0; // TO BREAK CONTINIOUS COUNT.
                }
            }
        }

        return max;
    }
    public static void main(String[] args) {
        String str1 = "abcde"; String str2 = "abcze";

        System.out.println(getLCS(str1, str2));
    }
}
