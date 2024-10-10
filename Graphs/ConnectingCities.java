import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * ConnectingCities
 */
public class ConnectingCities {
    static class Pair implements Comparable<Pair>{
        int city;
        int cost; // COST OF REACHING TO "CITY" FROM CURRENT-NODE(VERTEX).

        Pair(int city, int cost){
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; // TO COMPARE IN ACCENDING ORDER.
        }
    }

    public static int getMinCost(int cities[][]){
        int minCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<Integer> connected = new HashSet<>();  // TO TRACK WHETHER A CITY IS VISITED OR NOT.

        // FOR STARTING-POINT.
        pq.add(new Pair(0, 0)); 

        while(connected.size() < cities.length){ // WHILE ALL-CITIES ARE NOT CONNECTED. BECAUSE WE HAVE TO ADD IT'S NEIGHBOURS IN "PQ" ONLY ONCE.
            Pair curr = pq.remove(); // WE GET CITY WHERE WE CAN TRAVELL IN LESS-COST. 
            
            if(!connected.contains(curr.city)){ // IF CURRENT-CITY IS NOT GET CONNECTED.
                connected.add(curr.city);
                minCost += curr.cost;
                // NOTE : IN EACH ROW(CITY) IT'S NEIGHBOUR'S INFO IS STORED. 
                for(int col=0; col<cities[curr.city].length; col++){ // ADD IT'S NEIGHBOUR IN PRIORITY-QUEUE.
                    int currCost = cities[curr.city][col];

                    if(currCost > 0){ // 0 == NO EDGE(NO CONNECTION).
                        pq.add(new Pair(col, currCost)); 
                    }
                }
            }
        }

        return minCost; 
    }


    public static void main(String[] args) {
        int cities[][] = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };

        int x = getMinCost(cities);
        System.out.println(x);
    }
}