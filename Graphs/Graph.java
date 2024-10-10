import java.util.ArrayList;
public class Graph {
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

    public static void getNeighbours(ArrayList<Edge> graph[], int vertex){
        ArrayList<Edge> curr = graph[vertex]; // LIST OF EDGES OF CURRENT VERTICES.
        for(int i=0; i<curr.size(); i++){
            Edge currEdge = curr.get(i);
            System.out.println(currEdge.dst);
        }
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v]; // INITIALLY "NULL" IS STORED IN EVERY INDEX OF ARRAY(GRAPH).
        // MAKE EVERY INDEX OF GRAPH AS ARRAYLIST. BECAUSE EVERY INDEX IS A SEPARATE VARIABLE.
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // EVERY INDEX OF ARRAY IS A ARRAYLIST. 

        /*
                         4
                        /
            0          /(2)
             \       2
          (5) \     / \ 
               \(1)/   \ (1)
                \ /     \             
                 1-------3
                    (3)        
         
         
         */
        

        // VERTEX - 0
        graph[0].add(new Edge(0,1,5));

        // VERTEX - 1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // VERTEX - 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        // VERTEX - 3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // VERTEX - 4
        graph[4].add(new Edge(4,2,2));

        getNeighbours(graph, 2);
    }    
}