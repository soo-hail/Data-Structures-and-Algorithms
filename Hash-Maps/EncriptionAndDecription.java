import java.util.Scanner;
import java.util.HashMap;
public class EncriptionAndDecription {
    // ENCRIPTION.
    public static int readPassword(HashMap<Integer, String> map){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER PASSWORD : ");
        String password = sc.nextLine();
        int hc = password.hashCode();
        map.put(hc, password);
        return hc;
    }

    // DECRIPTION.
    public static String decription(HashMap<Integer, String> map, int password){
        return map.get(password);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(); // USED TO ENCRIPT DATA.
        
       int password = readPassword(map);

       System.out.println("ENCODED PASSWORD  : " + password);

       System.out.println("DECODED PASSWORD : " + decription(map, password));


       
    }
}
