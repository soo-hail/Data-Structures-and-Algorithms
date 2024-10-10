public class QueueWithLinkedList {
    
    static class Node{
        int data;
        Node next;

        //CONSTRUCTURE.
        Node(int value){
            this.data = value;
            next = null; //initially.
        }
    } //end Node.

    //Queue class.
    static class Queue{

    private Node front = null; private Node rear = null; 

    //isEmpty()
    public boolean isEmpty(){
        return front == null;
    }

    //add()
    public void add(int ele){
        //create node.
        Node newNode = new Node(ele);
        
        if(front == null){ //empty queue.
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    //remove()
    public int remove(){
        if(front == null){ //empty Queue.
            System.out.println("QUEUE UNDER-FLOW!!!");
            return Integer.MIN_VALUE;
        }

        Node temp = front;
        if(front == rear){ //size == 1
            front = rear = null;
            return temp.data;
        }

        front = front.next;
        temp.next = null;
        return temp.data;
    }

    //peek()
    public int peek(){
        if(front == null){
            System.out.println("EMPTY QUEUE!!!");
            return Integer.MIN_VALUE;
        }

        return front.data;
    }

    }//end Queue.
    public static void main(String[] args) {
        Queue q  = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);

       System.out.println(q.peek());

    }
}
