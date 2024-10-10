/*INBUILT SORT : 
     NOTE : 
      1.import java.util.Arrays;
      2.Syntax : Arrays.sort(arrName, startIndx, endIndex) --> by default startIndx = 0, endIndx=lenght-1*/
import java.util.*;
public class InbuiltSort {
    public static void main(String[] args) {
        int array[] = {45,97,29,21,89,7,22,56};
         //SORTING WHOLE ARRAY IN ACCENDING ORDER.
        // Arrays.sort(array); 

        //SORTING SUB ARRAY : 
        // Arrays.sort(array, 0, 4);

        //SORTING IN DECENDING ORDER.
          //NOTE : WE CAN USE METHODS OF COLLECTIONS CLASS ONLY ON OBJECT DATATYPE NOT PREMITIVE DATATYPE.
          //SO,
        Integer arr[] = {45,97,29,21,89,7,22,56};
        Arrays.sort(arr,Collections.reverseOrder());

       //SORTING SUB-ARRAY IN DECENDING ORDER.
        // Arrays.sort(arr,0,4,Collections.reverseOrder());
        
        System.out.print("[ ");
        for(int var : arr){
            System.out.print(var + " ");
        }
        System.out.print("]");
    }
}
