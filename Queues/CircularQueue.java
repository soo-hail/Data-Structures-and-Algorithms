public class CircularQueue {
    static class Queue{
        private int queue[] = new int[5];
        private int front = -1; private int rear = -1;
        int size = queue.length;

        //isEmpty()
        public boolean isEmpty(){
            if(front == -1){
                return true;
            }
            return false;
        }

        //add()
        public void add(int ele){
            if(front == (rear+1)%size){//QUEUE OVER-FLOW.
                System.out.println("QUEUE OVER-FLOW!!");
                return;
            }

            if(front == -1){ //EMPTY QUEUE.
                front++;
            }

            rear = (++rear)%size; //updation of rear in circular queue.
            queue[rear] = ele;
        }

        //REMOVE()
        public int remove(){
            if(front == -1){ //empty Queue
                System.out.println("QUEUE UNDER-FLOW!!!");
                return Integer.MIN_VALUE;
            }

            if(front == rear){
                int curr = queue[front];
                front = rear = -1;
                return curr;
            }

            int curr = queue[front];
            front = (++front)%size;
            return curr;
        }

        //PEEK()
        public int peek(){
            if(front == -1){
                System.out.println("EMPTY QUEUE!!");
                return Integer.MIN_VALUE;
            }

            return queue[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        // q.add(5); //QUEUE OVER-FLOW

        q.remove(); //0 removed.
        q.remove(); //1 removed.

        q.add(5);
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }

        System.out.println(q.peek());
    }
}
