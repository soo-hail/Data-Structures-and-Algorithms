import java.util.ArrayList;
public class MergeSort{

    public static void sortAndConquer(int array[], int start, int mid, int end){
        //NOTE : MID IS USED AS PARTITION.
        
        ArrayList<Integer> temp = new ArrayList<>();
        int lp = start; //(LEFT POINTER) TO TRACK ELEMENTS OF LEFT PARTIONED ARRAY.
        int rp = mid+1; // (RIGHT POINTER) TO TRACK ELEMENTS OF RIGHT PARTIONED ARRAY.

        while(lp<=mid && rp<=end){
            if(array[lp] < array[rp]){
                temp.add(array[lp]);
                lp++;
            }else{
                temp.add(array[rp]);
                rp++;
            }
        }

        // TO ADD REMAINING ELEMENTS.
        while(lp<=mid){ // TO ADD REMAINING ELEMENTS OF LEFT PARTIONED ARRAY. 
            temp.add(array[lp]);
            lp++;
        }

        while(rp<=end){ // TO ADD REMAINING ELEMENTS OF RIGHT PARTIONED ARRAY.
            temp.add(array[rp]);
            rp++;
        }

        // COPY ELEMENTS FROM AUXILARY(TEMP) TO ORIGINAL PARTIONED ARRAY AT THAT LEVEL.
        int indx = start;
        for(int i=0;i<temp.size();i++){
            array[indx] = temp.get(i); // OVER-WRITTING THE ELEMENTS.
            indx++;
        }
        
    }
    public static void sortAccending(int array[], int start, int end){

        // WE CAN FURTHUR DIVIDE AND SORT(MERGE) THE ARRAY IF THE ARRAY SIZE IS MORE THAN ONE. 
        if(start == end){ // SINGLE ELEMENT OF ARRAY.
            return;
        }

        // FIND MID.
        int mid = start+((end-start)/2);

        // DIVIDE ARRAY(ARRAY IS PARTIONED BUT NOT PHYSICALY DIVIDED).
        sortAccending(array, start, mid); // LEFT PARTITION.
        sortAccending(array, mid+1, end); // RIGHT PARTITION.

        // SORT&CONQUER.
        sortAndConquer(array, start, mid, end);
     }

     public static void sortAndConquer2(int array[], int start, int mid, int end){
        int lp = start; // LEFT POINTER.
        int rp = mid+1; // RIGHT POINTER.
        ArrayList<Integer> temp = new ArrayList<>();

        while(lp<=mid && rp<=end){
            if(array[lp] > array[rp]){
                temp.add(array[lp]);
                lp++;
            }else{
                temp.add(array[rp]);
                rp++;
            }
        }

        // ADD REMAINING ELEMENTS IN "TEMP"(ARRAY-LIST).
        while(lp<=mid){ // FOR LEFT-PARTITION. 
            temp.add(array[lp]);
            lp++;
        }

        while(rp<=end){ // FOR RIGHT-PARTITION. 
            temp.add(array[rp]);
            rp++;
        }

        // COPY ELEMENT FROM TEMP(ARRAY-LIST) TO ORIGINAL ARRAY.
        int i = start;
        for(int j=0; j<temp.size();j++){
            array[i] = temp.get(j);
            i++;
        }
     }
     // DECENDING ORDER.
     public static void sortDecending(int array[], int start, int end){
        if(start>=end){
            return;
        }

        // FIND MIDDLE ELEMENT.
        int mid = start + ((end-start)/2);


        // PARTITION.
        sortDecending(array, start, mid);// LEFT.
        sortDecending(array, mid+1, end); // RIGHT.

        // SORT&CONQUER.
        sortAndConquer2(array, start, mid, end);


     }
    public static void main(String[] args) {
        int array[] = {6,3,9,5,2,8,-34};

        sortAccending(array, 0, array.length-1);

        for(int x : array){
            System.out.print(x + " ");
        }

        System.out.println();
        sortDecending(array, 0, array.length-1);

         for(int x : array){
            System.out.print(x + " ");
        }

    }
}