import java.util.LinkedList;
import java.util.Queue;

public class RotOranges {

    static class Index{
        int row; int col;

        Index(int i, int j){
            this.row = i;
            this.col = j;
        }
    }

    public static boolean isSafe(int matrix[][], int i, int j){
        return i>=0 && i < matrix.length && j>=0 && j < matrix[0].length;
    }
    
    public static int getTime(int matrix[][]){
        Queue<Index> q = new LinkedList<>(); 
        int t = 0; // TIME GAVEN TO ROT-ALL ORANGES.
        int rottedOrange = 0; // TO COUNT NO.OF ROTTED-ORANGES.
        int freshOrange = 0;

        // FIND INITIAL ROTTED-ORANGES. 
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){

                if(matrix[row][col] == 1){
                    freshOrange++;
                }

                if(matrix[row][col] == 2){
                    q.add(new Index(row, col)); // ADD INDEX OF ROTTED-ORANGES IN QUEUE.
                }
            }
        }

        // START-"BFS"
        while(!q.isEmpty()){
            boolean isRotted = false; // TO CHECK-WHETHER ANY ORANGE GET ROTTED IN THIS ITERATION.
            int size = q.size();

            for(int i=1; i<=size; i++){ // ROT ALL THE ORANGES, WHICH ARE AROUND THE ROTTED-ORANGES IN QUEUE. 
                Index curr = q.remove();
                int row = curr.row; 
                int col = curr.col;

                if(isSafe(matrix, row, col-1) && matrix[row][col-1] == 1){
                    matrix[row][col-1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row, col-1)); 
                }

                if(isSafe(matrix, row, col+1) && matrix[row][col+1] == 1){
                    matrix[row][col+1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row, col+1)); 
                }

                if(isSafe(matrix, row-1, col) && matrix[row-1][col] == 1){
                    matrix[row-1][col] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row-1, col)); 
                }

                if(isSafe(matrix, row+1, col) && matrix[row+1][col] == 1){
                    matrix[row+1][col] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row+1, col)); 
                }

                if(isSafe(matrix, row-1, col-1) && matrix[row-1][col-1] == 1){
                    matrix[row-1][col-1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row-1, col-1)); 
                }

                if(isSafe(matrix, row-1, col+1) && matrix[row-1][col+1] == 1){
                    matrix[row-1][col+1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row-1, col+1)); 
                }

                if(isSafe(matrix, row-1, col+1) && matrix[row-1][col+1] == 1){
                    matrix[row-1][col+1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row-1, col+1)); 
                }

                if(isSafe(matrix, row+1, col-1) && matrix[row+1][col-1] == 1){
                    matrix[row+1][col-1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row+1, col-1)); 
                }

                if(isSafe(matrix, row+1, col+1) && matrix[row+1][col+1] == 1){
                    matrix[row+1][col+1] = 2;
                    rottedOrange++; isRotted = true;
                    q.add(new Index(row+1, col+1)); 
                }
            }// end forLoop.

            if(isRotted ==  false){
                break; 
            }

            t++; 
        }

        return rottedOrange == freshOrange? t : -1;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2,1,0,2,1},
                          {1,0,1,2,1},
                          {1,0,0,2,1}};

        int time = getTime(matrix);
        System.out.println(time);

        for(int row=0; row<3; row++){
            for(int col=0; col<5; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
