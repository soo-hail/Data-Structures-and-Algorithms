public class Problems {
    public static boolean isPowerOf2(int n){
        // IF N == 2^x ---> N&(N-1) == 0.
        return (n&(n-1)) == 0;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n!=0){
            if((n&1) == 1){ // CHECKING "LSB".
                count++;
            }
            n = (n>>1); // SHIFTING BITS OF N , ONE BY ONE SO THAT WE COULD CHECK "LSB".
        }
        return count;
    }
    public static void main(String[] args) {
            System.out.println(countSetBits(15));
    }
}
