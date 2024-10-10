public class StringBuilders {
    public static void main(String[] args) {
        // Declaration
        StringBuilder sb = new StringBuilder(""); //object datatype.
        for(char ch ='a';ch<='z';ch++){
            sb.append(ch); //.append() function is used to add a single character at send of the string
        }

        System.out.println(sb);

        //NOTE : 
        //we can apply all functions of string on string builder.
        System.out.println(sb.charAt(25));
        System.out.println("LENGTH : " + sb.length());
    }
}
