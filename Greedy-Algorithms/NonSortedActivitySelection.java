import java.util.*;
public class NonSortedActivitySelection {

    public static void main(String[] args) {
        int start[] = {0,1,3,5,3,8};
        int end[] = {6,2,4,7,9,9};

        // WE USE 2-D ARRAY TO SORT THE ACTIVITIES ACCORDING TO END TIME. BECAUSE THAT ACTIVITIES WILL COMPLETE FIRST AND WE CAN ALSO FIND THE NON-OVERLAPPING ACTIVITIES.
        int activity[][] = new int[end.length][3];
        // 2-D ARRAY HAS 3 COLUMNS TO STORE.
                        // INDEX START-TIME END-TIME.

        for(int indx = 0; indx<end.length; indx++){ //TO STORE INDEX START END IN 2-D ARRAY.
            int row = indx;
            // IN SINGLE ROW OF 2-D ARRAY A ACTIVITY IS STORED.
            activity[row][0] = indx; //iINDEX
            activity[row][1] = start[indx]; //START
            activity[row][2] = end[indx]; //END
        }

        // SORT 2-D ARRAY USING INBUILD FUNCTIONS AND COMPARATOR. 
            //COMPARATOR : IS A INFERFACE THAT TELLS PROGRAM HOW TO SORT OR ON WHAT BASEIS IT SHOULD BE SORTED.
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2])); // 2-D SORTED ON THE BASES OF 2ND INDEX OF A SINGLE ROW.

        int noAct = 0; //NO.OF ACTIVITIES.
        ArrayList<Integer> indx = new ArrayList<>(); //TO STORE INDEXES OF NON - OVERLAPPING ACTIVITIES.
        int lastIndx; //TO STORE LAST CHOSEEN ACTIVITY.

        //FIRST ACTIVITY :  IS ADDED IS TAKEN BECUASE IT ENDS FIRST.
        noAct++;
        indx.add(activity[0][0]); //ADDING INDEX OF ACTIVITY THAT HAS FINISHED FIRST.
        lastIndx = activity[0][0];

        // FINGING NON - OVERLAPPING ACTIVITIES(EVENTS).
        for(int row = 1; row < end.length; row++){
            if(activity[row][1] >= end[lastIndx]){ //CURRENT-ACTIVITY[START] >= LAST CHOSEEN ACTIVITY[END]. 
                noAct++;
                indx.add(activity[row][0]); //ADDING INDEX OF NON-OVERLAPPING 
                lastIndx = activity[row][0];
            }
        }

        System.out.println("NO.OF ACTIVITIES : " + noAct);
        System.out.println(indx);
    }
    
}