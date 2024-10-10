import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Edge{
        int src; int dst;
        int wt;

        // CONSTRUCTURE
        Edge(int src, int dst, int wt){
            this.src = src; this.dst = dst; 
            this.wt = wt; 
        }
    }

    static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;

        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair pair2){
            return this.wt - pair2.wt; // TO COMPARE WEIGHTS OF TWO PAIRS.
        }
    }

    // PRIMS-ALGORITHM.
    public static int getMST(ArrayList<Edge> graph[]){
        int minWt = 0; // MINIMUM-WEIGHT.
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        visited.add(0); // START-POINT.
        while(visited.size() != graph.length){

            for(int v : visited){ // TO GET VISITED-VERTICES IN SET. SO THAT WE CAN FIND NEXT SHORTEST-EDGES FROM ALREADY VISITED-VERTICES.
                for(int i=0; i<graph[v].size(); i++){ // FOR NEIGHBOURS OF ALREADY VISITED-VERTICES.
                    Edge e = graph[v].get(i); 
                    if(!visited.contains(e.dst)){ // IF VERTEX IS NOT VISITED, THEN ONLY ADD THAT VERTEX IN "PQ".
                        pq.add(new Pair(e.dst, e.wt));
                    }
                }
            }

            Pair nextVtx = pq.remove(); // PAIR WHICH HAS SHORTEST-WEIGHT.
            minWt = minWt + nextVtx.wt;
            visited.add(nextVtx.vtx);
            
            pq.clear();
        }

        return minWt;
    }

    public static int getMST2(ArrayList<Edge> graph[]){
        int minWt = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>(); // TO TRACK WHETHER A VERTX IS VISITED(CONNECTED).

        pq.add(new Pair(0, 0)); // STARTING-POINT.

        while(visited.size() < graph.length){
            Pair curr = pq.remove(); // REMOVES PAIR TO WHICH WE CAN TRAVELL IN SHORTEST-DISTANCE FROM VISITED(CONNECTED)-VERTICES.

            if(!visited.contains(curr.vtx)){ // IF THE VERTEX IS STILL NOT CONNECTED WITH MINIMUM-SPANNING-TREE.
                minWt += curr.wt;
                visited.add(curr.vtx); // MARK VISITED(CONNECTED).

                // FOR NEIGHBOURS.
                for(int i=0; i<graph[curr.vtx].size(); i++){ // WE CAN ADDED NEIGHBOURS OF CURRENT-VETICES ONLY ONCE IN PRIORITY-QUEUE(CONDITION IS WRITTEN ABOVE) 
                    Edge e = graph[curr.vtx].get(i);
                    if(!visited.contains(e.dst)){ // IF NEIGHBOUR IS ALREADY NOT VISITED, THEN ONLY ADD THAT VERTEX IN PRIORITY-QUEUE.
                        pq.add(new Pair(e.dst, e.wt));
                    }
                }
            }
        }// end whileLoop.

        return minWt;
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[4]; 

        for(int i=0; i<graph.length; i++){ // INITIALIZE EVERY-INDEX OF ARRAY WITH ARRAY-LIST.
            graph[i] = new ArrayList<>(); 
        }

        // CONSTRUCT GRAPH.
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));

        int x = getMST(graph); 
        int y = getMST(graph);
        System.out.println(x);
        System.out.println(y);

    }
}
