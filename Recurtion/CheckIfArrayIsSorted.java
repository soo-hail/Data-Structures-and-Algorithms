public class CheckIfArrayIsSorted {
   public static boolean isSorted(int array[], int start){
        if(start == array.length-1){ // ALREADY LAST INDEX WAS CHECKED. IF WE REACH TO LAST INDEX IT MEANS ALL ELEMENTS ARE CHECKED. 
            return true;
        }

        // CHECKING IN ACENDING ORDER.
        if(array[start] > array[start+1]){
            return false;
        }

        return isSorted(array, start + 1);
   }
    public static void main(String[] args) {
        int array[] = {-145,-92,0,1,8};
        System.out.println(isSorted(array, 0));
    }
}
