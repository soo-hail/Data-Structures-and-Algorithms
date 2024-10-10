public class LongestWordWithAllPrefixes {
    // Q. FIND A LONGEST-WORD IN "PREFIX(ARRAY)" WHOSE ALL PREFIXES ARE PRESENT IN "PREFIX(ARRAY)" 

    static class Node{
        Node children[] = new Node[26];
        boolean eow;

        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node(); // ROOT OF A TRIE.

    // INSERT()
    public static void insert(String word){
        Node curr = root; // TO START TRVERSE A TRIE.

        // AT EVERY LEVEL A SINGLE WORD IS STORED.
        for(int i=0; i<word.length(); i++){ // TO GET ALL CHARACTERS OF A WORD.
            int indx = word.charAt(i) - 'a';

            if(curr.children[indx] == null){ // IF CURRENT-CHARACTER IS NOT PRESENT IN TRIE.
                curr.children[indx] = new Node();
            }
            else{
                // DO NOTHING.
            }

            curr = curr.children[indx]; // UPDATE CURRENT FOR NEXT ITERATRION.
        }// end forLoop.

        curr.eow = true;
    }

    static class LongestWord{
        int size;
        String word;

        LongestWord(int size, String word){
            this.size = size;
            this.word = word;
        }
    }

    public static boolean searchUtil(String word){
        Node curr = root; // START TRAVERSING FROM ROOT.

        for(int i=0; i<word.length(); i++){
            int indx = word.charAt(i) - 'a';
            // LOGIC(MAIN) : EVERY CHARACTER IN WORD SHOULD BE END-OF-WORD FOR ----> LONGEST WORD WITH ALL PREFIXES.   
            if(!curr.children[indx].eow){ // IF CURRENT CHARACTER IS NOT A END OF THE WORD.
                return false;
            }

            curr = curr.children[indx];
        }

        return true;
    }


    public static String getLongestWord(String words[]){
        String lw = ""; // LONGEST WORD.
        for(int i=0; i<words.length; i++){
            if(searchUtil(words[i])){
                if(words[i].length() >= lw.length()){

                    if(words[i].length() == lw.length()){
                        if(words[i].compareTo(lw) > 0){ // LEXICOGRAPHIC CONDITION.
                            continue;
                        }
                    }
                    lw = words[i];
                }
            }
        }// end forLoop
        return lw;
    }
    
    public static void main(String[] args) {
        String prefix[] = {"a", "bannana", "app", "appl", "ap", "apply", "apple" };

        // CREATE A TRIE.
        for(int i=0; i<prefix.length; i++){
            insert(prefix[i]);
        }

        System.out.println(getLongestWord(prefix));
    }
}