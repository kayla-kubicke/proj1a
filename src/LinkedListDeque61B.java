import java.util.List;
import java.util.ArrayList;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node sentinel;

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
        // The number of mistakes I've made on this project is making me gloomy...
        // https://www.youtube.com/watch?v=GNWw2NFo_ec
        // https://www.youtube.com/watch?v=qkNa5xzOe5U
        // https://www.youtube.com/watch?v=Ty-bLdf8Bsw
        // https://www.youtube.com/watch?v=52ZdwZ7Ig-8

        // Ugh... okay, that's enough wallowing. Time to try again.
        // Sidenote: These Days is the perfect sad song. The lyrics are perfectly miserable.


        // Pretty sure the constructor is fine. The sentinel node of a circular doubly linked
        // list should just point at itself, prev and next are pointing back at the sentinel. Fine.
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // Now, let's start here.
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