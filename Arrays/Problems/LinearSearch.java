public class LinearSearch{
//LINEAR SEARCH IS A PROCESS TRAVERSING ALL THE ELEMENTS IN AN ARRAY IN A SEQUENTIAL MANNER.

    public static void linearSearch(int array[], int key){
        int flag = -1;
        for(int i = 0; i<array.length;i++){
            if(array[i] == key){
                System.out.print((i+1) + " ");
                flag++;
            }
        }//end forLoop.
        if(flag==-1){
            System.out.println("ELEMENT NOT FOUND!!");
        }
    } 
    public static void main(String[] args) {
        int array[] = {1,56,43,45,43,45,32,78};
        int key = 43;

        linearSearch(array, key);      
    }
}