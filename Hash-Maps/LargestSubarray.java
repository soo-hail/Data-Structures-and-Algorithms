import java.util.HashMap;
public class LargestSubarray {

    public static void main(String[] args) {
        int array[] = {15,-2,2,-8,1,7,10,23};

        HashMap<Integer, Integer> map = new HashMap<>(); // WE USE HASHMAP TO STORE PAIRS OF (SUM AND INDEX)

        int sum = 0 ;
        int maxLen = 0; // TO STORE LENGTH OF MAX SUBARRAY WHOSE SUM IS ZERO.
        for(int i=0; i<array.length; i++){ // TRAVRESE ARRAY AND CALCULATE SUM OF ELEMENTS TILL CURRENT INDEX AND STORE IT IN HASHMAP.
            sum = sum + array[i];

            if(!map.containsKey(sum)){ // IF SUM IS NOT PRESENT IN MAP.
                map.put(sum, i); // ADD THAT PAIR IN HASHMAP.
                continue;
            }

            // IF SUM IS ALREADY PRESENT IN SUM. WHICH MEANS FROM THE NEXT ELEMENTS OF THE ELEMENT WHOSE SUM IS SAME ARE MAKEING UP THEIR SUM TO ZERO. 
            int currLen = i - map.get(sum); // RETURNS THE SIZE OF SUBARRAY WHOSE SUM IS ZERO.
            // UPDATE MAX-LENGTH.
            maxLen = Math.max(maxLen, currLen);

        } //end forLoop.

        System.out.println(maxLen);

    }    
}