import java.util.TreeMap;
public class TreeMapJCF {
    // TREEMAP IS TYPE OF MAP WHERE KEYS ARE SORTED.
    // TREEMAPS ARE IMPLEMENTED USING "RED-BLACK-TREE" WHICH IS "SELF BALANCING TREE". 
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("India",130);
        map.put("China",150);
        map.put("US",90);
        map.put("Nepal",5);

        System.out.println(map);
    }
}
