public class Question2 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        // CONSTRUCTURE().
        Info(int size, int min, int max){
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // GET SIZE-OF-LARGEST-BST IN BINARY-TREE().
    static int maxSize = 0; 
    public static Info getSize(Node root){
        if(root == null){
            return new Info(0, 0, 0);
        }

        Info left = getSize(root.left); // TRAVELL LEFT-SUBTREE.
        Info right = getSize(root.right); // TRAVELL RIGHT-SUBTREE.

        if(left.max < root.data && right.min > root.data){ // CURRENT SUBTREE IS A VALID BST.
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size); 
            int max = Math.max(root.data, Math.max(left.max, right.max)); // MAXIMUM VALUE IN WHOLE SUBTREE.
            int min = Math.min(root.data, Math.min(left.min, right.min)); 
            return new Info(size, min, max); 
        }

        return new Info(1, root.data, root.data);  // CURERNT SUBTREE IS NOT VALID BST. START VALIDATING FOR BST FROM CURRENT-NODE.
    }
    

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);root.left.right = new Node(20);
        root.right.left = new Node(45); root.right.right = new Node(70);
        root.right.right.left = new Node(65); root.right.right.right = new Node(80);

        // int x = getSize(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // System.out.println(x);

        getSize(root);
        System.out.println(maxSize);
    }    
}