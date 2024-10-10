import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Traversals {
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
    
    public static void bfs(ArrayList<Edge> graph[], int sp){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length]; // INITIALIZED WITH "FALSE".

        q.add(sp);q.add(-1); // STARTING POINTING.
        visited[sp] = true;
        while(!q.isEmpty()){

            int v = q.remove(); // CURRENT VERTEX.

            if(v == -1){
                if(q.isEmpty()){
                    break;
                }

                q.add(-1);
                System.out.println();
            }
            else{   
                System.out.print(v + " ");
                for(int i=0; i<graph[v].size(); i++){
                    Edge e = graph[v].get(i);

                    if(visited[e.dst] == false){ // NOT VISITED YET.
                        q.add(e.dst);
                        visited[e.dst] = true;
                    }
                }// end forLoop
            }
        }// end whileLoop

    }

    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int v){
        System.out.print(v + " ");
        visited[v] = true;

        // CALL FOR UNVISITED NEIGHBOURS.
        for(int i=0; i<graph[v].size(); i++){
            Edge e = graph[v].get(i);

            if(visited[e.dst] == false){ // NOT VISITED YET. 
                dfs(graph, visited, e.dst);
            }
        }
    }
    
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v]; // INITIALLY "NULL" IS STORED IN EVERY INDEX OF ARRAY(GRAPH).
        // MAKE EVERY INDEX OF GRAPH AS ARRAYLIST. BECAUSE EVERY INDEX IS A SEPARATE VARIABLE.
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        /*
                1 -------- 3 
              /            |  \
             /             |   \
            0              |    5 ------ 6
             \             |   /   
              \            |  /
                2 -------- 4
          
          
         */

        // EVERY INDEX OF ARRAY IS A ARRAYLIST. 

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

        // bfs(graph, 0);
        dfs(graph, new boolean[v], 0);
    }
}
