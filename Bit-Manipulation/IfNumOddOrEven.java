public class IfNumOddOrEven {
    public static boolean checkNum(int n){
        int x = (n&1); 
        if(x == 0){
            System.out.println("EVEN NUMBER");
            return true;
        }

        System.out.println("ODD NUMBER ");
        return false;
    }

    public static void main(String[] args) {
        /* IF NUMBER IS EVEN : LSB WILL BE "0"
         * IF NUMBER IS ODD : LSB WILL BE "1"
         * SO, WE USE (N&1) TO DETERMINE LSB. IF LBB == 1 ---> (1)DECIMAL. IF LSB == 0 --->(0)DECIMAL.
         */

        checkNum(123);
    }
}
