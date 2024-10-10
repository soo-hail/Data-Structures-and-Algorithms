import java.util.LinkedList;
public class LinkedListUsingJCF {
    
    public static void main(String[] args) {
        // DEFINITION.
        LinkedList<Float> ll = new LinkedList<>();
        
        // OPERATIONS.

        ll.addFirst(12.004f);
        ll.addLast(23.5f);
        ll.add(1, 24.99f);
        ll.addFirst(9.999f);

        System.out.println(ll); // TO PRINT LINKED-LIST.

        // ll.removeAll(ll); // REMOVES ALL ELEMENTS(OBJECTS) OF LINKED-LIST.
        System.out.println(ll);

        Float headData = ll.peek(); // RETUNS NODE AT HEAD WITHOUT DELECTING IT.
        // REMOVE FUNCTION REMOVE VALUE AND RETURN REMOVED VALUE.
        // ll.removeFirst(); 
        // ll.removeLast(); 
        System.out.println(ll.remove(23.5f)); // REMOVES THE PERTICULAR OBJECT(ELEMENT).
        System.out.println(ll.contains(9.999f)); // CHECKS WHETHER A ELEENT(OBJECT) IS PRESENT IN LINKED-LIST.  
        while(!ll.isEmpty()){
            System.out.print(ll.remove() + "--->");  // REMOVES HEAD NODE(REMOVE-FIRST)
        }
        System.out.println("null");
    }
}
