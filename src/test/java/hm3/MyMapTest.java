package hm3;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MyMapTest {
    MyMap myMap=new MyMap();
    HashMap<Object,Object> map = new HashMap<>();

    @Test
    public void getMy() {
        myMap.add("1","1");
        map.put("1","1");
        assertEquals(map.get("1"), myMap.get("1"));

    }

    @Test
    public void removeMy() {
        myMap.add("1","1");
        myMap.remove("1");
        assertEquals(0, myMap.count);
    }

    @Test
    public void add() {
        myMap.add("1","1");
        assertEquals(1, myMap.count);
    }

    @Test
    public void update() {
        myMap.add("1","1");
        myMap.update( "1", "2");
        assertEquals("2", myMap.get("1"));
    }

    @Test
    public void checking() {
        myMap.add("1","1");
        assertEquals("1", "1");
    }

    @Test
    public void getCount() {
        myMap.add("1","1");
        assertEquals(1, myMap.count);
        myMap.remove("1");
        assertEquals(0, myMap.count);
    }

    @Test
    public void size() {
        myMap.add("1","1");
        map.put("1","1");
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void isEmpty() {
        myMap.add("1","1");
        myMap.remove("1");

        map.put("1","1");
        map.clear();
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void containsKey() {
        myMap.add("Kia", "Korea");

        map.put("Kia", "Korea");
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void containsValue() {
        myMap.add("Kia", "Korea");

        map.put("Kia", "Korea");
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void get() {
        myMap.add("1","1");
        map.put("1","1");
        assertEquals(map.get("1"), myMap.getMy("1"));
    }

    @Test
    public void put() {
        myMap.add("1","1");
        map.put("1","1");
        assertEquals(map.get("1"), myMap.getMy("1"));
    }

    @Test
    public void remove() {
        myMap.add("1","1");
        map.put("1","1");

        myMap.remove("1");
        map.clear();
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void putAll() {
        myMap.put("BMW", "Germany");
        myMap.put("Geely", "China");
        myMap.put("Kia", "Korea");

        map.put("BMW", "Germany");
        map.put("Geely", "China");
        map.put("Kia", "Korea");
        assertEquals(map.entrySet(), myMap.entrySet());
    }

    @Test
    public void clear() {
        myMap.put("BMW", "Germany");
        myMap.put("Geely", "China");
        myMap.put("Kia", "Korea");

        map.put("BMW", "Germany");
        map.put("Geely", "China");
        map.put("Kia", "Korea");
        myMap.clear();
        map.clear();
        assertEquals(map.entrySet(), myMap.entrySet());
    }

    @Test
    public void keySet() {
        myMap.put("BMW", "Germany");
        myMap.put("Geely", "China");
        myMap.put("Kia", "Korea");

        map.put("BMW", "Germany");
        map.put("Geely", "China");
        map.put("Kia", "Korea");
        assertEquals(map.keySet(), myMap.keySet());
    }

    @Test
    public void values() {
        myMap.put("BMW", "Germany");
        myMap.put("Geely", "China");
        myMap.put("Kia", "Korea");

        map.put("BMW", "Germany");
        map.put("Geely", "China");
        map.put("Kia", "Korea");
        assertEquals(myMap.size(), map.size());
        for (Object o : map.keySet()) {
            assertEquals(map.get(o), myMap.get(o));
        }
    }

    @Test
    public void entrySet() {
        myMap.put("BMW", "Germany");
        myMap.put("Geely", "China");
        myMap.put("Kia", "Korea");

        map.put("BMW", "Germany");
        map.put("Geely", "China");
        map.put("Kia", "Korea");
        assertEquals(map.entrySet(), myMap.entrySet());
    }
}