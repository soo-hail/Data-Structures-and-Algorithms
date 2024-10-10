import java.util.*;
public class MajorityElement {
    // GIVEN AN ARRAY OF INTEGERS OF SIZE 'N'. PRINT ALL ELEMENTS EHO'S FREQUENCY IS MORE THAN 'N/3'.
    public static void main(String[] args) {
        int array[] = {1,3,2,5,1,3,1,5,1};

        // WE USE HASH-MAP TO STORE ELEMENT AND IT'S FREQUENCY.
        HashMap<Integer, Integer> map = new HashMap<>();

        // TRAVERSE ARRAY.
        for(int i=0; i<array.length; i++){
            // NOTE : getOrDefault() FUNCTION RETURNS VALUE OF KEY IF KEY EXIST IN MAP. 
                        // OTHERWISE IT WILL RETURN DEFAULT VALUE.
            int currEle = array[i];
            map.put(currEle, map.getOrDefault(currEle, 0) + 1); // INCREMENT VALUE IF KEY IS PRESENT IN MAP OTHERWISE PUT 1 AS FREQUENCY OF CURRENT ELEMENT.
        }

        // FIND 'N/3'
        int n = array.length/3;

        // TRAVERSE HASHMAP.
        // NOTE : DO NOT STORE KEYSET IN ANY SEPARATE SET BECAUSE IT WILL INCREASE SPACE COMPLEXITY.
        for(int ele : map.keySet()){
            if(map.get(ele) > n ){
                System.out.print(ele + " ");  // IF FREQUENCY OF ELEMENT IS GREATER THAN 'N/3' THEN PRINT THAT ELEEMNT.
            }
        }
    }    
}