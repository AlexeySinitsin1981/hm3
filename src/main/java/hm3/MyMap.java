package hm3;

import java.util.*;

public class MyMap<K, V> implements Map {
    private static final int SIZE = 16;

    private MyEntry<K, V>[] table = new MyEntry[SIZE];

    int count = 0;


    V getMy(K k) {
        int column = k == null ? 0 : k.hashCode() % SIZE;
        MyEntry<K, V> e = table[column];
        while (e != null) {
            if (e.key.equals(k)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    V removeMy(K k) {
        int column = k == null ? 0 : k.hashCode() % SIZE;
        MyEntry e = table[column];
        if (table[column] == null) {
            return null;
        } else {
            MyEntry<K, V> previous = null;
            MyEntry<K, V> current = table[column];

            while (current != null) {
                if (((current.key == k) & (k == null)) ||current.key.equals(k)) {
                    if (previous == null) {

                        table[column] = null;
                        count--;
                        return current.getValue();
                    } else {
                        previous.next = current.next;
                        count--;
                        return current.getValue();
                    }
                }
                previous = current;
                current = current.next;
            }
            return null;
        }
    }

    V add(K k, V v) {
        MyEntry<K, V> newEntry = new MyEntry<>(k, v, null);

        int column = k == null ? 0 : k.hashCode() % SIZE;
        MyEntry<K, V> entry = table[column];

        if (entry == null) {
            table[column] = newEntry;
            count++;
            return null;
        } else {
            MyEntry<K, V> current = entry;
            MyEntry<K, V> previos = null ;
            while (current != null) {
                if (((current.key == k) & (k == null)) ||current.key.equals(k)) {
                    V value = current.getValue();
                    current.setValue(v);
                    return value;
                }
                previos=current;
                current = current.next;
            }
            previos.setNext(newEntry);
            count++;


            return null;
        }
    }


    boolean update(K k, V v) {
        MyEntry<K, V> newEntry = new MyEntry<>(k, v, null);
        int column = k == null ? 0 : k.hashCode() % SIZE;
        MyEntry entry = table[column];

        if (entry == null) {
            table[column] = newEntry;
        } else {
            MyEntry<K, V> previous = null;
            MyEntry<K, V> current = entry;

            while (current != null) {
                if (current.key.equals(k)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[column] = newEntry;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;

                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        return false;
    }


    private boolean checking(K k) {

        int column = k == null ? 0 : k.hashCode() % SIZE;
        MyEntry e = table[column];
        while (e != null) {
            if (((e.key == k) & (k == null)) || e.key.equals(k)) {
                return true;
            }
            e = e.next;
        }
        return false;
    }

    public int getCount() {

        return count;
    }

    public static void main(String[] args) {
        MyMap myHashMap = new MyMap();

//        myHashMap.add("Audi", "Germany");
//        myHashMap.add("Land-Rover", "England");
//        myHashMap.add("Lada", "Russia");
//        myHashMap.add("Fiat", "Italy");
//        myHashMap.add("Ford", "USA");
//        myHashMap.add(null, "Spain");

//        System.out.println("" + myHashMap.getMy("Lada"));
//        myHashMap.removeMy("Lada");
//        System.out.println("" + myHashMap.get("Lada"));


//        System.out.println(myHashMap.getCount());
//        myHashMap.update("Land-Rover", "Cyprus");
//        System.out.println("" + myHashMap.getMy("Land-Rover"));
//        System.out.println(myHashMap.checking("Ford"));
//        System.out.println(myHashMap.checking(null));

//        System.out.println(myHashMap.isEmpty());
//        System.out.println(myHashMap.keySet());
        //myHashMap.clear();
//        System.out.println(myHashMap.count);
//        System.out.println(myHashMap.keySet());
//
//        System.out.println(myHashMap.containsValue("USA"));
//
        HashMap<String,String> myHashMap2 = new HashMap<>();
        myHashMap2.put("BMW", "Germany");
        myHashMap2.put("Geely", "China");
        myHashMap2.put("Kia", "Korea");
        myHashMap2.put(null, "Russia");


        System.out.println(myHashMap2.size());

//        myHashMap.putAll(myHashMap2);
//        System.out.println("---------------------------------------");
//        System.out.println(myHashMap.get("BMW"));


    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        return checking((K) key);
    }

    @Override
    public boolean containsValue(Object value) {

        for (MyEntry<K, V> kvMyEntry : table) {
            while (kvMyEntry != null) {
                if (kvMyEntry.getValue().equals(value)) {
                    return true;
                }
                kvMyEntry = kvMyEntry.next;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for (MyEntry<K, V> kvMyEntry : table) {
            while (kvMyEntry != null) {
                if (((kvMyEntry.key == key) & (key == null)) ||kvMyEntry.getKey().equals(key)) {
                    return kvMyEntry.getValue();
                }
                kvMyEntry = kvMyEntry.next;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return add((K) key, (V) value);
    }

    @Override
    public Object remove(Object k) {
        return removeMy((K) k);
    }

    @Override
    public void putAll(Map m) {
        for (Object o : m.keySet()) {
            this.put(o, m.get(o));
        }
    }

    @Override
    public void clear() {
        if (table != null) {
            count = 0;
            for (int i = 0; i < table.length; i++)
                table[i] = null;
        }
    }


    @Override
    public Set keySet() {
        Set<K> mySet = new HashSet<>();
        for (MyEntry<K, V> kvMyEntry : table) {
            do {
                if (kvMyEntry != null) {
                    mySet.add(kvMyEntry.getKey());
                    kvMyEntry = kvMyEntry.next;
                }
            } while (kvMyEntry != null);
        }
        return mySet;
    }

    @Override
    public Collection values() {
        List<V> mySet = new LinkedList<>();
        for (MyEntry<K, V> kvMyEntry : table) {
            do {
                if (kvMyEntry != null) {
                    mySet.add(kvMyEntry.getValue());
                    kvMyEntry = kvMyEntry.next;
                }
            } while (kvMyEntry != null);
        }
        return mySet;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> mySet = new HashSet<>();
        for (MyEntry<K, V> kvMyEntry : table) {
            while (kvMyEntry != null) {
                if (kvMyEntry != null) {
                    mySet.add((Entry) kvMyEntry);
                    kvMyEntry = kvMyEntry.next;
                }
            }
        }
        return mySet;
    }
}


