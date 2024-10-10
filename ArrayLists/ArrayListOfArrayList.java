import java.util.ArrayList;
public class ArrayListOfArrayList {

    public static void main(String[] args) {
        //Declaration.
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        mainList.add(list1);//add()

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        mainList.add(list2);//add()


        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(5); list3.add(6);
        mainList.add(list3);//add()

        System.out.println(mainList);

        //Iteration.
        for(int i=0;i<mainList.size();i++){ //to traverse mainList. ---> returns number of sub-ArrayList(row)
            ArrayList<Integer> currList = mainList.get(i); //returns whole sub-list.
            for(int j=0;j<currList.size();j++){ //travering individual list.
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }    
}