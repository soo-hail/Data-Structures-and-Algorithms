public class WildcardMatching {

    public static void printDp(boolean dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Q. FIND WHETHER A WILDCARD-PATTERN CAN BE MATCHED WITH STRING(TEXT). WILDCARD PATTERN INCLUDES "?" AND "*" CHARACTRES.
    // "?" ---> MATCHES ANY SINGLE CHARACTER
    // "*" ---> MATCHES ANY SEQUENCE-OF-CHARACTERS(INCLUDING EMPTY-SEQUENCE)

    // TABULATION.
    public static boolean isMatch(String text, String pattern){

        // 1.CREATE TABLE.
        boolean dp[][] = new boolean[text.length()+1][pattern.length()+1];

        // 2.ASSIGN MEANING
        // DP[I][J] ---> REPRESENTS IS_PATTERN_MATCHED(TRUE/FALSE) WHEN LENGTH OF TEXT AND PATTERN ARE "I AND J" RESPECTIVELY.

        // 3.INITIALIZE
        // WHEN "I=0 AND J=0" ---> PATTERN MATCHED(BOTH ARE EMPTY STRINGS)
        // WHHEN "I=0 AND J>0" ---> s = "xyz..." and p=" " ---> SO PATTERN CANNOT BE MATCHED. STORE, DP[I][J] = FALSE.
        // WHEN "I>0 AND J=0" ---> S = " " AND P="XYZ..." ---> IF LAST-CHARACTER OF P != "*" THEN STORE "FALSE"(EXCPET "*" NO OTHER CHARACTER CAN MATCH EMPTY-SEQUENCE)
          // IF DP[I][J] == "*"(LAST-CHARACTER IS "*") THEN CHECK FOR PATTERN SIZE "J-1", IF "J-1" CAN FORM EMPTY-SEQUENCE THEN DP[I][J] CAN FORM EMPTY-SEQUENCE(TRUE) ELSE "FALSE"  

        dp[0][0] = true;
        for(int i=1; i<dp.length; i++){ // J==0
            dp[i][0] = false; // CAN MATCH PATTERN  
        }

        for(int j=1; j<dp[0].length; j++){ // I==0
            if(pattern.charAt(j-1) == '*'){
                // "*" ---> CAN FORM EMPTY-SEQUENCE. BUT CHECK FOR PATTERN SIZE(J-1). IF "J-1" CAN FORM EMPTY SEQUENCE THRN "J-SIZE PATTERN CAN FROM EMPTY SEQUENCE".
                dp[0][j] = dp[0][j-1]; // J == '*'---> CAN FORM EMPTY-SEQUENCE. SO WE ARE CALLING FOR "J-1".
            }
            else{
                dp[0][j] = false;
            }
        }

        // 2. START FILLING TABLE IN BOTTOM-UP(START SOLVING PROBLEM).

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(pattern.charAt(j-1) == '*'){
                    // THERE ARE TWO CASES : 
                    // 1. IGNORE-"*" ---> S="ABB" P="ABB*" ---> THERE WE NEED TO IGNORE(TREAT "*" AS EMPTY STRING)

                    // 2. "*" CAN MATCH LAST-CHARACTER. SO CHECK FOR "I-1"(DONT DECREMENT "*" ---> S = "AAB" P = "A*" SO THAT * CAN COVER BOTH "A&B")
                    
                    Boolean X = dp[i][j-1]; // IGNORE-CASE.(S="AAB" P="ABB*" HERE WE NEED TO IGNORE-"*") 
                    Boolean Y = dp[i][j] = dp[i-1][j]; // CHECK FOR "I-1" (S="AAB" P="A*" ---> "*"-SHOULD COVER 2-CHARACTERS(A&B))
                    
                    dp[i][j] = X || Y; 
                }
                else if(pattern.charAt(j-1) == '?'){ // CAN MATCH ONLY ONE CHARACTER.
                    // CAN MATCH CURRENT-CHARACTER. BUT CHECK FOR LENGTHD "I-1 AND J-1"
                    dp[i][j] = dp[i-1][j-1];
                }
                else{ // SOME CHARACTER(ALPHABET).
                    if(text.charAt(i-1) == pattern.charAt(j-1)){
                        // IF LAST CHARACTERS OF "TEXT AND PATTERN" ARE SAME THEN CHECK FOR "I-1 AND J-1".
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }// end forLoop.

        // printDp(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    // MEMOIZATION
    public static boolean isMatch(String s, String p, int n, int m){

        // BASE-CASE
        if(n == 0 || m == 0){
            return true;
        }

        
        return true;
    }
    public static void main(String[] args) {
        String str = "aabc"; String pattern = "*b?*";

        System.out.println(isMatch(str, pattern));
    }
}
