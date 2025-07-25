import java.util.Comparator;
import java.util.Iterator;

public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T element) throws Exception {
        list.add(element, list.size());
    }

    public T dequeue() throws Exception {
        return list.remove(0);
    }

    public T peek() throws Exception {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public void sort(Comparator<T> cmp) throws Exception {
        list.sort(cmp);
    }

    public int indexOf(Object searchedEl) throws Exception {
        return list.indexOf(searchedEl);
    }

    public T toArray() {
        return (T) list.toArray();
    }
}
