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

    // My bread turned out great!

    /**
     *
     * @param x item to add
     */
    @Override
    // "addFirst and addLast may not use looping or recursion. A single add operation must take "constant time,..."
    public void addFirst(T x) {
        // create a new node that assigns the sentinel as the prev and sentinel.next as the next.
        // Node first = new Node(sentinel, sentinel.next, x);

        // now, one needs to point sentinel.next.prev in the right direction.
        // sentinel.next.prev = first;
        // and sentinel.next in the right direction as well.
        // sentinel.next = first;

        // and that's it?
        // kinda assumed I'd need a pointer (okay, okay, object reference) for this but didn't end up using
        // one... yet. maybe this is a jumbled mess.
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