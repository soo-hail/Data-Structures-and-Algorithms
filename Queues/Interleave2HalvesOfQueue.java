import java.util.LinkedList;
import java.util.Queue;
public class Interleave2HalvesOfQueue {
    public static void getInterleave(Queue<Integer> q){
        // FIND MID OF QUEUE.
        int mid = q.size()/2; 

        // STORE 1st HALF QUEUE IN TEMP QUEUE.
        Queue<Integer> tq = new LinkedList<>(); // TEMP-QUEUE
        for(int i=1;i<=mid;i++){
            tq.add(q.remove());
        }

        //  INTERLEAVE OF 2 HALVES OF QUEUE.
        // 1st HALF = tq , 2nd HALF = q.
        for(int i=1; i<=mid; i++){
            // WE ADD INTERLEAVE IN ORIGINAL QUEUE IT SELF.
            q.add(tq.remove());
            q.add(q.remove()); 
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        getInterleave(q);

        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}
