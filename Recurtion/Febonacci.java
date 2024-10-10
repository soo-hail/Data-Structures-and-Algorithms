public class Febonacci {
    public static void febo(int f0, int f1, int n){
        if(n == 0){
            return;
        }
        System.out.print(f0 + " ");
        int f2 = f0+f1;
        febo(f1, f2, n - 1);
    }

    public static int getfebo(int i){ //Febonacci number at perticular index(index starts from 0)
        if(i==0 || i==1){
            return i;
        }
        //flow come here when i>1.
        int febo = getfebo(i-1) + getfebo(i-2);
        return febo; 
    }

    public static void main(String[] args) {
        // febo(0, 1, 7);    
        System.out.println(getfebo(5));
    }
}
