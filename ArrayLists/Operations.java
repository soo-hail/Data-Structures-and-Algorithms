import java.util.ArrayList;
public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //1.ADD ELEMENT.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        list.add(3,4); //add element at perticular index.


        //2.GET Element at perticular index.
        // System.out.println(list.get(2));

        //3.Remove element at perticular index.
        // System.out.println(list.remove(2)); //.remove() delect the element and return value of that element. 
        // System.out.println(list);

        //4.SET Element at perticulat index.
        // list.set(0, 0); //Set funtion overwrites the old element by new element.
        System.out.println(list);

        //5.Contains Function : to check whether a element present in ArrayList.
        // System.out.println(list.contains(2));
        // System.out.println(list.contains(11));

        //6.Size function : returns the size of ArrayList.
        System.out.println(list.size());            
            
    }
}
