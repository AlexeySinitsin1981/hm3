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
        myMap.add(null, null);
        assertEquals(null, myMap.get(null));

    }

    @Test
    public void removeMy() {
        myMap.add("1","1");
        myMap.remove("1");
        assertEquals(0, myMap.count);
        assertEquals(null, myMap.remove(2));
        myMap.put(null,"2");
        assertEquals("2", myMap.remove(null));

    }

    @Test
    public void add() {
        myMap.add("1","1");
        assertEquals(1, myMap.count);
        myMap.add(null, "2");
        assertEquals("2", myMap.get(null));
    }


    @Test
    public void checking() {
        myMap.add("1","1");
        assertTrue(myMap.containsKey("1"));
        myMap.add(null,"2");
        assertTrue(myMap.containsKey(null));


    }

    @Test
    public void getCount() {
        for (int i = 0; i < 50; i++) {
            myMap.add(i,"1");
        }

        assertEquals(50, myMap.count);
        myMap.remove(1);
        assertEquals(49, myMap.getCount());
        myMap.add(null, "3");
        myMap.remove(null);
        assertEquals(49, myMap.getCount());

    }

    @Test
    public void size() {
        myMap.add("1","1");
        myMap.add("2","2");
        myMap.add("3","3");
        myMap.add("4","4");

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        assertEquals(map.size(), myMap.count);
    }

    @Test
    public void isEmpty() {
        myMap.add("1","1");
        myMap.add("2","2");
        myMap.add("3","3");
        myMap.removeMy("2");

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.remove("2","2");
        assertEquals(map.size(), myMap.count);
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
        assertEquals(map.containsValue("Korea"), myMap.containsValue("Korea"));
    }

    @Test
    public void get() {
        myMap.add("1","1");
        myMap.add("2","2");
        myMap.add("3","3");

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        assertEquals(map.get("2"), myMap.getMy("2"));
    }

    @Test
    public void put() {
        myMap.add("1","1");
        myMap.add("2","2");
        myMap.add("3","3");

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        assertEquals(map.size(), myMap.count);
    }

    @Test
    public void remove() {
        myMap.add("1","1");
        map.put("1","1");

        myMap.removeMy("1");
        map.remove("1");
        assertEquals(map.size(), myMap.count);
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