public class MinArrayJumps {
    
    // Q. GIVEN AN ARRAY(WHERE MAX-NO. OF JUMPS IS STORED). SO WE HAVE TO FIND MINMUM NUMBER OF JUMPES TO REACH "N-1 INDEX" FROM INDEX-0 USING VALUES STORED IN ARRAY.
    
    public static int getMinJumps(int array[], int indx, int dp[]){

        // NOTE : DP[I] REPRESENTS MIN-JUMPS REQUIRED TO REACH "N-1 INDEX" FROM CURRENT INDEX "I"

        // BASE-CASE
        if(indx >= array.length-1){
            return 0;
        }


        if(dp[indx] != 0){ // OPTIMIZATION STEP
            return dp[indx];
        }

        int minJumps = Integer.MAX_VALUE; // TO STORE MINIMUM JUMPS.
        for(int i=1; i<=array[indx]; i++){
            // WE HAVE "1 TO ARRAY[INDEX]" CHOICES TO JUMP FROM CURRENT-INDEX 
            int x = 1 + getMinJumps(array, indx+i, dp); // INCLUDE MY JUMPS AND CALL FOR OTHER
            minJumps = Math.min(x, minJumps);
        }
        
        return dp[indx] = minJumps;
    }

    // TABULATION
    public static int getMinDiff(int array[]){

        // 1. CREATE TABLE
        int dp[] = new int[array.length];

        // 2. ASSIGN MEANING
        // DP[I] ---> MIN-JUMPS TO REACH "N-1" INDEX OF ARRAY FROM "CURRENT-INDEX(I)"

        // 3. INITIALIZATION 
        dp[array.length-1] = 0;

        // 4. SLOVE PROBLEM FROM SMALL-PROBLEM TO LARGE-PROBLEM(BOTTOM-UP)
        for(int i=array.length-2; i>=0; i--){ // FROM SMALL-PROBLEM TO LARGE-PROBLEM

            int minJump = Integer.MAX_VALUE;
            for(int j=1; j<=array[i]; j++){ // AT EVERY INDEX THERE ARE ARRAY[INDEX] CHOICES.
                if((i+j) > array.length-1){ // INVALID-STEP
                    break; 
                }

                int x = 1 + dp[i+j]; // (i+j)<array.length-1? dp[i+j] : dp[array.length-1]; // MY_JUMP + MIN-JUMP FROM REMAING INDICES.
                
                minJump = Math.min(x, minJump); // STORE MIN-JUMPS TO REACH FROM "CURRENT-INDEX(I)"
            }

            dp[i] = minJump;
        }

        return dp[0]; // SINCE WE NEED TO START FROM INDEX-ZERO
    }
    public static void main(String[] args) {
        int array[] = {2,3,1,1,4};

        int dp[] = new int[array.length]; // DP[I] REPRESENTS MIN-JUMPS REQUIRED TO REACH "N-1 INDEX" FROM CURRENT INDEX "I"

        System.out.println(getMinJumps(array, 0, dp));
        System.out.println(getMinDiff(array));
    }
}
