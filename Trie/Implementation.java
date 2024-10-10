public class Implementation {

    // TRIE IS A K-ARRAY TREE, WHICH IS USED TO STORE STRINGS. BEACUSE TIME-COMPLEXITY OF TRAVELLING STRINGS IS LESS.
    // BECAUSE PREFIX OF STRING ARE NOT REPEATED IN TRIE.

    // NOTE : EVERY NODE REPRESENT A SINGLE CHARATER.

    static class Node{
        Node children[] = new Node[26]; // TO STORE CHILDREN OF NODE. 
        boolean eow = false; // TO MARK END OF WORD.

        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null; // STORE "NULL" IN EVERY INDEX OF A TRIE.
            }
        }
    }

    static class Trie{
        Node root = new Node(); // ROOT-NODE DOES NOT REPRESENT ANY CHARACTER. IT STROES CHILDREN.

        // INSERT() : TO INSERT A STRING IN A TRIE. t(n) = O(L) ---> LENGTH OF LARGEST-STRING.
        public void insert(String word){
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
        public boolean search(String word){ // t(n) = O(L) ---> LENGTH OF LARGEST-STRING.
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
    }
    public static void main(String[] args) {
        Trie trie = new Trie(); // CREATE A TRIE.
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0; i<words.length; i++){
            trie.insert(words[i]); // INSERT ALL WORDS IN A TRIE. 
        }

        boolean x = trie.search("there");
        System.out.println(x);
    }    
}