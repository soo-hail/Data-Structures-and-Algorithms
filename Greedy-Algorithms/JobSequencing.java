import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class JobSequencing {
    public static boolean isPresent(int time[], int index){
        if(time[index] > -1){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        char name[] = {'A','B','C','D'};

        int jobs[][] = {{0,4,20},{1,1,10},{2,1,40},{3,1,30}};
                    // ROW : INDEX DEADLINE PROFIT.
        // SORT JOBS ACCORDING TO PROFIT.
        Arrays.sort(jobs,Collections.reverseOrder(Comparator.comparingDouble(o -> o[2]))); // SORT IN DECENDING ORDER ACCORDING  TO INDEX 2(PROFIT).
        // FIND MAX DEADLINE.

        int max = 0; // DEADLINE SHOULD BE MIN 1.
        for(int i=0;i<jobs.length;i++){
            int deadLine = jobs[i][1];
            if(deadLine > max){
                max = deadLine;
            }
        }// END FORLOOP.

        int time[] = new int[max]; // TO STORE JOBS THAT CAN BE SHEDULED.
        // INITIALIZE "TIME" WITH -1. WHERE "-1 == NO ELEMENT". 
        for(int i=0;i<time.length;i++){
            time[i] = -1;
        }

        int profit = 0;
        ArrayList<Integer> seq = new ArrayList<>(); 
        for(int i=0;i<jobs.length; i++){
            int index = jobs[i][0]; // INDEX OF A JOB.  
            int deadLine = jobs[i][1];
            int pft = jobs[i][2];
            if(isPresent(time, deadLine-1)){
                // SEARCH FOR THE EMPTY POSITION IN "time" THAT IS LESS THAN DEADLINE.
                for(int j = deadLine - 2; j>=0; j--){ // ALWAYS GO IN DECENDING ORDER. BECAUSE LARGER DEADLINE CAN BE PLACED IN SMALLER DEADLINE, BUT SMALLER DEADLINE CAN'T BE PLACED IN LARGER DEADLINE.
                    if(time[j] == -1){
                        time[j] = index;
                        profit +=pft;
                        seq.add(index);
                        break;
                    }
                }
            }else{
                time[deadLine-1] = index;
                profit +=pft;
                seq.add(index);
            }
        }

        System.out.print("SEQUENCE : ");
        for(int k=0;k<seq.size();k++){
            System.out.print(name[seq.get(k)] + " ");
        }

        System.out.println();
        System.out.println("PROFIT : " + profit);
    }
}
