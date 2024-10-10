public class Update {
    // TO UPDATE SEGMENT-TREE(WHEN VALUE IN ARRAY IS CHANGED).

    // LOGIC/APPROACH
    // WE TRAVELL SEGMENT-TREE IF "GIVEN INDEX" LIE IN RANGE-OF-SEGMENT-TREE "WE ADD DIFFERENCE TO RANGE(SUM)".
    // UPDATE-UTIL() : TO UPDATE THE SEGMENT-TREE.
    public static void updateUtil(int st[], int stindx, int start, int end, int indx, int diff){

        // T(N) = 0(LOG N)
        if(indx < start || indx > end){ // GIVEN INDEX IS NOT PRESENT IN CURRENT-RANGE.
            return; // IF GIVEN INDEX IS NOT PRESENT IN CURRENT-RANGE, RETURN FROM HERE WE DON'T NEED TO SEARCH IN IT'S SUB-PROBLEMS(BECAUSE IT'S SUB-PROBLEMS ARE OF IT'S RANGE ONLY)
        }

        // IF INDEX IS PRESENT IN CURRENT-RANGE, UPDATE(ADD DIFFERENCE TO CURENT-SUM OF CURRENT-RANGE)
        st[stindx] += diff;

        if(start != end){ // IF IT IS NOT A LEAF-NODE.
            // WE TRAVELL FROM WHOLE-RANGE-NODE(ROOT) TO LEAF-NODE AND UPDATE VALUE AT ALL THE INDEXES.

            // UPDATE SMALLER SUB-PROBLEMS WHERE INDEX LIE IN THAT RANGE.
            int mid = (start+end)/2;
            updateUtil(st, 2*stindx+1, start, mid, indx, diff); // LEFT SUB-PROBLEM.
            updateUtil(st, 2*stindx+2, mid+1, end, indx, diff); // RIGHT SUB-PROBLEM.

            // NOTE : EVEN IN THIS TWO PROBLEMS ONE WILL BECOME FALSE. SO THAT WE CAN TRAVELL TO LEAF-NODE OF GIVEN INDEX.
        }

        // IF IT IS LEAF-NODE THEN FROM HERE WE AUTOMATICALL GET RETURNED.
    }

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

    public static void update(int array[], int st[], int indx, int newVal){
        // NOTE : "INDX" ---> REPRESENTS A INDEX WHERE WE NEED TO CHANGE VALUE WITH "NEWVAL"

        // 1. GET DIFFERENCE
        int diff = newVal - array[indx];

        // 2. UPDATE "NEW-VALUE" IN ARRAY.
        array[indx] = newVal;

        // 3. UPDATE IN SEGMENT-TREE.
        updateUtil(st, 0, 0, array.length-1, indx, diff);
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8};

        int st[] = new int[4*array.length];
        buildST(array, st, 0, array.length-1, 0);

        for(int x : st){
            System.out.print(x + " ");
        }
        System.out.println();

        update(array, st, 2, 2);

        System.out.println("AFTER UPDATING VALUE : ");
        for(int x : st){
            System.out.print(x + " ");
        }

    }
}
