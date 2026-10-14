import java.util.List;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node sentinel;

    // static too?
        // Nested classes declared static can not access methods owned by outer class.
    public class Node {
         public Node prev;
         public Node next;
         public T data;

        public Node(Node prev, Node next, T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    /**
     *
     */
    public LinkedListDeque61B() {
        // This is wrong, for several reasons.
        // While this does not throw an error, the complier can't find the complete sentinel object
        // while creating sentinel, thus causing the NullPointerException I ran into yesterday in
        // addFirst(...). I guess the compiler sees the argument, can't quite find the object requested
        // but knows about 'this.sentinel' so it doesn't throw, but becomes visible later.
        // this.sentinel = new Node(sentinel, sentinel, null);

        this.sentinel = new Node(null, null, null);
        // So, prev and next need to be assigned after the sentinel object is created.
        // Now, are they assigned to the sentinel node?
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        // Or to each other? No, right?
        // sentinel.prev = sentinel.next;
    }

    /**
     *
     * @param x item to add
     */
    @Override
    // "addFirst and addLast may not use looping or recursion. A single add operation must take "constant time,..."
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