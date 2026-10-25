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
        // // First attempt notes.
        // Node removalNode = sentinel.next;

        // sentinel.next = removalNode.next;
        // removealNode.next.prev = sentinel;

        // // Grab the data to return?
        // T returnData = removalNode.data;

        // removalNode.next = null;
        // removalNode.prev = null;
        // // The garbage collector will do the rest.

        // size--;
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public T removeLast() {
        // // First attempt notes.
        // Node removalNode = sentinel.prev;

        // sentinel.prev = removalNode.prev;
        // removalNode.prev.next = sentinel;

        // T returnData = removalNode.data;

        // removalNode.next = null;
        // removalNode.prev = null;

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
        // Account for the null base cases here before hitting the recursive helper method:
         if(index > size || index < 0) {
             return null;
         }

         int currentIndex = 0;

         return getRecursiveHelper(sentinel.next, currentIndex, index);
    }

    public T getRecursiveHelper(Node node, int currentIndex, int index) {
        // Nonnull base case:
         if(currentIndex == index) {
             return node.data;
         }

         return getRecursiveHelper(node.next, currentIndex + 1, index);
    }
}