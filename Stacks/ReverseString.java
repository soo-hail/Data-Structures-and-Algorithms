import java.util.Stack;
public class ReverseString {
    public static StringBuilder reverse(String str){
        Stack<Character> stack = new Stack<>();
        // STORE EACH CHARACTER IN STACK.
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        // RESTORE STRING CHARACTERS.
       while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb;
    }
    public static void main(String[] args) {
        
        String str = "sohail";
        System.out.println(reverse(str));
        
    }
}