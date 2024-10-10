/* BIPARTITE-GRAPH IS A GRAPH WHOS VERTICES CAN BE DIVIDED INTO TWO INDEPENDENT SETS AND VERTICES OF SAME 
   SET WILL NOT BE FORMING EDGE.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import  java.util.Queue;
public class Bipartite {

  // EDGE CLASS.
  static class Edge{
    int src; // SOURCE 
    int dest; // DESTINATION
    int col = -1; // COLOUR(we use colouring algo to slove this algo).

    // CONSTRUCTURE.
    Edge(int src, int dest){
      this.src = src;
      this.dest = dest;
    }
  }

  // IS-BIPARTITE GRAPH()
  public static boolean isBipartiteUtil(ArrayList<Edge> graph[], int sp, int color[] ){
    Queue<Integer> q = new LinkedList<>();
    q.add(sp);color[sp] = 1;

    while(!q.isEmpty()){
      int curr = q.remove();

      for(int i=0; i<graph[curr].size(); i++){ // ADD NEIGHBOURS OF CURRENT-NODE
        int n = graph[curr].get(i).dest; // NEIGHBOUR.
        // IF NEIGHBOUR IS NOT ALREADY COLOURED.
        if(color[n] == 0){
          q.add(n); 
          color[n] = color[curr]==1? 2 : 1; // ADD COLOUR TO NEIGHBOUR VERTEX. 
        }
        else{ // ALREADY COLOURED.
          if(color[curr] == color[n]){ // IF COLOUR OF CURRENT AND NEIGHBOUR VERTEX OF SAME IS SAME THEN IT IS NOT A BIPARTITE-GRAPH.
            return false;
          }
        }
      }// end forLoop.
    }

    return true;
  }

  public static boolean isBipartite(ArrayList<Edge> graph[]){
    // WE USE COLOURING-ALGORITHM WITH "BFS".
    int color[] = new int[graph.length]; // TO STORE COLOUR OF A GRAPH AND WORKES AS VISITED-ARRAY.
    // 0 ---> NOT COLOURED
    // 1 ---> COLOUR-1(set1)
    // 2 ---> COLOUR-2(set2)


    for(int i=0; i<graph.length; i++){ // FOR DIFFERNT COMPONENETS OF GRAPH.
      if(color[i] == 0){
        if(!isBipartiteUtil(graph, i, color)) return false; // IF ANY COMPONENT IS NOT BIPARTITE, RETURN ZERO.
      }
    }

    return true;
  }
    
    public static void main(String[] args) {
      int v = 5;
      ArrayList<Edge> graph[] = new ArrayList[v]; // ADJECENCY-LIST.
      // INDEX == VERTEX, AT EVERY-INDEX WE STORE EDGES OF THAT VERTEX.

      for(int i=0; i<graph.length; i++){ 
        graph[i] = new ArrayList<>(); // INITIALIZE EVERY INDEX OF EDGE WITH ARRAY-LIST.
      }

      // STORE EDGES IN ADJECENCY-LIST.
      graph[0].add(new Edge(0, 1));
      graph[0].add(new Edge(0, 2));

      graph[1].add(new Edge(1, 0));
      graph[1].add(new Edge(1, 3));

      graph[2].add(new Edge(2, 0));
      graph[2].add(new Edge(2, 3));

      graph[3].add(new Edge(3, 1));
      graph[3].add(new Edge(3, 2));

      // graph[4].add(new Edge(4, 2));
      // graph[4].add(new Edge(4, 3));

      System.out.println(isBipartite(graph));

    }
}
