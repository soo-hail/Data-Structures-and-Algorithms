import java.util.Comparator;
import java.util.PriorityQueue;
public class PQForObjects {
    // CLASS SHOULD INHERIT(IMPLEMENT) COMPARABLE INTERFACE TO ENABLE ITSELF TO COMPARE IT'S OBJECTS.
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        //CONSTRUCTURE.
        Student(String n, int r){
            this.name = n;
            this.rank = r;
        }

        // OVERRIDE "compareTo()" METHOD TO COMPARE CURRENT-OBJECT WITH OTHER OBJECT BASED ON IT'S ONE OF THE PROPERTY.
        @Override
        public int compareTo(Student s){
            return this.rank - s.rank; // TO COMPARE RANK OF CURRENT OBJECT WITH OTHER OBJECT.
            /* 
            RETURN r1 - r2            
            RETURN -VE WHEN (R1>R2)
            RETURN +VE WHEN (R2>R1)
            RETURN 0(ZERO) WHEN (R1=R2)
            FROM THIS WE WILL GET TO KNOW WHICH IS GREATEST.
            */
        } 
    }
    public static void main(String[] args) {
        // WE ENABLE CLASS TO COMAPRE IT'S OBJECTS BUT "Priority Queue" CLASS WILL COMPARE THE OBJECTS BASED ON IT'S PROPERTIES AND GIVE PRIORITY.
        PriorityQueue<Student> pq = new PriorityQueue<>(); // GIVE PRIORITY TO OBJECTS. BY DEFAULT LOW RANK OBJECTS WILL GET HIGH PRIORITY BECAUSE LOW INTEGERS HAS HIGH PRIORITY.
        
        // TO REVERSE PRIORITY.
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()); 

        pq.add(new Student("A", 3));
        pq.add(new Student("B", 12));
        pq.add(new Student("C", 9));
        pq.add(new Student("D", 2));
        pq.add(new Student("E", 7));
        pq.add(new Student("F", 11));

        while(!pq.isEmpty()){
            Student currStudent = pq.remove();
            System.out.println(currStudent.name + " ---> " + currStudent.rank);
        }

    }
}