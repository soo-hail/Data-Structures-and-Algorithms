import java.util.Arrays;
import java.util.Comparator;
public class MaxLengthChainPairs {
    
    public static void main(String[] args) {
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}; // 2-D ARRAY IS THE COLLECTION OF 1-D ARRAY. i.e. EVERY ROW OF 2-D ARRAY IS 1-D ARRAY.

        //SORT 2-D ARRAY ACCORDING TO SECOND NUMBER OF PAIR.
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

        // FOR FIRST PAIR WHICH HAS LEAST 2ND NUMBER.
        int lastPair = pairs[0][1];
        int countPair = 1;

        // FINDING CHAIN OF PAIRS.
       for(int row=1;row<pairs.length;row++){
            if(pairs[row][0] > lastPair){
                countPair++;
                lastPair = pairs[row][1];
            }
       }

       System.out.println(countPair);
    }
}
