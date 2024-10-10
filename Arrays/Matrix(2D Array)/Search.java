public class Search {
    public static boolean stairCase(int matrix[][], int key){

        int row = 0, col = matrix[0].length-1;

        while(row<matrix.length && col>=0){
            if(matrix[row][col] == key){
                System.out.println("(" + row +"," + col + ")");
                return true;
            }else if(key > matrix[row][col]){
                row++;
            }else{ // key<matrix[row][col]
                col--;
            }
        }//end whileLOOP

        System.out.println("ELEMENT NOT FOUND!!");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,47},{32,33,47,50}};
       stairCase(matrix, 50);
    }
}
