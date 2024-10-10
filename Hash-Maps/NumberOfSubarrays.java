public class NumberOfSubarrays {

    public static int getCount(int array[], int k){
        int sum = 0; int count = 0; int indx = 0; int i = indx;

        while(i < array.length){
            sum += array[i];
            // System.out.println(sum);

            if(sum == k){
                count++;
            }

            if((i != array.length-1) && (sum >= k)){
                indx++;
                sum = 0;
                i = indx;
            }else{
                i++;
            }
        }// end whileLoop.

        return count;
    }

    public static void main(String[] args) {
        int array[] = {2,4,3,5,1,8,1,7,1};
        int k = 9;

        System.out.println(getCount(array, k));
        
    }    
}