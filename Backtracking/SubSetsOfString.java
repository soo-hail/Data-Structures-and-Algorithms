public class SubSetsOfString {
    
    public static void subset(String str, String sb, int indx){
        // BASE-CONDITION.
        if(indx == str.length()){
            if(sb.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(sb);
            }
            return;
        }

        // YES CHOICE.
        subset(str, sb+str.charAt(indx), indx + 1); // STRINGS ARE IMMUTABLE. WHEN WE MAKE CHANGES A NEW STRING IS BEEN CREATED.
               
        // NO CHOICE.
        subset(str, sb, indx + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        subset(str, "", 0);        
    }
}
