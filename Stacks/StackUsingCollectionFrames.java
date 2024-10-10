import java.util.Stack;
public class StackUsingCollectionFrames {

    public static void pushBottom(Stack<Integer> stk, int ele){
        if(stk.isEmpty()){
            stk.push(ele);
            return;
        }

        int curr = stk.pop();
        pushBottom(stk, ele);
        stk.push(curr);

    }

    public static void reverse(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            int curr = stack.pop();
            pushBottom(temp,curr);
        }

        while(!temp.isEmpty()){
            int curr = temp.pop();
            stack.push(curr);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        reverse(s);

        System.out.println(s);
    }
}
