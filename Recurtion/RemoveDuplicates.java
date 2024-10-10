public class RemoveDuplicates {
    
    public static void remove(String str, StringBuilder sb, boolean map[], int indx){
        
        if(indx == str.length()){
            System.out.println(sb);
            return;
        }

        char curr = str.charAt(indx);
        int charIndx = curr - 'a';
        if(map[charIndx] == false){ // CHARACTER IS NOT REPEATED.    
            sb.append(curr);
            map[charIndx] = true;
        }

        remove(str, sb, map, indx + 1);
    }
    public static void main(String[] args) {
        String str = "appnnacollege";
        remove(str, new StringBuilder(""), new boolean[26], 0);
    }
}
