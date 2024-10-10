import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePart3 {
    
    static class Node{ 
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null; // INITIALLY
            right = null;  // INITIALLY
        }
    }

    static class BinaryTree{
        private int index = -1; // TO TRAVERSE "NODES(ARRAY)"

        public Node build(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            // CREATE NEW NODE.
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
                    }

                    q.add(null);
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

        // GET Kth LEVEL() : ITERATION.
        public void getKthLevel(Node root, int k){
            if(k < 0){
                System.out.println("INVALID LEVEL");
                return;
            }

            if(k == 1){
                System.out.print(root.data);
                return;
            }

            int level = 1; // TO TRACK LEVELS OF A BINARY TREE.
            Queue<Node> q = new LinkedList<>(); // FOR LEVEL ORDER TRAVERSAL.

            q.add(root); q.add(null);
            
            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    level++; // INCREMENT LEVEL.
                    if(q.isEmpty()){
                        System.out.println("INVALID LEVEL");
                        break;
                    }

                    if(level == k){
                        while(!q.isEmpty()){
                            System.out.print(q.remove().data + " ");
                        }
                        break;
                    }

                    q.add(null);
                    continue;
                }

                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }

        }

        // GET Kth LEVEL() :  RECURSION.
        public void getKthLevel(Node root, int level, int k){
            if(level < 0){ // HANDEL CASE.
                System.out.println("INVALID LEVEL!!");
                return;
            }

            if(root == null){
                return;
            }
            // MATCH CASE.
            if(level == k){
                System.out.print(root.data + " ");
                return; // NO NEED TO CALL FOR NEXT LEVELS.
            }
            // CALL FOR NODES OF NEXT LEVEL
            getKthLevel(root.left, level+1, k); getKthLevel(root.right, level+1, k);

        }
        
        // GET-ANCESTOR() : 
        public boolean getAcestors(Node root, int node, LinkedList<Node> l){
            
            if(root == null){
                return false; // TRAVELLED WHOLE BRANCH BUT "NODE" IS NOT FOUND.
            }

            if(root.data == node){
                return true; // "NODE" FOUND.
            }

            l.add(root);

            // CALL FOR SUB-TREES.
            boolean leftBranch = getAcestors(root.left, node, l); // SEARCH IN LEFT-BRANCH. 
            boolean rightBranch = getAcestors(root.right, node, l); // SEARCH IN RIGHT-BRANCH.

            if(leftBranch || rightBranch){ // IF NODE EXIST IN IT'S LEFT OR RIGHT BRANCH THEN IT MEANS CURRENT NODE IS IT'S ANCESSTOR. 
                return true;
            }
             
            l.removeLast();
            return false;
        }

        // GETLCA() : 
        public Node getLCA(Node root, int node1, int node2){
            LinkedList<Node> list1 = new LinkedList<>(); 
            LinkedList<Node> list2 = new LinkedList<>();

            getAcestors(root, node1, list1); getAcestors(root, node2, list2);

            // COMPARE ANCESSTORS OF "NODE1" AND "NODE2".
            Node lca = null; 
            for(int i = 0 ; i<list1.size() && i<list2.size(); i++){
                if(list1.get(i) != list2.get(i)){
                    break;
                }

                lca = list1.get(i);
            }// end forLoop.

            return lca;
        }

        public Node getLCA2(Node root, int node1, int node2){
            // IT GIVES CORRECT RESULT WHEN 2 NODES EXIST IN 2 SEPARATE BRANCHES OF A TREE AND THERE SHOULD NOT BE ANY DUPLICATE NODES.
            if(root == null){
                return null;
            }

            if(root.data == node1 || root.data == node2){ // CHECKING WHETHER NODE EXIST IN TREE.
                return root;
            }

            Node leftBranch = getLCA2(root.left, node1, node2);
            Node rightBranch = getLCA2(root.right, node1, node2);

            if(leftBranch!=null && rightBranch!=null){
                return root; // LCA WILL BE A NODE, WHERE TWO NODES(node1 and node2) EXIST IN IT'S TWO BRANCHES. 
            }
            else if(leftBranch != null){
                return leftBranch; // RETURN A NODE TO TELL PARENT-NODES THAT "NODE" IS PRESENT IN LEFT-BRANCH
            }
            else if(rightBranch != null){
                return rightBranch; // RETURN A NODE TO TELL PARENT-NODES THAT "NODE" IS PRESENT IN RIGHT-BRANCH. 
            }
            else{
                return null;  // RETURN "NULL" IF "NODES" DOES NOT EXIST IN BOTH THE BRANCHES.
            }
        }

        public int getDistance(Node root, int node){
            if(root == null){
                return -1;
            }

            if(root.data == node){
                return 0;
            }

            int x = getDistance(root.left, node); 
            int y = getDistance(root.right, node);

            if(x != -1){
                return x+1;
            }
            else if( y != -1){
                return y+1;
            }
            else{
                return -1;
            }
            
        }
        
        // public boolean isSameBranch(Node lca, int node1, int node2, int dist1, int dist2){
            // LinkedList<Node> list1 = new LinkedList<>(); LinkedList<>
        // }

        // GET-MIN-DISTANCE-BETWEEN-NODES()
        public int getMDBN(Node root, int node1, int node2){
            // NOTE : 
            // DISTANCE BETWEEN TWO NODES IS "DISTNACE OF NODE1 FROM LCA" AND "DISTANCE OF NODE2 FROM LCA".
            Node lca = getLCA(root, node1, node2);
            int dist1 = getDistance(lca, node1);
            int dist2 = getDistance(lca, node2);

            return dist1+dist2;

        }

        // SUM-TREE() : BUILD A TREE WHERE "VALUE OF IT'S NODES" WILL BE SUM OF IT'S SUBTREES.
        // EACH NODE = SUM OF IT'S LEFT AND RIGHT SUBTREES.
        public int buildSumTree(Node root){
            if(root == null){
                return 0;
            }

            int x = buildSumTree(root.left);
            int y = buildSumTree(root.right);

            int data = root.data; 
            int sum = x+y; root.data = sum;
            return data + sum;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,7,-1,-1,-1,3,-1,6,-1,8,-1,9,-1,-1}; 

        BinaryTree bt = new BinaryTree();
        Node root = bt.build(nodes);

        // bt.levelorder(root);
        // bt.getKthLevel(root, 5); // ITERATION

        // int k = 3;
        // bt.getKthLevel(root, 1, k); // RECURTION.

        // int lca = bt.getLCA(root, 8, 9);
        // System.out.println(lca);

        // Node lca = bt.getLCA2(root, 4, 7);
        // System.out.println(lca.data);


        // int dist = bt.getMDBN(root, 4, 9);
        // System.out.println(dist);

        // int x = bt.getKthAncestor(root, 7, 2); // THIS FUNCTION RETURNS INTRGER BUT WE USE IT AS "VOID" FUNCTION.
        // System.out.println(x);

        bt.buildSumTree(root);
        bt.levelorder(root);
    }
}
