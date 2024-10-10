// PAIR SUM IN SORTED&ROTATED ARRAY.
import java.util.ArrayList;
public class PairSum {
    
    public static boolean getPair(ArrayList<Integer> list, int target){
        // FIND BREAKING(PIVOT) POINT.
        int pivot = 0;
        for(int i=0; i<=list.size()-2; i++){
            if(list.get(i)>list.get(i+1)){
                pivot = i;
                break;
            }
        }

        // POINTERS(REFRENCE VARIABLES) TO TRACK THE START AND END INDEXIS.
        int start = pivot+1;
        int end = pivot;

        while(start!=end){
            int sum = list.get(start) + list.get(end);

            if(sum == target){
                return true;
            }
            else if(sum<target){
                // if(start==list.size()-1){ // START-POINTER(REFRENCE VARIABLE) IS AT LAST INDEX.
                //     start=0;
                    
                // }else{
                //     start++;
                // }

                start=(start+1)%(list.size()); // (N-X)%N == N-X / N%N == 0.
                
            }
            else{ // SUM>TARGET.
                // if(end==0){ // END-POINTER
                //     end = list.size()-1;
                // }else{
                //     end--;    
                // }

                end = ((end-1)+list.size()) % list.size(); // (N+X)%N = X / (0)
                
            }
        }

        // WE HAVE TRAVERSED ALL THE ARRAYLIST BUT WE HAVE NOT FOUND PAIR, THEN RETURN "FALSE". 
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11); list.add(15); list.add(6); list.add(8); list.add(9); list.add(10);
        int target = 18;
        System.out.println(getPair(list, target));

    }
}
