public class LinkedList2 {
    static class Node{
        int data;
        Node next;

        // CONSTRUCTURE.
        Node(int value){
            this.data = value;
            next = null;
        }
    }

    static class LinkedList{
        private Node head = null;
        private Node tail = null;
        // ADDLAST.
        public void addLast(int value){
            // CREATE NODE.
            Node newNode = new Node(value);
            // EMPTY LINKED-LIST.
            if(head==null){
                head = tail=newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // DISPLAY()
        public void display(){
            Node currNode = head;
            while(currNode!=null){
                System.out.print(currNode.data + "--->");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        // ISCYCLE() : CHECK WHETHER CYCLE EXIST IN LINKED-LIST.
        public boolean isCycle(){
            // FLOYD'S CYCLE FINDING ALGORITHM.
            Node slow = head;
            Node fast = head;
            // NOTE : IN CYCLE SLOW AND FAST WILL DEFNATELY OVERLAP BECAUSE AFTER ONE COMPLETE ITERATION OF "SLOW" IN CYCLE. 
                // FAST WILL COMEPLETE 2 COMPLETE OTERATIONS AND THEY WILL MEET AT SAME NODE WHERE THEY HAVE STARTED.
            while(fast!=null && fast.next!=null){
                slow = slow.next; // INCREMENT +1.
                fast = fast.next.next; // INCREMENT BY +2.
                if(slow==fast){ // OVERLAPPING CONDITION.
                    return true;
                }
            }
            // FLOW COMES OUT OF WHILE-LOOP ONLY WHEN LAST-NODE IS POINTING TO "NULL".
            return false;
        }

        // GET STARTOFCYCLE().
        public int getStartOfCycle(){
            Node slow = head;
            Node fast = head;
        
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    slow = head;
                    break;
                }
            }// END WHILE-LOOP.

           if(fast==null || fast.next==null){ // CYCLE DOES NOT EXIST.
                return -999999;
           }

           // IF FAST != NULL (OR) FAST.NEXT == NULL : CYCLE EXIST.
            while(slow!=fast){
                slow = slow.next; //+1.
                fast = fast.next; //+1.
            }

            return slow.data;
        }

        // REMOVE-CYCLE()
        public void removeCycle(){

            // FIND LAST-NODE.
            Node slow = head;
            Node fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }

            if(fast==null || fast.next==null){ // NO CYCLE IN LINKED-LIST.
                return;
            }

            slow = head;
            Node lastNode = null;
            while(slow!=fast){ // TO FIND START OF CYCLE.
                lastNode = fast;
                slow = slow.next; //+1
                fast = fast.next; //+1
            }

            // MAKE LAST.NEXT == NULL.
            lastNode.next = null;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = ll.head;

        System.out.println(ll.isCycle());
        // System.out.println(ll.getStartOfCycle());
        ll.removeCycle();
        System.out.println(ll.isCycle());
        ll.display();

        
    }
}
