import java.util.Stack;
public class DuplicatexParenthesis {
    
    public static boolean isDuplicate(String str){
        Stack<Character> stack = new Stack<>(); // TO STORE ALL CHARACTERS EXCEPT NON-CLOSING BRACKET.
        for(int i=0;i<str.length();i++){ // TO TRAVERSE ALL CHARACTERS OF A STRING. 
            char ch = str.charAt(i); // CURRENT CHARACTER.

            if(ch != ')'){ // NOT-CLOSING BRACKET.  
                stack.push(ch);
            }else{ // IF CURRENT CHARACTER IS A CLOSING BRACKET.
                // CASE-HANDLING.
                if(stack.isEmpty()){
                    System.out.println("INVALID EXPRESSION!!!");
                    return true;
                }
                // CHECK TOP.
                if(stack.peek() == '('){
                    return true;
                }
                // REMOVE ALL ELEMENTS TILL '('
                char temp = stack.pop();
                while(temp!='('){
                    temp = stack.pop();
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((((a+(b)))+c)";
        System.out.println(isDuplicate(str));
    }
}
