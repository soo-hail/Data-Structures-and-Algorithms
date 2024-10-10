import java.util.LinkedList;
import java.util.Queue;

public class Insertion {
    static class Node{
        int data;
        int height = 1; // NOTE(NEW THING TO STORE HEIGHT).

        Node left;
        Node right;

        // CONSTRUCTURE.
        Node(int data){
            this.data = data;
        }
    }

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }

        return root.height;
    }

    public static int getBalanceFactor(int lh, int rh){
        return lh - rh;
    }

    public static Node rightRotate(Node root){
        Node pc = root.left; // POINT OF ROTATION.
        Node t = pc.right; // STORE RIGHT-SUBTREE OF POINT-OF-ROTATION.

        // RE-ARRANGE.
        pc.right = root;
        root.left = t; // SUBTREE OF POINT-OF-ROTATION IS STORE WITH "BST SATISFING PROPERTIES".

        // UPDATE HEIGHT
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1; 
        pc.height = Math.max(getHeight(pc.left), getHeight(pc.right)) + 1;

        return pc; // NEW ROOT.

    }

    public static Node leftRotate(Node root){
        Node pc = root.right; // POINT OF ROTATION.
        Node t = pc.left; // STORE LEFT-SUBTREE OF POINT-OF-ROTATION.


        // RE-ARRANGE.
        pc.left = root;
        root.right = t; // SUBTREE OF POINT-OF-ROTATION IS STORE WITH "BST SATISFING PROPERTIES".

        // UPDATE HEIGHT
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1; 
        pc.height = Math.max(getHeight(pc.left), getHeight(pc.right)) + 1;

        return pc; // NEW ROOT.
    }

    public static Node insert(Node root, int key){
        if(root == null){ // SAME AS BST.
            return new Node(key); 
        }

        if(key < root.data){
            root.left = insert(root.left, key); // TRAVELL IN LEFT-SUBTREE
        }
        else if(key > root.data){
            root.right = insert(root.right, key); // TRAVELL IN RIGHT SUBTREE
        }
         

        int lh = getHeight(root.left); // LEFT HEIGHT.
        int rh = getHeight(root.right); // RIGHT HEIGHT.

        root.height = Math.max(lh, rh) + 1; // UPDATE HEIGHT OF CURRENT NODE.

        int bf = getBalanceFactor(lh, rh); // BALANCE-FACTOR.
        // NOTE : BALANCE-FACTOR IN BALANCED TREE IS ALWAYS -1/0/1
        // System.out.println(bf);


        if(bf < -1){ // (BF = -VE) == RIGHT-CASE.
            if(key >= root.right.right.data){ // RIGHT-RIGHT
                return leftRotate(root); // RETURN RE-ARRANGED NODES.
            }

            if(key <= root.right.left.data){ // RIGHT-LEFT
                root.right = rightRotate(root.right); // RIGHT-ROTATE ROOT-RIGHT.
                return leftRotate(root); // RETURN RE-ARRANGED NODES.
            }
        }

        else if(bf > 1){ // (BF > 1) == LEFT-CASE.
            if(key <= root.left.left.data){ // LEFT-LEFT.
                return rightRotate(root); // RETURN RE-ARRANGED NODES.
            }

            if(key >= root.left.right.data){ // LEFT-RIGHT.
                root.left = leftRotate(root.left); // LEFT-ROTATE ROOT-LEFT.
                return rightRotate(root); // RETURN RE-ARRANGED NODES.
            }
        }

        // IF BF = -1/0/1 
            return root;
    }

    // LEVEL-ORDER()
        public static void levelorder(Node root){
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

    // INORDER.
    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = null;
        int array[] = {10,20,30,40,50,25};

        for(int i=0; i<array.length; i++){
            root = insert(root, array[i]); // ROOT WILL BE UPDATING(TO GET A BALANCED BST). 
        }

        levelorder(root);
        
    }    
}