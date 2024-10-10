public class ShortestUniquePrefix {
    // Q. TO FIND SHOREST AND UNIQUE PREFIX OF ALL STRING IN A ARRAY.
    static class Node{
        Node children[] = new Node[26];
        int countchild = 0;
        boolean eow = false;

        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
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
                curr.countchild++;
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

    // GETPREFIX()
    public static void getPrefix(String word, String prefix[], int preIndx){
        int indx = word.charAt(0) - 'a';
        Node curr = root.children[indx]; // START TRAVERSING FROM STARTING CHARACTER OF A WORD.
        String str = ""; 

        for(int i=0; i<word.length(); i++){ // TO TRAVERSE TRIE. 
            str = str + word.charAt(i);

            if(curr.countchild == 0 || curr.countchild == 1){ // IF CHILDREN OF CURRENT-NODE IS 0 (OR) 1.
                break;
            }

            int nextIndx = word.charAt(i+1) - 'a';
            curr = curr.children[nextIndx]; // UPDATE CURRENT.
        }// end forLoop.

        prefix[preIndx] = str;
    }


    public static void main(String[] args) {
        String words[] = {"zebra", "dog", "duck", "dove"};
        String prefix[] = new String[words.length]; // TO STORE PREFIX OF WORDS.

        // CREATE TRIE.
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        // GET PREFIX.
        for(int i=0; i<words.length; i++){
            getPrefix(words[i], prefix, i);
        }

        // PREINT PREFIX.
        for(String x : prefix){
            System.out.print(x + " ");
        }
    }    
}