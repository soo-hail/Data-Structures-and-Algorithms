public class Triangle {
    public static void main(String[] args) {
        
        int n = 10;

        for(int i=1;i<=n;i++){ //NO. OF ROWS
            for(int j=1;j<=n-i;j++){//SPACE.
                System.out.print(" " );
            }

            for(int k=1;k<=i;k++){//STARS
                System.out.print("*" + " ");
            }

            System.out.println();
        }
    }
}
