package death;

import java.util.Arrays;
import java.util.Collection;

/**
 * Vector.
 * Vector is dynamic array with type E.
 *
 * @param <E> type of Vector.
 */
public class Vectors<E> {

    private E[] array;
    private int curSize;

    /**
     * DEFAULT_SIZE is just basic start size of Vector if user didn't give start size of Vector.
     */
    public static final int DEFAULT_SIZE = 2;

    /**
     * Init a Vector with startSize size.
     *
     * @param startSize start size of Vector (user can give it).
     */
    @SuppressWarnings({"unchecked"})
    public Vectors(int startSize) {
        if (startSize <= 0) {
            throw new IllegalArgumentException("Size is incorrect");
        }
        curSize = 0;
        array = (E[]) new Object[startSize];

    }

    /**
     * If user ignore startSize, init Vector with DEFAULT_SIZE size.
     */
    public Vectors() {

        this(DEFAULT_SIZE);

    }

    /**
     * Resize of Vector to new size.
     *
     * @param size new size.
     */
    private void resize(int size) {
        array = Arrays.copyOf(array, size);
    }

    /**
     * Resize to increased into 2 times of currentSize size.
     */
    private void grow() {
        resize(array.length * 2);
    }

    /**
     * Adds an elem to Vector.
     *
     * @param elem element which will be added.
     */
    public void add(E elem) {
        if (curSize == array.length) {
            grow();
        }
        array[curSize++] = elem;
    }

    /**
     * Pops last element in Vector.
     *
     * @return popped element.
     */
    public E popLast() {
        if (curSize == 0) {
            throw new IllegalArgumentException("Array is empty, there is nothing to remove");

        }
        return array[--curSize];
    }

    /**
     * Gets an element on index place.
     *
     * @param index place in Vector.
     * @return element on index place.
     */
    public E get(int index) {
        if (index < 0 || index >= curSize) {
            throw new IllegalArgumentException("Incorrect index");
        }
        return array[index];
    }

    /**
     * Sets an element to index place.
     *
     * @param value element to set.
     * @param index place to set.
     */
    public void set(E value, int index) {
        if (index < 0 || index >= curSize) {
            throw new IllegalArgumentException("Incorrect index");
        }
        array[index] = value;
    }

    /**
     * Gets current size of Vector.
     *
     * @return current size of Vector.
     */
    public int getCurSize() {
        return curSize;
    }

    /**
     * Adds all elements from Collection to Vector.
     *
     * @param elements elements of Collection.
     */
    public void addAll(Collection<? extends E> elements) {

        if (elements == null) {
            throw new IllegalArgumentException("No collection");
        }

        for (E element : elements) {
            add(element);
        }

        //elements.stream().peek(this::add);

    }

    /**
     * Puts all elements from stack to collection.
     *
     * @param collection place, where you want to place elements.
     */
    public void popAll(Collection<E> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("No collection");
        }
        collection.addAll(Arrays.asList(array));
        curSize = 0;
    }

    /**
     * Clears Vector.
     */
    public void clear() {
        curSize = 0;
    }

    @Override
    public String toString() {
        return "Vectors{" +
                "array=" + Arrays.toString(array) +
                ", curSize=" + curSize +
                '}';
    }
}