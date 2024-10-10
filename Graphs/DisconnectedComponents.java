import java.util.ArrayList;

public class DisconnectedComponents {
    // GRAPH CAN HAVE MULTIPLE COMPONENTS WHICH ARE NOT CONNECTED TO EACH OTHER.

    static class Edge{
        int src; // SOURCE
        int dst; // DESTINATION
        int wt; // WEIGHT

        // CONSTRUCTURE.
        Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }


    public static void dfsHelper(ArrayList<Edge> graph[], boolean visited[], int v){ // DOES THE "DFS" OF CONNECTED-COMPONENTS.
        System.out.print(v + " ");
        visited[v] = true;

        // CALL FOR UNVISITED NEIGHBOURS.
        for(int i=0; i<graph[v].size(); i++){
            int node = graph[v].get(i).dst;

            if(visited[node] == false){ // NOT VISITED YET. 
                dfsHelper(graph, visited, v);
            }
         }
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int v =0; v<graph.length; v++){ // TO CHECK WHETHER ALL NODES ARE VISITED OR NOT.
            if(!visited[v]){
                dfsHelper(graph,visited,v); // IF ANY NODE IS NOT VISITED THEN WE WILL START "DFS" FROM THAT NODE.
            }
        }
    }

    public static void main(String[] args) {
        int v = 5; // NO.OF VERTICES
        ArrayList<Edge> graph[] = new ArrayList[v]; // INITIALLY "NULL" IS STORED IN EVERY INDEX OF ARRAY(GRAPH).
        // MAKE EVERY INDEX OF GRAPH AS ARRAYLIST. BECAUSE EVERY INDEX IS A SEPARATE VARIABLE.
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
    }
}
