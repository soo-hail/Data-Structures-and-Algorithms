public class ButterFlyPattern {

    public static void main(String[] args) {
        int n=5;
        //FIRST-HALF
        for(int row=1;row<=n;row++){ 
            for(int col=1;col<=2*n;col++){
                if(col<=row || col>(2*n)-row){
                    System.out.print("*" + " ");
                }else{
                    System.out.print(" " + " ");
                }
            }//end innerLoop
            System.out.println();
        }//end outerLoop 
        
        //SECOND-HALF
        for(int row=n;row>=1;row--){
            for(int col=1;col<=2*n;col++){
                if(col<=row || col>(2*n)-row){
                    System.out.print("*" + " ");
                }else{
                    System.out.print(" " + " ");
                }
            }//end innerLoop
            System.out.println();
        }
    }
}
