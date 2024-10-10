// SORT THE STUDENTS ACCORDING TO THEIR NAMES AND GIVE ROLL NUMBERS.
import java.util.PriorityQueue;
public class PQForObjects2 {

    static class Student implements Comparable<Student>{
        String name;
        int id;

        // CONSTRUCTURE.
        Student(String n){
            this.name = n;
            this.id = 0; // INITIALLY.
        }

        @Override
        public int compareTo(Student s){ // ENABLEING CLASS TO COMPARE IT'S OBJECTS.
            return this.name.compareTo(s.name); // COMPARING OBJECTS BASED ON NAMES.
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Student> names = new PriorityQueue<>();
        PriorityQueue<Student> register = new PriorityQueue<>();


        names.add(new Student("Abdul Fatah"));
        names.add(new Student("Mohammed Sohail"));
        names.add(new Student("Mohsin Alam"));
        names.add(new Student("Sruthi"));
        names.add(new Student("Dev Yadav"));
        names.add(new Student("Druv"));
        names.add(new Student("Rahil Pradeep"));
        names.add(new Student("Jeevan Krishna"));

        int id = 1;
        while(!names.isEmpty()){
            Student currStudent = names.remove();
            currStudent.id = id;
            register.add(currStudent);
            id++; 
        }

        while(!register.isEmpty()){
            Student currStudent = register.remove();
            System.out.println(currStudent.id + " ---> " + currStudent.name);
        }
    }
}
