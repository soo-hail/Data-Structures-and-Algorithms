import java.util.HashSet;
public class CountDistinctEle {
    
    public static void main(String[] args) {
        int array[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<>(); // TO STORE UNIQUE ELEMENTS.
        // ADD ELEMETS OF ARRAY IN SET.
        for(int x : array){
            set.add(x);
        }
        System.out.println("TOTAL NUMBER OF ELEMENTS IN ARRAY : " + array.length);
        System.out.println("NUMBER OF DISTINCT ELEMENTS IN ARRAY : " + set.size());
    }
}