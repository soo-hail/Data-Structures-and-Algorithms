import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    static class Node{
        int data;
        Node left; // INITIALIZED TO "NULL"
        Node right; // INITIALIZED TO "NULL"

        Node(int data){
            this.data = data;
        }
    }

    static class BST{

        private Node root = null; // CREATE A ROOT-NODE AND INITIALIZE IT WITH "NULL".

        // INSERT()
        private Node insert(Node root, int currNode){
            if(root == null){ // TO INSERT A "CURRNODE" AT IT'S CORRECT POSITION.
                // WE TRAVERSE A TREE ACCORDING TO "BST" RULES. IF ROOT == NULL ---> INSERT "CURRNODE" THERE.
                root = new Node(currNode);
                return root;
            }

            if(currNode < root.data){
                root.left = insert(root.left, currNode); 
            }
            else{
                root.right = insert(root.right, currNode);
            }

            return root; 
        }
        
        // BUILD-BST()
        public Node BuildBST(int node[]){

            for(int i=0; i<node.length; i++){  // WE INDIVIDUALLY INSERT-NODES IN "BST".
                root = insert(root, node[i]); // EVERY TIME UPDATED ROOT IS PASSED IN RECURSIVE FUNCTION(ROOT IS UPDATED ONLY ONCE).
            }

            return root;
        }

        // INORDER()
        public void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // LEVEL-ORDER()
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

        // SEARCH()
        public boolean search(Node root, int key){
            if(root == null){ // KEY NOT FOUND.
                return false;
            }

            if(root.data == key){ // KEY FOUND.
                return true;
            }
            else if(key > root.data){
                return search(root.right, key); // SEARCH IN RIGHT SUBTREE.
            }
            else{ // KEY < ROOT.DATA
                return search(root.left, key); // SEARCH IN LEFT SUBTREE.
            }
        }

        // GET-INORDER-SUCESSOR : LEFT MOST NODE IN A RIGHT-SUBTREE.
        private Node getInorderSucessor(Node node){
            if(node.left == null){
                return node;
            }
            return getInorderSucessor(node.left);
        }

        // DELETE NODE.
        public Node delete(Node root, int node){
            if(root == null){
                System.out.println("NODE NOT FOUND!!!  ");
                return null;
            }

            if(node == root.data){ // "NODE" FOUND
                if(root.left == null && root.right == null){ // NO-CHILD
                    return null; // PARENT OF "NODE" WILL POINT TO NULL. 
                }
                else if(root.left == null || root.right == null){ // ONE CHILD  
                    // RETURN 'CHILD' TO 'PARENT'.
                    if(root.left != null){
                        return root.left;
                    }
                    else{
                        return root.right;
                    }
                }
                else{ // TWO CHILDREN.
                    // FIND INORDER-SUCESSOR.
                    Node sucessor = getInorderSucessor(root.right); // LEFT MOST NODE IN "RIGHT-SUBTREE". 

                    delete(root, sucessor.data); // DELETE SUCESSOR FROM THE BTS.

                    root.data = sucessor.data; // MAKE "NODE" AS SUCESSOR.
                }
            }
            else if(node < root.data){ // SEARCH IN LEFT-SUBTREE.
                root.left = delete(root.left, node);
            }
            else{  // SEARCH IN RIGHT-SUBTREE.
                root.right = delete(root.right, node);
            }

            return root; // EXECUTED IN "NODE" NOT FOUND CASE. WE NEED TO RETURN "ROOT" TO MAIN SAME STRUCTURE OF BST.
        } // END DELETE()
    }

    public static void main(String[] args) {
        int nodes[] = {8,5,6,3,1,4,10,11,14};

        BST bst = new BST();

        Node root = bst.BuildBST(nodes);

        // bst.inorder(root); System.out.println();

        bst.levelorder(root);
        
        // System.out.println(bst.search(root, 9));

        
        System.out.println("AFTER DELECTION : ");
        bst.delete(root, 5);
        bst.levelorder(root);

    }    
}