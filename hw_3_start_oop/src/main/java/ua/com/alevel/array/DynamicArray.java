package ua.com.alevel.array;

public class DynamicArray<T> {

    private final int INITIAL_CAPACITY = 10;
    private final double INCREMENT = 1.5;
    private Object[] elements;
    private int capacity;
    private int size;

    public DynamicArray() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    public void add(Object element) {
        if (size == capacity) increaseArraySize();
        elements[size] = element;
        size++;
    }

    private void increaseArraySize() {
        Object[] tempArray = new Object[(int) (capacity * INCREMENT + 1)];
        System.arraycopy(elements, 0, tempArray, 0, capacity);
        elements = tempArray;
        capacity = capacity * (int) (capacity * INCREMENT + 1);
    }

    public void delete(int element) {
        for (int i = element; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void out() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    public int size() {
        return size;
    }

    public Object getElement(int element) {
        return elements[element];
    }

    /*@SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }


    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }*/
}
