import java.util.LinkedList;
import java.util.Queue;
public class FirstNonRepeatingLetter2 {
    // FIND FIRST NON-REPEATING CHARACTER IN STREAM OF CHARACTERS.
    // STREAM : STRING IS FORMING ONE-BY-ONE CHARACTER. 
    public static void main(String[] args) {
        String str = "aabccxb";
        Queue<Character> queue = new LinkedList<>(); // TO GET FIRST NON-REPEATING LETTER OF A STREAM.
        int freq[] = new int[26]; // TO STORE FREQUENECY OF CHARACTERS OF STRING.

        for(int i=0;i<str.length();i++){ // TO GET "STREAM OF STRING" USING CHARACTERS ONE-BY-ONE.
            char curr = str.charAt(i); // GET CURRENT CHARACTER.

            // UPDATE FREQUENCY.
            freq[curr-'a']++;

            // ADD CURRENT CHARACTER IN QUEUE.
            queue.add(curr);

            // REMOVE REPEATING LETTERS FROM QUEUE.
            while(!queue.isEmpty() && freq[queue.peek()-'a'] > 1){
                queue.remove();
            }

            if(queue.isEmpty()){ // NO NON-REPEATING ELEMENTS IN QUEUE. 
                System.out.print("-1 ");
            }else{
                System.out.print(queue.peek() + " ");
            }
        }

    }
}
