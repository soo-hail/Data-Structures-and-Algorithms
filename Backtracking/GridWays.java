public class GridWays {
    public static int countGridWays(int grid[][], int row, int col){
        // AT EVERY CELL WE HAVE A CHOICE TO MOVE RIGHT OR DOWN.
            int count1 = 0;
            int count2 = 0;
        // BASE CASE.
        if(row == grid.length-1 && col == grid[0].length-1){ // REACHES TO DESTINATION.
            return 1;
        }

        if(col<=grid[0].length-2){ // WE CAN MOVE RIGHT, WHEN THERE ARE CELLS AT RIGHT SIDE.
            count1 = countGridWays(grid, row, col+1); // MOVE RIGHT SIDE.
        }   

        if(row<grid.length-1){ // WE CAN MOVE DOWN, WHEN THERE ARE CELLS AT BOTTOM.
            count2 = countGridWays(grid, row + 1, col); // MOVE DOWN.
        }

        return count1 + count2;
    }
    public static void main(String[] args) {
        System.out.println(countGridWays(new int [15][15], 0, 0));
    }
}
