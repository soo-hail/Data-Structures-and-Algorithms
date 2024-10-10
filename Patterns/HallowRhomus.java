public class HallowRhomus {
    
    public static void main(String[] args) {
        
        int n = 5;

        for(int row=1;row<=n;row++){
            //SPACE.
            for(int i=1;i<=n-row;i++){
                System.out.print(" ");
            }

            //STAR.
            for(int i=1;i<=n;i++){
                if(i==1 || i==n || row==1 || row==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
