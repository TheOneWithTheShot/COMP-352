package A3.src.ElasticDatabase;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Set;


public class HashTable<E> extends ElasticERL<E> {
    Hashtable<Integer, DatabaseEntry<E>> hashTable;

    public HashTable() {
        this(0);
    }
    public HashTable(int n) {
        hashTable = new Hashtable<Integer, DatabaseEntry<E>>(n);
    }

    /**
     * returns all keys sorted using heap sort
     * @return - return array with all the keys sorted
     */
    public Integer[] allKeys() {
        //extract keys out from the hash table and converts it into an array
        Set<Integer> keys = hashTable.keySet();
        Integer[] arr = keys.toArray(new Integer[keys.size()]);
        System.out.println("Number of keys: "+ arr.length);


        heapSort(arr); //Call heap sort

        return arr;
    }

    public void heapSort(Integer[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapDataStructure(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call min heapify on the reduced heap
            heapDataStructure(arr, i, 0);
        }
    }

    // Creates a heap data structure from a binary tree using an array.
    // Starting at first index of a non-leaf node whose index is n/2 - 1.
    // Continue using recursion.
    void heapDataStructure(Integer[] arr, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is smaller than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is smaller than smallest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If smallest is not root
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected sub-tree
            heapDataStructure(arr, n, smallest);
        }
    }

    //add an entry for the given key and value;
    public void add(int key, E value) {
        if( Integer.toString(key).length() != 8 ){
            return;
        }

        DatabaseEntry<E> entry = new DatabaseEntry<>(key, value);
        if(hashTable.containsKey(key)) {
            hashTable.replace(key, entry);
            return;
        }
        hashTable.put(key, entry);
        _size++;
    }

    //remove the entry for the given key
    public DatabaseEntry<E> remove(int key) {
        try {
            DatabaseEntry<E> temp = hashTable.remove(key);
            _size--;
            return temp;
        } catch (NullPointerException e) {
            return null;
        }
    }

    //return the values of the given key
    public E getValues(int key) {
        try {
            return hashTable.get(key).getValue();
        } catch (NullPointerException e) {
            return null;
        }
    }

    //return the key for the successor of key
    public int nextKey(int key) {
        int nextKey = 0;
        Integer[] arrayKeys = allKeys();

        for (int i = 0; i <= arrayKeys.length-1; i++) {
            if (arrayKeys[i] == key) {
                if (i+1 <= (arrayKeys.length-1)) {
                    nextKey= arrayKeys[i+1];
                }
            }
        }
        if (nextKey == 0){
            System.out.println("The next key of " + key + " does not exist.");
            return 0;
        } else {
            return nextKey;
        }
    }

    //return the key for the predecessor of key
    public int prevKey(int key) {
        int previousKey = 0;
        Integer[] arrayKeys = allKeys();

        for (int i = 0; i <= arrayKeys.length-1; i++) {
            if (arrayKeys[i] == key) {
                if (i-1 >= 0) {
                    previousKey= arrayKeys[i-1];
                }
            }
        }
        if (previousKey == 0){
            System.out.println("The previous key of " + key + " does not exist.");
            return 0;
        } else {
            return previousKey;
        }
    }
}