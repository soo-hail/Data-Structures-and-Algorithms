public class DiagonalSum {
    public static int diagonalSum(int matrix[][]){
        int pd = 0; //primary diagonal.
        int sd = 0; //secondry diagonal.
        int n = matrix.length;
       
        for(int i=0;i<n;i++){
            //primary diagonal sum.
            pd+=matrix[i][i]; //row == col.
            //secondry diagonal sum.
            int col = n-1-i;//row + col = n-1 ----> col = n-1-row.
            if(col != i){
                sd=sd+matrix[i][col];
            }
        }
       
        return pd+sd;

    }
    
    public static void main(String[] args) {
        int matrix[][] = {{0,1,2},
                          {3,4,5},
                          {6,7,8}};
    
       System.out.println(diagonalSum(matrix));
    }
}
