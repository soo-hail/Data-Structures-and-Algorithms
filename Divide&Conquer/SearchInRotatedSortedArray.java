public class SearchInRotatedSortedArray {
    
    public static int search(int array[], int target, int start, int end){
        
        // FIND MID.
        int mid = start + (end-start)/2;

        if(mid<start || mid>end){ // INDEX OVERFLOW CONDITION.
            return -1;
        }

        if(array[mid] == target){ // ELEMENT FOUND CONDITION.
            return mid;
        }

        if(array[mid] >= array[start]){  // MID IS ON LEFT-SORTED-SUBARRAY. 
            // IF MID IS THERE ON LEFT-SORTED-SUBARRAY, CHECK WHETHER THE ELEMENT IS PRESENT IN LEFT-SORTED-SUBARRRAY.
            if(target >= array[start] && target < array[mid]){  // WE CAN TRACK RIGHT-SORTED-SUBARRAY USING END-INDEX ONLY. 
                // TARGET ELEMENT LIE BETWEEN "START AND MID-1"
                return search(array, target, start, mid-1);
            }else{ 
                // ELEMENT PRESENT BETWEEN "MID+1 AND END".
                return search(array, target, mid+1, end);
            }
        }else{ // MID IS ON RIGHT-SORTED-SUBARRAY.    
            // IF MID IS PRESENT ON RIGHT-SORTED-SUNARRAY, CHECK WHETHER THE LEMENT IS PRESENT IN RIGHT-SORTED-ARRAY.
            if(target<=array[end] && target > array[mid]){ // WE CAN TRACK RIGHT-SORTED-SUBARRAY USING END-INDEX ONLY.
                // SEARCH BETWEEN MID + 1 AND END.
                return search(array, target, mid+1, end);
            }else{
                // ELEMENT PRESENT BETWEEN "START AND MID-1".
                return search(array, target, start, mid-1);
            }
        }        
    }

    // USING ITERATION.
    public static int search2(int array[], int target, int start, int end){
        
        while(start<=end){
             // FIND MID.
            int mid = (start + end)/2;

            if(array[mid] == target){
                return mid;
            }

            if(array[mid] >= array[start]){ // CHECK WHETHER MID LIE ON LEFT-SORTED-SUBARRAY.
                if(target>=array[start] && target < array[mid]){  // TARGET MAY PRESENT IN ARRAY BETWEEN START AND MID.
                    //  SEARCH IN SMALL PART OF ARRAY.
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{  //MID LIE ON RIGHT-SORTED-SUBARRAY.
                if(target>array[mid] && target <= array[end]){ //TARGET MAY PRESENT IN ARRAY BETWEEN MID AND END.
                    //  SEARCH IN SMALL PART OF ARRAY.
                    start = mid +1 ;
                }else{
                    end = mid - 1;
                }

            }

        } // END FOR-LOOP.

        return -1;
    }

    public static void main(String[] args) {
        int array[] = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search(array, target, 0, array.length-1));
        System.out.println(search2(array, target, 0, array.length-1));
        
    }
}
