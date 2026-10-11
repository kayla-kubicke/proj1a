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
        this.sentinel = new Node(sentinel, sentinel, null);
        // This intuitively seems more circular. Both previous and next point back to
        // the sentinel object...
        // But the diagram implies the next node points to the previous.
        // Clearly, I am not sure. What I am sure of is that is configuration does not
        // cause a NullPointerException.
        // Just going to have to try it, possibly f it up, accept it's wrong, and start again.
    }

    // Thankfully found a new piercing parlor super close to my home that can accommodate me.
    // https://www.youtube.com/watch?v=iWz9H3MPgqI
    // And my poolish looks very happy.

    /**
     *
     * @param x item to add
     */
    @Override
    // "addFirst and addLast may not use looping or recursion. A single add operation must take "constant time,..."
    public void addFirst(T x) {
        // Insert after the sentinel:
            // make new node
            // assign new node's next to the current first
            // assign current first's prev to new node
            // assign new node's previous to sentinel
            // assign sentinel next to new node

        // but what about updating the sentinel's prev?
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