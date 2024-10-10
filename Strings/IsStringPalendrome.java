public class IsStringPalendrome{
    public static boolean isPalendrome(String str){
        int mid = str.length()/2;
        int n = str.length()-1;
       for(int i=0;i<mid;i++){
            if(str.charAt(i) != str.charAt(n-i)){
                return false;
            }
       }//END FORLOOP.
       return true;
    } 
    public static void main(String[] args) {
        String s = "indi";
        System.out.println(isPalendrome(s));
    }
}