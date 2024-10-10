public class LargestString {
    public static String getLargest(String array[]){
        String l = array[0] ; //Largest sub-array.
        for(int i=1;i<array.length;i++){
            if(l.compareToIgnoreCase(array[i]) < 0){
                l = array[i];
            }
        }
        return l;
    }
    public static void main(String[] args) {
        String fruits[] = {"apple", "mango", "bannana","grapes","pear"};
        System.out.println(getLargest(fruits)); 
    }
}
