import java.util.ArrayDeque;
import java.util.Queue;
public class LinkedList{ //object of this class is a whole linked-list.

    public static class Node{ //static is used because this node can be used without parent class object.
        int data;
        Node next; //reference variable which stores only reference of objects i.e. address of nextNode.
        
        public Node(int value){
            this.data = value;
            this.next = null; //initially.
        }
    }//end Node.

    //Head and Tail are refrence variables.
    public Node head = null; //head and tail cannot be static.
    public Node tail = null; 
    public int size = 0; //initial.

    //Methods should be non-static because they are different for different for different objects.

    //size()
    public int size(){
        return size;
    }

    //addFirst()
    public void addFirst(int value){
        Node newNode = new Node(value); //first create object.
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        //if head != null.
        newNode.next = head;//linking step.
        head = newNode;
    }

    //addMid()
    public void add(int indx,int value){
        if(indx < 0 || indx > size()){
            System.out.println("INVALID POSITION!!");
        }

        //create Node.
        Node newNode = new Node(value);
        if(indx == 0){//add at index 0
            addFirst(value);
            return;
        }

        if(indx == size()){ //add at index n-1.
            addLast(value);
            return;
        }

        Node currNode = head;
        for(int i=1;i<indx;i++){
            currNode = currNode.next;
        }
        size++;
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    //addLast()
    public void addLast(int value){
        //create a Node.
        Node newNode = new Node(value);
        size++;
        if(head == null){ //empty LinkedList.
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    //set().
    public void set(int indx, int value){
        if(indx < 0 || indx >=size()){
            System.out.println("INVALID POSITION!!!");
            return;
        }

        if(indx == 0){
            removeFirst();
            addFirst(value);
            return;
        }

        if(indx == size()-1){
            removeLast();
            addLast(value);
            return;
        }
        //set between.
        remove(indx);
        add(indx, value);        

    } 

    //removeFirst().
    public int removeFirst(){

        if(head == null){ //empty linkedist
            System.out.println("EMPTY LINKED-LIST!!!");
            return -1;
        }
        if(head == tail){ //has only one Node.
            Node currNode = head;
            head = tail = null;
            size = 0;
            return currNode.data;
        }

        size--;
        Node currNode = head;
        head = head.next; //logic
        currNode.next = null; //disconnecting.
        return currNode.data;
    }


    //remove()
    public void remove(int index){

        if(index < 0 || index >=size()){ //here we are also handling the empty linkedList case.
            System.out.println("INVALID POSITION!!!");
            return;
        }

        if(index == 0){
            removeFirst();
        }
        else if(index == size()-1){
            removeLast();
        }

        else{ //between.
            Node preNode = head;

            //traverse.
            for(int i=1;i<index;i++){
                preNode = preNode.next;
            }//end forLoop.
            preNode.next = preNode.next.next;
            size--;
        }
    }

    // public int removeEnd(int n){
    //     //remove nth element form end of LinkedList.
    //     if(n < 0 || n>=size()){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(head == tail){ //one Node.
    //         Node currNode = head;
    //         head = tail = null;
    //         return currNode.data;
    //     }


    // }

    //removeLast()
    public int removeLast(){
        if(head == null){ //empty linkedList.
            System.out.println("EMPTY LINKED-LIST!!!");
            return -1;
        }

        if(head == tail){ //has only one Node.
            Node currNode = tail;
            head = tail = null;
            size = 0;
            return currNode.data;
        }

        //has more than one Node.
        Node prevNode = head;
        Node currNode = prevNode.next;

        while(currNode.next!=null){
            currNode = currNode.next;
            prevNode = prevNode.next;
        }
        prevNode.next = null;
        tail = prevNode;
        size--;
        return currNode.data; 
    }

    //display()
    public void display(){
        if(head == null){
            System.out.println("EMPTY LINKED LIST!!");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "--->");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    //search()
    public int search(int key){
        if(size == 0){
            System.out.println("EMPTY LINKED-LIST!!!");
            return -1;
        }

        Node currNode = head;
        int index = 0;
        while(currNode != null){ 
            if(currNode.data == key){
                return index;
            }
            currNode = currNode.next;
            index++;
        }//end whileLoop.
        return -1;
    }

    //search(): search recurcively.
    public int search(int key, Node currNode){
        if(currNode == null){
            return -1;
        }

        if(key == currNode.data){
            return 0;
        }
        int index = search(key, currNode.next);

        if(index == -1){ // KEY DOES NOT EXIST.
            return -1;
        }

        return index + 1/*to count*/;
    }

    //reverse() using loop(iteration)
    public void reverse(){
        if(head == null){
            //empty linkedList.
            return;
        }

        if(head == tail){ //size = 1
            return;
        }

        //LOGIC.
        Node preNode = head;
        Node currNode = preNode.next;
        Node nextNode = currNode.next;

       while(nextNode!=null){
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
       }//end whileLoop.
       currNode.next = preNode;
       tail = head;
       tail.next = null;
       head = currNode;
    }

    //reverse() using recurtion.
    public Node reverse(Node currNode){ //return tail of LinkedList
        if(currNode==null || currNode.next == null){
            head = currNode;
            return currNode;
        }

        Node nextNode = reverse(currNode.next);
        nextNode.next = currNode;
        currNode.next = null; //to make previous LiinkedList tail null.
        
        return currNode;
    }

    // //isPalendrome()
    // public boolean isPalendrome(Node currNode, Queue<Integer> q){
    //     if(currNode==null){
    //         return true;
    //     }

    //     q.add(currNode.data);

    //     // boolean next = isPalendrome(currNode, Q)
    //     if(isPalendrome(currNode.next,q) && currNode.data == q.remove()){ // WE START COMPARING THE NODES FROM N-1th NODE, WHICHIS NOT NULL.
    //         return true;
    //     }

    //     return false;
    // }


    // ISPALENDROME()
    public Node getMid(){ // SLOW-FAST APPROACH.
        // REFRENCE-VARIABLES(POINTERS) TO TRACK THE MID OF LINKED-LIST.
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next; // INCREAMENT BY +1.
            fast = fast.next.next; // INCREMENT BY +2.
        }
        // WHEN FAST REACHED LAST NODE, AT THAT TIME SLOW WOULD HAVE REACHED EXCATLY HALF OF THE LINKED-LIST.
        // SO, SLOW == MID.
        return slow;
    }

    public boolean isPalendrome(){
        if(head == null || head.next == null){
            return true;
        }
        // FIND MID OF LINKED-LIST.
        Node midNode = getMid();

        // REVERSE 2nd HALF OF LINKED-LIST.
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next; // STORE NEXT NODE.
            curr.next = prev; // REVERSE LINK.

            // UPDATE.
            prev = curr;
            curr = next;
        }

        // CHECK LINKED-LIST FROM BOTH THE ENDS.
        Node left = head;
        Node right = tail;

        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // REMOVE Nth NODE FROM END.
    public int removeFromEnd(int n){
        // CALCULATE SIZE.
        // USING FAST APPROACH.
        Node fast = head;
        int size = 0;
        while(fast!=null && fast.next!=null){
            size++;
            fast = fast.next.next; // INCREMENT BY +2.
        }
        if(fast == null){
            // EVEN SIZE.
            size = size*2;
        }else{
            // ODD SIZE.
            size = (size*2)+1;
        }

        if(head == null || n > size || n < 1){
            return -1;
        }

        if(n == size){
            // REMOVE FIRST.
            return removeFirst();
        }

        // FIND N-1th NODE FROM THE END.
        int index = size-n+1;
        Node prevNode = head; // I==1.
        for(int i=2;i<index;i++){
            prevNode = prevNode.next;
        } 

        // CHANGE THE LINK.
        int nodeData = prevNode.next.data;
        prevNode.next = prevNode.next.next;

        return nodeData;
    }

    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(8);
        ll.addLast(4);
        ll.addLast(1);

        // ll.reverse();

        ll.display();

        // Queue<Integer> que = new ArrayDeque<>();

        // System.out.println(ll.isPalendrome(ll.head, que));

        System.out.println(ll.removeFromEnd(2));
        ll.display();
       
    }
}