import java.util.*;
public class MaxMinSumOfSubarray {

    //BRUTE FORCE 
    public static int getMaxBruteForce(int array[]){
        int max = Integer.MIN_VALUE;
        //FOR START.
        for(int start=0;start<array.length;start++){
            //FOR END.
            for(int end=start;end<array.length;end++){
                int sum = 0;
                for(int count = start; count<=end;count++){
                    sum += array[count];
                }
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }//END GETMAX.

    //GET MINSUM.
    public static int getMinBruteForce(int array[]){
        int min = Integer.MAX_VALUE; //MAXIMUM VALUE IN INTEGERS.
        //FOR START.
        for(int start = 0;start<array.length;start++){
            //FOR END.
            for(int end=start;end<array.length;end++){
                int sum=0;
                for(int count=start;count<=end;count++){
                    sum+=array[count];
                }
                if(sum < min){
                    min = sum;
                }
            }
        }
        return min;
    }//END MINSUM. 
/* -------------------------------------------------------------------------------------------------------------------------*/
    //PREFIX METHOD.
    public static int getMaxPrefix(int array[]){
        int prefix[] = new int[array.length]; //PREFIX ARRAY.
        int maxSum = Integer.MIN_VALUE; //SMALLEST INTEGER VALUE.

        //STORING SUM.
        prefix[0] = array[0]; 
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + array[i];
        }//END FORLOOP.

        //GETTING SUM;
        for(int start=0;start<prefix.length;start++){
            int currsum = 0;
            for(int end=start;end<array.length;end++){
                currsum = start == 0? prefix[end] : prefix[end]-prefix[start-1];

                if(currsum > maxSum){
                    maxSum = currsum;
                }
            }//END INNER FORLOOP.
        }//END OUTER FORLOOP.
        return maxSum;
    }//END PREFIX METHOD.

/*-------------------------------------------------------------------------------------------------------------------------------------------- */
    //KADANE'S ALGORITHM.

    public static boolean isNegitive(int array[]){
        for(int var : array){
            if(var > 0){
                return false;
            }
        }
        return true;
    }


    public static int getMaxKadanes(int array[]){
        int maxSum = Integer.MIN_VALUE;
        int currsum = 0;

        if(isNegitive(array)){
            for(int var : array){
                maxSum = Math.max(maxSum, var);
            }
            return maxSum;
        }
        
        for(int i=0;i<array.length;i++){
            currsum+=array[i];

            if(currsum<0){
                currsum = 0;
            }

            maxSum = Math.max(maxSum, currsum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("MAXIMUN :" + getMaxKadanes(arr));
        System.out.println("MINIMUM : " + getMinBruteForce(arr));
        
    }
}
