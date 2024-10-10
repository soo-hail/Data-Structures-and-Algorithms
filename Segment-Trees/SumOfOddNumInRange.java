public class SumOfOddNumInRange {
    // Q. SUM OF ODD NUMBERS IN A RANGE.

    public static int buildST(int array[], int st[], int start, int end, int indx){

        if(start == end){ // LEAF-NODE(SMALLEST-PROBLEM)
            if(start == end){

                if(array[start]%2!=0){ // ODD CASE
                    return st[indx] = array[start];
                }

                return st[indx] = 0; // IF THE NUMBER IS EVEN THEN STORE ZERO AS IT'S SUM.
            }
        }

        int mid = (start+end)/2;
        int l = buildST(array, st, start, mid, 2*indx+1); // LEFT-SUBTREE.
        int r = buildST(array, st, mid+1, end, 2*indx+2); // RIGHT-SUBTREE.

        return st[indx] = l+r;
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8};

        // 1. CREATE SEGMENT-TREE(ARRAY) OF SIZE 4*N
        int n = array.length;
        int st[] = new int[4*n]; // EMPTY SEGMENT-TREE IS CREATED.

        System.out.println(buildST(array, st, 0, n-1, 0));

    }
}
