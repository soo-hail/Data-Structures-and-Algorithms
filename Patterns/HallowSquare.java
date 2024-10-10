public class HallowSquare {
    public static void main(String[] args) {

        int n = 8;
        for(int i=1;i<=n;i++){ //NO.of rows 
            for(int j=1;j<=n;j++){ //No.of col
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*" + " ");
                }else{
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }
}
