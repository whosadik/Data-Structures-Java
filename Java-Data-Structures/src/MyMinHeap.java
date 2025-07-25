import java.util.Comparator;

public class MyMinHeap<T> {
    private MyLinkedList<T> list;
    private Comparator<T> comparator;

    public MyMinHeap() {
        list = new MyLinkedList<>();
    }

    public MyMinHeap(Comparator<T> comparator) {
        list = new MyLinkedList<>();
        this.comparator = comparator;
    }

    public void add(T element) throws Exception {
        list.add(element, list.size());
        siftUp(list.size() - 1);
    }

    public T poll() throws Exception {
        if (list.size() == 0) {
            throw new Exception("Heap is empty");
        }

        T min = list.get(0);
        T lastElement = list.remove(0);

        if (list.size() > 0) {
            list.set(list.get(list.size() - 1), 0);
            siftDown(0);
        }
        return min;
    }

    public T peek() throws Exception {
        if (list.size() == 0) {
            throw new Exception("Heap is empty");
        }
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public void sort() throws Exception {
        MyMinHeap<T> tempHeap = new MyMinHeap<>(comparator);
        while (list.size() > 0) {
            tempHeap.add(poll());
        }

        while (tempHeap.size() > 0) {
            list.add(tempHeap.poll(), list.size());
        }
    }

    private void siftUp(int index) throws Exception {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(list.get(index), list.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) throws Exception {
        int leftChildIndex;
        int rightChildIndex;
        int minIndex;

        while (index < size() / 2) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;

            if (rightChildIndex < size() && compare(list.get(rightChildIndex), list.get(leftChildIndex)) < 0) {
                minIndex = rightChildIndex;
            } else {
                minIndex = leftChildIndex;
            }

            if (compare(list.get(index), list.get(minIndex)) <= 0) {
                break;
            }

            swap(index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int i, int j) throws Exception {
        T temp = list.get(i);
        list.set(list.get(j), i);
        list.set(temp, j);
    }

    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            Comparable<? super T> comparableA = (Comparable<? super T>) a;
            return comparableA.compareTo(b);
        }
    }
}
