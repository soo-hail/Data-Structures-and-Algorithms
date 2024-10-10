public class CaptalizeWord {
    public static String getCaptalize(String str){
        StringBuilder sb = new StringBuilder("");
        // NOTE : 
        // Character.toUpperCase is used to convert a char to upperCase
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1) == ' '){
                ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);
            }
            else{
                ch = str.charAt(i);
                sb.append(ch);
            }
        }//end forLoop.
    
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "allah is the greatest";
        System.out.println(getCaptalize(str));
    }
}
