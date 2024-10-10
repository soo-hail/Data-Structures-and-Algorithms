public class HalfPyramidChar {
    public static void main(String[] args) {
        int n=4;

        //Q. continious Alphabets.
        char ch = 'A';
        for(int i=1;i<=n;i++){
            for(int j=1; j<=i; j++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        
        //Q. non conitious Alphabets.

        for(int i=1;i<=n;i++){
            char c='A';
            for(int j=1;j<=i;j++){
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }
}
