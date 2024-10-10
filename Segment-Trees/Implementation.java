public class Implementation {

    // SEGMENT_TREES : ARE FULL BINARY-TREES WHICH IS USED TO STORE SPECIAL INFORMATION OF ANY INTERVAL(RANGE).
    
    // BUILD_SEGMENT_TREE() : 
    // SEGMENT-TREES ARE IMPLEMENTED USING ARRAY(TREE[]) "SAME AS HEAP". BUT VISUALIZED AS TREE.
    // AT EVERY LEVEL PROBLEM(RANGE/INTERVAL) IS DIVIDED INTO TWO SMALLER-EQUAL PARTS I.E (LEFT AND RIGHT).
    // NOTE : LEFT-CHILD == 2*I+1 AND RIGHT-CHILD == 2*I+2
    public static int buildST(int array[], int tree[], int indx, int start, int end){

        // BASE-CASE
        if(start == end){ // SMALLEST PROBLEM(LEAF-NODES ARE BEING CREATED).
            return tree[indx] = array[start]; // SINCE THERE IS ONLY ONE-ELEMENT.
        }

        // DIVIDE THE RANGE IN SMALLER PARTS.
        int mid = (start+end)/2; // FIND MIDDLE OF THE RANGE.

        // NOTE : LEFT-CHILD == 2*I+1 AND RIGHT-CHILD == 2*I+2
        int leftSum = buildST(array, tree, 2*indx+1, start, mid); // CALL FOR LEFT-SUBTREE.
        int rightSum = buildST(array, tree, 2*indx+2, mid+1, end); // CALL FOR RIGHT-SUBTREE.

        return tree[indx] = leftSum + rightSum; // SUM OF TWO SMALL-EQUAL RANGES IS STORED IN CURRENT-INDEX OF SEGMENT-TREE.
    }
    public static void main(String[] args) {
        int array[] = {1,2};
        int n = array.length;
        
        // 1. CREATE A ARRAY[SEGMENT-TREE] OF SIZE "4*N"
        int tree[] = new int[4*n];

        System.out.println(buildST(array, tree, 0, 0, array.length-1));
    }    
}