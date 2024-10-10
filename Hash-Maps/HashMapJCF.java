import java.util.*;
public class HashMapJCF {
    
    public static void main(String[] args) {
        // DECLARATION
        HashMap<String, Integer> map = new HashMap<>();

        // PUT() : TO ADD NEW KEY-VALUE PAIR IN HASHMAP.
        map.put("China", 150);
        map.put("India", 120);
        map.put("US",90);
        map.put("Iraq", 20);

        System.out.println(map);

        map.put("India", 130); // WHEN WE WANT TO ADD SAME KEY THAT IS ALREADY EXIST IN HASHMAP. 
        // THEN ONLY VALUE OF THAT PAIR IS OVER-WRITTEN.
        System.out.println(map);

        // REMOVE() : TO REMOVE KEY-VALUE PAIR OF HASHMAP BASED ON "KEY". AND RETURNS "VALUE" OF KEY-VALUE PAIR.
        System.out.println(map.remove("US"));
        System.out.println(map.remove("Nepal")); // IF KEY IS NOT EXIST IN HASH-MAP THEN IT WILL RETURN "NULL".

        System.out.println(map);

        //GET() : TO GET "VALUE" OF KEY-VALUE PAIR BASED ON KEY.
        System.out.println("POPULATION OF IRAQ : " + map.get("Iraq"));
        // NOTE : 
        // IF KEY IS NOT EXIST IN HASHMAP THAN "NULL" WILL BE RETURNED.
        System.out.println(map.get("Nepal")); 

        // CONTAINSKEY() : CHECKS WHETHER KEY IN PRESENT IN HASHMAP. RETURNS BOOLEAN VALUE.
        System.out.println(map.containsKey("India")); 
        System.out.println(map.containsKey("Nepal"));

        // ENTRYSET() : RETURNS SET OF ALL KEY-VALUE PAIRS OF A HASHMAP.
        System.out.println(map.entrySet()); 

        // CLEAR() : TO REMOVE ALL ELEMENTS FROM HASHMAP.
        map.clear();

        System.out.println(map); 
    }
}
