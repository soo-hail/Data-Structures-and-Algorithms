public class BubbleSort{

    //OPTIMIZED BUBBLE SORT ---> IF THE ARRAY IS ALREADY SORTED OT ARRAY GET'S SORTED BEFORE N-2 ITERATIONS.
    public static void sort(int array[]){
        int count = 0;
        for(int i = array.length-2; i>=0;i--){ //TILL WHERE WE HAVE TO COMPARE. BECAUSE AFTER EVERY ITERATION ONE LAST ELEMENT GETS SORTED.
            int swap = 0; // TO TRACK WHEATHER ELEMENTS GETS SWAPED OR NOT IN ANY ONE ITERATION.
            for(int j=0;j<=i;j++){ //TO COMPARE WITH ADJACENT ELEMENTS FROM INDEX ZERO. AND SWAP.
                if(array[j] > array[j+1]){ //COMAPREING
                    //SWAPING.
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    swap = 1;
                }
            }//END INNER-FORLOOP.
            count++;
            if(swap == 0){ //NO ELEMENTS ARE SWAPPED(ARRAY IS SORTED).
                break;
            }
        }//END OUTER LOOP.
        System.out.println("OUTER FORLOOP : " + count); //NO OF TIMES OUTER FORLOOP RUNNED.
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7} ;

        // for(int i=array.length-2;i>=0;i--){ //TILL WHERE WE HAVE TO COMPARE.
        //     //AFTER ONE ITERATION OF OUTER LOOP. LAST ELEMENT OF ARRAY IS SORTED I.E. LARGEST ELEMENT WILL BE AT THE END OF ARRAY.
        //     for(int j=0;j<=i;j++){
        //         if(array[j] > array[j+1]){ //COMPARE.
        //             //SWAP.
        //             int temp = array[j];
        //             array[j] = array[j+1];
        //             array[j+1] = temp;
        //         }
        //     }//END INNER-FORLOOP.
        // } //END OUTER-FORLOOP.

        sort(array);

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}