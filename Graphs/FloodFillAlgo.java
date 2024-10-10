public class FloodFillAlgo {
    
    public static boolean isSafe(int image[][], int row, int col){
        return row>=0 && row<image.length && col >=0 && col < image[row].length; 
    }
    public static void floodFill(int image[][], boolean visited[][], int sr, int sc, int color){
        // SR ---> STARTING ROW
        // SC ---> STARTING COLOUM
        // COLOR ---> COLOUR TO BE FILLED.

        if(!isSafe(image, sr, sc) || image[sr][sc] != 1 || visited[sr][sc]){
            return; 
        }

        image[sr][sc] = 2; // FILL-COLOUR.
        visited[sr][sc] = true;

        // LEFT-SIDE.
        floodFill(image, visited, sr, sc-1, color);

        // RIGHT-SIDE.
        floodFill(image, visited, sr, sc+1, color);

        // UP-SIDE.
        floodFill(image, visited, sr-1, sc, color);

        // DOWN-SIDE.
        floodFill(image, visited, sr+1, sc, color);

        // UP-LEFT
        floodFill(image, visited, sr-1, sc-1, color);

        // UP-RIGHT
        floodFill(image, visited, sr-1, sc+1, color);

        // BOTTOM-LEFT
        floodFill(image, visited, sr+1, sc-1, color);

        // BOTTOM-RIGHT
        floodFill(image, visited, sr+1, sc+1, color);
    }

    public static void main(String[] args) {
        // Q. PERFORM A FLOOD-FILL ON IMAGE FROM STARTING-CELL IMAGE[1][1], REPLACE COLOUR-1 WITH COLOUR-2(REPLACE 1 WITH 2). 

        int image[][] = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        }; 

        floodFill(image, new boolean[image.length][image[0].length], 1, 1, 2);
    }
}
