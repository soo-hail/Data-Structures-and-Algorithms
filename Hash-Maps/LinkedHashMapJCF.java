import java.util.LinkedHashMap;
public class LinkedHashMapJCF {
    // LINKED-HASHMAP IS TYPE OF HASHMAP WHERE INSERTION ORDER IS MAINTAINED.
    // LINKED-HASHMAP IS IMPLEMENTED USING ARRAY OF DOUBLY-LINKEDLIST. 
    public static void main(String[] args) {
        // DECLARATION.
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("India",130);
        map.put("China",150);
        map.put("US",90);
        map.put("Nepal",5);

        System.out.println(map);
    }
}
