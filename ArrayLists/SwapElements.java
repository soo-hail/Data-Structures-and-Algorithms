import java.util.ArrayList;
public class SwapElements {
    public static void swap(ArrayList<Integer> list, int indx1, int indx2){
        int temp = list.get(indx1);
        list.set(indx1,list.get(indx2));
        list.set(indx2, temp);
    }
    public static void main(String[] args) {
        //Swap Elements at index1 and index2.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(11);
        list.add(3);
        list.add(6);

        System.out.println("ARRAY LIST BEFORE SWAP : ");
        System.out.println(list);
        swap(list, 1, 4); //swap function.
        System.out.println("ARRAY LIST AFTER SWAP : ");
        System.out.println(list);
    }
}
