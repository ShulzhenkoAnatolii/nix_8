package ua.com.alevel.mathsetnumber;

public class MathSet<T extends Number & Comparable<T>> {

    private final int INITIAL_CAPACITY = 10;
    private final double INCREMENT = 1.5;
    private int size = 0;
    private Number[] elements;

    public MathSet() {
        this.elements = new Number[INITIAL_CAPACITY];
    }

    public MathSet(int capacity) {
        this.elements = new Number[capacity];
    }

    public MathSet(T[] numbers) {
        elements = new Number[INITIAL_CAPACITY];
        addArrayToMathSet(numbers);
    }

    public MathSet(T[]... numbers) {
        elements = new Number[INITIAL_CAPACITY];
        for (int i = 0; i < numbers.length; i++) {
            addArrayToMathSet(numbers[i]);
        }
    }

    public MathSet(MathSet<T> numbers) {
        elements = numbers.toArray();
        size = numbers.size;
    }

    public void add(T n) {
        if (doesNotContain(n)) {
            if (elements.length == size) {
                increaseSize();
            }
            elements[size] = n;
            size++;
        }
    }

    public void add(T... n) {
        addArrayToMathSet(n);
    }

    public void join(MathSet<T> ms) {
        Number[] array = ms.toArray();
        for (int i = 0; i < ms.size; i++) {
            if (doesNotContain(array[i])) {
                if (elements.length == size) {
                    increaseSize();
                }
                elements[size] = array[i];
                size++;
            }
        }
    }

    public void join(MathSet<T>... ms) {
        for (int i = 0; i < ms.length; i++) {
            join(ms[i]);
        }
    }

    public void intersection(MathSet<T> ms) {
        Number[] inputArray = new Number[INITIAL_CAPACITY];
        int inputArraySize = 0;
        Number[] msArray = ms.toArray();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < msArray.length; j++) {
                if (elements[i].equals(msArray[j])) {
                    if (inputArray.length == inputArraySize) {
                        increaseSize();
                    }
                    inputArray[inputArraySize] = elements[i];
                    inputArraySize++;
                    break;
                }
            }
        }
        elements = inputArray.clone();
        size = inputArraySize;
    }

    public void intersection(MathSet<T>... ms) {
        for (int i = 0; i < ms.length; i++) {
            intersection(ms);
        }
    }

    public void sortDesc() {
        quickSort(0, size - 1, true);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        quickSort(firstIndex, lastIndex, true);
    }

    public void sortDesc(Number value) {
        if (getIndexByValue(value) != -1) {
            quickSort(getIndexByValue(value), size - 1, true);
        } else System.out.println("Element not found");
    }

    public void sortAsc() {
        quickSort(0, size - 1, false);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        quickSort(firstIndex, lastIndex, false);
    }

    public void sortAsc(Number value) {
        if (getIndexByValue(value) != -1) {
            quickSort(getIndexByValue(value), size - 1, false);
        } else System.out.println("Element not found");
    }

    private void increaseSize() {
        Number[] numbers = new Number[(int) (size * INCREMENT) + 1];
        System.arraycopy(elements, 0, numbers, 0, size);
        elements = numbers.clone();
    }

    private boolean doesNotContain(Number number) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(number)) {
                return false;
            }
        }
        return true;
    }

    private void addArrayToMathSet(T[] n) {
        for (int i = 0; i < n.length; i++) {
            add(n[i]);
        }
    }

    public T[] toArray() {
        Number[] array = new Number[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return (T[]) array;
    }

    public T[] toArray(int firstIndex, int lastIndex) {
        Number[] array = new Number[lastIndex - firstIndex + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = elements[i + firstIndex];
        }
        return (T[]) array;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Number getMax() {
        if (size > 0) {
            T max = get(0);
            for (int i = 0; i < size; i++) {
                if (get(i).compareTo(max) > 0) {
                    max = get(i);
                }
            }
            return max;
        } else throw new IndexOutOfBoundsException();
    }

    public Number getMin() {
        if (size > 0) {
            T min = get(0);
            for (int i = 0; i < size; i++) {
                if (get(i).compareTo(min) < 0) {
                    min = get(i);
                }
            }
            return min;
        } else throw new IndexOutOfBoundsException();
    }

    public Number getAverage() {
        if (size > 0) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += get(i).doubleValue();
            }
            return sum / size;
        } else throw new IndexOutOfBoundsException();
    }

    public Number getMedian() {
        if (size > 0) {
            sortAsc();
            if (size % 2 != 0) {
                return get((size) / 2).doubleValue();
            } else return (get(size / 2).doubleValue() + get(size / 2 - 1).doubleValue()) / 2;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public MathSet<T> cut(int firstIndex, int lastIndex) {
        int sizeNew = lastIndex - firstIndex + 1;
        MathSet<T> cutElements = new MathSet<>(sizeNew);
        for (int i = 0; i < firstIndex; i++) {
            cutElements.add((T) elements[i]);
        }
        for (int i = lastIndex + 1; i < size; i++) {
            cutElements.add((T) elements[i]);
        }
        return cutElements;
    }

    public void out() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public void clear() {
        elements = new Number[INITIAL_CAPACITY];
        size = 0;
    }

    public void clear(Number[] numbers) {
        Number[] array = new Number[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < numbers.length; j++) {
                if (elements[i].equals(numbers[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                array[count] = elements[i];
                count++;
            }
        }
        elements = array.clone();
        size = count;
    }

    public int size() {
        return size;
    }

    private int getIndexByValue(Number value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void quickSort(int firstIndex, int lastIndex, boolean reverse) {

        T[] inputArray = (T[]) elements;

        if (inputArray.length == 0) return;
        if (firstIndex >= lastIndex) return;

        int middle = (lastIndex + firstIndex) / 2;
        int i = firstIndex;
        int j = lastIndex;
        T base = inputArray[middle];

        while (i <= j) {
            if (reverse == true) {
                while (inputArray[i].compareTo(base) > 0) {
                    i++;
                }
                while (inputArray[j].compareTo(base) < 0) {
                    j--;
                }
            } else {
                while (inputArray[i].compareTo(base) < 0) {
                    i++;
                }
                while (inputArray[j].compareTo(base) > 0) {
                    j--;
                }
            }
            if (i <= j) {
                T temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
                i++;
                j--;
            }
        }
        if (firstIndex < j)
            quickSort(firstIndex, j, reverse);
        if (lastIndex > i)
            quickSort(i, lastIndex, reverse);
    }
}
