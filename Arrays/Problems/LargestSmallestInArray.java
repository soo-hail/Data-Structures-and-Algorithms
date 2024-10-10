import java.util.*;
public class LargestSmallestInArray { 

    public static int getLargest(int array[]){
        int large =Integer.MIN_VALUE; //lowest integer value.
        for(int var : array){
            if(var > large){
                large = var;
            }
        }//end forLoop
        return large;
    }

    public static int getSmallest(int array[]){
        int s = Integer.MAX_VALUE;
        for(int var : array){
            if(var < s){
                s = var;
            }
        }
        return s;
    }
    
    public static void main(String[] args) {

        int arr[] = {23,78,45,99,45,345,2130,542};

        System.out.println("LARGEST : " + getLargest(arr) );
        System.out.println("SMALLEST :" + getSmallest(arr));
        
    }
}
