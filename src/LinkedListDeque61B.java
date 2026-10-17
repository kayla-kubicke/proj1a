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
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node first = new Node(null, null, x);
        // I know I could do this all in one line, but I'll keep this for now.
        first.prev = sentinel;
        first.next = sentinel.next;

        // Repoint the current first's prev node before one does anything else.
        sentinel.next.prev = first;
        // Now, one can repoint sentinel's next.
        sentinel.next = first;

        // No, don't do this.
            // !!!Four pointers need to always be repointed!!!
            // Line 42 always correctly repoints "this" pointer and doesn't drop any conditions.
        // if(sentinel.prev == sentinel) {
            // sentinel.prev = first;
        // }
        // Fk, I finally got it all by myself. So easy once you know it... like all things in life.
        // I'm just going to play DOOM for the rest of the day.
        // (Yes, I still play 2016 DOOM; it's just so relaxing.)
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // I'll do the same here; I'll just simply create the new node.
        Node last = new Node(null, null, x);

        // Deal with last's prev and next.
        last.next = sentinel;
        last.prev = sentinel.prev;

        // Now, deal with the current last's next and sentinel's prev.
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