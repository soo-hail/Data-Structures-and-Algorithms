public class PowerFunction {
    
    public static int pow(int n, int p){
        if(p == 0){
            return 1;
        }

        return n * pow(n, p - 1);
    }

    // OPTIMIZED.
    public static int pow2(int n, int p){

        if(p == 0){
            return 1;
        }

        if(p==1){
            return n;
        }

        return pow2(n, p/2) * pow2(n, p - (p/2));
    }
    public static void main(String[] args) {
        System.out.println(pow(3, 4));
        System.out.println(pow2(7, 3));
    }
}
