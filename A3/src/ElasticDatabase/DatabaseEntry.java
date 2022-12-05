//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;

public class DatabaseEntry<E> {
    private int key;
    private E value;

    /**
     * parameterized constructor
     * @param key - key
     * @param value - value of key
     */
    public DatabaseEntry(int key, E value) {
        this.key = key;
        this.value = value;
    }

    /**
     * get key
     * @return - returns key
     */
    public int getKey() {
        return key;
    }

    /**
     * set key value
     * @param key - key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * get value of key
     * @return - returns value
     */
    public E getValue() {
        return value;
    }

    /**
     * set value of key
     * @param value - value
     */
    public void setValue(E value) {
        this.value = value;
    }
}
