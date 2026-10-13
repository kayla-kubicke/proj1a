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
        // Assuming this is the way to go...
        this.sentinel = new Node(sentinel, sentinel, null);
    }

    /**
     *
     * @param x item to add
     */
    @Override
    // "addFirst and addLast may not use looping or recursion. A single add operation must take "constant time,..."
    public void addFirst(T x) {
        // create a new node that assigns the sentinel as the prev and sentinel.next as the next.
         Node first = new Node(sentinel, sentinel.next, x);

        // nope.
        // java.lang.NullPointerException: Cannot assign field "prev" because "this.sentinel.next" is null
         sentinel.next.prev = first;
         sentinel.next = first;
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