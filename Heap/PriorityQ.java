// PRIORITY QUEUE IS A QUEUE WHICH FUNCTIONS ACCORDING TO PRIORITY OF THE ELEMENT.
import java.util.PriorityQueue;
public class PriorityQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        // NOTE : BY DEFAULT INTEGER PRIORITY QUEUE HAS HIGH PRIORITY TO THE LOWEST VALUES.        

        // REVESE THE PRIORITY : WE USED COMPARATOR. 
        // COMPARATOR IS A INTERFACE THAT DEFINES LOGIC FOR COMPARING OF ELEMENTS(WHILE SORTING). 
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq.add(4);
        pq.add(2);
        pq.add(5);
        pq.add(9);
        pq.add(1);
        pq.add(3);

        System.out.println("ELEMENTS OF PRIORITY QUEUE : ");
        while(!pq.isEmpty()){
            System.out.println(pq.remove()); // ELEMENTS ARE REMOVED ACCORDING TO PRIORITY.
        }
    }
}