import java.util.HashMap;
public class ValidAnagram {

    public static boolean isAnagram(String s, String t){
        
        if(s.length() != t.length()){ // IF SIZE OF 2 STRINGS ARE NOT EQUAL THEN RETURN FALSE.
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>(); // WE USE HASHMAP TO STORE FREQUENCY OF LETTER.
        
        // STORE FREQUENCY OF LETTERS OF STRING "S".
        for(int i=0; i<s.length(); i++){
            Character currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1); // UPDATE THE FREQUENCY OF LETTER IN MAP.
        }

        // CHECK IN STRING "T".
        for(int i=0; i<s.length(); i++){

        }
        return true;
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
    }    
}