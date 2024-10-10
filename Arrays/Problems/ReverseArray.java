public class ReverseArray {

    public static void reverse1(int array[]){
        int n = array.length - 1; //lastIndex.
        for(int i=0;i<n/2;i++){
            //SWAP
           int temp = array[i];
           array[i] = array[n-i];
           array[n-i] = temp;
        }
    }

    public static void reverse2(int array[]){
        int first = 0; //first index
        int last = array.length -1; //last index
        while(first < last){ //we don't write first<=last. Because first=last is swaping same number.
            int temp  = array[first];
            array[first] = array[last];
            array[last] = temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};

        reverse2(arr);

        for(int var : arr){
            System.out.print(var + " ");
        }
    }
}
