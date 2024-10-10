import java.util.ArrayList;
public class MultiplicationTable {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> table1 = new ArrayList<>();
        ArrayList<Integer> table2 = new ArrayList<>();
        ArrayList<Integer> table3 = new ArrayList<>();

        for(int i=1;i<=5;i++){
            table1.add(i*1); //1-Table.
            table2.add(i*2); //2-table.
            table3.add(i*3); //3 table.
        }

        mainList.add(table1); mainList.add(table2); mainList.add(table3);

        System.out.println(mainList);
    }
}
