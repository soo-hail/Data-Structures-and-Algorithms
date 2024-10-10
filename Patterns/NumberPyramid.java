public class NumberPyramid {
    
    public static void main(String[] args) {
        int n = 9;
        for(int row=1;row<=n;row++){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }
            //STAR.
            for(int i=1;i<=row;i++){
                System.out.print(row + " ");
            }
            System.out.println();
        }//end outer forLoop.
    }
}
