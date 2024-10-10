import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    static class Edge{
        int src;
        int dst;

        Edge(int src, int dst){
            this.src = src;
            this.dst = dst; 
        }
    }

    // TOPOLOGICAL-SORTING IS A TEQNIQUE TO GET A LINEAR SEQUENCE OF VERTICES SUCH THAT EDGE IS FROM U--->V, ALWAYS "U" COMES BEFORE "V" IN ORDERING.   
    // NOTE : IT CAN BE ONLY USED FOR DIRECTED-ACYCLIC-GRAPHS(DAG). 
    // TOPOLOGICAL SORTING IS A APPLIED ON DEPENDENCY-GRAPHS TO GET(KNOW) WHICH ACTION SHOULD BE TAKEN FIRST.
    
    public static void topologicalSort(ArrayList<Edge> graph[]){
        // WE USE STACK WITH DFS TO GET TOPOLOGIACAL SORT.
        // BECAUSE STACK FOLLOWS FIRST-IN-LAST-OUT-PRINCIPLE. WE ADD DESTINATION FIRST IN STACK FOLLOWED BY SOURCE. 

        Stack<Integer> stack = new Stack<>(); // TO STORE TOPOLOGICAL-SERIES.
        boolean visited[] = new boolean[graph.length]; 

        for(int i=0; i<graph.length; i++){ // FOR DIRECTED GRAPHS(BECAUSE FROM VERTEX OF GRAPH THERE WILL BE NO ROUTE) AND ALSO FOR DISCONNECTED COMPONENTS OF A GRAPH.
            if(!visited[i]){
                dfs(graph, visited, stack, i); // TO GET STACK(TOPOLOGICAL SEQUENCE) 
            }
        }

        print(stack); // PRINT TOPOLOGICAL-ORDER.

    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> stk, int v){
        vis[v] = true; 
        for(int i=0; i<graph[v].size(); i++){ // TO FIND NEIGHBOURS.
            Edge e = graph[v].get(i); 
            if(!vis[e.dst]){ // NEIGHBOUR NOT VISITED.
                dfs(graph, vis, stk, e.dst); // DFS FOR NEIGHBOUR.
            }
        }
        stk.push(v); // PUSH VERTEX IN STACK WHEN ALL NEIGBOURS/CONTINUE-SERIES OF NEIGHBOYS TILL END ARE VISITED. 
    }

    public static void print(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }


    // TOPOLOGICAL-SORTING USING "BFS" (KAHN'S ALGORITHM).

    public static void getTopSort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length]; // TO STORE IN-DEGREE OF VERTICES.
        Queue<Integer> q = new LinkedList<>();

        getIndegree(graph, indegree); // TO GET-INDEGREE.

        // NOTE : IN DIRECTED-ACYCLIC-GRAPH(DAG) THERE WILL BE A VERTITEX WHOSE IN-DEGREE WILL BE ZERO.(STARTING VERTEX)
        // NOTE : IN-DEGREE = 0 MEANS VERTEX GOT TRAVELLED FROM ALL IT'S PRE-NEIGHBOURS.
        for(int i=0; i<graph.length; i++){ // TO ADD-VERTICES IN QUEUE WHEN THEIR INDEGREE IS ZERO.
            if(indegree[i] == 0){
                q.add(i); 
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove(); 
            System.out.print(curr + " "); // PRINT CURRENT-VERTEX WHOSE IN-DEGREE IS ZERO.

            for(int i=0; i<graph[curr].size(); i++){ // FOR NEIGHBOURS.
                Edge e = graph[curr].get(i);
                indegree[e.dst]--; // DECREMENT IN-DEGREE OF NEIGHBOUR. ITS LIKE WE HAVE TRAVELLED/VISITED TO NEIGHBOUR FROM CURRENT-VERTEX.

                if(indegree[e.dst] == 0){ // ADD VERTEX IN QUEUE. IF IT'S INDEGREE IS ZERO.
                    q.add(e.dst); 
                }
            } 
        }
    }

    public static void getIndegree(ArrayList<Edge> graph[], int array[]){
        for(int i=0; i<graph.length; i++){ // FOR VERTICES.
            for(int j=0; j<graph[i].size(); j++){ // FOR EDGES OF VERTEX.
                Edge e = graph[i].get(j);
                // TARGETING INCOMMING EDGES.
                array[e.dst]++; // INCREMENT INDEGREE OF VERTEX'S NEIBHOUR.
            }
        }
    }


    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v]; // INITIALLY "NULL" IS STORED IN EVERY INDEX OF ARRAY(GRAPH).
        // MAKE EVERY INDEX OF GRAPH AS ARRAYLIST. BECAUSE EVERY INDEX IS A SEPARATE VARIABLE.
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,4));

        // topologicalSort(graph); // USING "DFS"

        getTopSort(graph); // USING "BFS(KAHN'S ALGORITHM)"

    }
}
