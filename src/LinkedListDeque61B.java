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
        this.sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // Node first = new Node(this.sentinel, this.sentinel.next, x);

        // Now, one needs to deal with sentinel's prev and next.
        // sentinel.next = first;

        // NO.
        // sentinel.prev only needs to be updated if it's the only node, right?
        // if(sentinel.prev == sentinel) {
            // sentinel.prev = first;
        // }
        // NO, NO, NO.

        // I think this is right...
        // sentinel.next.prev = first;
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // And I think this is also...
        // Node last = new Node(sentinel.prev, sentinel, x);

        // sentinel.prev = last;
        // sentinel.prev.next = last;
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