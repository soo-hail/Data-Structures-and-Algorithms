public class PairsInArray {

    public static void printPairs(int array[]){
        for(int i=0;i<array.length -1 /*ignore lastElement*/;i++){ 
            for(int j=i+1;j<array.length;j++){
                System.out.print("("+ array[i]+","+ array[j] +")" + " ");
            }
        }
    }

    public static int getTotalPairs(int array[]){
        int tp = 0; //initially
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                tp++;
            }
        }
        return tp;
    }
    public static void main(String[] args) {
        int array[] = {2,4,6,8,10};

        // System.out.println("TOTAL PAIRS : " + getTotalPairs(array));
        printPairs(array);
        
    }
}
