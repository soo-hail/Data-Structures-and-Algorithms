// STACK USING ARRAYLIST.
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
public class StackWithArrayList {

    static class Stack{
        ArrayList<Integer> stack = new ArrayList<>();
        private int top = -1; //initial.

        //isEmpty()
        public boolean isEmpty(){
            if(top == -1){
                return true;
            }

            return false;
        }

        //size()
        public int size(){
            return top+1;
        }

        //push() 
        public void push(int ele){
            // STACK OVER-FLOW CONDITION IS NOT CHECKED BECAUSE ARRAYLIST HAS VARIABLE SIZE.
            stack.add(ele); //element will be added at last index of ArrayList.
            top++;
        }

        //pop()
        public int pop(){ //ELEMENT AT TOP OF THE STACK IS REMOVED.
            if(top==-1){ //Empty ArrayList. 
                System.out.println("STACK UNDER-FLOW!!");
                return Integer.MIN_VALUE;
            }

            return stack.remove(top--);
        }

        //peek()
        public int peek(){ //RETURN THE ELEMENT AT TOP OF THE STACK.
            if(top == -1){
                System.out.println("EMPTY STACK!!");
                return Integer.MIN_VALUE;
            }

            return stack.get(top);
        }

        //pushBottom
        // public void pushBottom(int ele){
        //     if(top == -1){
        //         stack.add(++top,ele);
        //         return;
        //     }

        //     int curr = stack.remove(top--);
        //     pushBottom(ele);
        //     stack.add(++top,curr);
        // }

        // REVERSE()
        public void reverse(){
            if(stack.isEmpty()){
                return;
            }

            int item = stack.remove(stack.size()-1); // REMOVE TOP ELEMENT.
            reverse(); //  RECURCIVE CALL.
            // PUSH AT BOTTOM

        }

        // PUSH-AT-BOTTOM()
        public void pushBottom(int item){
            
        }

    } 

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // s.pushBottom(-5);

       int n = s.size();

       System.out.println("STACK ELEMENTS : ");
       for(int i=0;i<n;i++){
            System.out.println(s.pop());
       }
        
    }
}