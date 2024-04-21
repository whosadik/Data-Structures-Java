import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private Class<?> listType;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.listType = null;
    }

    private void increaseCapacity() {
        int newCapacity = size * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(elements, 0, newData, 0, size);
        elements = newData;
    }


    private boolean validateType(Object element) {
        if (listType == null) {
            return true;
        }
        return element.getClass().equals(listType);
        }

    private void standListType(Object refEl) {
        listType = refEl.getClass();
    }

    private boolean needStandListType() {
        return size == 0 && listType == null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }


    @Override
    public void add(T element, int index) throws IllegalAccessError {
        if(index > size || index < 0){
            throw new IllegalAccessError("Error index");
        }
        if(!validateType(element)){
            throw new IllegalAccessError("Error element type");

        }
        if (needStandListType()) {
            standListType(element);
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public void set(T element, int index){
        elements[index] = element;
    }

    public void addLast(T element){
        add(element, size);
    }

    public void addFirst(T element){
        add(element, 0);
    }


    @Override
    public T get(int index) throws IllegalAccessError{
        if(size == 0){
            throw new IllegalAccessError("List is empty");
        }
        if(index >= size || index < 0){
            throw new IllegalAccessError("Error index");
        }
        return (T) elements[index];
    }
    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size-1);
    }

    @Override
    public T remove(int index) throws IllegalAccessError{
        if(size == 0){
            throw new IllegalAccessError("List is empty");
        }
        if(index >= size || index < 0){
            throw new IllegalAccessError("Error index");
        }
        T removedelement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index -1);
        elements[size - 1] = null;
        size--;
        return removedelement;
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    private boolean isCorrectLessFunction(T x, Comparator<? super T> cmp){
        boolean ok = true;
        try {
            cmp.compare(x, x);
        } catch (Exception t) {
            ok = false;
        }
        return ok;
    }

    @Override
    public void sort(Comparator<T> cmp) {
        if(!isCorrectLessFunction((T) elements[0], cmp)){
            throw new IllegalAccessError("Incorrect less function");
        }
        Arrays.sort((T[]) elements, 0, size, cmp);
    }
    public int indexOf(Object o){
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elements[i] == null){
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if(o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    public int lastIndexOf(Object o){
        if(o == null){
            for (int i = size - 1; i >= 0; i--) {
                if(elements[i] == null){
                    return i;
                }
            }
        }else{
            for (int i = size - 1; i >= 0; i--) {
                if(o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean exists(Object o){
        if(size == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            if(Objects.equals(elements[i], o)){
                return true;
            }
        }
        return false;
    }

    public Object[] toArray(){
        if(size == 0){
            return (T[]) new Object[0];
        }
        T[] arr = (T[]) new Object[size];
        System.arraycopy(elements, 0, arr, 0, size);
        return arr;
    }

    public void clear(){
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}