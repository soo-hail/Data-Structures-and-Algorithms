import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Questions {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    static class BST{
        Node root = null; // INITIALIZE WITH "NULL"

        public void levelorder(Node root){
            Queue<Node> q = new LinkedList<>(); 
            q.add(root); q.add(null); 

            while(!q.isEmpty()){
                Node curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        System.out.println();
                        break;
                    }
                    
                    q.add(null);
                    System.out.println();
                    continue; // SKIP(ADDING CHILD NODES{"null" does not has child nodes})
                }

                System.out.print(curr.data + " ");

                // ADD CHILD NODES IN "QUEUE".
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

        // INSERT()
        private Node insert(Node root, int node){
            if(root == null){
                return root = new Node(node); // RETURN NEW-NODE.
            }
            else if(node > root.data){
                root.right = insert(root.right, node);
            }
            else{
                root.left = insert(root.left, node);
            }
            return root; // EXECUTES ONLY WHEN "root != null".
        }


        // BUILD()
        public Node build(int nodes[]){
            for(int i=0; i<nodes.length; i++){ // TO SELECT EACH NODE.
                root = insert(root, nodes[i]); // INSERTS CURRENT NODE IN CORRECT POSITION.
            }

            return root;
        }

        // INORDER()
        public static void inorder(Node root){
            if(root == null){ // BASE CASE.
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void getRange(Node root, int node1, int node2){
            if(root == null){ // BASE-CASE
                return;
            }

            if(root.data >= node1 && root.data <= node2 ){ // PRINT "NODES" WHICH ARE IN-BETWEEN THE RANGE.
                getRange(root.left, node1, node2); 
                System.out.print(root.data + " ");  
                getRange(root.right, node1, node2);
            }
            else if(root.data < node1){ 
                // NO NEED TO SEARCH IN LEFT-SUBTREE.
                getRange(root.right, node1, node2); 
            }
            else if(root.data > node2){ 
                // NO NEED TO SEARCH IN RIGHT-SUBTREE.
                getRange(root.left, node1, node2);
            }
        }

        public void getPaths(Node root, ArrayList<Integer> path){

            if(root.left == null && root.right == null){ // PRINT PATH WHEN WE HAVE REACHED TO "LEAF NODE"
                path.add(root.data);
                for(int i=0; i<=path.size()-2; i++){
                    System.out.print(path.get(i) + "--->");
                }
                System.out.println(path.get(path.size()-1));
                return;
            }

            path.add(root.data);
            if(root.left != null){ // TRAVEL TO LEFT-SUBTREE.
                getPaths(root.left, path);
            }

            if(root.right != null){ // TRAVELL TO RIGHT-SUBTREE.
                getPaths(root.right, path);
            }

            path.remove(path.size()-1);
        } // end getPaths()

        public static void getInorderSequence(Node root, ArrayList<Integer> sequence){
            if(root == null){
                return;
            }

            getInorderSequence(root.left, sequence);
            sequence.add(root.data);
            getInorderSequence(root.right, sequence);
        }

        public boolean isValidBST(Node root){
             ArrayList<Integer> seq = new ArrayList<>(); 
             getInorderSequence(root, seq);

             for(int i=0; i<=seq.size()-2; i++){
                if(seq.get(i+1) < seq.get(i)){
                    return false;
                }
             }
             return true;
        }

        public Node getMirror(Node root){
            if(root == null){ // ROOT-NODE.
                return null;
            }

            // TRAVEL BINARY SEARCH TREE.
            Node right = root.right; // TEMP NODE
            root.right = getMirror(root.left);
            root.left = getMirror(right);

            return root;
    
        }

        // SORTED-ARRAY TO BALANCED-BST.
        public Node build(int array[], int start, int end){
            if(start > end){
                return null;
            }

            int mid = (start+end)/2;
            Node newNode = new Node(array[mid]); // CREATE NEWNODE.
            newNode.left = build(array, start, mid - 1);
            newNode.right = build(array, mid+1, end);

            return newNode;
        }

        // BST TO BALANCED-BST. 

        public static Node build(ArrayList<Integer> seq, int start, int end){
            if(start > end){
                return null;
            }

            int mid = (start+end)/2; // FIND MID.
            Node root = new Node(seq.get(mid)); // CREATE A ROOT-NODE TO A SUBTREE.
            root.left = build(seq, start, mid-1); // LEFT-SUBTREE.
            root.right = build(seq, mid+1, end); // RIGHT-SUBTREE.
            return root;
        }

        public static Node BalancedBST(Node root){
            ArrayList<Integer> inorderSeq = new ArrayList<>(); // TO STORE INORDER SEQUENCE.

            getInorderSequence(root, inorderSeq);
            
            Node node = build(inorderSeq, 0, inorderSeq.size()-1);

            return node;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {8,6,10,5,11,3,12};

        BST bst = new BST();
        Node root = bst.build(nodes);
        
        // bst.inorder(root);
        // bst.getRange(root, 70, 110);

        // System.out.println("PATHS FROM ROOT TO LEAF-NODES : ");
        // bst.getPaths(root, new ArrayList<>());

        // System.out.println(bst.isValidBST(root));

        // bst.levelorder(root);
        // System.out.println("AFTER MIRROR : ");
        // bst.getMirror(root);
        // bst.levelorder(root);
        // bst.inorder(root); // INORDER-SEQUENCE OF MIRROR-BST WILL BE IN DECENDING ORDER.

        // SORTED-ARRAY TO "BALANCED-BST"
        // int array[] = {3,5,6,8,10,11,14};
        // Node root2 = bst.build(array, 0, array.length-1);
        // bst.levelorder(root2);
        // bst.inorder(root2);

        bst.levelorder(root);
        Node root2 = bst.BalancedBST(root); // BST TO BALANCED-BST.
        System.out.println("BALANCED BST : ");
        bst.levelorder(root2);


    }
}
