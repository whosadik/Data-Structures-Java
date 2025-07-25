import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MyBSTTest {

    private static final int TESTING_ELEMENTS_COUNT = 20;

    @Test
    public void testPutAndGetWithIntKeyAndStructKey() {
        MyBST<String, RandomFormula.TestStruct> bst = new MyBST<>();
        List<MyBST.TraversalNode<String, RandomFormula.TestStruct>> currList = new ArrayList<>();
        List<Integer> normalOrderToAdd = getNormalOrderToAdd(1, TESTING_ELEMENTS_COUNT);
        for (Integer i : normalOrderToAdd) {
            String key = String.valueOf(i);
            RandomFormula.TestStruct value = RandomFormula.getStruct(i);
            currList.add(new MyBST.TraversalNode<>(key, value));
            try {
                bst.put(key, value);
            } catch (Exception e) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
        assertTrue(true);
    }

    @Test
    public void testPutWithExistingKey() {
        MyBST<Integer, Integer> bst = new MyBST<>();
        try {
            bst.put(1, 1);
            assertThrows(IllegalArgumentException.class, () -> bst.put(1, 8));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetWithIntKeyAndValues() {
        MyBST<Integer, Integer> bst = new MyBST<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> normalOrderToAdd = getNormalOrderToAdd(1, TESTING_ELEMENTS_COUNT);
        for (Integer i : normalOrderToAdd) {
            int key = i;
            int value = RandomFormula.randomFormula(i);
            map.put(key, value);
            try {
                bst.put(key, value);
            } catch (Exception e) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
        for (int i = 1; i <= TESTING_ELEMENTS_COUNT; i++) {
            Integer bstValue = bst.get(i);
            assertNotNull(bstValue);
            assertEquals(map.get(i), bstValue);
        }
        assertNull(bst.get(100));
    }

    @Test
    public void testDeleteWithIntKeyAndValues() {
        MyBST<Integer, Integer> bst = new MyBST<>();
        Map<Integer, Integer> currMap = new HashMap<>();
        List<List<MyBST.TraversalNode<Integer, Integer>>> expectedInOrderTraversals = new ArrayList<>();
        List<List<MyBST.TraversalNode<Integer, Integer>>> actualInOrderTraversals = new ArrayList<>();
        for (int i = 1; i <= TESTING_ELEMENTS_COUNT; i++) {
            currMap.put(i, RandomFormula.randomFormula(i));
        }

        for (int i = 1; i <= TESTING_ELEMENTS_COUNT; i++) {
            bst.delete(i);
            currMap.remove(i);
            List<MyBST.TraversalNode<Integer, Integer>> currentTraversal = bst.inOrderTraversal();
            actualInOrderTraversals.add(currentTraversal);
            List<MyBST.TraversalNode<Integer, Integer>> expectedTraversal = getCurrentTraversal(currMap);
            expectedInOrderTraversals.add(expectedTraversal);
        }
        assertEquals(expectedInOrderTraversals, actualInOrderTraversals);
    }

    @Test
    public void testDeleteWithRandomDeletedIndexes() {
        MyBST<Integer, Integer> bst = new MyBST<>();
        Map<Integer, Integer> currMap = new HashMap<>();
        List<List<MyBST.TraversalNode<Integer, Integer>>> expectedInOrderTraversals = new ArrayList<>();
        List<List<MyBST.TraversalNode<Integer, Integer>>> actualInOrderTraversals = new ArrayList<>();
        for (int i = 1; i <= TESTING_ELEMENTS_COUNT; i++) {
            currMap.put(i, RandomFormula.randomFormula(i));
        }

        int[] rndArr = RandomFormula.shuffleMp(currMap);
        for (Integer i : rndArr) {
            bst.delete(i);
            currMap.remove(i);
            List<MyBST.TraversalNode<Integer, Integer>> currentTraversal = bst.inOrderTraversal();
            actualInOrderTraversals.add(currentTraversal);
            List<MyBST.TraversalNode<Integer, Integer>> expectedTraversal = getCurrentTraversal(currMap);
            expectedInOrderTraversals.add(expectedTraversal);
        }
        assertEquals(expectedInOrderTraversals, actualInOrderTraversals);
    }

    private List<Integer> getNormalOrderToAdd(int l, int r) {
        if (l > r) {
            return Collections.emptyList();
        }
        if (l == r) {
            return Collections.singletonList(l);
        }
        int mid = (l + r) / 2;
        List<Integer> currAns = new ArrayList<>();
        currAns.add(mid);
        List<Integer> leftAns = getNormalOrderToAdd(l, mid - 1);
        List<Integer> rightAns = getNormalOrderToAdd(mid + 1, r);
        currAns.addAll(leftAns);
        currAns.addAll(rightAns);
        return currAns;
    }

    private List<MyBST.TraversalNode<Integer, Integer>> getCurrentTraversal(Map<Integer, Integer> map) {
        List<MyBST.TraversalNode<Integer, Integer>> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new MyBST.TraversalNode<>(entry.getKey(), entry.getValue()));
        }
        arr.sort(Comparator.comparingInt(o -> o.key));
        return arr;
    }
}
