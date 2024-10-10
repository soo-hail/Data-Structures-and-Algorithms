import java.util.ArrayList;
public class MaxElement {
    public static Integer getMax(ArrayList<Integer> list){
        Integer max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            max = Math.max(max, list.get(i));
        }

        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(getMax(list));



    }
}
