import java.util.ArrayList;
import java.util.Arrays;
public class IndianCoins {
    
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,200,500,2000}; 
        int amount = 30000;
        // SORT COINS.
        Arrays.sort(coins);

        ArrayList<Integer> cash = new ArrayList<>(); // TO STORE COINS.
        int count = 0; // TO COUNT NO.OF COINS.
        int helper = 0; // TEMP VARIABLE.

        int indx = coins.length -1; // LAST INDEX IS STORED.
        while(indx>=0 && amount != helper){
            if(coins[indx] <= (amount - helper)){
                count++;
                helper += coins[indx];
                cash.add(coins[indx]);
            }else{
                indx--;
            }
        }// END WHILE-LOOP.

        System.out.println("NO.OF NOTES  : " + count);
        System.out.println("CASH : " + cash);

    }
}
