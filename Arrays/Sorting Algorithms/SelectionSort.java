public class SelectionSort {

    //SELECTON-SORT : PICK THE SMALLEST FROM UNSORTED ARRAY AND PLACE IT AT FIRST INDEX OF UNSORTED ARRAY.
       //NOTE : AFTER ONE ITERATION OF OUTERLOOP, FIRST INDEX OF UNSORTED ARRAY GET'S SORTED.
    
    public static void main(String[] args) {
        int array[]={5,3,4,2,1,-1,0};
       
        for(int i=0;i<=array.length-2;i++){ //FROM WHERE UNSORTED ARRAY START'S
            int indxMin = i;
            for(int j=i+1;j<array.length;j++){ //TO COMPARE AND FIND INDEX OF SMALLEST ELEMENT.
                if(array[j] > array[indxMin]){ //COMPARE.
                    indxMin = j;
                }
            }//end innerLoop.
            //PLACE SMALLEST ELEMENT AT FIRST INDEX OF UNSORTED ARRAY.
            array[i] = array[indxMin] + array[i]-(array[indxMin] = array[i]);
            //1.ADDITION.
            //2.SUNTRACTION.
            //3.ASSIGNMENT.
        }
       
    }
}
                                                           