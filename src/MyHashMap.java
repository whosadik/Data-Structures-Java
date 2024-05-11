import java.security.*;
import java.util.*;

public class MyHashMap<K, E> {

    private static class MapNode<K, E> {
        K key;
        E value;

        public MapNode(K key, E value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<MapNode<K, E>>[] chains;
    private int capacity;
    private MessageDigest hasher;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCap) {
        this.chains = new List[initialCap];
        this.capacity = initialCap;
        try {
            this.hasher = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.size = 0;
    }

    private int hash(K el) {
        byte[] salt = hasher.digest(el.toString().getBytes());
        int intSalt = 0;
        for (int i = 0; i < salt.length; i++) {
            if (intSalt > 5 * capacity) {
                break;
            }
            intSalt += Math.pow(10, i) * salt[i];
        }
        intSalt %= capacity;
        return intSalt;
    }

    public boolean put(K key, E value) {
        int insertIndex = hash(key);
        if (chains[insertIndex] == null) {
            chains[insertIndex] = new LinkedList<>();
            size++;
        } else {
            for (MapNode<K, E> node : chains[insertIndex]) {
                if (node.key.equals(key)) {
                    return true; // collision
                }
            }
        }
        chains[insertIndex].add(new MapNode<>(key, value));
        return false;
    }

    public E get(K key) {
        int searchedIndex = hash(key);
        if (chains[searchedIndex] == null) {
            return null;
        }
        for (MapNode<K, E> node : chains[searchedIndex]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int deletedIndex = hash(key);
        if (chains[deletedIndex] == null) {
            return;
        }
        Iterator<MapNode<K, E>> iterator = chains[deletedIndex].iterator();
        while (iterator.hasNext()) {
            MapNode<K, E> node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    public boolean contains(K key) {
        int searchedIndex = hash(key);
        if (chains[searchedIndex] == null) {
            return false;
        }
        for (MapNode<K, E> node : chains[searchedIndex]) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (List<MapNode<K, E>> chain : chains) {
            if (chain != null) {
                for (MapNode<K, E> node : chain) {
                    keys.add(node.key);
                }
            }
        }
        return keys;
    }

    public List<E> values() {
        List<E> values = new ArrayList<>();
        for (List<MapNode<K, E>> chain : chains) {
            if (chain != null) {
                for (MapNode<K, E> node : chain) {
                    values.add(node.value);
                }
            }
        }
        return values;
    }

    public void clear() {
        size = 0;
        chains = new List[capacity];
    }

    public int size() {
        return size;
    }
}
