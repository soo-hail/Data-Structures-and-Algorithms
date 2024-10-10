public class Permutation {

    public static void findPermutation(String str, String helper){
        // BASE-CASE.
        if(str.length() == 0){
            System.out.println(helper);
            return;
        }

        for(int i=0;i<str.length();i++){ // TO SELECT THE SINGLE CHARACTER AT EVERY LEVEL.
            char curr = str.charAt(i); // CURRENT-CHARACTER.
            String newStr = str.substring(0, i) + str.substring(i+1); // CURRENT CHARACTER IS REMOVED.
            findPermutation(newStr, helper+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }    
}
