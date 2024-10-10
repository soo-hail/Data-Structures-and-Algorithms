import java.util.Scanner;
public class CreatingMatrix{

    //LINEAR SEARCH.
    public static void linearSearch(int matrix[][], int key){
        int n = matrix.length; //return no.of rows.
        int m = matrix[0].length; //return no.of cols.
        for(int row =0;row<n;row++){
            for(int col=0;col<m;col++){
                if(matrix[row][col] == key){
                    System.out.print(key + " FOUND AT INDEX : ");
                    System.out.println("[" + row + ", " + col + "]");
                    return;
                }
            }
        }//end outter loop.
        System.out.println("ELEMENT NOT FOUND!!");
    }

    //LARGEST.
    public static int maxt(int matrix[][]){

        return -1;
    }

    //SMALLEST.
    public static int min(int matrix[][]){
        
        return -1;
    }

    public static void main(String[] args) {
        //DECLARATION.
        int matrix[][] = new int[3][3]; //[row][col]
        Scanner sc = new Scanner(System.in);
        int n = matrix.length; //RETURN NO.OF ROWS
        int m = matrix[0].length; //RETURN NO.OF COL
        System.out.println("ENTER ELEMENTS IN MATRIX : ");
        //INPUT MATRIX.
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                matrix[row][col] = sc.nextInt();
            }//end inner forLoop.
        }//end outter forLoop.

        //OUTPUT MATRIX.
        for(int row=0;row<n;row++){
            System.out.println();
            for(int col=0;col<m;col++){
                System.out.print(matrix[row][col] + " ");
            }
        }//end outter forLoop.


        System.out.println();
        System.out.println("ENTER ELEMENT TO BE SEARCHED : ");
        int key = sc.nextInt();
        linearSearch(matrix, key);
    }
}