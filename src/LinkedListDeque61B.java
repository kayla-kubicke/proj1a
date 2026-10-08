import java.util.List;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node first; // ?? Just a dummy for now.
    // private Node last; // ??

    // Oops, an oversight, needs to be public so outer class can access it...
    // static too?
        // Nested classes declared static can not access methods owned by outer class.
    public class Node {
        //
    }

    /**
     *
     */
    public LinkedListDeque61B() {
        // Constructor...
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {

    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {

    }

    /**
     *
     * @return
     */
    @Override
    public List<T> toList() {
        return List.of();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     *
     * @param index index to get
     * @return
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     *
     * @param index index to get
     * @return
     */
    @Override
    public T getRecursive(int index) {
        return null;
    }
}