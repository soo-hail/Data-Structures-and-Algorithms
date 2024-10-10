import java.util.HashSet;

public class UniqueSubstrings {
    // Q. FIND NO. OF UNIQUE SUB-STRINGS CAN BE FORMED USING A GIVEN STRING.

    // // USING HASHSET.
    // public static int countSubstrings(String str){
    //     HashSet<String> count = new HashSet<>(); // TO STORE UNIQUE SUB-STRINGS.

    //     //  FIND SUBSTRINGS.
    //     for(int i=0; i<str.length(); i++){
    //         String subStr = ""; // TO STORE SUBSTRINGS.
    //         for(int j=i; j<str.length(); j++){
    //             subStr += str.charAt(j);
    //             count.add(subStr);
    //         }
    //     }// end forLoop.
    //     System.out.println(count);
    //     return count.size() + 1;
    // }


    static class Node{
        Node children[] = new Node[26]; 
        boolean eow = false;

        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    // CREATE TRIE.
    static Node root = new Node();
    static int count = 0;

    // INSERT()
    public static void insert(String word){
        Node curr = root; // START TRAVERSING FROM ROOT.
        boolean isNewAdded = false;
    
        for(int i=0; i<word.length(); i++){ // TRAVERSE ALL CHARACTER OF A STRING.
            int indx = word.charAt(i) - 'a'; // INDEX OF A "CHARACTER IN ARRAY".
    
            if(curr.children[indx] == null){ // CHARACTER IS NOT CHILDREN OF CURRENT-NODE. 
                curr.children[indx] = new Node(); // MARK CURRENT CHILDREN AS CHILDREN OF CURRENT-NODE.
                isNewAdded = true; // TO AVOID DUPLICATES.
            }
            else{
                //  CHARACTER IS ALREADY PRESENT IN TRIE -----> DO NOTING. 
            }
    
            curr = curr.children[indx]; // UPDATE CURRENT TO TRAVELL NEXT NODE(CHACTER OF A STRING)
        }
    
        curr.eow = true; // AFTER STORING WHOLE STRING MARK END-OF-WORD AS TRUE.
        if(isNewAdded){
            count++;
        }
    }

    public static int countNodes(Node root){ // TO COUNT NO. OF NODES OF A TRIE == NO. OF STRINGS.
        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]); // INCLUDE COUNT CAME FROM ALL CHILDREN OF NODE. 
            }
        }// end forLoop.

        return count + 1; // INCLUDE COUNT OF CURRENT NODE.
    }
    public static void main(String[] args) {
        // UNIQUE SUBSTRINGS = ALL UNIQUE PREFIXES OF ALL UNIQUE SUFIXES OF A STRING.
        // NOTE : TRIE STORES ALL PREFIXES OF A STRING. 
        // NOTE : NO. OF UNIQUE PREFIXES = COUNT OF NODES OF A TRIE. 

        String str = "ababa";

        // CREATE A TRIE OF ALL SUFIXES OF A STRING.
        for(int i=0; i<str.length(); i++){
            insert(str.substring(i));
        }

        int x = countNodes(root);
        System.out.println(x);


    }
}
