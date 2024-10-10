public class CountingSort {

    public static int getMax(int array[]){
        int max = Integer.MIN_VALUE;
        for(int var : array){
            if(var > max){
                max = var;
            }
        }//end forLoop.
        return max;
    }
    public static void main(String[] args) {
        int array[] = {1,4,1,2,2,7,6,3,4,3,6,5};

        //FIND MAX ELEMENT IN ARRAY.
        int max = getMax(array); 

        //DECLARE COUNT ARRAY.
        int count[] = new int[max + 1];

        //INITIALIZE COUNT ARRAY WITH ZERO.
        for(int i=0;i<count.length;i++){
            count[i] = 0;
        }

        //FIND FREQUENCE OF EACH ELEMENT AND STORE IN RESPECTIVE INDEX.
        for(int var : array){
            count[var]++;
        }

        //RESTORING ELEMENTS IN ARRAY(AS SORTED).
        int x = -1; //LAST INDEX OF SORTED ARRAY.
        for(int i=0;i<count.length;i++){ //TRAVERSING COUNT ARRAY.
            int freq = count[i];

            while(freq > 0){ //RESTORING ELEMENTS IN ARRAY.
                array[++x] = i; //STORING SORTED ELEMENTS.
                freq--;
            }
        }//END FORLOOP.

        for(int var : array){
            System.out.println(var);
        }
    }
    
}