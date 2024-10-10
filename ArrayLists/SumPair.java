import java.util.ArrayList;
public class SumPair {
    //brute force.
    // public static int getTarget(ArrayList<Integer> list, int target){
    //     for(int start = 0; start<list.size()-1;start++){
    //         for(int end=start+1;end<list.size();end++){
    //             int sum = list.get(start) + list.get(end); 
    //             if(sum == target){
    //                 return start;
    //             }
    //         }
    //     }//end outer forLoop.
    //     return -1;
    // }

    // BRUTE-FORCE APPROACH.
    // public static boolean getPair(ArrayList<Integer> list, int target){

    //     for(int start=0; start<=list.size()-2; start++){
    //         for(int end=start+1; end<list.size(); end++){
    //             if((list.get(start)+list.get(end)) == target){
    //                 return true;
    //             }
    //         }
    //     }

    //     // WE HAVE FOUND SUM OF ALL PAIRS BUT TARGET-SUM IS NOT FOUND.
    //     return false;
    // }

    // TWO-POINTER APPROACH.
    public static boolean getPair(ArrayList<Integer> list, int target){
        int start=0, end=list.size()-1;

        while(start<end){
            // CHECK SUM WITH TARGET.
            int sum = list.get(start)+list.get(end);
            if(sum == target){
                return true;
            }

            else if(sum<target){
                start++; // WE GET LARGE SUM VALUE WHEN WE INCREMENT START.
            }else{
                end--; //  WE GET SMALL SUM VALUE WHEN WE DECREMENT END.
            }
        }// END WHILE-LOOP.
        return false; 
    }
    

    //2-Pointer approch
    // public static int getTarget(ArrayList<Integer> list, int target){
    //     int start = 0;
    //     int end = list.size() -1 ;
    //     while(start<end){
    //         int sum = list.get(start) + list.get(end);
    //         if(sum == target){
    //             return start;
    //         }

    //         if(target<sum){
    //             end--; //if we increment start then value of sum will increase, but to decrease value we decrement end.
    //         }else{
    //             start++;
    //         }
    //     }
    //     return -1;
    // }

    //
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //list should be sorted.
        list.add(1); list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        int target = 11;

        // System.out.println(getTarget(list, target));
        System.out.println(getPair(list, target));
    }
}
