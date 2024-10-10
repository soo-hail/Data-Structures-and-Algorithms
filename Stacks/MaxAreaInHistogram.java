import java.util.Stack;
public class MaxAreaInHistogram {

    public static void print(int array[]){
        for(int x : array){
            System.out.print(x + " ");
        }
    }

    public static void getLeftSmaller(int array[], int leftSmaller[]){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<array.length;i++){ // TRAVERSE ALL ELEMENT OF ARRAY TO FIND ITS LEFTSMALLER.
            int curr = array[i]; // CURRENT ELEMENT.
            while(!stack.isEmpty() && array[stack.peek()] >= curr){ // REMOVE ALL GREATER ELEMENT THAN CURRERNT ELEMENT.
                stack.pop();
            }

            if(stack.isEmpty()){ // SMALLEST ELEMENT TILL NOW.
                // NO SMALLER ELEMENT EXIST AT LEFT SIDE OF CURRENT ELEMENT.
                leftSmaller[i] = -1;
            }else{
                leftSmaller[i] = stack.peek();
            }

            stack.push(i); // ADD CURRENT INDEX FOR NEXT-ELEMENTS(right elements).
        }
    }

    // getRightSmaller()
    public static void getRightSmaller(int array[], int rightSmaller[]){
        Stack<Integer> stack = new Stack<>(); // TO STORE SMALLER ELEMENTS.

        for(int i=array.length-1;i>=0;i--){ // TRAVERSE ALL ELEMETS OF ARRAYS TO FIND RIGHT-SMALLER.
            int curr = array[i];
            while(!stack.isEmpty() && array[stack.peek()] >= curr){ // REMOVE ALL GREATER ELEMENTS IN STACK.
                stack.pop();
            }

            if(stack.isEmpty()){ // SMALLEST ELEMENT TILL NOW.
                // NO SMALLER ELEMENT EXIST AT RIGHT SIDE OF CURRENT ELEMENT.
                rightSmaller[i] = array.length-1;
            }else{
                rightSmaller[i] = stack.peek();
            }

            stack.push(i); // PUSH INDEX OF CURRENT ELEMENT FOR NEXT-LEFT ELEMENTS.
        }
    }

    public static int getArea(int heights[]){
        int leftSmaller[] = new int[heights.length];
        int rightSmaller[] = new int[heights.length];
        int maxArea = 0;
        // FIND LEFT-SMALLER.
       getLeftSmaller(heights,leftSmaller); // BECAUSE ARRAYS ARE PASSED BY REFRENCE.

       // FIND RIGHT-SMALLER.
       getRightSmaller(heights, rightSmaller);

       for(int i=0; i<heights.length;i++){ // FOR FINDING MAX AREA OF RECTANGLE IN HISTOGRAM.
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int area = heights[i] * width;
            
            maxArea = Math.max(maxArea, area);
       }

       return maxArea;
       
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(getArea(heights));
        getArea(heights);
    }
}