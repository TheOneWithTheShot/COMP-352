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
        super();
        sequence = new ArrayList<DatabaseEntry<E>>(n);
    }

    //add an entry for the given key and value;
    public void add(int key, E value) {
        if(Integer.toString(key).length() != 8) {
            //System.out.println("Sequence Error: Length is not 8.\n");
            return;
        }

        //clear the old key
        try {
            this.remove(key);
        } catch(Exception e) {
            sequence.add(new DatabaseEntry<E>(key, value));
            _size++;
            return;
        }
        //System.out.println("Found duplicate for key " + key + ".\n");      
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

        } catch (NullPointerException e) {
            System.out.println("Key " + key + " does not exist");
            return null;
        }
    }

    public E getValues(int key) {
        try {
            int index = search(key);
            return sequence.get(index).getValue();

        } catch (NoSuchElementException e) {
            System.out.println("Key " + key + " does not exist");
        }

        return null;
    }

    public int nextKey(int key) {
        try {
            int index = search(key);
            if(sequence.get(index+1) != null) {
                return sequence.get(index+1).getKey();
            } else {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e) {
            System.out.println("Next key of " + key + " does not exist.");
        }
        return 0;
    }

    public int prevKey(int key) {
        try {
            int index = search(key);
            if(sequence.get(index-1) != null) {
                return sequence.get(index-1).getKey();
            } else {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e) {
            System.out.println("Prev key of " + key + " does not exist.");
        }
        return 0;
    }

    public int search(int key) throws NoSuchElementException {
        for (int i = 0; i< _size; ++i) {
            if(sequence.get(i).getKey() == key) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    //return all keys in ElastricERL as a sorted sequence;
    public Integer[] allKeys() {
        Integer[] result = new Integer[super.get_size()];
        int ctr = 0;
        for(DatabaseEntry<E> each : sequence) {
            result[ctr] = each.getKey();
            ctr++;
        }
        insertionSort(result);
        return result;
    }

    //sorting the sequence using insertion Sort
    public void insertionSort(Integer[] keys) {
        int n = keys.length;
        for(int i = 1; i< n; ++i) {
            int current = keys[i];
            int j = i-1;

            while(j >= 0 && current < keys[j]) {
                keys[j+1] = keys[j];
                j--;

            }
            keys[j+1] = current;
        }
    }
}