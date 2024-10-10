import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueReversal {
    public static void reverse(Queue<Integer> q){
        // WE REVERSE QUEUE USING STACK.
        Stack<Integer> stack = new Stack<>();

        // ADD ELEMENTS OF QUEUE IN STACK.
        while(!q.isEmpty()){
            stack.push(q.remove());
        }

        // ADD ELEMENTS BACK TO QUEUE FROM STACK.
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);

        // PRINT QUEUE.
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}
