import java.util.LinkedList;
import java.util.Queue;
public class SJFPremptive {
    static class Process{
        int pIndx; // PROCESS INDEX.
        int bt; // BRUST-TIME.
        int at; // ARRIVAL-TIME.

        // CONSTRUCTURE.
        Process(int id, int bt, int at){
            this.pIndx = id;
            this.bt = bt;
            this.at = at;
        }
    }

    public static void printArray(int array[]){
        for(int x : array){
            System.out.println(x + " ");
        }
        // System.out.println();
    }

    public static void getGnattChat(Queue<Integer> q ){
        int prev = q.remove();
        System.out.print("| " +"P"+prev + " | ");
        while(!q.isEmpty()){
            if(q.peek() != prev){
                System.out.print("P"+q.peek() + " | ");
            }

            prev = q.remove();
        }

        System.out.println();
    }

    public static void getCompletionTime(Process p[], int ct[],  Queue<Integer> q){
        int cput = 0; // CPU-TIME.
        int shotest = 0; // TO STORE INDEX OF SHORTEST-JOB.
        int shotJob = Integer.MAX_VALUE;
        boolean check = false; // TO CHECK WHETHER A JOB IS ARRIVED AT CURRENT CPU'S TIME.
        int complete = 0; // TO TRACK NO. OF JOBS ARE COMPLETELY EXECUTED.

        int bt[] = new int[p.length];

        // STORE BRUST-TIME OF ALL PROCESS IN "BT[]".
        for(int i=0; i<p.length; i++){
            bt[i] = p[i].bt;
        }
        
        while(complete!=p.length){
            // TO SELECT SHORTEST JOB ARRIVED AT CURRENT CPU'S TIME.
            for(int i=0;i<p.length;i++){
                Process currJob = p[i];
                if(currJob.at <= cput && bt[i] < shotJob && bt[i] > 0){
                    shotest = i;
                    shotJob = bt[i];
                    check = true;
                }
            }// end forLoop

            cput++; // UPDATE CPU'S TIME.
            if(!check){ // IF ANY JOB IS NOT FOUND AT CURRENT CPU'S TIME.
                continue; 
            }

            bt[shotest]--;
            if(bt[shotest] == 0){ // JOB COMPLETED.
                complete++;
                ct[shotest] = cput; // STORE CURRENT CPU'S-TIME WHERE JOB IS COMPLETELY EXECUTED.
            }

            q.add(shotest+1);
            
            check = false;
            shotJob = Integer.MAX_VALUE;
        }
        
    }

    public static void scheduler(Process p[], int ct[], int tat[], int wt[], Queue<Integer> q){
        getCompletionTime(p, ct, q);

        // TURNAROUND-TIME.
        for(int i=0;i<p.length;i++){
            tat[i] = ct[i] - p[i].at;
        }

        // WAITING-TIME.
        for(int i=0; i<p.length; i++){
            wt[i] = tat[i] - p[i].bt;
        }
    }

    public static void main(String[] args) {
        Process p[] = {
            new Process(1, 4, 0),
            new Process(2,6,1),
            new Process(3, 1, 2),
            new Process(4,3,3)                   
         };
         
         int ct[] = new int[p.length];
         int tat[] = new int[p.length];
         int wt[] = new int[p.length];
         Queue<Integer> heapMeamory = new LinkedList<>();

        scheduler(p, ct, tat, wt, heapMeamory); // FUNCTION CALL.

        System.out.println("GANTT-CHAT : "); getGnattChat(heapMeamory);


        System.out.println("COMPLETION TIME : "); printArray(ct);
        System.out.println("TURN-AROUND TIME : "); printArray(tat); 
        System.out.println("WAITING TIME : "); printArray(wt);
 
    }
}
