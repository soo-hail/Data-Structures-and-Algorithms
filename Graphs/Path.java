import java.util.ArrayList;
public class Path {
    
    static class Edge{
        int src; int dst;
        int wt;

        Edge(int src, int dst, int wt){
            this.src = src; this.dst = dst; 
            this.wt = wt; 
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[],boolean vis[], int curr, int target){
        vis[curr] = true; // SO THAT RECURTION FLOW SHOULD NOT COME TO CURENT-NODE FROM IT'S NEIGHBOUR.
        for(int i=0; i<graph[curr].size(); i++){ // FOR NEIGHBOURS.
            Edge e = graph[curr].get(i); 
            if(e.dst == target){
                return true;
            }

            // TRAVELLING TO NEIGHBOURS BUT NOT AGAIN TO PARENT-VERTEX.
            if(vis[e.dst] == false){
                if(hasPath(graph, vis, e.dst, target)){ // IF ANY RECURSIVE-FUNCTION RETURNS TRUE. THEN FROM THERE DIRECTLY RETURN TRUE
                    return true; 
                } 
            } 

        }// END FOR-LOOP.

        vis[curr] = false; // AFTER TRAVELLING NEIGHBOURS IF WE HAVE NOT FOUND TARGET, THEN WE WILL SEARCH IN OTHER NEIGHBOURS OF PARENT-VERTEX OF CURRENT-VERTEX.
        return false;
    }

    // GET-PATH FOR UNDIRECTED GRAPH.
    public static void getPath(ArrayList<Edge> graph[],boolean vis[], int curr, int target, String path){ 
        if(curr == target){
            System.out.println(path);
            return;
        }

        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){ // FOR NEIGHBOURS.
            Edge e = graph[curr].get(i); 

            if(!vis[e.dst]){
                getPath(graph, vis, e.dst, target, path + e.dst + " "); // TRAVELL TO NEIGHBOURS.
            }
        }// end forLoop.
 
        vis[curr] = false;
    }

    // GET-PATH FOR DIRECTED-GRAPHS.
    public static void getPathDG(ArrayList<Edge> graph[], int curr, int target, String path){
        if(curr == target){
            System.out.println(path + curr);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){ // FOR NEIGHBOURS.
            Edge e = graph[curr].get(i); 

            getPathDG(graph, e.dst, target, path + curr + " ");// TRAVELL TO NEIGHBOURS.
        }// end forLoop.
    }

    public static void main(String[] args) {
        int v = 7; ArrayList<Edge> graph[] = new ArrayList[v]; 
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){ // INITIALIZE.
            graph[i] = new ArrayList<>(); 
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        // HAS PATH.
        // System.out.println(hasPath(graph, visited, 0, 9));

        // GET-ALL-PATHS FROM SOURCE TO DESTINATION. 
        // getPath(graph, visited, 0, 3, "0 ");

        // DIRECTED-GRAPH.
        int v2 = 6;
        ArrayList<Edge> dGraph[] = new ArrayList[v2]; 

        for(int i=0; i<dGraph.length; i++){ // INITIALIZE EVERY-INDEX OF ARRAY WITH ARRAY-LIST.
            // OTHERWISE WE CAN ONLY STORE ARRAY-LIST IN PERTICULAR INDEX BUT WE CANT USE INDEX OF GRAPH(ARRAY) AS ARRAY-LIST.
            dGraph[i] = new ArrayList<>();
        }

        int wt = 1;

        dGraph[0].add(new Edge(0, 3, wt));
        
        dGraph[2].add(new Edge(2, 3, wt));
        
        dGraph[3].add(new Edge(3, 1, wt));

        dGraph[4].add(new Edge(4, 0, wt));
        dGraph[4].add(new Edge(4, 1, wt));

        dGraph[5].add(new Edge(5, 0, wt));
        dGraph[5].add(new Edge(5, 2, wt));


        // GET-ALL-PATHS FROM SOURCE TO DESTINATION IN DIRECTED-GRAPHS.
        getPath(dGraph, visited, 0, 6, "");
    }
}
