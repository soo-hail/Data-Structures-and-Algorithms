public class BinaryString {
    
    // TO PRINT BINARY STRING WITHOUT CONSEGITIVE 1's OF SIZE "N".
    public static void printBinaryStrings(StringBuilder sb, int n, int lastPlace){
        if(n == 0){
            System.out.println(sb);
            return;
        }

        printBinaryStrings(sb.append('0'), n-1, 0); // WE ARE ADDING "0" AT LAST PLACE OF A STRING-BUILDER. SO, FOR NEXT PLACE "0" WILL BECOME LAST-PLACE.
        sb.deleteCharAt(sb.length() -1 ); // DELECT LAST CHAR BEFORE ADDING OTHER CHAR.
        
        if(lastPlace == 0){
            printBinaryStrings(sb.append('1'), n-1, 1);
            sb.deleteCharAt(sb.length() -1 ); // DELECT LAST CHAR BEFORE ADDING OTHER CHAR.
        }
    }
    public static void main(String[] args) {
        printBinaryStrings(new StringBuilder(""), 3, 0);
    }
}
