import java.util.*;

public class HashMapCode {

    static class HashMap<keyType, valueType>{

        // CREATE A DATA TYPE TO STORE PAIR.
        private class Pair {
            keyType key;
            valueType value;

            // CONSTRUCTOR()
            Pair(keyType key, valueType value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Pair> buckets[]; // ARRAY OF LINKED-LIST (ACTUAL HASHMAP).
        private int k = 2; // THRESHOLD
        private int n; // NO. OF KEY-VALUE PAIRS.

        @SuppressWarnings("unchecked") // TO SUPPRESS UNWANTED WARNINGS OF NEXT BLOCK OF CODE.
        HashMap() { // CONSTRUCTOR.
            // WE ARE NOT DEFINING THE TYPE OF LINKED-LIST HERE SO WE DO "@SuppressWarnings("Unchecked")"
            this.buckets = new LinkedList[4]; // GIVING SPACE IN MEMORY FOR THE BUCKETS.
            this.n = 0; // INITIALLY NO. OF KEY VALUE PAIRS == 0.

            // INITIALIZE EVERY INDEX OF BUCKETS WITH LINKED-LIST.
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>(); // INITIALIZING EVERY INDEX OF BUCKET WITH LINKED-LIST.
            }
        }

        // GETBUCKET() : IT IS A HASH FUNCTION WHICH RETURNS BUCKET-INDEX OF A KEY.
        private int getBucket(keyType key) { // HASH-FUNCTION.
            int hc = key.hashCode(); // RETURNS INTEGER FORM OF KEY.
            return Math.abs(hc) % buckets.length; // TO GET POSITIVE INDEX BETWEEN "0 TO N-1"
        }

        // getDataIndex() : AFTER TRAVERSING LINKED-LIST, RETURNS INDEX OF KEY-VALUE PAIR IF IT IS PRESENT IN LINKED-LIST.
        private int getPairIndex(keyType key, int bi) {
            // SEARCH IN LINKED-LIST.
            LinkedList<Pair> currLL = buckets[bi]; // CURRENT LINKED-LIST.

            // TRAVERSE LINKED-LIST.
            for (int i = 0; i < currLL.size(); i++) {
                Pair currPair = currLL.get(i); // RETURNS PAIR PRESENT AT INDEX-i
                if (currPair.key == key) {
                    return i;
                }
            }

            return -1; // IF KEY IS NOT ALREADY PRESENT IN HASHMAP.
        }

        // REHASHING()
        private void rehashing() {
            LinkedList<Pair> oldBuckets[] = buckets; // STORE BUCKETS IN TEMP.

            buckets = new LinkedList[oldBuckets.length * 2]; // RESIZE THE BUCKET.
            // INITIALIZE ALL INDEXES OF BUCKET WITH LINKED-LIST.
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // TRANSFER ALL "KEY-VALUE PAIRS" OF OLD BUCKET TO TEMP-ARRAY OF LINKED-LIST.
            for (int bi = 0; bi < oldBuckets.length; bi++) {
                LinkedList<Pair> currLL = oldBuckets[bi]; // CURRENT LINKED-LIST.
                for (int pi = 0; pi < currLL.size(); pi++) {
                    Pair currPair = currLL.remove(pi);
                    int newbi = getBucket(currPair.key); // NEW BUCKET INDEX.

                    buckets[newbi].addLast(currPair); // ADD BACK IN BUCKETS.
                }
            }
        }

        // PUT() : TO ADD A NEW ELEMENT IN HASHMAP OR UPDATE THE VALUE OF KEY.
        public void put(keyType key, valueType value) {
            int bi = getBucket(key); // BUCKET INDEX OF CURRENT KEY.
            int pi = getPairIndex(key, bi); // PAIR INDEX IN LINKED-LIST.

            if (pi == -1) {
                // KEY IS NOT PRESENT IN HASHMAP. ADD NEW PAIR IN HASHMAP.
                Pair newPair = new Pair(key, value); // CREATE A NEW PAIR.
                buckets[bi].addLast(newPair);  // ADD NEW PAIR IN LINKEDLIST.
                n++; // INCREMENT NO. OF PAIR IN HASHMAP.
            } else { // KEY ALREADY PRESENT IN HASHMAP.
                // UPDATE VALUE OF KEY.
                Pair pair = buckets[bi].get(pi); // CURRENT PAIR 
                pair.value = value; // UPDATE VALUE OF PAIR.
            }

            // REHASHING CONDITION.
            double lamda = (double) n / buckets.length;
            if (lamda > k) { // LAMDA > THRESHOLD
                // REHASHING: LENGTH OF EACH LINKED-LIST IN BUCKETS HAS INCREASED MORE THAN THRESHOLD.
                rehashing();
            }
        }

        // containsKey()
        public boolean containsKey(keyType key) {
            int bi = getBucket(key);
            int pi = getPairIndex(key, bi);
            return pi != -1; // Returns true if key exists, false otherwise.
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        map.put("US", 90);
        map.put("Nepal", 5);

        System.out.println(map.containsKey("India")); // true
        System.out.println(map.containsKey("Pakistan")); // false
    }
}
