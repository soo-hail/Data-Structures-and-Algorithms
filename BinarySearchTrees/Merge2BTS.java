import java.util.ArrayList;
// Q. MERGE 2 BST's
public class Merge2BTS{

static class Node{
    int data;
    Node left;
    Node right;

    // CONSTRUCTURE.
    Node(int data){
        this.data = data;
    }
}

public static void getInorder(Node root, ArrayList<Integer> list){
    if(root == null){ // BASE-CASE.
        return;
    }

    getInorder(root.left, list);
    list.add(root.data);
    getInorder(root.right, list);
}

public static void getSortedList(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> sortedList){
    // GET SORTED ARRAY-LIST USING LIST1 AND LIST2.
    int p1 = 0; int p2 = 0; // POINTERS TO TRACK INDEX.

    while(p1 < list1.size() && p2 < list2.size()){
        if(list1.get(p1) < list1.get(p2)){
            sortedList.add(list1.get(p1));
            p1++;
        }
        else{
            sortedList.add(list2.get(p2));
            p2++;
        }
    }

    while(p1 < list1.size()){
        sortedList.add(list1.get(p1)); p1++;
    }

    while(p2 < list2.size()){
        sortedList.add(list2.get(p2)); p2++;
    }
}

public static Node build(ArrayList<Integer> list, int start, int end){
    if(start > end){
        return null; 
    }
    
    int mid = (start+end)/2;

    Node root = new Node(list.get(mid)); 
    root.left = build(list, start, mid-1);
    root.right = build(list, mid+1, end); 

    return root;
}

public static Node merge(Node root1, Node root2){
    ArrayList<Integer> list1 = new ArrayList<>(); ArrayList<Integer> list2 = new ArrayList<>(); // TO STORE INORDER-SEQUENCE OF BST's
    getInorder(root1, list1); getInorder(root2, list2);

    ArrayList<Integer> sortedList = new ArrayList<>(); // TO STORE SORTED-LIST AND TO BUILD BALANCED BST. 

    getSortedList(list1, list2, sortedList); // TO GET SORTED-LIST.
    System.out.println(sortedList);

    return build(sortedList, 0, sortedList.size()-1); // TO BUILD BALANCED BST.
}
    public static void main(String[] args) {
        Node root1 = new Node(2); root1.left = new Node(1); root1.right = new Node(4);
        Node root2 = new Node(9); root2.left = new Node(3); root2.right = new Node(12); 

        Node root = merge(root1, root2);
        System.out.println(root.data);
        
    }
}
