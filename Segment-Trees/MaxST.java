public class MaxST {
    
    // BUILD-SEGMENT-TREE()
    public static void buildST(int array[], int st[], int start, int end, int indx){

        if(start == end){ // LEAF-NODE(BASE-CASE(SMALLEST-PROBLEM))
            st[indx] = array[start];
            return;
        }

        int mid = (start+end)/2;
        buildST(array, st, start, mid, 2*indx+1); // LEFT SUB-PROBLEM
        buildST(array, st, mid+1, end, 2*indx+2);// RIGHT SUB-PROBLEM

        st[indx] = Math.max(st[2*indx+1], st[2*indx+2]); // STORE ELEMENT WHICH IS MAXIMUM FROM BOTH LEFT AND RIGHT SUB-PROBLEMS.
    }

    // QUERY (GETMAX)
    public static int getMax(int st[], int indx, int start, int end, int i, int j){
        // SOLUTION FOR QUERY WILL BE PRESENT IN SUB-PARTS(DIFFERENT-NODES) OF SEGMENT-TREE.
        // SO, WEE TRAVELL WHOLE SEGMENT-TREE AND TRY TO FIND THAT SMALL SUB-PROBLEMS.

        if(j < start || i > end){ // NON-OVERLAPPING CASE. 
            return -1; // RETURN FROM HERE BECAUSE WE DON'T NEED TO SEARECH IN IT'S SUB-TREE(SUB-PROBLEMS). BACAUSE THEY ARE SMALL PARTS OF CURRENT-RANGE ONLY.
        }
        else if(start>=i && end<=j){ // SUB-PROBLEMS OF SEGMENT TREE ARE COMPLETLY OVERLAPPING IN GIVEN QUERY. 
            return st[indx]; // CONSIDER THIS VALUE
        }
        else{ // PARTIALLY OVERLAPPING.
            // THEN SEARCH FOR SMALLER PARTS FOR QUERY.

            int mid = (start+end)/2;
            int x = getMax(st, 2*indx+1, start, mid, i, j); // SEARCH IN LEFT-SUBPROBLEM.
            int y = getMax(st, 2*indx+2, mid+1, end, i, j); // SEARCH IN RIGHT-SUBPROBLEM.

            return Math.max(x, y);
        }
    }

    public static void updateUtil(int st[], int stIndx, int start, int end, int indx, int diff){
        // WE UPDATE ONLY RANGES OF SEGMENT-TREE WHERE GIVEN INDEX LIES.

        if(true){

        }
    }
    // UPDATE 
    public static void update(int array[], int st[], int indx, int newVal){

        // 1. FIND DIFFERENCE.
        int diff = newVal - array[indx];

        // 2. UPDATE NEW-VALUE IN ARRAY.
        array[indx] = newVal;

        // 3. UPDATE IN SEGMENT-TREE.
    }
    public static void main(String[] args) {
        int array[] = {6,8,-1,2,17,1,3,2,4};

        // BUILD SEGMENT-TREE
        int st[] = new int[4*array.length]; // SEGMENT-TREE
        buildST(array, st, 0, array.length-1, 0);

        System.out.println(getMax(st, 0, 0, array.length-1, 6, 8));



    }
}
