package hm3;


import java.util.Map;
import java.util.Objects;

public class MyEntry<K, V> implements Map.Entry<K, V> {
    K key;
    V value;
    MyEntry<K, V> next;

    public MyEntry(K key, V value, MyEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next=null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;
        return Objects.equals(key, myEntry.key) &&
                Objects.equals(value, myEntry.value) &&
                Objects.equals(next, myEntry.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, next);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    public MyEntry<K, V> getNext() {
        return next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setNext(MyEntry<K, V> next) {
        this.next = next;
    }


}
