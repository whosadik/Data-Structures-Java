import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {

    private final int testingCap = 200;
    private final int testingAddElsCount = 5000;

    @Test
    public void testPut() {
        MyHashMap<Integer, Integer> mp = new MyHashMap<>(testingCap);
        for (int i = 1; i <= testingAddElsCount; i++) {
            mp.put(i, RandomFormula.randomFormula(i));
        }
        assertEquals(testingAddElsCount, mp.size());
    }

    @Test
    public void testGet() {
        MyHashMap<Integer, Integer> mp = new MyHashMap<>(testingCap);
        for (int i = 1; i <= testingAddElsCount; i++) {
            mp.put(i, RandomFormula.randomFormula(i));
        }

        for (int i = 1; i <= testingAddElsCount; i++) {
            assertEquals(RandomFormula.randomFormula(i), mp.get(i));
        }

        assertNull(mp.get(19));
    }

    @Test
    public void testContains() {
        MyHashMap<Integer, Integer> mp = new MyHashMap<>(testingCap);
        for (int i = 1; i <= testingAddElsCount; i++) {
            mp.put(i, RandomFormula.randomFormula(i));
        }

        assertTrue(mp.contains(1));
        assertTrue(mp.contains(124));
        assertTrue(mp.contains(43221));
        assertFalse(mp.contains(-19284));
    }

    @Test
    public void testRemove() {
        MyHashMap<Integer, Integer> mp = new MyHashMap<>(testingCap);
        for (int i = 1; i <= testingAddElsCount; i++) {
            mp.put(i, RandomFormula.randomFormula(i));
        }

        mp.remove(1);
        mp.remove(2);
        mp.remove(-23498);
        mp.remove(2);
        mp.remove(239298);

        assertEquals(testingAddElsCount - 5, mp.size());
    }

    @Test
    public void testWithStructs() {
        MyHashMap<Integer, RandomFormula.TestStruct> mp = new MyHashMap<>(testingCap);

        for (int i = 1; i <= testingAddElsCount; i++) {
            mp.put(i, RandomFormula.getStruct(i));
        }

        for (int i = 1; i <= testingAddElsCount; i++) {
            assertEquals(RandomFormula.getStruct(i), mp.get(i));
        }

        assertFalse(mp.contains(19));
    }
}
