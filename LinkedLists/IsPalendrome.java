public class IsPalendrome {
    static class Node{
        int data;
        Node next;

        // CONSTRUCTURE.
        Node(int value){
            this.data = value;
            this.next = null;
        }
    }

    static class LinkedList{

        private Node head = null; // HEAD OF LINKED-LIST(refrence_variable-pointer).
        private Node tail = null; // TAIL OF LINKED-LIST(refrence_variable-pointer).

        // ADDLAST()
        public void addLast(int data){
            // CREATE A NEWNODE.
            Node newNode = new Node(data);

            if(head == null){ // EMPTY LINKED-LIST.
                head=tail=newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // DISPLAY()
        public void display(){
            Node curr = head;
            while(curr!=null){
                System.out.print(curr.data + "--->");
                curr = curr.next;
            }
            System.out.println("null");
        }

        // SLOW-FAST APPROACH(TO FIND MID OF THE LINKED-LIST).
        public Node getMid(Node heaNode){

            // REFRENCE VARIABLES TO TRAVERSE THE LINKED-LIST.
            Node slow = head;
            Node fast = head;

            while(fast!=null && fast.next != null){ // "fast!=null"--->even case. "fast.next!=null--->odd case".
                slow = slow.next; // INCREMENT BY +1.
                fast = fast.next.next; // INCREMENT BY +2
            }

             // WHEN FAST HAS TRAVERSED WHOLE LINKED-LIST, BY THAT TIME "SLOW" WOULD HAVE TRAVELLED HALF OF THE LINKED-LIST.
            // SO, SLOW IS AT MIDDLE OF LINKED-LIST.
            return slow;
        }

        public boolean isPalendrome(){
            // GET MID OF LINKED-LIST.
            Node midNode = getMid(head);
            
            // REVERSE 2nd HALF OF LINKED-LIST.
            Node prev;
            Node curr = midNode;
            Node next;

            while(curr!=null){
                next = curr.next; // STORE NEXT NODE.
                prev = curr;
                // REVERSE LINK.
                curr.next = prev;

                // UPDATE.
                prev = curr;
                curr = next;

            }
            midNode.next = null;

            // TRAVERSE BOTH HALFS
            return true;
        }

    }// END LINEDLIST.

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(8);
        ll.addLast(4);
        ll.addLast(1);

        ll.isPalendrome(); 
        ll.display();

        

    }
}
