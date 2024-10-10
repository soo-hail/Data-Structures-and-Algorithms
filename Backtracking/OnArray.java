/* Q. TRAVERSE THE EMPTY ARRAY BY GIVING 1,2,3,4,5..... VALUES TO EVERY INDEX OF INDEX. 
WHILE BACKTRACKING REDUCE "-2" FROM THE VALUE AT PERTICULAT INDEX */

public class OnArray {

    public static void backtrack(int array[], int indx){
        // BASE CASE.
        if(indx == array.length){
            return;
        }

        array[indx] = indx + 1;
        backtrack(array, indx + 1); // CALL FOR NEXT INDEX.
        // WHILE BACKTRACKING.
        array[indx] = array[indx]-2;
    }

    public static void main(String[] args) {
        int array[] = new int[5]; // EMPTY ARRAY.

        backtrack(array, 0);

        for(int x : array){
            System.out.print(x + " ");
        }
    }
    
}