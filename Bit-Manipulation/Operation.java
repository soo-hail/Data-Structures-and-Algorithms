public class Operation {
    /* NOTE : POSITIONING OF BITS STARTS FROM "0" FROM LEFT TO RIGHT. */
    public static int getBit(int n, int pos){
        int bitmask = 1<<pos;
        int ans = (n&bitmask); // RETURN "0" IF BIT AT INDEX IS 0. OTHER-WISE IT WILL RETURN NON-ZERO VALUE.
        if(ans == 0){
            return 0;
        }
        return 1; // IF "ANS" IS NON-ZERO VALUE.
    }

    public static int setBit(int n, int pos){
        int bitmask = 1<<pos; // ALL DIGITS OF BITMASK ARE ZERO EXCEPT THE DIGIT AT POSITION.

        int ans = (n|bitmask); // BECAUSE 1|0 = 1 AND 1|1 = 1;

        return ans;
    }

    public static int clearBit(int n, int pos){
        int bitmask = 1<<pos;
        int ans = (n&~(bitmask)); // (b&~(bitmask)).
        return ans;
    }

    public static int updateBit1(int n, int pos, int updateVal){
        if(updateVal == 0){
            return clearBit(n, pos);
        }else{
            return setBit(n, pos);
        }
    }

    public static int updateBit2(int n, int pos, int updateVal){
        n = clearBit(n, pos); // FIRST CLEAR BIT AT GIVEN POSITION.
        // NOW THE BIT GIVEN AT POSITION OF A NUMBER IS ZERO. 

        int bitmask = updateVal<<pos; // IS UPDATEVALUE == 0, THEN BITMASK == 000000000000.
        // ALREADY THERE IS A ZERO BIT AT GIVEN POSITION.
        return n|bitmask; 
    }

    public static int clearLastIbits(int n, int i){
       int bitmask = (~0)<<i; // ~0 == (ALL 1'S). WE LEFT SHIFT (~0). SO THAT WE GET i-0'S AT LAST OF A BITMASK. 
       return n&bitmask;
    }

    public static int clearRangeOfBits(int n, int start, int end){
        int helper1 = (~0)<<end+1; 
        int helper2 = (int)Math.pow(2, start) -1 ; // TO GET 1'S AT RIGHT SIDE.
        // int helper2 = (1<<start) - 1; // (2^x) = (1<<x)
        int bitmask = helper1|helper2; // WE GOT A BITMASK WHICH HAS ZEROS B/T START AND END.

        int ans = n&bitmask;
        return ans;
    }
    public static void main(String[] args) {
        // // GET-BIT()
        // int bit = getBit(18, 0);
        // System.out.println(bit);

        // // SET-BIT()
        // int n = setBit(18, 2);
        // System.out.println(n);

        // // CLEAR-BIT()
        // int n2 = clearBit(18, 1);
        // System.out.println(n2);

        // //UPDATE BIT.
        // System.out.println("UPDATE BIT : ");
        // System.out.println(updateBit1(24,1, 0));
        // System.out.println(updateBit2(24, 1, 0));


        // // CLEAR LAST "i"-BITS
        // System.out.println(clearLastIbits(17, 2));


        // CLEAR RANGE OF BITS.
        System.out.println(clearRangeOfBits(2515, 2, 7));

    }
}
