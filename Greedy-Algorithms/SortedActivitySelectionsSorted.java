import java.util.ArrayList;
public class SortedActivitySelectionsSorted{

    public static void sortAct(int start[], int end[]){
        //SORT ACTIVITIES BASED ON END TIME.
    }

    public static void main(String[] args) {
        int start[]={1,3,0,5,8,3};
        int end[] = {2,4,6,7,9,9};

        int noAct = 0; //NO. OF ACTIVITIES.
        ArrayList<Integer> indx = new ArrayList<>(); //TO STORE INDEX'S OF NON-OVERLAPPING ACTIVITIES.
        int lastAct; //LAST PARTICIPATED ACTIVITY.

        //SELECTING FIRST ACTIVITY BECAUSE IT WILL COMPLETE FIRST.
        noAct++; 
        indx.add(0); 
        lastAct = 0;

        //TO SELECT NON-OVERLAPPING ACTIVITIES.
        for(int curr=1;curr<end.length;curr++){ 
            if(start[curr]>=end[lastAct]){ //CHECKING NON-OVERLAPPING CONDITION.
                noAct++;
                indx.add(curr);
                lastAct = curr;
            }
        }//end forLoop.

        System.out.println("NO. OF ACTIVITIES : " + noAct);
        System.out.println("ACTIVITY INDEXES : " + indx);
    }
}