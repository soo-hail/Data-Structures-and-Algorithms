import java.util.LinkedHashSet;
public class LinkedHashSetJCF {
    // IN LINKED-HASHSET INSERTION ORDER IS MAINTAINED.
    // TIME COMPLEXITY OF ALL OPERATIONS IS CONSTANT. BUT PERFORMANCE OF LINKED-HASHSET IS LESS THAN HASHSET.

    // IT HAS ALL OPERATION OF HASHSET. ONLY THING IS INTERTION ORDER IS MAINTAINED.
    public static void main(String[] args) {

        LinkedHashSet<String> set = new LinkedHashSet<>(); // DECLARATION.
        set.add("Bengaluru"); set.add("Chennai"); set.add("Delhi"); set.add("Kochi");


        System.out.println(set); // INSERTION ORDER ID MAINTAINED.
    }
}
