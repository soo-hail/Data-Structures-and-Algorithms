// FAV-PROBLEM.
public class EditDistance {

    // MEMOIZATION 
    public static int getOpr(String s1, String s2, int n, int m, int dp[][]){

        // BASE CASE
        if(n == -1){
            return m+1; // "M+1(SIZE OF REMANING CHARACTERS IN STR2)"-CHARACTERS NEEDED TO ADDED IN STR1.---> SO, MINIMUM OPERATIONS TO ADDED "M+1" CHARACTERS IS "M+1".
        }

        if(m == -1){
            return n+1; // "N+1(SIZE OF REMAINING CHARACTERS IN STR1)"-CHARACTERS ARE NEEDED TO REMOVE FROM STR1. ---> SO, MINIMUM OPERATIONS TO REMOVE "N+1" CHARACTERS IS "N+1".
        }

        if(s1.charAt(n) == s2.charAt(m)){ // SAME
            // NO NEED TO PERFORM ANY OPERATION.
            return dp[n][m] = getOpr(s1, s2, n-1, m-1, dp); // CALL FOR SMALLER PROBLEM.
        }
        else{ // IF TWO CHARACTER OF TWO STRINGS ARE NOT EQUAL.
            // THERE ARE 3 CHOICES.

            // 1. ADD() : WE ASSUM THAT WE ARE ADDING S2[M] AT S1[N](S1[N] == S2[M])
            int add = 1 + getOpr(s1, s2, n, m-1, dp); // NOW CALL FOR "N" AND "M-1"(BECAUSE WE ADDED(ASSUM) A NEW CHAR TO STR-1 SO NO NEED TO DECREMENT-"N")
            // NOTE : 1+ ---> REPRESENTS INCLUUSING CURRENT-OPERATION.

            // 2. DELECT : WE ASSUM THAT WE ARE DELECTING S1[N].
            int del = 1 +  getOpr(s1, s2, n-1, m, dp); // "N-1" ---> REPRESENTS WE DELECTED S1[N]. 

            // 3. REPLACE : WE ASSUM THAT WE ARE REPLACING S1[N] WITH S2[M]
            int rep = 1 + getOpr(s1, s2, n-1, m-1, dp); 

            return Math.min(Math.min(add, del), rep); // STORE AND RETURN MIN-NO. OF OPERATION REQUIRED TO SOLVE SOLVE SMALLER-PROBLEM(CURR-N,M)

        }
    }

    // TABULATION
    public static int getOpr(String s1, String s2){

        // 1. CREATE TABLE
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        // 2. ASSIGN MEANING.
        // dp[i][j] ---> MIN-NUMBER OF OPERATIONS NEED TO PERFORM SO THAT S1_OF_LENGTH = "I" CAN BE CONVERTED INTO S2_OF_LENGTH = "J" 

        // 3. INITIALIZATION.
        // WHEN I == 0 AND J ==0 ---> S1 == " " AND S2 == " ". HERE ZERO OPERATINS ARE REQUIRED.
        // WHEN I==0 AND J==1+ ---> S1 == " " AND S2 == "XYZ....". HERE TO CONVERT S1 INTO S2 WE NEED MINIMUM SIZE_OF_S2-OPERATIONS I.E ADD "XYZ..." IN "S1"
        //  WHEN I==1 AND J==0 ---> S1 == "xyz..." AND S2 == " ". HERE TO CONVERT S1 INTO S2 WE NEED MINIMUM SIZE_OF_S2-OPERATIONS I.E  REMOVE "XYZ..." FROM "S1"

        dp[0][0] = 0; // OPTIONAL BECAUSE IN JAVA ZERO IS STORED BY DEFAULT.
        for(int j=1; j<dp[0].length; j++){ // I==0
            dp[0][j] = j; 
        }

        for(int i=1; i<dp.length; i++){ // J==0
            dp[i][0] = i;
        }

        // 4. START SOLVING IN BOTTOM-UP(SMALL TO LARGE PROBLEM)
        for(int i=1; i<dp.length; i++){ // TO TRAVERSE "S1"
            for(int j=1; j<dp[0].length; j++){ // TO TRAVERSE "S2"
                if(s1.charAt(i-1) == s2.charAt(j-1)){ // IF BOTH CHARACTERS ARE SAME
                    // NO OPERATION IS NEEDED TO PERFORM.
                    dp[i][j] = dp[i-1][j-1]; // STORE NO. OF OPERATIONS ARE NEEDED FOR "I-1 AND J-1"
                }
                else{
                    // WE HAVE 3-OPTIONS == "3-OPERATIONS".
                    // ADD, DELECT, REPLACE.
                    int add = 1 + dp[i][j-1]; // ADD 
                    int del = 1 + dp[i-1][j]; // DELECT
                    int rep = 1 + dp[i-1][j-1];// REPLACE

                    dp[i][j] = Math.min(Math.min(add, del), rep); // STORE MIN-NO. OF OPERATION REQUIRED TO SOLVE SOLVE SMALLER-PROBLEM(CURR-N,M)
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1]; // FOR WHOLE-PROBLEM.
    }
    public static void main(String[] args) {
        String str1 = "intention"; String str2 = "execution";

        int dp[][] = new int[str1.length()][str2.length()];

        System.out.println(getOpr(str1, str2, str1.length()-1, str2.length()-1, dp));
        System.out.println(getOpr(str1, str2)); // TABULATION
    }
}
