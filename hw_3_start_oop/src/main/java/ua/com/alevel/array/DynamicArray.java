package ua.com.alevel.array;

import java.util.Objects;

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;

    public DynamicArray(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        resizeArray();
        elements[size] = element;
        size++;
    }

    public void resizeArray() {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public void out() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    @SuppressWarnings("unchecked")
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
    }
}
