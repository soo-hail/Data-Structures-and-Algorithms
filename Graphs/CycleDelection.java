import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDelection {
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

    public static boolean dfs(ArrayList<Edge> graph[], boolean visited[], int parent, int node){
        visited[node] = true; 
        for(int i=0; i<graph[node].size(); i++){ // TO GET NEIGHBOURS.
            int neighbour = graph[node].get(i).dst;

            if(visited[neighbour] == true && neighbour != parent){
                // PARENT : IS A DIRECT CONNECTED NODE THROUGH WHICH WE HAVE TRAVELLED TO CURRENT-NODE.
                return true;
            }

            if(!visited[neighbour]){
                if(dfs(graph, visited, node, neighbour)) return true; // IF ITS NEIGHBOUR IS NOT VISITED THEN CALL RECURSIVE FUNCTION.
            }
        }

        return false;
    }

    // CYCLE DETECTION FOR UNDIRECTED-GRAPH.
    public static boolean isCycleUDG(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length]; // INITIALIZED WITH FALSE.
        for(int i=0; i<graph.length; i++){ // FOR DISCONNECTED COMPONENETS OF A GRAPH.
            if(!visited[i]){
                if(dfs(graph,visited, -1, i)) return true; // CHECKS CYCLE IN CONNECTED COMPONENT, IF IT RETURN TRUE WE RETURN TRUE.
            }
        }

        return false; // IF CYCLE IS NOT PRESENT IN GRAPH.
    }

    // CYCLE DETECTION FOR UNDIRECTED-GRAPH USING "BFS"
    public static boolean isCycleBFS(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>(); 
        boolean parent[] = new boolean[graph.length];
        boolean inPath[] = new boolean[graph.length]; 
        q.add(0); inPath[0] = true; 
        while (!q.isEmpty()) {
            int curr = q.remove(); parent[curr] = true; // MAKING PARENTS TRUE(BECAUSE PARENT SHOULD NOT ADD AGAIN IN QUEUE).
            inPath[curr] = false; // REMOVE PARENT FROM IN-PATH OF FINDING CYCLE. 
            for(int i=0; i<graph[curr].size(); i++){ // TO FIND NEIGHBOURS.
                Edge e = graph[curr].get(i);
                if(inPath[e.dst]){ // IF "NEIGHBOUR" IS ALREADY PRESENT IN-PATH OF FINDING CYCLE.
                    return true; 
                }

                if(!parent[e.dst]){ // IF NEIGHBOUR IS NOT PARENT/ ANCESSTOR.
                    q.add(e.dst);
                    inPath[e.dst] = true; 
                }
            }
        }

        return false; // RETURN FALSE IF CYCLE IS NOT EXIST.  
    }

    // CYCLE DETECTION FOR DIRECTED-GRAPH(HELPER-FUNCTION). 
    public static boolean isCycleDG(ArrayList<Edge> graph[], boolean vist[], boolean inCycle[], int vtx){
        vist[vtx] = true;
        inCycle[vtx] = true; // WE ARE ADDING ELEMENTS IN ARRAY. TO TRACK WHETHER CURRENT-NODE WILL REPEAT AGAIN.
        for(int i=0; i<graph[vtx].size(); i++){ // TO FIND NEIGHBOURS.
            int n = graph[vtx].get(i).dst; // NEIGHBOUR.
            if(inCycle[n]){ // NEIGHBOUR IS ALREADY PRESENT IN CURRENT-PATH(DFS PATH).
                return true; 
            }

            if(!vist[n]){ // IF NEIGHBOUR IS NOT VISITED.
                if(isCycleDG(graph, vist, inCycle, n)) return true; // TRAVERSE NEIGHBOUR.
            }
            
        } // end forLoop.

        inCycle[vtx] = false; // REMOVE CURRENT-VERTEX FROM DFS-PATH(RECURTION).
        return false;
    }

    public static boolean isCycleDG(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length]; 
        boolean inCycle[] = new boolean[graph.length]; 
        for(int i=0; i<graph.length; i++){ // FOR DIS-CONNECTED COMPONENTS OF A GRAPH
            if(!visited[i]){
                if(isCycleDG(graph, visited, inCycle, i)) return true; 
            }
        }

        return false;
    }

    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v]; // INITIALLY "NULL" IS STORED IN EVERY INDEX OF ARRAY(GRAPH).
        // MAKE EVERY INDEX OF GRAPH AS ARRAYLIST. BECAUSE EVERY INDEX IS A SEPARATE VARIABLE.
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        /*
                  0 --------- 3
                 /|           
                / |           
               1  |           
                \ |           
                 \|           
                  2 --------- 4

         */

        graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 0, 1));

        graph[4].add(new Edge(4, 2, 1));

        System.out.println(isCycleUDG(graph));
        System.out.println(isCycleBFS(graph));

        // DIRECTED GRAPH.
        int v2 = 5;
        ArrayList<Edge> dGraph[] = new ArrayList[v2];

        for(int i=0; i<dGraph.length; i++){ 
            dGraph[i] = new ArrayList<>(); // INITIALIZE.
        }

        dGraph[0].add(new Edge(0, 1,1));
        dGraph[1].add(new Edge(1, 2,1));
        // dGraph[2].add(new Edge(2, 3,1));
        dGraph[2].add(new Edge(2, 4,1));
        dGraph[3].add(new Edge(3, 2,1));
        dGraph[4].add(new Edge(4, 3, 1));

        System.out.println(isCycleDG(dGraph));
        
        
    }
}
