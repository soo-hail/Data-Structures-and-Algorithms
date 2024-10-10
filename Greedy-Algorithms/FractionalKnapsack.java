import java.util.*;
public class FractionalKnapsack {

    public static boolean canTakeFull(int capacity, int itemWeight){
        return capacity >= itemWeight; // IF CAPACITY OF KNAPSACK IS MORE THAN ITEM WEIGHT.
    }

    public static void main(String[] args) {
        int value[] = {100,120,60};
        int weight[] = {20,30,10};
        int w = 50;

        // USE 2-D ARRAY TO SORT ITEMS ACCORDING TO VALUE/WEIGHT RATIO.
        double array[][] = new double[value.length][2];
            // ARRAY HAS 2 COLUMNS TO STORE INDEX TO ITEM AND RATIO.
                // INDEX  |  RATIO.
        //ADD ALL ITEMS IN ARRAY(2-D ARRAY).

        for(int row = 0; row < value.length; row++){
            array[row][0] = row; // STORING INDEX OF ITEMS.
            array[row][1] = (double)(value[row]/weight[row]); // STORING RATIO. 
        }

        // SORT 2-D ARRAY ACCORDING TO RATIO.
        Arrays.sort(array,Comparator.comparingDouble( o -> o[1])); //THIS 2-D ARRAY IS SORTED IN ACCENDING ORDER BUT WE NEED IN DECENDING ORDER.

        // BEFORE START FILLING KNAPSACK.
        int capacity = w; // CAPACITY OF KNAPSACK MORE IT CAN STORE.
        int countValue = 0 ; 

        // FILLING KNAPSACK.
        int row = value.length - 1; // WE START FILLING ITEMS FROM LAST INDEX. BECUASE 2-D ARRAY IS SORTED IN ACCENDING ORDER.
        while(capacity > 0){
            int indx = (int)array[row][0]; // INDEX WHICH HAVE MORE RATIO.
            if(canTakeFull(capacity, weight[indx])){
                countValue += value[indx];
                capacity-=weight[indx];
                row--;
            }else{ //CAN'T TAKE FULL WEIGHT OF A ITEM.
                double ratio = array[row][1]; // STORING RATIO OF ITEM TO GET REMAINING WEIGHT. 
                countValue +=  (ratio * capacity);
                capacity = 0; // KANPSACK IS FULL NOW.
            }
        }//end whileLoop.

        System.out.println("TOTAL VALUE : " + countValue);
    }
}