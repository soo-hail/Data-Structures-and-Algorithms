// IF SOLUTION EXIST FOR SUDOKU. WE PRINT ONLY ONE SOLUTION.

public class Sudoku {
    
    public static boolean canPlace(int sudoku[][], int row, int col, int digit){ // TO CHECK A DIGIT CAN BE PLACED AT RESPECTIVE CELL. 

        // CHECK IN ROW.
        for(int i=0;i<9;i++){
            // IN SUDOKU[ROW][COL](CURRENT CELL) ZERO IS PRESENT.
            if(sudoku[row][i] == digit){ // IF DIGIT IS ALREADY PRESENT IN COLUMN.
                return false;
            }
        }

        // CHECK IN COLUMN.
        for(int i=0;i<9;i++){
            // IN SUDOKU[ROW][COL](CURRENT CELL) ZERO IS PRESENT.
            if(sudoku[i][col] == digit){ // IF DIGIT IS ALREADY PRESENT IN COLUMN.
                return false;
            }
        }

        // CHECK IN SUB-GRID.



        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col){

        if(row == 9){ // FOR ALL CELLS SOLUTION IS EXIST. SO WE CAME TO ROW == 9.
            return true; // IF ONE SOLUTION IS EXIST. WE RETURN FROM ALL CALL STACKS.
        }
        
        int nextRow = row, nextCol = col+1;
        if(nextCol == 9){ // WE ARE AT LAST-COLUMN OF A ROW. BECAUSE INDEX OF NEXT-COLUMN IS 8.
            nextRow = row+1;
            nextCol = 0; 
        }

        if (sudoku[row][col] != 0){ // FIXED POSITIONS.
            // WE CAN'T CHANGE THE NON-ZERO VALUE(FIXED POSITION).
            return sudokuSolver(sudoku, nextRow, nextCol); // DIRECTLY GO FOR NEXT CELL.
        }

        // IF THE CELL CONTAIN ZERO.
        for(int digit=1; digit<=9; digit++){ // TO PLACE DIGITS FROM "1 TO 9" IN RESPECTIVE CELLS IF THEY ARE SAFE. 
            if(canPlace(sudoku, row, col, digit)){
                sudoku[row][col] = digit; // PLACING DIGIT IN SUDOKU.
                if(sudokuSolver(sudoku, nextRow, nextCol)){ // FUNCTION CALL FOR NEXT COLUMN AND ROW.
                     // IF ONE SOLUTION IS EXIST. WE RETURN FROM HERE(NO NEED BACKTRACK AGAIN).
                    return true;
                } 
                // IF SOLUTION IS NOT EXIST FOR NEXT CELLS.
                sudoku[row][col] = 0; // MAKE CURRENT CELL TO ZERO. BECAUSE WE MAY NEED TO BACKTRACK FROM THIS CELL ALSO(ONLY ZERO CONTAINING CELLS CAN BE USED.)
                // AGAIN FOR-LOOP RUNS FOR NEXT DIGIT. IF SOLUTION IS NOT EXIST AGAIN BACKTRACK.
            }
        }//END FOR-LOOP.
        return false; // IF SOLUTION IS NOT EXIST FOR THIS CELL. WE AGAIN BACKTRACK.
    }
    public static void main(String[] args) {
        int sudoku[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
    }
}
