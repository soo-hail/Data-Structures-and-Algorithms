import java.util.HashSet;
public class HashSetJCF{
    
    // SET IS A COLLECTION OF UNIQUE OBJECTS/ELEMETS. WHICH IS IMPLEMENTED USING HASH-MAP.
    
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // DECLARATION.

        // ADD()
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(3); // DUPLICATE.
        set.add(5);

        System.out.println(set);

        // CONTAINS() : CHECKS WHETHER A ELEMENT IS PRESENT IN SET.
        System.out.println(set.contains(3));
        System.out.println(set.contains(80));

        // REMOVE()
        set.remove(2);
        System.out.println(set);

        // SIZE() 
        System.out.println(set.size());

        // ISEMPTY() : CHECKS WHETHER A SET IS EMPTY.
        System.out.println(set.isEmpty());

        // CLEAR() : REMOVES ALL ELEMETS FROM SET WITHOUT DELECTING A SET.
        set.clear();
        System.out.println(set);
    }
}