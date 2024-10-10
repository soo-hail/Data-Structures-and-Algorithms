public class DisjointSetUnion {

    // DISJOINT-SET-UNION : IS A TEQNIUE TO FIND THE CONNECTED-COMPONENETS OF A GRAPH. USING WHICH WE CAN DETECT-CYCLES IN UNDIRECTED GRAPHS.
    // IN DISJOINT-SET-UNION WE USE "UNION-FIND-DATA STRUCTURE (OR) DISJOINT-SET-DATA STRUCTURE" TO STORE AND TRACK DISJOINT-COMPONENETS(DISCONNECTED) OF A GRAPH.


    // NOTE : IF TWO VERTICES HAS SAME REPRESENTATIVE(BELONGS TO SAME COMPONENET). THEN WE CAN NOT HAVE A EDGE BETWEEN THAT TWO VERTICES. BEACUSE THEY WILL FORM CYCLE IN THAT COMPONENET.


    public static int find(int parent[], int vtx){ // TO FIND THE REPRESENTATIVE OF A COMPONENT WHERE VERTIEX(GIVEN) IS PRESENT(CONNECTED). 
        if(parent[vtx] == vtx){ // (IMPORTANT)PARENT OF REPRESENTATIVE IS REPRESENATATIVE ONLY.
            return vtx;
        }

        // IF VERTEX HAS PARENT : RECURSIVELY FIND REPRESENTATIVE OF COMPONENT OF GRAPH WHERE VERTEX IS PRESENT.S 
        // return find(parent, parent[vtx]); // TO FIND PARENT OF PARENT-OF-CURENT-VERTEX.

        return parent[vtx] = find(parent, parent[vtx]); // PATH-COMPRESSION OPTIMIZATION : HERE WE ARE DIRECTLY STORING REPRESENTIVE OF COMPONENT WHERE THE VERTEX IS PRESENT.
        // WE ARE UPDATING REPRESENTATIVE OF VERTEX IN "FIND()" BECAUSE WE CAN'T(UPDATE) CHANGE IT IN UNION FUNCTION. 

        // ADVANTAGE OF STORING "REPRESENTIVE" IS --> FROM CURRENT-VERTEX WE TRAVELL DIRECTLY TO REPRESENTIVE WHERE PARENT[VTX] == VTX. 
    }

    public static boolean union(int parent[], int rank[], int vtx1, int vtx2){ // TO CONNECT DISCONNECTED-COMPONENTS OF A GRAPH(USING VERTICES).
        int repVtx1 = find(parent, vtx1); // REPRESENTATIVE OF VERTEX-1.
        int repVtx2 = find(parent, vtx2); // REPRESENTATIVE OF VERTEX-2.

        if(repVtx1 == repVtx2){ // THEY BELONG TO SAME COMPONENT.
            return false; // WE CAN'T JOIN(FORM-EDGE) BETWEEN VERTEX-1 AND VERTEX-2. "BEACUSE CYCLE WILL FORM".
        }

        if(rank[repVtx1] == rank[repVtx2]){ // IF RANK OF BOTH REPRESENTATIVES ARE SAME. THEN MAKE "REPRESENTATIVE" TO ANY OF THEM.
            parent[repVtx2] = repVtx1;//  MAKING REPRESENATTIVE OF VERTEX-1 AS REPRESENTATIVE OF WHOLE(CONNECTED-COMPONENT).
            rank[repVtx1]++; // UPDATE RANK OF "NEW REPRESENATATIVE"
        }

        else if(rank[repVtx1] > rank[repVtx2]){
            parent[repVtx2] = repVtx1; // CONNECTING COMPONENTS.
            // DON'T NEED TO UPDATE RANK. BEACUSE IT IS ALREADY GREATER THAN RANK OF OTHER REPRESENTATIVE.
        }
        else{
            parent[repVtx1] = repVtx2;
            // DON'T NEED TO UPDATE RANK.
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4; // NO. OF VERTICES.
        int parent[] = new int[n]; // TO STORE PARENT-VERTEX OF EVERY-NODE, SO THAT WE CAN REACH TO REPRESENTATIVE OF COMPONENET OF GRAPH WHERE VERTEX IS PRESENT.        
        int rank[] = new int[n]; // TO STORE RANK OF REPRESENTIVE'S(LEADER) OF ALL COMPONENETS.
        
        // INITIALLY EVERY VERTEX HAS INITIAL COMPONENT. SO INITIALIZE PARENT-OF-VERTEX AS VERTEX ONLY.
        for(int i=0; i<n; i++){
            parent[i] = i; // INITIALLY VERTICES ITSELF IT'S OWN PARENT.
        }

        // RANK OF ALL-VERTICES ARE INITIALIZED WITH "ZERO".

        union(parent, rank, 2, 3); // 2 <-- 3

        union(parent, rank, 3, 1);  // 2 <-- 1

        union(parent, rank, 1, 0);  // 2 <--0

        // NOTE : 2 IS REPRESENTATIVE OF FORMED GRAPH(COMPONENT).
        int rep = find(parent, 0);
        System.out.println(rep);

        boolean x = union(parent, rank, 0, 3); // WE CAN NOT CONNECTED VERTICES WHICH HAS SAME REPRESENTATIVE(BELONGS TO SAME COMPONENT). BECAUSE "CYCLE WILL FORM".
        System.out.println(x); // FALSE IS PRINTED.

    }
}