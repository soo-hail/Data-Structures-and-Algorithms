public class NQueen {

    static int count = 0; // TO COUNT NUMBER OF WAYS FOR ARRANGING QUEENS.S
    public static void printBoard(char board[][]){
        int n = board.length; // ROWS.
        int m = board[0].length; // COLUMNS.
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println(); // NEXT LINE AFTER COMPLETING A ROW.
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        int n = board.length-1; // NUMBER OF ROWS.
        int m = board[0].length-1; // NUMBER OF COLUMNS.

        // HORIZONTAL-LEFT.
        for(int i = col-1; i>=0; i--){
            if(board[row][i] == 'Q'){ // ROW IS CONSTAANT. 
                return false;
            }
        }

        // HORIZONTAL-RIGHT.
            // "WE DONT HAVE TO CHECK HORIZONTAL-RIGHT SIDE " BECAUSE THERE ARE NO QUEEN AT RIGHT SIDE.

        // VERTICAL-UP/DOWN.
            // "WE DONT HAVE TO CHECK VERTICALLY" BECAUSE IN SINGLE COLUMN A SINGLE QUEEN IS BEEN PLACED.
     

        // TOP-LEFT.
        for(int i=row-1, j=col-1; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
               return false; 
            }
        }   

        // TOP-RIGHT.
            // "WE DONT HAVE TO CHECK TOP-RIGHT SIDE " BECAUSE THERE ARE NO QUEEN AT RIGHT SIDE.

        // BOTTOM-LEFT.
        for(int i=row+1, j = col-1; i<=n && j>=0; i++,j--){
            if(board[i][j] == 'Q'){
               return false; 
            }
        }

        // BOTTOM-RIGHT.
            // "WE DONT HAVE TO CHECK HORIZONTAL-RIGHT SIDE " BECAUSE THERE ARE NO QUEEN AT RIGHT SIDE.

        return true;
    }

    public static void nQueen(char board[][],int col){
        // BASE-CASE.
        if(col == board[0].length){
            printBoard(board);
            System.out.println();
            count++;
            return;
        }

        for(int row=0; row<board.length; row++){ // TO TRACK ROWS OF A BOARD.
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                nQueen(board, col + 1); // CALL FOR NEXT COLUMNS.  
                board[row][col] = '*'; // WHEN WE BACKTRACK REMOVE THE "Q" FROM CURRENT INDEX.
            }

        }
    }


    // PRINT ONE SOLUTION.
    public static boolean isExist(char board[][],int col){
        // BASE-CASE.
        if(col == board[0].length){
            return true; // IF ONE SOLUTION EXIST WE RETURN TRUE FROM ALL CALL STACKS.
        }

        for(int row=0; row<board.length; row++){ // TO TRACK ROWS OF A BOARD.
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                if(isExist(board, col + 1)){ // RECURCIVE CALL FOR NEXT COLUMN.
                    // IF ONE SOLUTION IS EXIST. WE RETURN FROM HERE(NO NEED BACKTRACK AGAIN).
                    return true;
                } 
                board[row][col] = '*'; // WHEN WE BACKTRACK REMOVE THE "Q" FROM CURRENT INDEX.
            }
        }// END FOR-LOOP.
        // IF QUEEN IS NOT SAFE AT ALL ROW. RETURN FALSE.
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        char chessBoard[][] = new char[n][n];

        // INITIALIZING CHESSBOARD.
        for(int row=0; row<chessBoard.length; row++){
            for(int col=0 ; col<chessBoard[0].length; col++){
                chessBoard[row][col] = '*';
            }
        }

        //CALLING "N-QUEEN" FUNCTION.
        // nQueen(chessBoard, 0);
        // System.out.println("TOTAL WAYS : " + count); // COUNT WAYS.

        // PRINT ONLY ONE SOLUTION.
        if(isExist(chessBoard, 0)){
            printBoard(chessBoard);
        }else{
            System.out.println("SOLUTION DOES NOT EXIST!!");
        }


    }
}
