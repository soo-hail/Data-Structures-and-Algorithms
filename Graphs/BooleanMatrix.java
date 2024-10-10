public class BooleanMatrix {

    public static boolean isSafe(int matrix[][], int row, int col){
        return row>=0 && row<matrix.length && col>=0 && col<matrix[row].length;
    }

    public static int dfs(int matrix[][], int row, int col, int size){
        if(matrix[row][col] == 0 || matrix[row][col] == -1){
            return size;
        }

        matrix[row][col] = -1; // TO MARK AS VISITED(INCLUDED). 
        size = size+1;

        // TRAVELL-RIGHT-SIDE.
        if(isSafe(matrix, row, col-1)){
            size = dfs(matrix, row, col-1, size);
        }

        // TRAVELL-LEFT-SIDE.
        if(isSafe(matrix, row, col+1)){
            size = dfs(matrix, row, col+1, size); 
        }
        
        // TRAVELL BOTTOM.
        if(isSafe(matrix, row+1, col)){
            size = dfs(matrix, row+1, col, size);
        }

        // LEFT-BOTTOM.
        if(isSafe(matrix, row+1, col-1)){
            size = dfs(matrix, row+1, col-1, size);
        }

        // RIGHT-BOTTOM.
        if(isSafe(matrix, row+1, col+1)){
            size = dfs(matrix, row+1, col+1, size);
        }

        return size;  
    }
    
    public static int getBooleanMatrix(int matrix[][]){
        // RETURN SIZE OF LARGEST-FILLED-REGION IN MATRIX. 1 == FILLED, 0 == NOT-FILLED.
        int region = 0;

        // TRAVELL MATRIX.
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                if(matrix[row][col] == 1){
                    // "DFS"
                    region = Math.max(region, dfs(matrix, row, col, 0));
                }
            }
        }

        return region;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,0,1,1,0}, 
                          {0,0,1,1,0},
                          {0,1,0,0,0}, 
                          {0,0,1,1,1} };

        int x = getBooleanMatrix(matrix);
        System.out.println(x);

    }
}
