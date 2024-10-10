import java.util.LinkedList;
import java.util.Queue;
public class Implemantation{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int value){
            this.data = value;
            left = null; //INITIALLY.
            right = null; //INITIALLY.
        }
    }//end Node.

    static class BinaryTree{

        //BUILD()
        private int index = -1;
        public Node build(int nodes[]){  //RETURN ROOT OF THE TREE.
            index++;
            if(nodes[index] == -1){
                return null;
            }
            //CRAEATE NODE.
            Node newNode = new Node(nodes[index]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);
            return newNode;
        }

        //PREORDER()
        public void preorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }


        //INORDER()
        public void inorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //POSTORDER()
        public void postorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //LEVELORDER()
        public void levelorder(Node root){ // CAN BE DONE USING ITERATION/LOOP.
           if(root == null){
                System.out.println("EMPTY BINARYTREE!!");
                return;
           }

           Queue<Node> q = new LinkedList<>();

           // FOR ROOTNODE.
           q.add(root);
           q.add(null); // REPRESENTS LEVELS AND USED TO GIVE NEW-LINE.

           while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    if(q.isEmpty()){ // IF NO NODE IS PRESENT AFTER REMOVING LAST ELEMENT "NULL".
                        break;
                    }else{
                        System.out.println(); // GIVING NEWLINE.
                        q.add(null); //"NULL" IS ADDED AT LAST INDEX.
                        continue; // SKIP ADDING ELEMENTS OF CURRENTNODE BECAUSE "null" HAS NO CHILD NODES
                    }
                }

                // IF CURRNODE IS NOT "null". THEN ADD LEFT AND RIGHT NODES OF CURRNODE.
                if(currNode.left != null){
                    q.add(currNode.left);   
                }

                 if(currNode.left != null){
                    q.add(currNode.right);   
                }

                System.out.print(currNode.data + " "); // PRINT CURRENTNODE DATA.
           }//end whileLoop.
        }
       
        //HEIGHT()
        public int height(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);// HEIGHT OF LEFT SUBTREE.
            int rightHeight = height(root.right); // HEIGHT OF RIGHT SUBTREE.
            return Math.max(leftHeight, rightHeight) + 1;
        }

        //COUNTNODES()
        public int countNodes(Node root){
            if(root == null){
                return 0;
            }

            int countLeft = countNodes(root.left); // TOTAL NO.OF NODES IN LEFT SUB-TREE.
            int countRight = countNodes(root.right); // TOTAL NO.OF NODES IN RIGHT SUB-TREE.
            return countLeft + countRight + 1; // +1 IS THE COUNT OF CURRENT ROOT NODE.
        }

        //SUMNODES()
        public int sum(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return leftSum + rightSum + root.data;
        }
    }
   

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};

        Node root = bt.build(nodes); //ROOT NODE IS STORED.

        // System.out.print("PREORDER : ");
        // bt.preorder(root);
        // System.out.println();

        // System.out.print("INORDER : ");
        // bt.inorder(root);
        // System.out.println();

        // System.out.print("POSTORDER : ");
        // bt.postorder(root);  

        // System.out.println("LEVEL ORDER : ");
        // bt.levelorder(root);

        // System.out.println("HEIGHT : " + bt.height(root));

        // System.out.println("TOTAL NO.OF NODES : " + bt.countNodes(root));
        
        // System.out.println("SUM OF NODES : " + bt.sum(root));
        

    }
    
}