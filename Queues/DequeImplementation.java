public class DequeImplementation {
    // DEQUEQE : DEQUEUE IS A QUEUE WHERE ALL OPERATION CAN BE PERFORMED AT BOTH THE ENDS.
    // WE USE LINKED-LIST TO IMPLEMENT DEQUE.

    static class Node{
        int data;
        Node next;

        // CONSTRUCTURE.
        Node(int data){
            this.data = data;
            this.next = null; // INITIALLY.
        }
    }

    static class Deque{
        // ENDS OF A DEQUE.
        Node first = null;
        Node last = null;

        // addFirst().
        public void addFirst(int data){
            // CREATE NODE.
            Node newNode = new Node(data);

            if(first == null){ // EMPTY DEQUE.
                first = last = newNode;
                return;
            }

            newNode.next = first;
            first = newNode;
        }

        // addLast()
        public void addLast(int data){
            // CRREATE NODE.
            Node newNode = new Node(data);

            if(first == null){ // EMPTY DEQUE.
                first = last = newNode;
                return;
            }

            last.next = newNode;
            last = newNode;
        }

        //getFirst()
        public int getFirst(){
            if(first == null){
                System.out.println("EMPTY DEQUE!!");
                return -999999;
            }

            int data = first.data; // STORE DATA OF FIRST NODE.
            if(first.next == null){ // SIZE == 1
                first = last = null;
                return data;
            }

            first = first.next;
            return data;
        }

        // getLast()

        //removeFirst()

        //removeLast()
    }
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.addFirst(0);
        dq.addFirst(1);
        dq.addLast(2);
        dq.addFirst(3);

        System.out.println(dq.getFirst());
    }
}
