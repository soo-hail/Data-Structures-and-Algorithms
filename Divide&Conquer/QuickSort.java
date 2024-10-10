public class QuickSort {
    
    public static void sort(int array[], int start, int end){

        if(start>=end){
            return;
        }

        // SELECT "PIVOT" ELEMENT.
        int pivot = end;

        // ARRANGE SMALLER ELEMENTS THAN PIVOT AT BEGINING OF THE ARRAY.
        int i = start; // POINTER TO SWAP THE SMALLER ELEMENT.
        for(int j=start;j<end;j++){
            if(array[j] <= array[pivot]){
                // SWAP.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++; // UPDATE.
            }
        }

        // FIX PIVOT-ELEMENT POSITION.
        // NOTE : POINTER WILL BE POINTING AT ELEMENT WHICH IS GREATER THAN "PIVOT" ELEMENT.
        int temp = array[i];
        array[i] = array[pivot];
        array[pivot] = temp;
        // UPDATE PIVOT.
        pivot = i;
        
        // PARTITION.
        sort(array, start, pivot-1); // LEFT.
        sort(array, pivot+1, end); // RIGHT.
    }
    public static void main(String[] args) {
        int array[] = {6,3,9,8,2,5,-12,91,17,9,-12};

        sort(array, 0, array.length-1);

        for(int x : array){
            System.out.print(x + " ");
        }
    }
}
