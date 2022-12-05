//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;
import java.util.Hashtable;
import java.util.Set;


public class HashTable<E> extends ElasticERL {

    //initialize hash table
    Hashtable<Integer, DatabaseEntry<E>> hashTable;

    /**
     * default constructor
     */
    public HashTable() {
        this(0);
    }

    /**
     * Parameterized constructor
     * Creates hashtable
     * @param n - size n int
     */
    public HashTable(int n) {
        hashTable = new Hashtable<Integer, DatabaseEntry<E>>(n);
    }

    /**
     * returns all keys sorted using heap sort
     * 1st - Extracts the key out of the hash table
     * 2nd - Converts it into an array
     * 3rd - Calls heap sort with the array as parameter
     * @return - return array with all the keys sorted in decreasing order
     */
    public Integer[] allKeys() {
        Set<Integer> keys = hashTable.keySet();
        Integer[] array = keys.toArray(new Integer[keys.size()]);
        System.out.println("Number of keys: "+ array.length);

        heapSort(array);
        return array;
    }

    /**
     * Heap sort method that sorts the hash table in decreasing order.
     * 1st - Builds heap by rearranging the array (calling heapDataStructure)
     * 2nd - extracts an element from the heap one by one
     * @param array - Receives array
     */
    public void heapSort(Integer[] array) {
        int n = array.length;

        // 1st
        for (int i = (n/2 - 1); i >= 0; i--)
            heapDataStructure(array, n, i);

        // 2nd
        for (int i = n - 1; i >= 0; i--) {

            // move the root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // calls heapDataStructure on the reduced heap
            heapDataStructure(array, i, 0);
        }
    }

    /**
     * Creates a heap data structure from a binary tree using an array.
     * Starting at first index of a non-leaf node whose index is n/2 - 1.
     * Continue using recursion.
     * @param array - array
     * @param n - size n
     * @param i -  index i
     */
    void heapDataStructure(Integer[] array, int n, int i) {
        //Smallest = root
        int root = i;
        int left = 2*i + 1;
        int right = 2 *i + 2;

        // Left child smaller than root
        if (left < n && array[left] < array[root])
            root = left;

        // Right child smaller than root
        if (right < n && array[right] < array[root])
            root = right;

        // if root is not root anymore
        if (root != i) {
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;

            // recursive call the subtree with heapDataStructure
            heapDataStructure(array, n, root);
        }
    }

    /**
     * Add an entry for the given key and value.
     * If entry already exist with the same key
     * then it removes it and puts the new entry.
     * Increases the size of the hash table.
     * @param key - key
     * @param value - value
     */
    public void add(int key, E value) {
        //Makes sure that the key is of length 8
        if(Integer.toString(key).length() != 8 ){
            return;
        }

        DatabaseEntry<E> newEntry = new DatabaseEntry<>(key, value);
        if(hashTable.containsKey(key)) {
            hashTable.replace(key, newEntry);
            return;
        }
        hashTable.put(key, newEntry);
        _size++;
    }

    /**
     * Remove the entry for the given key.
     * Tries to remove the key. If none found, throws NullPointerException
     * else removes entry and reduces the size of the hash table.
     * @param key - key
     * @return - returns the removed key
     */
    public DatabaseEntry<E> remove(int key) {
        try {
            DatabaseEntry<E> temp = hashTable.remove(key);
            _size--;
            return temp;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Method that finds the value of a given key.
     * Return the value of key or null if not found.
     * @param key - key
     * @return - returns value or null
     */
    public E getValues(int key) {
        try {
            return hashTable.get(key).getValue();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Method that first calls allKeys() to sort the hash table and to get it as an array.
     * For loop that finds the provided key and returns value of array[indexKey+1]
     * If and only if there is an item there.
     * @param key - provided key
     * @return - returns next key or 0
     */
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

    /**
     * Method that first call allKeys() to sort the hash table and to get it as an array.
     * For loop that finds the provided key and returns value of array[indexKey-1]
     * If and only if there is an item there.
     * @param key - key
     * @return - returns previous key
     */
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