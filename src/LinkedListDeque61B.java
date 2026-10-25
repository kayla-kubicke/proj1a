import java.util.List;
import java.util.ArrayList;

/**
 * @param <T>
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
     private Node sentinel;
     private int size;

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
        size = 0;
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

        size++;
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

        size++;
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
        // Added the extra check in case the sentinel
        // is malformed, but at that point... eh, that might be unnecessary.
        if(sentinel.next == sentinel && sentinel.prev == sentinel) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
         return size;
    }

    /**
     *
     * @return
     */
    @Override
    public T removeFirst() {
        // size--;
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public T removeLast() {
        // size--;
        return null;
    }

    /**
     * Returns data at specified index.
     * @param index index to get
     * @return
     */
    @Override
    public T get(int index) {
         if(index > size || index < 0) {
             return null;
         }

        // Make dummy tracker node.
         Node node = sentinel.next;
         int currentIndex = 0;

         while(index != currentIndex) {
             currentIndex++;
             node = node.next;
         }

         return node.data;
    }

    /**
     *
     * @param index index to get
     * @return
     */
    @Override
    public T getRecursive(int index) {
        // Account for the null base cases here.
        // if(index > size || index < 0) {
            // return null;
        // }

        // int currentIndex = 0;

        // return getRecursiveHelper(sentinel.next, currentIndex, index);
        return null;
    }

    public T getRecursiveHelper(Node node, int currentIndex, int index) {
        // Nonnull base case:
        // if(currentIndex == index) {
            // return node.data;
        // }

        // return getRecursiveHelper(node.next, currentIndex + 1, index);

        return node.data;
    }
    // https://www.youtube.com/watch?v=5b5v3--3zTA
    // You know what really scared me as a 90's kid?
    // F'ing Beyond Belief, those first two seasons messed me up.

    // Also, not a horror thing, but pbs thirteen aired* a (very) adult
    // Barbie documentary, Barbie Nation, when I was a child and I found
    // it... unsettling. Maybe I realized something about humanity I did
    // not quite understand until that moment?
    // Maybe we are always quite playful once the chores are done, even as adults?
    // And we all just want to feel safe?
    // https://www.youtube.com/watch?v=dFCC3a3gX1I
    // I have not rewatched it as an adult... yet.
    // *To be clear, it was aired late at night.
}