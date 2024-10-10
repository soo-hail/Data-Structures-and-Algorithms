//QUEUE USING ARRAY.
public class QueueWithArray {
    static class Queue{
        private int queue[]; //to store elements.

        //constructure.
        Queue(int size){
            queue = new int[size];
        }

        private int front = -1; private int rear = -1; 
        
        //isEmpty()
        public boolean isEmpty(){
           return front == -1;
        }

        //add()
        public void add(int ele){ //add element at rear.
            if(rear == queue.length - 1){
                System.out.println("QUEUE OVER-FLOW!!!");
                return;
            }

            if(front == -1){ //Empty Queue.
                front++;
            }
            rear++;
            queue[rear] = ele;
        }

        //remove()
        public int remove(){ //removes element at front. 
            if(front == -1){ //empty Queue.
                System.out.println("QUEUE UNDER-FLOW!!!");
                return Integer.MIN_VALUE;
            }
            
            if(front == rear){ //size == 1
                int curr = queue[front];
                front = rear = -1;
                return curr;
            }

            int curr = queue[front];
            front++;
            return curr;
        }

        //peek() : returns front of Queue.
        public int peek(){
            if(front == -1){
                System.out.println("EMPTY QUEUE!!!");
                return Integer.MIN_VALUE;
            }
            return queue[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        // q.add(5);

        System.out.println("PEEK OPERATION : " + q.peek());

        System.out.println("QUEUE ELEMENTS : ");
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }

        System.out.println(q.remove()); //Queue under-flow.
    }
}