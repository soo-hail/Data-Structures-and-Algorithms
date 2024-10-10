import java.util.Deque;
import java.util.LinkedList;
public class DequeInJCF {
    
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>(); //DEQUE IS IMPLEMENTED USING LINKED-LIST.
        dq.addFirst(1);
        dq.addFirst(0);
        dq.addLast(2);

        // System.out.println(dq);

        dq.addLast(3);
        dq.addLast(4);    

        System.out.println(dq);
        dq.removeFirst();
        dq.removeLast();

        System.out.println(dq);
    }
}
