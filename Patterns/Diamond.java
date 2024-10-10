public class Diamond {
    
    public static void main(String[] args) {
        int n = 5;

        //HALF-PART.
        for(int row=1; row<=n;row++){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }
            //STAR.
            for(int i=1;i<=row;i++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }//end outer forLoop.

        //SECOND-HALF.
        for(int row=n;row>=1;row--){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }
            //STAR.
            for(int i=1;i<=row;i++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
