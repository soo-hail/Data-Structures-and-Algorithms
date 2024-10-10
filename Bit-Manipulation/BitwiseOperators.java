public class BitwiseOperators {

    public static void main(String[] args) {
        // BIT-WISE "AND" : OUTPUT WILL BE TRUE ONLY WHEN 2 INPUTS ARE TRUE OTHER-WISE IN ALL CASES OUTPUT WILL BE FALSE.  
        System.out.println("AND(&) : " + (5 & 6));

        // BIR-WISE "OR" : OUTPUT WILL BE FALSE ONLY WHEN 2 INPUTS ARE FALSE OTHER-WISE IN ALL CASES OUTPUT WILL BE TRUE.
        System.out.println("OR(|): " + (5 | 6));

        // BINARY XOR(^) : WHEN 2 INPUTS ARE SAME OUTPUT FALSE. WHEN 2 INPUTS ARE DIFFERENT OUTPUT TRUE.
        System.out.println("XOR(^) : " + (5 ^ 6));

        System.out.println(~5); /* ~5 return "1010" in sout function "1010" MSB has 1 which means it is -ve number. 
        -ve numbers are represented in decimals using 2's complement of magnitude. 
        so 2's "1010" is "1110" in decimal it is -6 . And -6 is finally printed in console bar. */

        System.out.println("Left Shilf : " + (5<<2));

        System.out.println("Right Shift : " + (6>>1));
    }
} 