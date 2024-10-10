public class StringCompression {
    public static String getCompression(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            sb.append(ch);
            int count = 1;
            while(i<=str.length()-2 && str.charAt(i+1) == ch){
                count++;
                i++;
            }//end WhileLoop.
            if(count > 1){
                sb.append(count);
            }
        }//end forLoop.
        return sb.toString(); 
    }
    public static void main(String[] args) {
        String str = "aaabbcccd";
        System.out.println(getCompression(str));
    }
}