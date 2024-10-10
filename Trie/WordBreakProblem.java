public class WordBreakProblem {

    static class Node{
        Node children[] = new Node[26]; // TO STORE CHILDREN OF NODE. 
        boolean eow = false; // TO MARK END OF WORD.

        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null; // STORE "NULL" IN EVERY INDEX OF A TRIE.
            }
        }
    }

    static Node root = new Node();

    // INSERT()
    public static void insert(String word){
        Node curr = root; // START TRAVERSING FROM ROOT.

        for(int i=0; i<word.length(); i++){ // TRAVERSE ALL CHARACTER OF A STRING.
            int indx = word.charAt(i) - 'a'; // INDEX OF A "CHARACTER IN ARRAY".

            if(curr.children[indx] == null){ // CHARACTER IS NOT CHILDREN OF CURRENT-NODE. 
                curr.children[indx] = new Node(); // MARK CURRENT CHILDREN AS CHILDREN OF CURRENT-NODE.
            }
            else{
                //  CHARACTER IS ALREADY PRESENT IN TRIE -----> DO NOTING. 
            }

            curr = curr.children[indx]; // UPDATE CURRENT TO TRAVELL NEXT NODE(CHACTER OF A STRING)
        }

        curr.eow = true; // AFTER STORING WHOLE STRING MARK END-OF-WORD AS TRUE.
    }


    // SEARCH()
    public static boolean search(String word){ // t(n) = O(L) ---> LENGTH OF LARGEST-STRING.
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            int indx = word.charAt(i) - 'a'; 

            if(curr.children[indx] == null){ // IF CURRENT-CHARACTER IS NOT PRESENT IN CURRENT-NODE.
                return false;
            }

            curr = curr.children[indx]; // UPDATE CURRERNT.
        }

        if(curr.eow){ // WORD SHOULD END.
            return true;
        }

        return false;
    }

    public static boolean canBreakWords(String key){

        if(key.length() == 0){
            return true; // WHEN THERE IS NO CHARACTER IN OTHER PART OF "KEY".  
        }

        for(int i=0 ; i<key.length(); i++){ // FOR TRAVELLING "KEY".
            if(search(key.substring(0, i+1)) && canBreakWords(key.substring(i+1))){
                return true; // IF BOTH CONDITION ARE TRUE.
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        // CREATE TRIE.
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        String key = "ilikesamsung";
        System.out.println(canBreakWords(key));

    }    
}