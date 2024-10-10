import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;

public class DijkstrasAlgo {
    
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
        int vrtx;
        int dist;

        Pair(int vrtx, int dist){
            this.vrtx = vrtx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair pair2){
            return dist - pair2.dist; // RETURNS INTEGER-VALUE WHICH IS USED TO COMPARE "PAIRS" IN PRIORITY-QUEUE.
        }
    }

    public static void getShotestPath(ArrayList<Edge> graph[], int dist[], int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // TO GET VERTICES WHICH HAS SHOREST-PATH(DISTANCE) FROM SOURCE.  
        HashSet<Integer> visited = new HashSet<>(); // WORK AS VISITED-ARRAY. 

        // FIRST INITIALIZE ALL DISTANCES-OF-VERTICES FROM SOURCE AS "INFINITY".
        for(int i=0; i<graph.length; i++){ 
            if(i != src){
                dist[i] = Integer.MAX_VALUE; 
            }
        }

        pq.add(new Pair(src, 0)); // ADD SOURCE IN PRIORITY-QUEUE.
        while (visited.size() != graph.length){
            if(pq.isEmpty()){
                return; 
            }

            int curr = pq.remove().vrtx; 

            if(visited.contains(curr)){ // IF CURRENT-VERTEX IS ALREADY VISITED. DIRECTLY GO FOR NEXT VERTEX WHICH HAS SHORTEST-PATH.
                continue; // FOR UNDIRECTED GRAPH.
            }

            // TRAVERSING-NEIGHBOURS.
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);

                if(visited.contains(e.dst)){ 
                    continue;
                }

                int newDistance = dist[curr] + e.wt; // e.wt == DISTANCE BETWEEN CURR-VRXT AND IT'S NEIGHBOUR.

                if(newDistance < dist[e.dst]){ //IF NEW-DISTANCE IS SHORTER THAN ALREADY EXISTING DISTANCE OF NEIGHBOUR.
                    dist[e.dst] = newDistance; // UPDATE SHORTEST-DISTANCE OF NEIGHBOUR.
                    pq.add(new Pair(e.dst, dist[e.dst])); // ADD NEIGHBOUR IN PRIORITY-QUEUE.
                }
            }

            // AFTER VISITING-ALL NODES(VERTICES) OF A GRAPH.
            visited.add(curr); 
        }

    }

    public static void main(String[] args) {
        int v = 6; ArrayList<Edge> graph[] = new ArrayList[v]; 
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){ // INITIALIZE EVERY-INDEX OF ARRAY WITH ARRAY-LIST.
            graph[i] = new ArrayList<>(); 
        }

        // CONSTRUCTURE GRAPH.

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1,2,7));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,4,3));

        // graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

        int dist[] = new int[graph.length]; // TO STORE SHORTEST-DISTANCE.  

        getShotestPath(graph, dist, 0);
        for(int x : dist){
            System.out.print(x + " ");
        }

    }
}
