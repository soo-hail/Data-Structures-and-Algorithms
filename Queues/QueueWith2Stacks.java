import java.util.Stack;
public class QueueWith2Stacks {
    static class Queue{
        private Stack<Integer> helper = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        //isEmpty()
        public boolean isEmpty(){
            return stack.isEmpty();
        }

        //add()
        public void add(int ele){ //INSERT AT BOTTOM.
            //REMOVING EXISTING ELEMENT FROM STACK.
            while(!stack.isEmpty()){
                int curr = stack.pop();
                helper.push(curr);
            }

            stack.push(ele); //ADDING NEW ELEMENT AT BOTTOM OF THE STACK.

            //ADDING BACK ELEMENTS FROM HELPER STACK.
            while(!helper.isEmpty()){
                int curr = helper.pop();
                stack.push(curr);
            }
        }

        //remove()
        public int remove(){
            if(stack.isEmpty()){
                System.out.println("QUEUE UNDER-FLOW!!!");
                return Integer.MIN_VALUE;
            }
            return stack.pop();
        }

        //peek()
        public int peek(){
            if(stack.isEmpty()){
                System.out.println("EMPTY QUEUE!!");
                return Integer.MIN_VALUE;
            }
            return stack.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("QUEUE ELEMENTS : ");
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }    
}