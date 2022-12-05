//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Sequence<E> extends ElasticERL<E> {
    ArrayList<DatabaseEntry<E>> sequence;

    //constructor
    public Sequence() {
        this(0);
    }
    public Sequence(int n) {
        sequence = new ArrayList<DatabaseEntry<E>>(n);
    }

    //return all keys in ElasticERL as a sorted sequence;
    public Integer[] allKeys() {
        Integer[] result = new Integer[super.get_size()];
        int ctr = 0;
        for(DatabaseEntry<E> each : sequence) {
            result[ctr] = each.getKey();
            ctr++;
        }
        System.out.println("Number of keys: "+ allKeys().length);
        insertionSort(result);
        return result;
    }

    //sorting the sequence using insertion Sort O(n^2)
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

    //add an entry for the given key and value;
    public void add(int key, E value) {
        if(Integer.toString(key).length() != 8) {
            return;
        }

        // try catch that removes old key. If none found, adds a new key.
        try {
            this.remove(key);
        } catch(Exception e) {
            sequence.add(new DatabaseEntry<E>(key, value));
            _size++;
            return;
        }
        sequence.add(new DatabaseEntry<E>(key, value));
        _size++;
    }

    //remove the entry for the given key
    public DatabaseEntry<E> remove(int key) {
        try {
            int index = search(key);
            DatabaseEntry<E> temp = sequence.get(index);
            sequence.remove(index);
            _size--;
            return temp;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int search(int key) throws NoSuchElementException {
        for (int i = 0; i< _size; ++i) {
            if(sequence.get(i).getKey() == key) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public E getValues(int key) {
        try {
            int index = search(key);
            return sequence.get(index).getValue();

        } catch (NoSuchElementException e) {
            return null;
        }
    }

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