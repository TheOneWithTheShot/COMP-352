package A3.src.ElasticDatabase;
import java.util.Hashtable;
import java.util.Set;


public class HashTable<E> extends ElasticERL<E> {
    Hashtable<Integer, DatabaseEntry<E>> hashTable;

    public HashTable() {
        this(1000);
    }
    public HashTable(int n) {
        super();
        hashTable = new Hashtable<Integer, DatabaseEntry<E>>(n);
    }

    //add an entry for the given key and value;
    public void add(int key, E value) {
        if( Integer.toString(key).length() != 8 ){
            //System.out.println("Hashtable Error: Length is not 8.\n");
            return;
        }

        //checks if key exists
        DatabaseEntry<E> entry = new DatabaseEntry<>(key, value);
        if(hashTable.containsKey(key)) {
            //System.out.println("Found duplicate for key " + key + ".\n");
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
            System.out.println("Key " + key + " does not exist");
        }
        return null;
    }

    //return the values of the given key
    public E getValues(int key) {
        try {
            return hashTable.get(key).getValue();
        } catch (NullPointerException e)  {
            System.out.println("Key " + key + " does not exist");
        }
        return null;
    }

    //return the key for the successor of key
    public int nextKey(int key) {
        Set<Integer> keys = hashTable.keySet();
        Integer[] allKeys = keys.toArray(new Integer[keys.size()]);

        for(int i = 0; i<allKeys.length; ++i) {
            if(allKeys[i] == key) {
                if(i < allKeys.length - 1) {
                    return allKeys[i+1];
                } else {
                    System.out.println("Next key of " + key + " does not exist.");
                    return 0;
                }
            }
        }

        System.out.println("Next key of " + key + " does not exist.");
        return 0;
    }

    //return the key for the predecessor of key
    public int prevKey(int key) {
        //convert key set into array
        Set<Integer> keys = hashTable.keySet();
        Integer[] allKeys = keys.toArray(new Integer[keys.size()]);

        for(int i = 0; i<allKeys.length; ++i) {
            if(allKeys[i] == key) {
                if(i >= 1) {
                    return allKeys[i-1];
                } else {
                    System.out.println("Prev key of " + key + " does not exist.");
                    return 0;
                }
            }
        }

        System.out.println("Prev key of " + key + " does not exist.");
        return 0;
    }

    //returns all keys sorted using heap sort
    public Integer[] allKeys() {
        //extract keys out from the hash table and converts it into an array
        Set<Integer> keys = hashTable.keySet();
        Integer[] arr = keys.toArray(new Integer[keys.size()]);
        System.out.println("size is:"+ arr.length);

        heapSort(arr); //Call heap sort

        return arr;
    }

    public void heapSort(Integer[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapDataStructure(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // calls headDataStructure on a reduced heap
            heapDataStructure(arr, i, 0);
        }
    }

    // Creates a heap data structure from a binary tree using an array.
    // Starting at first index of a non-leaf node whose index is n/2 - 1.
    // Continue using recursion.
    void heapDataStructure(Integer arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursive call
            heapDataStructure(arr, n, largest);
        }
    }

}