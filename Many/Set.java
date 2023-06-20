import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList implements Iterable<Integer> {
    private static final int DEFAULT_SIZE = 10;
    private int userLength = -1;
    private int[] value;
    private int countElements;

    public MyArrayList() {
        this.value = new int[DEFAULT_SIZE];
    }

    public MyArrayList(int... values) {
        this();
        addAll(values);
    }

    public int size() {
        return this.countElements;
    }

    public boolean isEmpty() {
        return countElements == 0;
    }

    public void clear() {
        this.value = new int[userLength >= 0 ? userLength : DEFAULT_SIZE];
        countElements = 0;
    }

    public int[] toArray() {
        return Arrays.copyOf(this.value, countElements);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private void getDynamicExpansion() {
        if (countElements == this.value.length) {
            this.value = Arrays.copyOf(this.value, this.value.length < DEFAULT_SIZE ? DEFAULT_SIZE : this.value.length * 3 >> 1);
        }
    }

    private boolean checkRangeArray(int index) {
        return index >= 0 && index < countElements;
    }

    public void add(int value) {
        getDynamicExpansion();
        this.value[countElements++] = value;
    }

    public boolean add(int index, int value) {
        boolean result = false;
        if (checkRangeArray(index) || countElements == index) {
            getDynamicExpansion();
            System.arraycopy(this.value, index, this.value, index + 1, countElements - index);
            this.value[index] = value;
            countElements++;
            result = true;
        }
        return result;
    }

    public boolean addAll(int... values) {
        boolean result = values != null && values.length != 0;
        if (result) {
            for (int value : values) {
                add(value);
            }
        }
        return result;
    }

    public int get(int index) {
        int result;
        if (checkRangeArray(index)) {
            result = this.value[index];
        } else {
            throw new IndexOutOfBoundsException(String.format("Index %s is not found...", index));
        }
        return result;
    }

    public boolean delete(int index) {
        boolean result = false;
        if (checkRangeArray(index)) {
            System.arraycopy(this.value, index + 1, this.value, index, countElements - index - 1);
            this.value[--countElements] = 0;
            result = true;
        }
        return result;
    }

    public int update(int index, int value) {
        int oldValue;
        if (checkRangeArray(index)) {
            oldValue = this.value[index];
            this.value[index] = value;
        } else {
            throw new IndexOutOfBoundsException(String.format("Index %s is not found...", index));
        }
        return oldValue;
    }

    public void makePareNumberSum() {
        int[] result = this.countElements % 2 == 0 ? new int[this.countElements / 2] : new int[(this.countElements + 1) / 2];
        int count = 0;
        for (int index = 1; index < this.size(); index += 2) {
            result[count++] = get(index - 1) + get(index);
        }
        if (this.size() % 2 != 0) {
            result[count] = get(size() - 1);
        }
        clear();
        addAll(result);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorArray();
    }

    private class IteratorArray implements Iterator<Integer> {
        private int cursorIterator;

        @Override
        public boolean hasNext() {
            return cursorIterator < countElements;
        }

        @Override
        public Integer next() {
            if (cursorIterator == countElements) {
                throw new NoSuchElementException("The element is not found...");
            }
            return value[cursorIterator++];
        }
    }
}

class Main{
    public static void main(String[] args) {
        MyArrayList ints = new MyArrayList(1, 2, 3, 4, 5);
        System.out.println(ints);
        ints.delete(0);
        System.out.println(ints);
        ints.add(6);
        ints.addAll(1, 2, 3, 4);
        System.out.println(ints);
        ints.makePareNumberSum();
        System.out.println(ints);
        ints.delete(ints.size() - 1);
        ints.makePareNumberSum();
        System.out.println(ints);

    }
}
