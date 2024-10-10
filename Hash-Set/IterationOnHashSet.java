import java.util.*;

public class IterationOnHashSet {
    
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Bengaluru"); set.add("Delhi"); set.add("Punjab"); set.add("Kochi");

        // USING ITERATOR INTERFACE.
         Iterator i = set.iterator(); // RETURNS NULL/GARBAGE VALUE.
         while(i.hasNext()){ // CHECKS WHETHER A ITERATOR HAS NEXT ELEMENT(OBJECT).
            System.out.println(i.next()); // next() METHOD PRINTS THE NEXT ELEMENT OF ITERATOR AND ITERATES ON NEXT ELEMENT. 
         }


         System.out.println("USING FOREACH LOOP : ");
         // USING FOREACH-LOOP/ ADVANCED FORLOOP.
         for(String x : set){
            System.out.print(x + " ");
         }
    }
}
