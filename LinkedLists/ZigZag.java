public class ZigZag {
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

        private Node getMid(Node head){
            // SLOW-FAST APPROACH.
            Node slow = head;
            Node fast = head.next;

            while(fast!=null && fast.next!=null){
                slow = slow.next; // +1
                fast = fast.next.next; //+2
            }

            // WHEN FAST HAS TRAVELLED WHOLE LINKED-LIST. BY THAT TIME SLOW WOULD TRAVELL HAF OF THE LINKED-LIST.
            return slow;
        }

        public void makeZigZag(){
            // BASE-CASE.
            if(head == null || head.next == null){
                return;
            }

            // 1.FIND MID OF A LINKED-LIST.
            Node mid = getMid(head);

            // 2. REVERSE 2nd HALF OF LINKED-LIST. AND DIVIDE THE LINKED-LIST.
            // REVERSE 2nd HALF.
            Node prev = null;
            Node curr = mid.next;
            while(curr!=null){
                Node next = curr.next; // STORE FOR THE FUTURE.
                // REVERSE LINK THE NODES.
                curr.next = prev;

                //UPDATE.
                prev = curr;
                curr = next;
            }
            Node rightHead = prev; // HEAD OF RIGHT HALF OF LINKED-LIST.
            // DIVIDE 2nd HALFS OF LINKED-LIST.
            Node lastRight = mid.next; // LASTNODE OF RIGHT-HALF.
            mid.next = null;
            lastRight.next = null;

            // 3. ZIG-ZAG THE NODES OF LINKED-LIST.
            Node lp = head; // LEFT-POINTER.
            Node rp = rightHead; // RIGHT-POINTER.
            while(lp!=null && rp!=null){
                // STORE FOR FUTURE.
                Node nextLeft = lp.next;
                Node nextRight = rp.next;

                // LINK ZIG-ZAG.
                lp.next = rp;
                rp.next = nextLeft;

                // UPDATE.
                lp = nextLeft;
                rp = nextRight;
            }
        }      
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // ll.addLast(6);

        ll.display();
        ll.makeZigZag();
        ll.display();
    }
}
