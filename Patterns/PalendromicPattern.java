public class PalendromicPattern {
    
    public static void main(String[] args) {
        int n = 5;

        for(int row=1;row<=n;row++){
            //SPACE.
            for(int sp=1;sp<=(n-row);sp++){
                System.out.print(" " + " ");
            }
            //HALF-PYRAMID.
            for(int j=row;j>=1;j--){
                System.out.print(j + " " );
            }
            // SECOND HALF-PYRAMID.
            for(int i=2;i<=row;i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }//end forLoop.
    }
}
