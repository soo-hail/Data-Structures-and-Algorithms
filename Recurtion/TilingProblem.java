public class TilingProblem {
    public static int tile(int n){
      if(n ==0 ){ // FLOOR IS COMPLETELY FULL.
        return 1;
      }

      // CHECK VERTICALLY.
      int way1 = tile(n-1); 

      // CHECK HORIZONTALLY.
      int way2 = 0;
      if(n>=2){
        way2 = tile(n-2);
      }
      
      return way1 + way2;
    }
    public static void main(String[] args) {
        System.out.println(tile(4));
    }
}
