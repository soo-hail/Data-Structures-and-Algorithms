import java.util.Arrays;
public class MinAbsoluteDifferencePairs {
    
    public static void main(String[] args) {
        int a[] = {4,1,8,7};
        int b[] = {2,3,6,5};

        //SORTING TWO ARRAYS IN ACCENDING ORDER.
        Arrays.sort(a);
        Arrays.sort(b);

        int diff = 0; //SUM OF DIFFERENCE OF PAIRS.
        System.out.print("ABSOLUTE DIFFERENCE PAIRS : ");
        for(int i=0;i<a.length;i++){
            // CALCULATING SUM OF ABSOLUTE DIFFERENCE OF ALL PAIRS.
            diff += Math.abs(a[i]-b[i]); // TERNARY OPERATOE IS USED. IF DIFFERENCE IS NEGITIVE THEN, THAT DIFFERENCE IS CONVERTED TO POSITIVE.
            
            System.out.print("("+ a[i]+","+b[i]+")"); // PRINTING PAIRS.
        }
        System.out.println();

        System.out.println("MIN ABSOLUTE DIFFERENCE OF PAIRS : " + diff);
    }
}
