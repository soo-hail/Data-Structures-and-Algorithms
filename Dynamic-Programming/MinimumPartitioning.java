public class MinimumPartitioning {
    // VARIATION OF 0_1-KNAPSACK

    // Q. GIVEN AN ARRAY OF INTEGERS(NUMBERS) WE HAVE TO DIVIDE THAT NUMBERS IN TWO SETS THAT THEIR DIFFERNCE SHOULD BE MINIMUM.

    // APPROACH : 
    // 1. IF THE SUM_OF_NUMBERS = "X" THEN WE TRY TO DIVIDE TWO SETS EQUALLY(X/2), SO THAT THEIR DIFFERENCE WOULD BECOME MINIMUM. 
    // 2. WE TRY TO FILL FIRST SET WITH NUMBERS, VALUE OF SET-2 WILL BE SUM_OF_REMAINING NUMBERS.
    //(OUR WORK IS TO FIND THE SET-1)

    // RECURTION
    public static int getMinDiff(int array[], int cap, int arrSum, int indx){
        // CAP ---> SUM/2(MAX-CAPACITY_OF_BAG)

        // BASE-CASE
        if(indx == -1){
            return Integer.MAX_VALUE;
        }

        // BASE-CASE
        if(array[indx] > cap){ 
            int capSet1 = 0; // CAPACITY OF SET-1
            if(arrSum%2 == 0){
                capSet1 = arrSum/2;
            }
            else{
                capSet1 = arrSum/2 + 1 ;
            }

            capSet1 = capSet1 - cap; // ACTUALL VALUE CONTAINDED BY SET-1
            int capSet2 = arrSum - capSet1;

            return Math.abs(capSet1 - capSet2);
        }

        // FOR EVERY NUMBER THERE WILL BE 2 CHOICES(INCLUDE/EXCLUDE)
        int x = getMinDiff(array, cap-array[indx], arrSum, indx-1); // INCLUDE
        int y = getMinDiff(array, cap, arrSum, indx-1); // EXLUDE

        return Math.min(x, y);
    }

    // TABULATION
    public static int getMinDiff(int array[]){

        // FIND ARRAY-SUM
        int arrSum = 0;
        for(int i=0; i<array.length; i++){
            arrSum += array[i];
        }

        // FIND CAPACITY OF SET-1
        int cap = 0;
        if(arrSum%2 == 0){
            cap = arrSum/2;
        }
        else{
            cap = arrSum/2 + 1 ;
        }

        // TABULATION
        
        // 1.  CREATE TABLE
        int dp[][] = new int[array.length+1][cap+1]; // ROW ---> NUMBERS AND COL ---> CAPACITY(DIVIDED INTO SMALLER PROBLEMS)

        // 2. ASSIGN MEANING : EVERY CELL OF DP (DP[I][J])---> TO STORE MAX-SUM WHEN THERE ARE I-NUMBERS AND J-IS THE CAPACITY OF SET-1.
        
        // 3. INITIALIZATION : 

        // 4. SOLVE-PROBLEM(BOTTOM-UP)
        for(int i=1; i<dp.length; i++){ // FOR NUMBERS
            for(int j=1; j<dp[0].length; j++){ // FOR SUM/CAPACITY_OF_SET(DIVIDED INTO SMALLER PROBLEMS).

                // FOR EVERY-NUMBERS THEIR WILL BE TWO OPTIONS(INCLUDE/EXCLUDE)
                int x = 0; int y = 0;
                if(array[i-1] <= j){ // VALID CONDITION TO INCLUDE_NUMBER
                    // NOTE : INDEX OF NUMBER IN ARRAY IS "I-1".
                    x = array[i-1] + dp[i-1][j-array[i-1]]; // CURRENT_NUMBER + MAX_SUM WITH "I-1"-ITEMS FOR REMAINING SPACE
                }

                y = dp[i-1][j]; // EXCLUDE

                dp[i][j] = Math.max(x, y);
            }
        }// end forLoop

        // NOTE : MAX-SUM OF SET-1 IS STORED IN "DP[DP.LENGTH-1][DP[0].LENGTH-1]"
        return arrSum%2==0? cap - dp[dp.length-1][dp[0].length-1] : cap - dp[dp.length-1][dp[0].length-1] + 1; // DIFF == CAP - MAX-SUM OF SET-1
    }
    public static void main(String[] args) {
        int numbers[] = {1,6,11,5};
        
        // FIND ARRAY-SUM
        int arrSum = 0;
        for(int i=0; i<numbers.length; i++){
            arrSum += numbers[i];
        }

        // FIND CAPACITY OF SET-1
        int cap = 0;
        if(arrSum%2 == 0){
            cap = arrSum/2;
        }
        else{
            cap = arrSum/2 + 1 ;
        }

        System.out.println(getMinDiff(numbers, cap, arrSum, numbers.length-1)); // RECURTION
        System.out.println(getMinDiff(numbers)); // TABULATION
    }    
}