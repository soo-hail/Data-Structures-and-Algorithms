public class ValidateBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // VALIDATE-BST : CHECK NODE-DATA IN "RANGE BETWEEN LOW AND HIGH".
    public static boolean isBST(Node root, int low, int high){
        if(root == null){
            return true;
        }
        if(root.data <= low || root.data >= high){
            return false;
        }
        return isBST(root.left, low, root.data) && isBST(root.right, root.data, high);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);

        root.left.left = new Node(3);root.left.right = new Node(6);
        root.right.left = new Node(10); root.right.right = new Node(14);

        boolean x = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(x);

    }
}
