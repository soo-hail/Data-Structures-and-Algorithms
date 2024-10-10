import java.util.Set;
import java.util.HashMap;
public class IterateOnHashMap {
    // WE USE "SET" AND "KEYSET()" TO TRAVERSE A HASHMAP.    

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("China", 150);
        map.put("India", 120);
        map.put("US", 90);
        map.put("Nepal", 5);

        Set<String> keys = map.keySet(); // KEYSET() METHOD RETURNS "SET OF ALL KEYS" IN A HASHMAP.

        // USING FOR-EACH LOOP WE TRAVERSE SET IN ORDER TO TRAVERSE A HASHMAP.
        for(String k : keys ){
            System.out.println(k + "," + map.get(k));
        }
    }
    
}
