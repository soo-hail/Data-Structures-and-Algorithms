public class StackWithLinkedList2 {
    
    static class Node{
        int data;
        Node next;

        Node(int value){
            this.data = value;
            this.next = null; //initially.
        }
    }

    static class Stack{
        private Node top = null;
        private int size = 0;
        
        //isEmpty()
        public boolean isEmpty(){
            if(top == null){
                return true;
            }

            return false;
        }

        //size()
        public int size(){
            return size;
        }

        //push()
        public void push(int ele){
            //STACK OVER-FLOW CONDITION IS NOT CHECKED BECAUSE LINKEDLIST HAS VARIABLE SIZE.
            Node newNode = new Node(ele);
            if(top == null){ //Empty LinkedList.
                top = newNode;
                size++;
                return;
            }

            newNode.next = top;
            top = newNode;
            size++;
        }

        //pop()
        public int pop(){
            if(top == null){
                System.out.println("EMPTY STACK!!");
                return Integer.MIN_VALUE;
            }

            if( size == 1){ //has only one element.
                Node currNode = top;
                top = null;
                size--;
                return currNode.data;
            }

            Node currNode = top;
            top = top.next;
            currNode.next = null;
            size--;
            return currNode.data;
        }

        //peek()
        public int peek(){
            if(top == null){
                System.out.println("EMPTY STACK!!");
                return Integer.MIN_VALUE;
            }

            return top.data;
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

       
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
       
    }
}
