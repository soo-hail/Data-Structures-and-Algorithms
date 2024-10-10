
public class ShortestPath {
    public static float getShortestPath(String str){
        //initialization.
        int x1=0, y1=0;
        int x2 = x1, y2 = y1; 
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if((curr == 'N') || (curr == 'n')){
                y2++;
            }
            else if((curr == 'E') || (curr == 'e')){
                x2++;
            }
            else if((curr == 'S') || (curr == 's')){
                y2--;
            }
            else{
                x2--;
            }
        }//end forLoop.
        
        float sp =(float)Math.sqrt(Math.pow(x2-x1, 2) +Math.pow(y2-y1, 2) ); //shortest path
        return sp;
    }
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(getShortestPath(str));
    }
}
