public class SpiralMatrix {
    
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                          {4,5,6},
                           {7,8,9}}; //EACH ROW OF MATRIX IS TREATRED AS A LINEAR ARRAY.

        int startrow = 0;
        int endrow = matrix.length - 1;
        int startcol = 0;
        int endcol = matrix[0].length - 1;

        //NOTE : 
        //if startrow>endrow OR startcol>endCol(any one condition is true)it means elements are repeating.

        while(startrow <= endrow && startcol<=endcol){
            //TOP : row is fixed but col is changing
            for(int j=startcol;j<=endcol;j++){
                System.out.print(matrix[startrow][j] + " ");
            }
            startrow++;

            //RIGHT : col is fixed but row is changing.
            for(int i=startrow;i<=endrow;i++){
                System.out.print(matrix[i][endcol] + " ");
            }
            endcol--;

            //BOTTOM : row is fixed but col is changing.
            for(int i=endcol;i>=startcol && startrow<=endrow;i--){
                System.out.print(matrix[endrow][i] + " ");
            }
            endrow--;

            //LEFT : col is fixed but row is changing.
            for(int i=endrow;i>=startrow && startcol<=endcol;i--){
                System.out.print(matrix[i][startcol] + " ");
            }
            startcol++;

        }
    }
}
