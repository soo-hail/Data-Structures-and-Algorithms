public class MinDepth {
    // FIND MINIMUM DEPTH OF A BINARY-TREE.
    
    static class Node{
        int data;
        Node left; Node right; 

        // CONSTRUCTURE
        Node(int data){
            this.data = data; 
        }
    }

    static class BinaryTree{
        int indx = -1;

        public Node buildBT(int nodes[]){
            indx++;
            if(nodes[indx] == -1){
                return null;
            }

            // CREATE NEW-NODE.
            Node newNode = new Node(nodes[indx]); 
            newNode.left = buildBT(nodes);
            newNode.right = buildBT(nodes);

            return newNode;
        }

        public void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
 
        public int getMinDepth(Node root, int depth){
            if(root == null){
                return depth;
            }

            int x = getMinDepth(root.left, depth+1);
            int y = getMinDepth(root.right, depth+1); 
            return Math.min(x, y);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,8,6,-1,-1,5,-1,-1,2,9,-1,-1,-1};
        
        BinaryTree bt = new BinaryTree(); 
        Node root = bt.buildBT(nodes);

        System.out.println(bt.getMinDepth(root, 0)); // GET MIN-DEPTH.
    }
}
