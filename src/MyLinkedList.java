import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Class<?> listType;
    private int size;

    private static class Node<T> {
        private T val;
        private Node<T> next;
        private Node<T> prev;

        public Node(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private final static Object incorrectIndexErr = new Exception("incorrect index");
    private final static Object incorrectElementType = new Exception("incorrect added element type");
    private final static Object dataIsEmptyErr = new Exception("data is empty, cannot pick/delete any element");
    private final static Object incorrectLessFunction = new Exception("incorrect less function");

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.listType = null;
        this.size = 0;
    }

    private boolean validateType(T el) {
        if (listType == null) {
            return true;
        }
        return el.getClass() == listType;
    }

    private void standListType(T refEl) {
        listType = refEl.getClass();
    }

    private boolean needStandListType() {
        return size == 0 && listType == null;
    }

    private void initNewLinkedListWithOneNode(T newEl) throws Exception {
        if (!validateType(newEl)) {
            throw (Exception) incorrectElementType;
        }
        if (needStandListType()) {
            standListType(newEl);
        }

        Node<T> newNode = new Node<>(newEl);
        head = newNode;
        tail = newNode;
        size = 1;
    }
    public void add(T newEl, int index) throws Exception {
        if (index > size || index < 0) {
            throw (Exception) incorrectIndexErr;
        }
        if (!validateType(newEl)) {
            throw (Exception) incorrectElementType;
        }
        if (needStandListType()) {
            standListType(newEl);
        }

        if (size == 0) {
            initNewLinkedListWithOneNode(newEl);
            return;
        }
        int currDataLen = size;
        if (index == currDataLen) {
            addLast(newEl);
            return;
        }
        if (index == 0) {
            addFirst(newEl);
            return;
        }

        Node<T> copyHead = head;
        for (int i = 0; i <= index - 1; i++) {
            copyHead = copyHead.next;
        }

        Node<T> newNode = new Node<>(newEl);
        newNode.next = copyHead.next;
        newNode.prev = copyHead;
        copyHead.next.prev = newNode;
        copyHead.next = newNode;
        size++;
    }

    public T get(int index) throws Exception {
        if (size == 0) {
            throw (Exception) dataIsEmptyErr;
        }
        if (index < 0 || index >= size) {
            throw (Exception) incorrectIndexErr;
        }

        Node<T> copyHead = head;
        for (int i = 0; i <= index - 1; i++) {
            copyHead = copyHead.next;
        }
        return copyHead.val;
    }

    public T remove(int index) throws Exception {
        if (size == 0) {
            throw (Exception) dataIsEmptyErr;
        }
        if (index < 0 || index >= size) {
            throw (Exception) incorrectIndexErr;
        }
        if (index == 0) {
            return removeFirst();
        } else if (size - 1 == index) {
            return removeLast();
        }

        Node<T> currNode = head;
        for (int i = 0; i <= index - 2; i++) {
            currNode = currNode.next;
        }
        Node<T> nextCurrNodeNextNode = currNode.next.next;
        nextCurrNodeNextNode.prev = currNode;
        currNode.next = nextCurrNodeNextNode;
        size--;

        return currNode.val;
    }

    public void sort(Comparator<T> cmp) throws Exception {
        List<T> elsMsv = toArray();
        if (elsMsv.size() == 0) {
            return;
        }
        if (!isCorrectLessFunction(elsMsv.get(0), cmp)) {
            throw (Exception) incorrectLessFunction;
        }

        elsMsv.sort(cmp);
        clear();
        for (T el : elsMsv) {
            addLast(el);
        }
    }

    public int indexOf(Object searchedEl) throws Exception {
        if (size == 0) {
            return -1;
        }
        if (!validateType((T) searchedEl)) {
            throw (Exception) incorrectElementType;
        }

        Node<T> copyHead = head;
        int counter = 0;
        while (copyHead != null) {
            if (copyHead.val.equals(searchedEl)) {
                return counter;
            }
            copyHead = copyHead.next;
            counter++;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    private boolean isCorrectLessFunction(T x, Comparator<T> cmp) {
        try {
            cmp.compare(x, x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void set(T element, int index) throws Exception {
        if (size == 0) {
            throw (Exception) dataIsEmptyErr;
        }
        if (index < 0 || index >= size) {
            throw (Exception) incorrectIndexErr;
        }
        if (!validateType(element)) {
            throw (Exception) incorrectElementType;
        }

        Node<T> copyHead = head;
        for (int i = 0; i <= index - 1; i++) {
            copyHead = copyHead.next;
        }
        copyHead.val = element;
    }


    public List<T> toArray() {
        if (size == 0) {
            return new ArrayList<>();
        }
        List<T> msv = new ArrayList<>();
        Node<T> copyHead = head;
        while (copyHead != null) {
            msv.add(copyHead.val);
            copyHead = copyHead.next;
        }
        return msv;
    }

    private void addLast(T newEl) throws Exception {
        if (!validateType(newEl)) {
            throw new Exception("Incorrect added element type");
        }
        if (needStandListType()) {
            standListType(newEl);
        }

        if (size == 0) {
            try {
                initNewLinkedListWithOneNode(newEl);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        Node<T> newNode = new Node<>(newEl);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    private void addFirst(T newEl) throws Exception {
        if (!validateType(newEl)) {
            throw (Exception) incorrectElementType;
        }
        if (needStandListType()) {
            standListType(newEl);
        }

        if (size == 0) {
            initNewLinkedListWithOneNode(newEl);
            return;
        }

        Node<T> newNode = new Node<>(newEl);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    private T removeFirst() throws Exception {
        if (size == 0) {
            throw (Exception) dataIsEmptyErr;
        }
        if (size == 1) {
            clear();
            return null;
        }

        Node<T> newHead = head.next;
        newHead.prev = null;
        head = newHead;
        size--;
        return head.val;
    }

    private T removeLast() throws Exception {
        if (size == 0) {
            throw (Exception) dataIsEmptyErr;
        }
        if (size == 1) {
            clear();
            return null;
        }

        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return tail.val;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
