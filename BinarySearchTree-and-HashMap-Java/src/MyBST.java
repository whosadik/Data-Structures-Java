import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyBST<K extends Comparable<? super K>, V> {
    private Node<K, V> root;
    private int size;

    static class Node<K, V> {
        K key;
        V val;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    MyBST() {
        this.root = null;
        this.size = 0;
    }

    boolean existKey(K key) {
        return get(key) != null;
    }

    void put(K key, V value) {
        if (existKey(key)) {
            throw new IllegalArgumentException("Key " + key + " is already exist!");
        }
        if (size == 0) {
            root = new Node<>(key, value);
            size++;
            return;
        }
        appendNode(root, key, value);
        size++;
    }

    private void appendNode(Node<K, V> node, K key, V value) {
        K nodeKey = node.key;
        if (key.compareTo(nodeKey) < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, value);
                return;
            }
            appendNode(node.left, key, value);
            return;
        }
        if (node.right == null) {
            node.right = new Node<>(key, value);
            return;
        }
        appendNode(node.right, key, value);
    }

    V get(K searchedKey) {
        return get(root, searchedKey);
    }

    private V get(Node<K, V> node, K searchedKey) {
        if (node == null) {
            throw new IllegalArgumentException("Key " + searchedKey + " not exist");
        }
        K nodeKey = node.key;
        if (Objects.equals(nodeKey, searchedKey)) {
            return node.val;
        }
        if (searchedKey.compareTo(nodeKey) < 0) {
            return get(node.left, searchedKey);
        }
        return get(node.right, searchedKey);
    }

    void delete(K key) {
        if (!existKey(key)) {
            return;
        }
        size--;
        root = deleteNode(root, key);
    }

    private Node<K, V> deleteNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node<K, V> temp = node;
                node = minNode(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
        }
        return node;
    }

    private Node<K, V> minNode(Node<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return minNode(node.left);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    List<TraversalNode<K, V>> inOrderTraversal() {
        List<TraversalNode<K, V>> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node<K, V> node, List<TraversalNode<K, V>> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(new TraversalNode<>(node.key, node.val));
            inOrderTraversal(node.right, result);
        }
    }

    static class TraversalNode<K, V> {
        K key;
        V value;

        TraversalNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
