import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class TopviewOfTree {

    static class Node{
        int data;
        Node left;
        Node right;

        // CONSTRUCTURE.
        Node(int data){
            this.data = data;
        }
    }

    static class Info{
        Node node; // NODE.
        int hd; // HORIZONTAL DISTANCE.

        Info(Node n, int d){
            this.node = n;
            this.hd = d;
        }
    }

    static class BinaryTree{
        int index = -1;
        public Node create(int nodes[]){ // THIS FUNCTION WILL RETURN ROOT NODE.
            index++;

            if(nodes[index] == -1){ // BASE-CASE
                return null;
            }

            // CREATE A NEWNODE.
            Node newNode = new Node(nodes[index]);

            newNode.left = create(nodes);
            newNode.right = create(nodes);
            return newNode;
        }

        public void inorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            inorder(root.left);
            inorder(root.right);
        }

        public void getTopView(Node root){
            HashMap<Integer, Node> map = new HashMap<>(); // TO STORE "HORIZONTAL-DISTANCE AND ITS CORRESPONDING-NODE" WHEN IT IS OCCURING FOR FIRST TIME. 
            Queue<Info> q = new LinkedList<>(); // FOR LEVEL ORDER TRAVERSAL.

            // ADD FOR ROOT NODE.
            q.add(new Info(root, 0)); // BECAUSE ROOT IS THE ORIGIN ITS "HORIZONTAL-DISTANCE WILL BE ZERO".
            q.add(null);
            int min = 0; int max = 0; // TO TRACK START AND END FOR PRINTING NODES IN ORDER. 
            while(!q.isEmpty()){
                Info currInfo = q.remove();
                if(currInfo == null){
                    if(q.isEmpty()){
                        break;
                    }
                    q.add(null); // FOR NEXT LEVELS.
                    continue;
                }

                min = Math.min(min, currInfo.hd);
                max = Math.max(max, currInfo.hd);
                if(!map.containsKey(currInfo.hd)){ // IF HORIZONTAL-DISTANCE IS NOT PRESENT IN MAP I.E H-DISTANCE IS OCCURING FOR FIRST TIME.
                    map.put(currInfo.hd, currInfo.node);
                }

                Node currNode = currInfo.node;
                if(currNode.left != null){ // IF A CURRENT NODE HAS A LEFT NODE.
                    q.add(new Info(currNode.left, currInfo.hd - 1));
                }
                if(currNode.right != null){
                    q.add(new Info(currNode.right, currInfo.hd +1));
                }
            }// end whileLoop

            // PRINT TOP VIEW OF A TREE.
            for(int i = min; i<=max; i++){
                System.out.print(map.get(i).data + " ");
            }
        }

        public
         void getBottomView(Node root){
            HashMap<Integer, Node> map = new HashMap<>(); // TO STORE LAST OCCURED HORIZONTAL DISTANCE.
            Queue<Info> q = new LinkedList<>(); // FOR LEVEL ORDER TRAVERSAL.
            int min = 0; int max = 0; // TO STORE MIN AND MAX HORIZONTAL DISTANCES FOR PRINTING BOTTOM VIEW IN ORDER.
            
            // FOR ROOT NODE : 
            q.add(new Info(root, 0)); // BY DEFAULT H-DISTANCE OF ROOT IS ZERO. BECAUSE IT IS THE ORIGIN.
            q.add(null); // TO CHECK WHETHER ALL NODES OF TREE ARE TRAVERSED.

            while(!q.isEmpty()){

                Info currInfo = q.remove();
                
                if(currInfo == null){
                    if(q.isEmpty()){
                        break;
                    }
                    q.add(null);
                    continue; // ADD NULL IN QUEUE AND DO NOTHING.
                }

                Node currNode = currInfo.node;
                map.put(currInfo.hd, currNode); // LAST OCCURED HORIZONTAL DISTANCE WILL BE STORED.

                // ADD ITS CHILDREN.
                if(currNode.left != null){
                    q.add(new Info(currNode.left, currInfo.hd - 1));
                    min = Math.min(min, currInfo.hd-1); // WE WILL GET MINIMUM HORIZONTAL DISTANCE ONLY FROM LEFT SUBTREE. 
                }

                if(currNode.right != null){
                    q.add(new Info(currNode.right, currInfo.hd + 1));
                    max = Math.max(max, currInfo.hd+1); // WE WILL GET MAX HORIZONTAL DISTANCE ONLY FROM RIGHT SUBTREE. 
                }

            } //end whileLoop

            // PRINT BOTTOM VIEW NODES OF A TREE.
            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data + " ");
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,-1,4,-1,5,-1,6,-1,-1,3,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.create(nodes);
        
        // bt.getTopView(root);

        bt.getBottomView(root);

    }
}
