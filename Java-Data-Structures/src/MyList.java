import java.util.Comparator;
import java.util.Iterator;
public interface MyList<T> extends Iterable<T>{
    void add(T element, int index);
    void set(T element, int index);
    void addFirst(T element);
    void addLast(T element);
    T get(int index);
    T getFirst();
    T getLast();
    T remove(int index);
    T removeFirst();
    T removeLast();
    void sort(Comparator<T> cmp);
    int indexOf(Object o);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();

}
