// KRUSKALS-ALGO IS USED TO FIND MINIMUM-SPANNING-TREE(using greedy-approach).

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class KruskalsAlgo {
    
    static class Edge implements Comparable<Edge>{
        int src; 
        int dst;
        int wt;

        Edge(int src, int dst, int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt; // ACCENDING-ORDER.
        }
    }

    public static boolean isCycle(HashSet<Integer> connected, int src, int dst){
        if(connected.contains(src) && connected.contains(dst)){ // IF BOTH ENDS(VERTICES) OF EDGE ARE PRESENT IN MST, WHICH MEANS THEY CAN FORM CYCLE. 
            return true;
        }

        return false;
    }

    public static int find(int parent[], int vtx){ // TO FIND THE "REPRESENATATIVE" OF VERTEX : LEADER OF COMPONENT.
        if(parent[vtx] == vtx){
            return vtx;
        }

        return parent[vtx] = find(parent, parent[vtx]); // WE ARE STORING "REPRESENTIVE" DIRECTLY IN PARENT[VTX]. BEACUSE NEXT TIME WE CAN TRAVELL TO PARENT[VTX] == VTX ----> DIRECTLY(WITHOUT TRAVELLING NODES BETWEEN THEM). 
    }

    public static void union(int parent[], int rank[], int vtx1, int vtx2){
        int rVtx1 = find(parent, vtx1); int rVtx2 = find(parent, vtx2);  

        if(rank[rVtx1] < rank[rVtx2]){ // MAKE ANY OF THEM AS REPRESENTATIVE.
            parent[rVtx2] = rVtx1; // CONNECTING.
            rank[rVtx1]++; // UPDATE RANK(BECAUSE THEY HAVE SAME RANK AS OF NOW).
        }
        else if(rank[rVtx1] > rank[rVtx2]){
            parent[rVtx2] = rVtx1; // CONNECTING TWO COMPONENETS.
        }
        else{
            parent[rVtx1] = rVtx2; // CONNECTING TWO COMPONENTS.
        }

    }

    public static int kruskalAlgo(ArrayList<Edge> graph){
        // HERE ARE WE ARE IMPLEMENTING KRUSKALS-ALGORITHM USING DISJOINT-UNION-SET.
        int minWt = 0;
        int parent[] = new int[graph.size()]; // TO STORE PARENTS(CONNECTIONS) OF ALL VERTICES.
        int rank[] = new int[graph.size()]; // TO STORE RANK OF ALL THE VERTICES. SO THAT WE CAN CHOOSE A REPRESENTIVE.

        for(int i=0; i<parent.length; i++){
            parent[i] = i; // INITIALIZATION.
        }

        Collections.sort(graph); // SORT GRAPH (GREEDY-APPROACH).
        int countEdge = 0; // TO COUNT NUMBER OF EDGES FORMED IN MST.
        for(int i=0; i<graph.size(); i++){ // TRAVELL EDGES OF GRAPH.

            if(countEdge == graph.size()-1){ // WE NEED V-1 EDGES TO CONNECT V EDGES WITHOUT A CYCLE.
                break;
            }

            Edge e = graph.get(i); // WE GET A EDGE WHOSE WEIGHT IS LESS THAN NEXT-EDGES IN GRAPH.

            int u = e.src; int v = e.dst; 
            int repU = find(parent, u); int repV = find(parent, v); // GET REPRESENTATIVES OF U AND V.
            
            if(repU == repV){ // THEY BOTH PRESENT IN SAME COMPONENET. 
                continue;
            }

            // IF EDGE IS NOT FORMING A CYCLE.
            union(parent, rank, u, v); // CONNECT THE COMPONENETRS OF VERTEX U AND V.
            minWt = minWt + e.wt; // INCLUDE WEIGHT OF CURRENT EDGE IN WEIGHT OF SPANNING-TREE.
            countEdge++;

        }

        return minWt; 
    }

    public static void main(String[] args) {
        int minWt = 0; // TO STORE TOTAL WEIGHT OF MINIMUM-SPANNING-TREE.
        ArrayList<Edge> graph = new ArrayList<>(); 
        HashSet<Integer> connected = new HashSet<>(); // TO TRACK WHETHER A VERTES IS INCLUDED(CONNECTED) IN MINIMUM-SPANNING-TREE.

        // FOR KRUSKAL'S ALGORITHM WE CAN DIRECTLY STORE EDGES IN ARRAY-LIST.
        int v = 4;
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(3, 2, 50));

        Collections.sort(graph); // FOR GREEDY-APPROACH.

        for(int i=0; i<graph.size(); i++){ // TRAVELL SORTED-ARRAYLIST(EDGES).
            Edge e = graph.get(i); 

            if(!isCycle(connected, e.src, e.dst)){ // IF EDGE DOES NOT FORM CYCYLE. 
                minWt+= e.wt; // INCLUDE WEIGHT-OF CURRENT-EDGE IN MINIMUM-SPANNING-TREE.
                connected.add(e.src); connected.add(e.dst); // MARK AS INCLUDED.

                if(connected.size() == v){ // IF ALL VERTICES ARE CONNECTED, THEN RETURN(BREAK).
                    break;
                }
            }

        }// end forLoop.

        System.out.println(minWt);

        int x = kruskalAlgo(graph); // USING UNION-FIND DATA STRUCTURE(DISJOINT-SET UNION)
        System.out.println(x);
    }
}
