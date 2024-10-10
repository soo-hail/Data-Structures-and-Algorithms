import java.util.Stack;
public class ReverseStack {
    
    public static void pushBottom(Stack<Integer> stack, int ele){
        Stack<Integer> helper = new Stack<>(); // HELPER-STACK.
        
        // EMPTY-STACK.
        while(!stack.isEmpty()){
            int topEle = stack.pop();
            helper.push(topEle);
        }

        // ADD NEW-ELEMENT IN EMPTY-STACK.
        stack.push(ele);

        // RESTORE OLD-ELEMENTS IN STACK.
        while(!helper.isEmpty()){
            int topEle = helper.pop();
            stack.push(topEle);
        }

    }

    public static void reverse(Stack<Integer> stack){ // STACK IS PASSED BY REFRENCE.
        // BASE-CASE.
        if(stack.isEmpty()){
            return;
        }

        // EMPTY STACK.
        int curr = stack.pop();
        reverse(stack); // CALL FOR NEXT ELEMENT.
        // BACKTRACKING STEPS.
        // PUSHBOTTOM.
        pushBottom(stack, curr);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
