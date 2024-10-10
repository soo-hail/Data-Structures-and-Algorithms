public class BinarySearch {

    public static int bs(int array[], int key){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(array[mid] == key){
                return mid + 1;
            }else if(key < array[mid]){
                end = mid-1;
            }else{ //key > array[mid] 
                start = mid+1;
            }
        }//end forLoop.

        return -1;
    }
    
    public static void main(String[] args) {

        int arr[] = {4,7,27,32,78,89,99,102};
        int key = 32;
        System.out.println(bs(arr, key));
        
    }
}
