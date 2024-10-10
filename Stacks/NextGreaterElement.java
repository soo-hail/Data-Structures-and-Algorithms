import java.util.Stack;
public class NextGreaterElement {
    public static void printArray(int array[]){
        for(int x : array){
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) {
        int array[] = {6,5,8,0,2,1,3};
        int nextGreatest[] = new int[array.length]; // TO STORE NEXT-GREATEST NUMBER FOR ALL ELEMENTS.
        
        Stack<Integer> stack = new Stack<>(); // TO STORE GREATEST ELEMENTS OF RIGHT SIDE.
        // ADVANTAGE OF USING STACK IS ALL SMALL ELEMENTS BETWEEN TWO LARGE ELEMETS GETS DELECTED.

        // FOR LAST ELEMENT.
        nextGreatest[array.length-1] = -1; // IT IS THE LAST ELEMENT(THERE IS NO NEXT ELEMET FOR IT).
        stack.push(array[array.length-1]);

        // TRAVERSE IN REVERSE ORDER.
        for(int i=array.length-2; i>=0;i--){
            int curr = array[i];
            // REMOVE ALL SMALLER ELEMEMTS CLOSE TO CURRENT ELEMENT.
            while(!stack.isEmpty() && array[stack.peek()]<=curr){
                stack.pop();
            }// end whileLoop.
            if(stack.isEmpty()){ // GREATEST ELEMENT IS NOT EXIST AT RIGHT SIDE OF CURRENT-ELEMENT.
                nextGreatest[i] = -1;
            }else{
                nextGreatest[i] = array[stack.peek()]; // STORING NEXT GREATEST OF CURRENT ELEMENT.
            }

            // ADD CURRENT ELEMENT IN STACK FOR LEFT AT LEFT SIDE.
            stack.push(i); // WE STORE INDEX BECAUSE "SPACE OF INDEX(of curreElement) MAY BE < VALUE OF CURRENT-ELEMENT. "
        }// end forLoop.

        printArray(nextGreatest);
    }
}
