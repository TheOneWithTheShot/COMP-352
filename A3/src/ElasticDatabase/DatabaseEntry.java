//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;

public class DatabaseEntry<E> implements Comparable<DatabaseEntry> {
    private int key;
    private E value;

    //constructor
    public DatabaseEntry(int key, E value) {
        this.key = key;
        this.value = value;
    }
//
    //getters and setters
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    //compare method
    @Override
    public int compareTo(DatabaseEntry o) {
        return Integer.compare(this.getKey(), o.getKey());
    }

}
