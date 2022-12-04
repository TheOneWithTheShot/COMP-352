package A3.src.ElasticDatabase;

public class DatabaseEntry implements Comparable<DatabaseEntry> {
    private int key;
    private String value;

    //constructor
    public DatabaseEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    //getters and setters
    public long getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
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
