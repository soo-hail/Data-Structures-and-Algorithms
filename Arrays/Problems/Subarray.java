
//LOGIC : SELECT 'START' AND 'END' INDEXES OF ARRAY AND PRINT ALL ELEMENTS FROM INDEX START TO END.
public class Subarray {

    public static void printSubarray(int array[]){
        //FOR START INDEX.
        for(int start = 0 ; start<array.length;start++){
            //FOR END INDEX.
            for(int end = start;end<array.length;end++){
                //FOR PRINTING ELEMENTS FROM INDEX 'START' TO 'END'.
                for(int count = start; count<=end; count++){
                    System.out.print(array[count] + " ");
                }
                System.out.print("|");
            }
        }
    }

    public static int getTotalSubarray(int array[]){
        int ts = 0; //TOTAL SUBARRAYS.
        //FOR START INDEX.
        for(int start = 0 ; start<array.length;start++){
            //FOR END INDEX.
            for(int end = start;end<array.length;end++){
               ts++;
            }
        }
        return ts;
    }

    
    public static void main(String[] args) {

        int array[]={2,4,6,8,10};

        System.out.println("TOTAL SUBARRAYS : " + getTotalSubarray(array));
        printSubarray(array);
        
    }
}
