import java.util.ArrayList;
import java.util.Collections;
public class Sort {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(-22);
        list.add(47);
        list.add(24);
        list.add(11);

        Collections.sort(list); //sort accending order.
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder()); //sort decending order.
        //Comparator is a function to sort objects.
        System.out.println(list);
    }
}
