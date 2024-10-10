import java.util.LinkedList;
import java.util.Queue;
public class FirstNonRepeatingLetter {
// GIVEN A STRING. ACESS ONE BY ONE CHARACTER OF STRING AND PRINT FIRST NON-REPEATING CHARACTER 
// TILL THAT CHARACTER FROM START-OF-STRING.
    public static void main(String[] args) {
        String str = "aabccxbxzq";
        Queue<Character> queue = new LinkedList<>(); // TO STORE NON-REPEATING CHARACTERS. 
        // FIRST ELEMENT OF QUEUE WILL BE THE FIRST-NON-REPEATING-LETTER IN STRING.
        
        int freq[] = new int[26]; // TO STORE THE FREQUENCY OF LETTER. 

        for(int i=0;i<str.length();i++){ // TO ACESS ONE-BY-ONE CHARACTER OF A STRING.
            char curr = str.charAt(i); // CURRENT LETTER.

            // ADD CURRENT-LETTER IN QUEUE.
            queue.add(curr);

            // UPDATE THE FREQUENCY.
            freq[curr - 'a']++;

        }//end forLoop.

         // REMOVE ALL REPEATED LETTER FROM QUEUE.
         while(!queue.isEmpty() && freq[queue.peek() - 'a'] > 1){
            queue.remove();
        }

        System.out.println(queue.peek());
        

    }
}