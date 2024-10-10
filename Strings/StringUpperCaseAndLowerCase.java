import java.util.*;
public class StringUpperCaseAndLowerCase {
    
    public static void main(String[] args) {
        String s = "Sohail";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        s.toUpperCase();
        System.out.println(s); //toUpperCase function will not change string
    }
}
