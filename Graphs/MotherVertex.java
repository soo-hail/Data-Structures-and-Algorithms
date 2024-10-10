import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {

    static class Edge{
        int src;
        int dst;

        Edge(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void dfs(ArrayList<Edge> graph[], Stack<Integer> count, boolean visited[], int vtx){
        visited[vtx] = true; // TO AVOID CYCLE.
        for(int i=0; i<graph[vtx].size(); i++){ // FOR NEIGHBOURS.
            Edge e = graph[vtx].get(i); 

            if(!visited[e.dst]){
                dfs(graph, count, visited, e.dst); 
            }
        }// end forLoop.

        count.add(vtx); // FINISHED VERTICES ARE ADDED IN STACK THROUGH WHICH WE CAN'T TRAVELL TO FURTHUR VERTICES. 
    }
    public static int getMotherVertex(ArrayList<Edge> graph[]){
        // 1. FIND LAST FINISHED-VERTEX : FINISHED-VERTEX == WHICH DOES NOT HAVE ANYMORE EDGES TO TRAVELL OTHER VERTEX. 

        // NOTE : MOTHER-VERTEX MUST FINISH LAST. BECAUSE WE CAN TRAVELL ALL VERTICES FROM MOTHER-VERTEX.
        // SO CHECK WHETHER A LAST-FINISHED VERTEX IS A MOTHER-VERTEX.
        
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> count = new Stack<>(); // TO TRACK LAST-FINISHED VERTEX.
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(graph, count, visited, i);
            }
        }

        int lastFinished = count.pop(); // LAST-FINISHED VERTEX IS RETURNED. 

        count.clear(); // EMPTY STACK.
        for(int i=0; i<graph.length; i++){
            visited[i] = false; // AGOIN INITIALIZE VISITED TO FALSE.
        }

        dfs(graph, count, visited, lastFinished); // NOW PERFORM DFS ONLY ON "LAST-FINISHED VERTEX"
        
        return count.size() == graph.length? lastFinished : -1;
    }
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 4));

        // TIME-COMPLEXITY : O(2*(V+E)
        int x = getMotherVertex(graph);
        System.out.println(x);
    }
}