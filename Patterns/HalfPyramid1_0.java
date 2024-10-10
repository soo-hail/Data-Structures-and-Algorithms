public class HalfPyramid1_0 {
    public static void main(String[] args) {
        int n=5;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2 == 0){ //i+j==even ---> 1
                    System.out.print("1" + " ");
                }else{
                    System.out.print("0" + " ");
                }
            }//end innerLoop.
            System.out.println();
        }//End outerLoop.
    }
}
