//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Sequence<E> extends ElasticERL {

    //initialize sequence
    ArrayList<DatabaseEntry<E>> sequence;

    /**
     * Default constructor
     */
    public Sequence() {
        this(0);
    }

    /**
     * parameterized constructor
     * @param n - takes int n size of sequence
     */
    public Sequence(int n) {
        sequence = new ArrayList<DatabaseEntry<E>>(n);
    }

    /**
     * return all keys in ElasticERL as a sorted sequence
     * @return - array of sorted sequence
     */
    public Integer[] allKeys() {
        Integer[] result = new Integer[super.get_size()];
        int counter = 0;

        for(DatabaseEntry<E> each : sequence) {
            result[counter] = each.getKey();
            counter++;
        }
        System.out.println("Number of keys: "+ counter);
        insertionSort(result);
        return result;
    }

    /**
     * Sorting the sequence using insertion Sort O(n^2)
     * @param keys - array of keys
     */
    public void insertionSort(Integer[] keys) {
        for (int i = 1; i < keys.length; i++) {
            int current = keys[i];
            int j = i;

            while (j > 0 && keys[j - 1] < current) {
                keys[j] = keys[j - 1];
                j--;
            }
            keys[j] = current;
        }
    }

    /**
     * Add an entry for the given key and value.
     * If entry already exist with the same key
     * then it removes it and puts the new entry.
     * Increases the size of the sequence.
     * @param key - key
     * @param value - value
     */
    public void add(int key, E value) {
        //Makes sure that the key length is 8
        if(Integer.toString(key).length() != 8) {
            return;
        }

        // try catch that removes old key. If none found, adds a new key.
        try {
            this.remove(key);
        } catch(Exception e) {
            sequence.add(new DatabaseEntry<>(key, value));
            _size++;
            return;
        }
        sequence.add(new DatabaseEntry<>(key, value));
        _size++;
    }

    /**
     * Remove the entry for the given key.
     * Tries to find the index of the key. If none found, throws exception
     * else removes entry and reduces the size of the sequence.
     * @param key - key
     * @return - returns the removed key
     */
    public DatabaseEntry<E> remove(int key) {
        try {
            int findPosition = search(key);
            DatabaseEntry<E> temp = sequence.get(findPosition);
            sequence.remove(findPosition);
            _size--;
            return temp;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Method that searches for a received key. If none found then throws an exception
     * @param key - key provided
     * @return - returns the index of the key found or null
     * @throws NoSuchElementException - returns null
     */
    public int search(int key) throws NoSuchElementException {
        for (int i = 0; i< _size; ++i) {
            if(sequence.get(i).getKey() == key) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Method that finds the value of a given key.
     * Using search method finds the index and then get the value.
     * @param key - key
     * @return - returns value or null
     */
    public E getValues(int key) {
        try {
            int i = search(key);
            return sequence.get(i).getValue();

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Method that first call allKeys() to sort the sequence and to get it as an array.
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
     * Method that first call allKeys() to sort the sequence and to get it as an array.
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