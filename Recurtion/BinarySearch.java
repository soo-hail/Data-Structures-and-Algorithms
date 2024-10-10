public class BinarySearch {
    public static void binarySearch(int array[],int key, int start, int end){
        if(start > end){
            System.out.println("ELEMENT NOT FOUND!!");
            return;
        }

        int mid = (start+end)/2;
        if(key == array[mid]){
            System.out.println(mid);
        }
        else if(key > array[mid]){
            binarySearch(array, key, mid + 1, end);
        }
        else{
            binarySearch(array, key, start, mid -1 );
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60};
        int n = arr.length -1 ;
        binarySearch(arr, 12, 0, n);
    }
}
