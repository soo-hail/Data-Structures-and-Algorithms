public class MergeSort {

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

        // GETMID : MID SHOULD BE LAST-NODE OF FIRST-HALF OF LINKED-LIST FOR EVEN CASE.
        public Node getMid(Node head){
            if(head == null){
                return null;
            }

            Node slow = head;
            Node fast = head.next; // CHANGE TO GET MID AT LAST-NODE OF A FIRST-HALF OF LINKED-LIST.
            while(fast!=null && fast.next!=null){
                slow = slow.next; // +1
                fast = fast.next.next; // +2
            }
            
            return slow;
        }
        
        // MERGE SORT.
        public Node sort(Node head){
            if(head == null || head.next == null){ // HAS A SINGLE-NODE.
                return head;
            }
            // FIND MID OF LINKED-LIST.
            Node mid = getMid(head);

            // DIVIDE.
            Node rightHead = mid.next;
            mid.next = null; // DIVISIONS.
            // CALL FOR 2 HALFS.
            Node leftPointer = sort(head); // LEFT-HALF.
            Node rightPointer = sort(rightHead); // RIGHT-HALF.

            // SORT-AND-CONQUERE.
            return sortAndConquere(leftPointer, rightPointer);
        }

        // SORT-AND-CONQUERE() : // IMPORTANT STEP.
        public Node sortAndConquere(Node leftHead, Node rightHead){
            // WE USE HELPER-NODE
            Node helper = new Node(-1);
            Node curr = helper; // TO TRACK LAST-NDE OF SORTED LINKED-LIST.
        
            // TRAVERSING LINKED-LIST.
            while(leftHead!=null && rightHead!=null){
                if(leftHead.data < rightHead.data){
                    curr.next = leftHead;
                    curr = leftHead; // POINTING TO LAST-NODE OF A SORTED LINKED-LIST. 
                    leftHead = leftHead.next;
                }else{ 
                    // RIGHTHEAD>LEFTHEAD.
                    curr.next = rightHead;
                    curr = rightHead;
                    rightHead = rightHead.next;
                }
            }

            if(leftHead == null){
                curr.next = rightHead;
            }else{
                curr.next = leftHead;
            }

            return helper.next; // HEAD OF SORTED LINKED-LIST.
        }

    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(9);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(7);
        ll.addLast(5);
        ll.addLast(8);

        ll.display();
        ll.head = ll.sort(ll.head);
        ll.display();
    }
}
