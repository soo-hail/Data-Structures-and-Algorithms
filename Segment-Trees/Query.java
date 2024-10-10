public class Query {
    
    // BUILD SEGMENT-TREE() ---> METHOD-2
    public static void buildST(int array[], int st[], int start, int end, int indx){
        if(start == end){ // LEAF-NODE(SMALLEST-PROBLEM)
            st[indx] = array[start];
            return;
        }

        int mid = (start+end)/2;
        buildST(array, st, start, mid, 2*indx+1); // LEFT-SUBTREE(SMALLER-PROBLEM)
        buildST(array, st, mid+1, end, 2*indx+2); // RIGHT SUB-PROBLEM.

        st[indx] = st[2*indx+1] + st[2*indx+2]; // WE DON'T NEED TO RETURN ANY VALUE SINCE WE ARE DIRECTLY STORING VALIR IN SEGEMNT DUREING BASE-CONSITION(LEAF-NODE).
    }
    
    // Q. QUERY ON SEGMENT-TREE(GET SPECIAL-INFO FOR GIVEN RANGE "I TO J").

    // HERE WE TRY TO GET SUM OF SUB-ARRAY OF ANY RANGE.
    // LOGIC/APPROACH : WE TRAVELL WHOLE SEGMENT-TREE, AND TRY TO FIND SOLUTION FOR QUERY BY ADDING SMALLER-PROBLENS PRESENT IN SEGMENT-TREE.
    public static int getSum(int st[], int indx, int si, int sj, int i, int j){
        // "I AND J" ARE RANGE OF GIVEN QUERY.

        // NOTE : SOLUTION FOR "GIVEN-RANGE I AND J" IS EXIST IN SEGMENT-TREE AT DIFFERENT-NODES(I.E. SMALLER PROBLEMS)

        if(j<=si || i>=sj){ // NON-OVERLAPPING SOLUTIONS("I AND J ARE NOT OVERLAPPING WITH SI AND SJ")
            return 0; // GIVEN QUERY DOES NOT EXIST IN THIS RANGE(SO EXIST FROM NO NEED TO SEARCH IN SUB-PROBLEMS FROM THERE BECAUSE ALL SUB-PROBLEMS ARE EXIST IN CURRENT-RANGE ONLY)
        }
        else if(si>=i && sj<=j){ // RANGE-OF CURRENT-NODE IS COMPLETLY PRESENTS(OVERLAPS) IN GIVEN QUERY.
            return st[indx]; // INCLUDE IT'S "SUM"
        }
        else{ // PARTIALLY OVERLAPPING
            // SINCE SOME-PART(SMALLER-PROBLEM) OF SEGMENT-TREE IS PARTIALLY-OVERLAPPING WITH GIVEN QUERY. SO, WE SEARCH IN SUB-PROBLEMS OF CURRENT-RANGE OF SEGMENT-TREE. BECAUSE SUB-PROBLEMS OF CURRENT-RANGE WILL COME IN GIVEN QUERY.
            int mid = (si+sj)/2;
            int l = getSum(st, 2*indx+1, si, mid, i, j); // SEARCH IN LEFT SUB-PROBLEM.
            int r = getSum(st, 2*indx+2, mid+1, sj, i, j); // SEARCH IN RIGHT SUB-PROBLEM.

            return l+r; // ANY-ONE WILL RETURN "SUM" OTHER WILL RETURN ZERO.
        }
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8};

        int st[] = new int[4*array.length]; // CREATE EMPTY SEGEMNT-TREE(ARRAY)

        // BUILD SEGMENT-TREE()
        buildST(array, st, 0, array.length-1, 0);

        int i = 2; int j = 5;

        System.out.println(st[4]);
        System.out.println(st[5]);
        // NOTE : TOTAL NUMBER OF NODES IN SEGMENT-TREE IS 2*N-1
        System.out.println(getSum(st, 0, 0, array.length-1, i, j));
        
    }
}
