import java.util.Stack;
public class ValidParenthesis {

    // TO CHECK IF THE BRACKET IS A OPENING BRACKET.
    public static boolean isOpening(char ch){
        if(ch == '(' || ch == '{' || ch == '['){
            return true;
        }

        return  false;
    }
    
    // TO CHECK IF BRACKETS MAKE PAIR.
    public static boolean isPair(char open, char close){
        if((open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')){
            return true;
        }

        return false;
    }

    // ISVALID()
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>(); // TO STORE OPENING BRACKETS.
        
        if(str.length()%2 != 0){ // STRING-LENGTH IS ODD.
            // IF STRING LENGHT IS ODD. WHICH MEANS IT IS NOT A VALID-STRING.
            return false;
        }
       
        // ITERATE WHOLE STRING FROM STARTING INDEX TO ENDING INDEX.
        for(int i=0;i<str.length();i++){ 
            char curr = str.charAt(i);
            if(isOpening(curr)){ 
                // IF THE CHARACTER IS OPENDING-BRACKET PUCH IT IN A STACK.
                stack.push(curr);
                continue;
            }

            // NOT-OPENING / CLOSING BRACKET.
            if(stack.isEmpty()){
                return false; // "))))))" FOR THIS CASE.
            }
            
            if(!isPair(stack.pop(), curr)){ // IF NOT-PAIR.
                return false;
            }

        }//end forLoop.

        return true;
    }
    public static void main(String[] args) {

        System.out.println(isValid("({[]}){}"));
    }
}
