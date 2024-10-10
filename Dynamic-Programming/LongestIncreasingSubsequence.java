import java.util.Arrays;
import java.util.HashSet;
public class LongestIncreasingSubsequence {
    
    // INCREASING-SUBSEQUENCE : THE ELEMENTS OF SUBSEQUENCE WILL BE IN ACCENDING ORDER.
    // Q. FIND SIZE OF LONGEST INCREASING SUBSEQUENCE IN ARRAY.
    public static int getLIS(int array[]){
        // APPROACH: WE SORT THE ARRAY(WITHOUT REPEATING ELEMENTS) AND FIND THE LONGEST COMMON SUBSEQUENCE BETWEEN "SORTED-ARRAY AND GIVEN-ARRAY"

        
        // 1. FIND SORTED-ARRAY
        // GET UNIQUE ELEMENTS FROM GIVEN ARRAY(WE USE HASH-MAP)
        HashSet<Integer> set = new HashSet<>();
        for(int x : array){
            set.add(x);
        }

        int sortedArray[] = new int[set.size()]; // TO STORE UNIQUE SORTED ELEMENTS OF ARRAY.
        int indx = 0; // TO TRACK INDEX OF SORTED-ARRAY
        // STORE ELEMETS IN SORTED-ARRAY.
        for(int x : set){
            sortedArray[indx] = x;
            indx++;
        }

        // SORT ARRAY(SORTED-ARRAY) IN ACCENDING-ORDER
        Arrays.sort(sortedArray);

        // 2. FIND LONGEST-COMMON-SUBSEQUENCE(TABULATION) 
        // CREATE TABLE
        int dp[][] = new int[array.length + 1][sortedArray.length + 1];

        // ASSIGN MEANING : DP[I][J] ---> REPRESENTS LONGEST-COMMON-SUBSEQUENCE WHEN SIZE OF SORTED-ARRAY AND ARRAY ARE "I AND J" RESPECTIVELY.
        
        // INITIALIZATION : 
        //WHEN I==0 OR J==0 ---> DP[I][J] = 0 ---> BECAUSE CAN'T FIND "LCS" FOR EMPTY ARRAY.

        // NO NEED TO INITIALIZE DP WITH ZERO. BECAUSE IN JAVA BY DEFAULT ZERO IS STORED IN CELLS OF MATRIX.

        // START SOLVING PROBLEM(SMALL PROBLEM TO LARGE PROBLEM).
        for(int i=1; i<dp.length; i++){

        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int array[] = {};
    }
}
