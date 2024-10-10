public class HallowDiamond {
    
    public static void main(String[] args) {
        int n = 10;

        //HALF-PART.
        for(int row=1; row<=n;row++){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }
            //STAR.
            for(int i=1;i<=row;i++){
                if(i==1 || i==row){
                    System.out.print("*" + " ");
                }else{
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }//end outer forLoop.

        //SECOND-HALF.
        for(int row=n-1;row>=1;row--){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }
            //STAR.
            for(int i=1;i<=row;i++){
                if(i==1 || i==row){
                    System.out.print("*" + " ");
                }else{
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }
}
