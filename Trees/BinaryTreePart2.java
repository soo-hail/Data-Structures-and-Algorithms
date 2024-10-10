import java.util.LinkedList;
import java.util.Queue;;
public class BinaryTreePart2 {

    static class Node{
        int data;
        Node left;
        Node right;

        // CONSTRUCTURE.
        Node(int value){
            this.data = value;
            left = null; // INITIALLY.
            right = null; // INITIALLY.
        }
    }

    static class Info{ // USER DEFINED OBJECT DATATYPE TO STORE HEIGHT AND DIAMETER OF A NODE.
        int ht; // HEIGHT.
        int dia; // DIAMETER.

        Info(int h, int d){
            this.ht = h;
            this.dia = d; 
        }
    }

    static class BinaryTree{

        // BUILD() : THIS METHOD WILL RETURN ROOT OF A TREE.
        private int index = -1;
        public Node build(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            // CREATE NODE.
            Node newNode = new Node(nodes[index]);
            newNode.left = build(nodes); 
            newNode.right = build(nodes);
            return newNode;
        }

        //LEVEL-ORDER()
        public void levelorder(Node root){
            Queue<Node> q = new LinkedList<>();
            // FOR ROOT NODE.
            q.add(root);
            q.add(null); // REPRESENTS LEVEL AND USED TO GIVE NEW LINE.

            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }

                    continue;
                }

                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }

                System.out.print(currNode.data + " ");
                
            }
        } // END LEVEL-ORDER.  
        
        //HEIGHT()
        public int height(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // DIAMETER()
        public int diameter(Node root){

            if(root == null){
                return 0; //DIAMETER NULL NODE IS ZERO. (DON'T/CAN'T CALCULATE LEFT AND RIGHT HEIGHT)
            }

            // FIND DIAMETER FOR EVERY NODE.
            int leftdiameter = diameter(root.left); //MAX DIAMETER OF LEFT SUB-TREE.
            int rightdiameter = diameter(root.right); //MAX DIAMETER OF RIGHT SUB-TREE.

            //FINDING DIAMETER OF A NODE.
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int rootDiameter = (leftHeight + rightHeight + 1);
            int maxSub = Math.max(leftdiameter, rightdiameter); // MAX SUB-TREE DIAMETER(LEFT/RIGHT).
            return Math.max(rootDiameter, maxSub);
        }

        public Info htNdia(Node root){ // RETURNS HEIGHT AND DIAMETER OF A TREE.
            // HEIGHT AND DIAMETER ARE CALCULATED IN A SINGLE FUNCTION.(WE DON'T CALL SEPARATE FUNCTION FOR HEIGHT) 
            if(root == null){ 
                return new Info(0, 0);
            }

            Info leftInfo = htNdia(root.left); //INFO OF LEFT SUBTREE.
            Info rightInfo = htNdia(root.right); //INFO OF RIGHT SUBTREE.

            int height = Math.max(leftInfo.ht, rightInfo.ht) + 1; // HEIGHT OF NODE.
            int selfDiameter = (leftInfo.ht + rightInfo.ht) + 1; // DIAMETER OF CURR-NODE. 
            int maxDiameter = Math.max(selfDiameter, Math.max(leftInfo.dia, rightInfo.dia)); // MAX DIAMETER.
            
            Info currInfo = new Info(height, maxDiameter); // CREATING INFO OF CURR-NODE.
            //return new Info(height, maxDiameter);
            return currInfo;
        }
        
    }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,7,-1,-1,-1,3,-1,6,-1,8,-1,9,-1,-1};

        // int nodes[] = {1,2,4,9,-1,-1,-1,5,-1,6,-1,9,-1,-1,3,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root = bt.build(nodes);

        // bt.levelorder(root);

        // System.out.println("HEIGHT : " + bt.height(root));

        // System.out.println("DIAMETER : " + bt.diameter(root));

        Info htNdia = bt.htNdia(root); // RETURN HEIGHT AND DIAMETER(object of info)OF A TREE.

        System.out.println("DIAMETER : " + bt.htNdia(root).dia);
       
    }
}
