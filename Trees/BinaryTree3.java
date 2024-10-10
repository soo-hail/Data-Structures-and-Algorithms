public class BinaryTree3 {
    
    static class Node{
        int data;
        Node left;
        Node right;

        // CONSTRUCTURE.
        Node(int value){
            this.data = value;
            left = null;
            right = null;
        }
    }

    static class BinaryTree{
        private int index = -1; // TO TRACE INDEX OF "NODES ARRAY" 

        // BUILDTREE()
        public Node BuildTree(int nodes[]){
            index++; 
            
            if(nodes[index] == -1){
                return null;
            }
            // CREATE A NODE.
            Node newNode = new Node(nodes[index]);
            // CALL FOR LEFT-SUBNODE.
            newNode.left = BuildTree(nodes);
            // CALL FOR RIGHT-SUBNODE.
            newNode.right = BuildTree(nodes);
            return newNode;
        }

        // POSTORDER()
        public void postorder(Node root){
            if(root == null){
                return;
            }
            
            // TRAVERSING TREE.
            System.out.print(root.data + " ");
            postorder(root.left);
            postorder(root.right);
        }
    }

    public static boolean isIdentical(Node root, Node subRoot){

        if(root == null && subRoot == null){
            return true;
        }

        // WE CHECK FOR NON-IDENTICAL CASES.
        if((root == null && subRoot != null) || (root != null && subRoot == null)){
            return false;
        }

        if(root.data != subRoot.data){
            return false;
        }

        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right); // BOTH LEFT AND RIGHT SUBTREES SHOULD BE IDENTICAL.
    }

    // ISSUBTREE()
    public static boolean isSubtree(Node root, Node subRoot){
        // BASECASE.
        if(root == null){
            return false; // SUBROOT NOT PRESENT IN THAT SUBTREE(OF TREE). 
        }

        if(root.data == subRoot.data){ // MATCH ROOT AND SUBROOT.
            if(isIdentical(root, subRoot)){
                return true; // IF SUBTREE IS IDENTICAL THEN RETURN TRUE.
            }
        }

        // CHECK IN LEFT-SUBTREE.
        if(isSubtree(root.left, subRoot)){
            // IF SUBTREE PRESENT IN LEFT-SUBTREE OF TREE. THEN DIRECTLY RETURN FROM HERE DON'T NEED TO CHECK IN RIGHT SUBTREE.
            return true;
        }

        // CHECK IN RIGHT-SUBTREE.
        if(isSubtree(root.right, subRoot)){
            return true;
        }

        return false;
    }


     
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.BuildTree(nodes);

        int subtree[] = {3,-1,6,-1,-1};
        BinaryTree st = new BinaryTree();
        Node subRoot = st.BuildTree(subtree);

        System.out.println(isSubtree(root, subRoot));



    }
}
