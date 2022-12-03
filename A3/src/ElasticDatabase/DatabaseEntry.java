package A3.src.ElasticDatabase;

public class DatabaseEntry<E> implements Comparable<DatabaseEntry> {
    private long key;
    private E value;

    //constructor
    public DatabaseEntry(long key, E value) {
        this.key = key;
        this.value = value;
    }

    //getters and setters
    public long getKey() {
        return key;
    }

    public void setKey(long key) {
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
        return Long.compare(this.getKey(), o.getKey());
    }

}