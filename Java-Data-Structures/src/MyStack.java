import java.util.Comparator;

public class MyStack<T> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T element) throws Exception {
        list.add(element, list.size());
    }

    public T pop() throws Exception {
        return list.remove(list.size() - 1);
    }

    public T peek() throws Exception {
        return list.get(list.size() - 1);
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
