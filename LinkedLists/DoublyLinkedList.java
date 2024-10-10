public class DoublyLinkedList {

    // DOUBLY LINKED-LIST IS A LINKED-LIST WHERE EACH NODE IS POINTING TO BOTH NEXT AND PREVOIUS NODES. 
    // WE CAN TRAVELL IN BOTH THE DIRECTIONS.

    static class Node{
        int data;
        Node prev;
        Node next;

        // CONSTRUCTURE.
        Node(int value){
            this.data = value;
            prev = null; // INITIALLY.
            next = null; // INITIALLY.
        }
    }

    static class LinkedList{
        // REFRENCE VARIABLES.
        private Node head = null;
        private Node tail = null;
        private int size = 0;

        //addFirst()
        public void addFirst(int data){
            // CREATE NEWNODE.
            Node newNode = new Node(data);

            if(head == null){ // EMPTY LINKED-LIST.
                head = tail = newNode;
                size++;
                return;
            }

            // ADDFIRST.
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }

        // ADDLAST()
        public void addLast(int data){
            // CREATE NEWNODE.
            Node newNode = new Node(data);
            
            if(head == null){ // EMPTY LINKED-LIST.
                head = tail = newNode;
                size++;
                return;
            }

            // ADDLAST.
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

        // ADD(INDEX)
        public void add(int index, int data){
            if(index>size || index<0){
                System.out.println("INDEX OUTOFBOUNDS ERROR!!");
                return;
            }

            if(index == 0){ // ADDFIRST()
                addFirst(data);
                return;
            }

            if(index == size){ // ADDLAST()
                addLast(data);
                return;
            }

            // CREATE NEWNODE.
            Node newNode = new Node(data);

            Node prevNode = null;
            Node currNode = head; // WE ARE AT INDEX 0.
            // START TRAVERSING FROM INDEX-1.
            for(int i=1;i<=index;i++){
                prevNode = currNode;
                currNode = currNode.next;
            }

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = currNode;
            currNode.prev = newNode;
            size++;
        }

        // REMOVEFIRST()
        public int removeFirst(){
            if(head == null){ // EMPTY LINKED-LIST
                return -999999;
            }

            int nodeData = head.data;
            if(head.next == null){ // SINGLE-ELEMENT 
                head = tail= null;
                return nodeData;
            }

            head.next.next = null;
            head = head.next;
            return nodeData;
        }
        //REMOVELAST()
        public int removeLast(){
            if(head == null){ // EMPTY LINKED-LIST.
                return -9999;
            }

            int nodeData = tail.data;
            if(head.next==null){ // SINGLE NODE.
                head = tail = null;
                return nodeData;
            }

            tail.prev.next = null;
            tail = tail.prev;
            return nodeData;
        }

        // REMOVE(INDEX)
    
        // PRINT() : USING HEAD.
        public void print(){
            if(head == null){
                System.out.println("EMPTY LINKED-LIST!!");
                    return;
            }
            Node currNode = head;
            System.out.print("null<----");
            while(currNode.next!=null){
                System.out.print(currNode.data + "<====>");
                currNode = currNode.next;
            }
            System.out.print(currNode.data + "---->");
            System.out.println("null");
        }

        // PRINT() : USING TAIL.
        public void printReverse(){
            Node currNode = tail;
            System.out.print("null<----");
            while(currNode.prev != null){
                System.out.print(currNode.data + "<====>");
                currNode = currNode.prev;
            }
            System.out.print(currNode.data + " ---->");
            System.out.println("null");
        }

        // REVERSE()
        public void reverse(){
           if(head==null || head.next == null){
                return;
           }

           Node prev = null;
           Node curr = head;
           while(curr!=null){
                Node next = curr.next;

                // REVERSE LINKS.
                curr.prev = next;
                curr.next = prev;

                // UPDATE.
                prev = curr;
                curr = next;
           }

           head = prev; 
        }
    }
    
    public static void main(String[] args) {
        LinkedList dll = new LinkedList();
        dll.addFirst(6);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        
        // dll.print();
        // dll.printReverse();

        dll.addLast(7);
        dll.add(4, 5);

        dll.print();
        // System.out.println(dll.removeFirst());
        // System.out.println(dll.removeLast());
        dll.reverse();
        dll.print();


    }
}
