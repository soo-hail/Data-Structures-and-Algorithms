import java.util.ArrayList;
public class BellmanFordAlgo {
    // BELLMAN FORD ALGORITHM IS USED TO FIND SHORTEST-PATH FOR ALL VERTICES OF GRAPH FROM SOURCE "EVEN WHEN A GRAPH HAS NEGITIVE EDGES."
    // TIME-COMPLEXITY OF "BELLMAN-FORD ALGORITH" IS MORE THAN "DIJSTRA'S  ALGORITHM"
    // NOTE : BELLMAN FORD ALGORITH DOESN'T WORK FOR GRAPHS WHICH HAS CYCLES WHOSE OVER ALL SHOREST-DISTANCE IS NEGIVITE.

    static class Edge{
        int src; int dst;
        int wt;

        // CONSTRUCTURE
        Edge(int src, int dst, int wt){
            this.src = src; this.dst = dst; 
            this.wt = wt; 
        }
    }

    // BELLMAN-FORD ALGORITHM. 
    public static void getShotestPath(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length]; // TO STORE SHORTEST-DISTANCE OF ALL VERTICES OF GRAPH FROM SOURCE.
        
        // INITIALIZE ALL DISTANCES OF VERTICES FROM SOURCE AS "INFINITY".
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int v = graph.length-1;
        for(int i=1; i<=v-1; i++){ // (MAIN-LOGIC) WE HAVE TO FIND SHORTEST-PATH OF ALL VERTICES "V-1" TIMES. BECAUSE TO FIND THE SOURCE IS BIGGEST-TASK. 
            // FIND EDGES
            for(int vtx=0; vtx<graph.length; vtx++){
                for(int j=0; j<graph[vtx].size(); j++){
                    Edge e = graph[vtx].get(j); 

                    if(dist[vtx] != Integer.MAX_VALUE){ // SPECIAL-CONDITION(TO FIND SOURCE) AND BECAUSE IF WE ADD ANY NUMBVER TO "INIFITY" THAT WILL BECOME -VE.
                        int newDistance = dist[vtx] + e.wt;
                        if(newDistance < dist[e.dst]){
                            dist[e.dst] = newDistance;
                        }
                    }   
                }
            }
        }// end forLoop.

        for(int x : dist ){
            System.out.print(x + " ");
        }
    }


    public static void main(String[] args) {
        int v = 5; ArrayList<Edge> graph[] = new ArrayList[v]; 
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){ // INITIALIZE EVERY-INDEX OF ARRAY WITH ARRAY-LIST.
            graph[i] = new ArrayList<>(); 
        }

        // CONSTRUCTURE GRAPH.
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        
        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2,3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        getShotestPath(graph, 0);
    }
}
