import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class StackWith2Queues {

    static class Stack{
        Queue<Integer> q1 = new ArrayDeque<>(); // QUEUE IS A INTERFACE.
        Queue<Integer> q2 = new LinkedList<>();

        // PUSH()
        public void push(int ele){
            if(q1.isEmpty() && q2.isEmpty()){ // FIRST ELEMENT
                q1.add(ele);
                return;
            } 

            // ADD ELEMENTS IN QUEUE WHICH IS NOT EMPTY(WHICH HAS ELEMENTS ALREADY).
            if(!q1.isEmpty()){
                q1.add(ele);
            }else{
                q2.add(ele);
            }
        }

        // POP()
        public int pop(){
            // EMPTY STACK.
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("STACK UNDER-FLOW!!!");
                return -9999;
            }

            // TRANSFER ALL ELEMENTS FROM "NON-EMPTY QUEUE" TO EMPTY QUEUE EXCEPT "LAST ELEMENT".
            if(!q1.isEmpty()){
                // TRANSFER ALL ELEMETS TO Q2 EXCEPT LAST ELEMENT.
                while(q1.size()!=1){
                    int curr = q1.remove();
                    q2.add(curr); // TRANSFER.
                }
                // REMOVE LAST ELEMENT.
                return q1.remove();
            }else{ // ID Q1 IS EMPTY AND ELEMENTS PRESENT IN Q2.

                 // TRANSFER ALL ELEMETS TO Q1 EXCEPT LAST ELEMENT.
                while(q2.size()!=1){
                    int curr = q2.remove();
                    q1.add(curr); // TRANSFER.
                }
                // REMOVE LAST ELEMENT.
                return q2.remove();
            }
        }

        // ISEMPTY()
        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
    }
   
    public static void main(String[] args) {
       Stack s = new Stack();
       s.push(0);
       s.push(1);
       s.push(2);
       s.push(3);

       System.out.println(s.pop());

       s.push(4);

      // STACK ELEMENTS.
      while(!s.isEmpty()){
        System.out.println(s.pop());
      }
    }    
}