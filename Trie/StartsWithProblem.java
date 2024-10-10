public class StartsWithProblem {
    // Q. CHECK WHTHER ANY STRING IN TRIE STARTS WITH GIVEN PREFIX.

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


    public static boolean startsWith(String prefix){
        Node curr = root; // START TRAVERSING TRIE FROM ROOT.

        for(int i=0; i<prefix.length(); i++){ // TO TRAVELL PREFIX.
            int indx = prefix.charAt(i) - 'a'; // INDEX OF CURRENT-CHARACTER IN NODE.

            if(curr.children[indx] == null){ // PREFIX MIS-MATCHED.
                return false;
            }

            curr = curr.children[indx]; // UPDATE CURRENT.
        }

        return true;
    }
    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};

        // CREATE TRIE.
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        boolean x = startsWith("wo");
        System.out.println(x);

    }
}
