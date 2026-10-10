import java.util.List;

// The deque needs to be:
    // circular
    // doubly-linked
    // with sentinel

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node frontSentinel;
     private Node backSentinel;

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
        this.frontSentinel = new Node(null, backSentinel, null); // Is null fine???
        this.backSentinel = new Node(frontSentinel, null, null);
    }

    // Do I need this? I don't think so.
    // public LinkedListDeque61B(T data) {
        // Make a default one and "add" to it?
    // }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // insert after firstSentinel.
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        //insert right before backSentinel.
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