import java.util.List;
import java.util.ArrayList;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node sentinel;
     // Include cached size? Not required for assignment, as far as I know.

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
        Node first = new Node(null, null, x);
        first.prev = sentinel;
        first.next = sentinel.next;

        sentinel.next.prev = first;
        sentinel.next = first;
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        Node last = new Node(null, null, x);
        last.next = sentinel;
        last.prev = sentinel.prev;

        sentinel.prev.next = last;
        sentinel.prev = last;
    }

    /**
     *
     * @return
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node node = sentinel.next;

        while(node != sentinel) {
            returnList.add(node.data);

            node = node.next;
        }

        return returnList;
    }

    /**
     *
     * @return
     */
    @Override
    // Must take constant time.
    public boolean isEmpty() {
        if(sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    // Must take constant time.
    // ?Can one write a helper that reduces the code in both toList() and size()?
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