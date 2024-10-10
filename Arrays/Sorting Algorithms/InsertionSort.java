
//INSERTION SORT : FIRST ELEMENT OF UNSORTED ARRAY IS PLACED AT CORRERCT POSITION IN SORTED ARRAY.
public class InsertionSort {

    public static void main(String[] args) {

        int array[] = {45,97,29,21,89,7,22,56};

        for(int i=1;i<array.length;i++){ //IS TO SELECT FIRST FOR ELEMENT OF UNSORTED ARRAY. 
            int firstEle = array[i];
            int tracker = i-1; //to track elements of sorted array.
            while(tracker>=0 && array[tracker] > firstEle){
                array[tracker+1] = array[tracker]; //moving largest element by one position.
                tracker--;
            }
            array[tracker + 1] = firstEle;
        }//end forLoop.

        System.out.print("[ ");
        for(int var : array){
            System.out.print(var + " ");
        }
        System.out.print("]");
      
    }
}