//STACK USING LINKEDLIST.
import java.util.LinkedList;
public class StackWithLinkedList {
    
    static class Stack{
        private LinkedList<Integer> stack = new LinkedList<>();
        // TOP = HEAD

        //isEmpty()
        public boolean isEmpty(){
            return stack.isEmpty();
        }

        //size()
        public int size(){
            return stack.size();
        }

        //push()
        public void push(int ele){
            // STACK OVER-FLOW CONDITION IS NOT CHECKED. BECAUSE LINKED-LIST HAS VARIABLE SIZE.
            stack.addFirst(ele);
        }

        //pop()
        public int pop(){
            if(isEmpty()){
                System.out.println("STACK UNDER-FLOW!!");
                return Integer.MIN_VALUE;
            }

            return stack.removeFirst();
        }

        //peek()
        public int peek(){
            if(isEmpty()){
                System.out.println("EMPTY STACK!!");
                return Integer.MIN_VALUE;
            }

            return stack.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("STACK ELEMENTS : ");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
