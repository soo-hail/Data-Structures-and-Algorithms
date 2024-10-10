public class Occurance {
    
    public static int firstOccured(int array[], int key, int indx){

        if(indx == array.length){ // ALL ARRAY IS TRAVERSED. BUT ELEMENT NOT FOUND.
            return -1;
        }

        if(array[indx] == key){
            return indx;
        }

        return firstOccured(array, key, indx +1);
    }

    public static int lastOccured(int array[], int key, int indx){ // TRAVERSE FROM LAST-INDEX.
        if(indx == -1){ // TRAVERSED ALL ARRAY FROM LAST. BUT ELEMENT NOT FOUND IN ARRAY.
            return -1;
        }

        if(array[indx] == key){
            return indx;
        }

        return lastOccured(array, key, indx - 1);
    }

    public static int lastOccured2(int array[], int key, int indx){ // TRAVERSE FROM START INDEX OF ARRAY.
        
        if(indx == array.length){
            return -1;
        }

        System.out.println(indx);
        int foundIndx = lastOccured(array, key, indx+1); // TRAVERSING ARRAY FIRST.
        // THEN COMPARING WITH SELF.
        if(array[indx] == key){ // IF THIS CONDITION IS NOT TRUE EVEN FOR ONE TIME. THEN "FOUNDINDX" WILL BE -1.
            return indx;
        }

        return foundIndx;

    }
    public static void main(String[] args) {
        int array[] = {45,56,33,78,33,23,89,3,33};
        int key = 89;

        System.out.println("FIRST OCCURED : " + firstOccured(array, key, 0));
        System.out.println("LAST OCCURED : " + lastOccured(array, key, array.length-1));
        System.out.println(lastOccured2(array, key, 0));
    }
}
