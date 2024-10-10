import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {
    
    static class Edge{
        int city;
        int neigh; // NEIGHBOUR.
        int cost; // TICKET-COST.

        Edge(int city, int neigh, int cost){
            this.city = city;
            this.neigh = neigh;
            this.cost = cost;
        }
    }

    static class Info{
        int vtx;
        int cost;
        int k;

        Info(int vtx, int cost, int k){
            this.vtx = vtx;
            this.cost = cost;
            this.k = k;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int flights[][]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>(); // INITIALIZE GRAPH(ARRAY) WITH ARRAY-LIST.
        }

        for(int row=0; row<flights.length; row++){ // TO TRAVERSE FLIGHTS(MATRIX).
            int from = flights[row][0]; int to = flights[row][1]; int cost = flights[row][2];

            graph[from].add(new Edge(from, to, cost)); // ADD EDGE(FLIGHT) IN GRAPH.
        }
    }

    public static int getCheapestFlight(ArrayList<Edge> graph[], int src, int dst, int k){
        // WE SOLVE THIS PROBLEM USING BFS(MODIFIED).

        Queue<Info> q = new LinkedList<>(); // FOR "BFS"
        int cheapestPrice = Integer.MAX_VALUE; // TO STORE CHEAPTEST FLIGHT-TICKET.
        Boolean isFlight = false;

        q.add(new Info(src, 0, 0)); // FOR SOURCE.

        while(!q.isEmpty()){
            Info curr = q.remove();

            for(int i=0; i<graph[curr.vtx].size(); i++){ // FOR NEIGHBOURS.
                Edge e = graph[curr.vtx].get(i);

                if(e.neigh == dst){
                    int newCost = curr.cost + e.cost;
                    cheapestPrice = Math.min(cheapestPrice, newCost);
                    isFlight = true;
                    continue; // DON'T NEED TO ADD DESTINATION IN QUEUE.
                }

                if(curr.k + 1 <= k){ // IF WE CAN TAKE(STAY) NEXT-STOP.
                    q.add(new Info(e.neigh, curr.cost + e.cost, curr.k + 1)); // ADD NEIGHBOUR CITY IN QUEUE, IF WE CAN TRAVELL TO IT.
                }
            }
        } //end whileLoop.

        return isFlight? cheapestPrice : -1;
    }

    public static void main(String[] args) {
        int cities = 6;
        int src = 1; int dst = 4; 
        int k = 1; // NO. OF STOPS

        int flights[][] = {{1,2,200}, {1,3,20}, {2,3,100}, {3,0,40}, {3,4,500}, {0,1,300}, {0,4,10}, {4,5,250}};

        ArrayList<Edge> graph[] = new ArrayList[cities]; // GRAPH(TO STORE CITIES).

        createGraph(graph, flights);

        int x = getCheapestFlight(graph, src, dst, k);
        
        System.out.println(x);
    }
}
