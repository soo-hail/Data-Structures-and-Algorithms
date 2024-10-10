import java.util.TreeSet;
public class TreeSetJCF {
    // IN TREESET ELEMENTS/OBJECTS ARE SORTED IN ACCENDING ORDER.
    // TIME COMPLEXITY OF ADD, REMOVE, CONTAINES OPERATIONS IS O(log n)    
    // TREESET IS IMPLEMENTED USING TREEMAP IN JAVA.
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(); // DECLARATION.
        set.add(1); set.add(4); set.add(3); set.add(0); set.add(2);

        System.out.println(set); // ELEMENTS OF SET ARE SORTED IN ACEENDING ORDER.
    }
}
