import java.util.HashSet;
public class UnionAndIntersectionOfArrays {
    
    public static void main(String[] args) {
        int array1[] = {1,2,3,4,5,6};
        int array2[] = {9,8,7,6,5,4}; 

        HashSet<Integer> set = new HashSet<>(); // TO STORE UNION OF ARRAY1 AND ARRAY2.
        HashSet<Integer> set2 = new HashSet<>(); // TO STORE COMMON ELEMENS(INTERSECTION) OF ARRAY1 AND ARRAY2.
        
        // UNION : ELEMETS OF 2 ARRAYS ARE TAKEN AND DUPLICATE NUMBERS ARE TAKEN ONCE.
        // INTERSECTION : COMMON ELEMENTS AMONG 2 ARRAYS.
        for(int x : array1){ // FOR ARRAY-1
            set.add(x);
        }

        for(int x : array2){ // FOR ARRAY-2
            if(set.contains(x)){ // IF ELEMENT IS ALREADY PRESENT SET, WHICH MEANS THAT ELEMENT IS COMMON AMONG 2 ARRAYS.  
                set2.add(x);
            }
            else{
                set.add(x);
            }   
        }

        System.out.println("UNION : " + set);
        System.out.println("INTERSECTION : " + set2);

    }
}
