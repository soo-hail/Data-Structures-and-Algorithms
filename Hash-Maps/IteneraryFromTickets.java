import java.util.HashMap;
public class IteneraryFromTickets {
    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>(); // REVERSE MAP.
        // GET REVRSE PAIRS OF TICKETS TO FIND START PLACE BY SEARCH IT IN KEYS.
        for(String x : tickets.keySet()){
            revMap.put(tickets.get(x), x); // ADDING REVERSE PAIR.
        }

        // GET START OF JOURNEY : THE CITY WHERE WE DOES NOT HAVE TICKET TO GO.   
        for(String x : tickets.keySet()){
            if(!revMap.containsKey(x)){ 
                return x; // START POINT(PLACE).
            }
        }

        return "";

    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Delhi", "Kochi");
        tickets.put("Chennai", "Bengalore");
        tickets.put("Kochi", "Srilanka");
        tickets.put("Bengalore", "Delhi");
        tickets.put("Goa","Chennai");

        // FIND STARTING PLACE OF JOURNEY.
        String start = getStart(tickets);

        while(tickets.containsKey(start)){
            System.out.print(start + "---->");
            start = tickets.get(start); // UPDATE START.
        }
        System.out.println(start);
    }
}
