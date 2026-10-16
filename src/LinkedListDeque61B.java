import java.util.List;
import java.util.ArrayList;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node sentinel;

    public static class Node {
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

        // sentinel.next = first;
        // sentinel.next.prev = first;
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
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
        List<T> returnList = new ArrayList<>;

        // Node node = sentinel.next;

        // iterate over the nodes and add them to returnList during each iteration.
        // while(node.next != sentinel) {
            // append to returnList.
            // returnList.add(node.data);

            // update node.
            // node = node.next;
        // }

        // return List.of();
        // https://www.youtube.com/watch?v=02483qMtL4s
        return returnList;
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