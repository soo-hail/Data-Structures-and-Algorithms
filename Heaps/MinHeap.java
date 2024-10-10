/* MIN-HEAP IS A COMPLETE BINARY TREE. WHERE VALUE OF PARENT NODE IS LESS THAN OR EQUAL TO VALUE CHILD NODE.*/
import java.util.ArrayList;
public class MinHeap {

    static class Heap{
        private ArrayList<Integer> heap = new ArrayList<>(); // HEAPS ARE IMPLEMENTED USING ARRAY-LIST OR ARRAY.

        //DISPLAY()
        public void display(){
            System.out.println(heap);
        }

        // ADD()
        public void add(int ele){
            // ADD NEW-ELEMENT AT LAST INDEX.
            heap.add(ele);  // THIS WILL WORK EVEN FOR EMPTY HEAP.

            int newNodeIndx = heap.size()-1 ;
            int parNodeIndx = (newNodeIndx-1)/2; // APPLICATE FOR BOTH LEFT AND RIGHT CHILD NODES.
            while(newNodeIndx > 0 && heap.get(newNodeIndx) < heap.get(parNodeIndx)){
                // SWAP.
                int temp = heap.get(newNodeIndx);
                heap.set(newNodeIndx, heap.get(parNodeIndx));
                heap.set(parNodeIndx, temp);

                // UPDATE.
                newNodeIndx = parNodeIndx;
                parNodeIndx = (newNodeIndx-1)/2; // NEW-PARENT.
            }
        }

        // PEEK() : RETURNS THE MINIMUM VALUE OF HEAP(ROOT NODE). BECUASE IT IS A MIN-HEAP.
        public int peek(){
            return heap.get(0);
        }

        // REMOVE() : REMOVES THE MINIMUM VALUE ELEMENT(ROOT NODE) FROM THE HEAP. BECAUSE IT IS A MIN-HEAP.
        public int remove(){
            if(heap.isEmpty()){
                System.out.println("EMPTY HEAP!!");
                return Integer.MIN_VALUE;
            }

            // SWAP 1ST AND LAST ELEMENT OF HEAP. BECAUSE TIME COMPLEXITY TO REMOVE LAST ELEMENT IS O(1) i.e. CONSTANT
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.set(heap.size()-1, temp);

            // REMOVE LAST ELEMENT FROM HEAP(MIN_VALUE)
            int curr = heap.remove(heap.size()-1);

            // FIX HEAP. USING HEAPITY METHOD.
            heapify(0);
            return curr;

        }

        private void heapify(int currIndx){
            // USING CURRENT INDEX FIND LEFT AND RIGHT CHILD.
            int leftIndx = (currIndx*2) + 1;
            int rightIndx = (currIndx*2) + 2;

            // FIND MINIMUM AMOUNG ROOT, LEFTCHILD, RIGHTCHILD.
            int minIndx = currIndx;

            // WE ARE USING TWO SEPARATE IF-CONDITIONS BEAUSE THERE CAN BE ONLY ONE-CHILD(LEFT-CHILD).
            if(leftIndx<=heap.size()-1 && heap.get(leftIndx) < heap.get(minIndx)){
                minIndx = leftIndx;
            }
            if(rightIndx<=heap.size()-1 && heap.get(rightIndx) < heap.get(minIndx)){
                minIndx = rightIndx;
            }

            // SWAP THE MINIMUM VALUE WITH ROOT.
            int temp = heap.get(currIndx);
            heap.set(currIndx, heap.get(minIndx));
            heap.set(minIndx, temp);

            if(leftIndx > heap.size()-1 || rightIndx > heap.size()-1 || minIndx == currIndx){
                return;
            }

            heapify(minIndx);

        }

    }
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(3);
        h.add(8);
        h.add(7);
        h.add(9);
        h.add(10);
        h.add(1);

        h.display();

        h.remove();

        h.display();
    }    
}