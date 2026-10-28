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
     * Constructor
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
     * @return ArrayList containing the data of each node in order
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
     * @return boolean answering 'is the list empty?'
     * empty deque returns true, nonempty deque returns false
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
     * @return int describing the size of the deque
     */
    @Override
    public int size() {
         return size;
    }

    /**
     *
     * @return null if deque is empty, otherwise
     * returns the data, type T, of the removed node
     */
    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }

        Node removalNode = sentinel.next;

        sentinel.next = removalNode.next;
        removalNode.next.prev = sentinel;

        T returnData = removalNode.data;

        removalNode.next = null;
        removalNode.prev = null;
        // The garbage collector will do the rest.

        size--;

        return returnData;
    }

    /**
     *
     * @return null if empty, otherwise
     * returns the data, type T, of the removed node
     */
    @Override
    public T removeLast() {
         if(isEmpty()) {
             return null;
         }

         Node removalNode = sentinel.prev;

         sentinel.prev = removalNode.prev;
         removalNode.prev.next = sentinel;

         T returnData = removalNode.data;

         removalNode.next = null;
         removalNode.prev = null;

         size--;
         return returnData;
    }

    /**
     * @param index index to get
     * @return data, type T, at specified index
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
     * @return null if the index is invalid, otherwise
     * returns the data, type T, of the removed node via helper method
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

    /**
     *
     * @param node the current node, used to keep track of node currently being
     *             visited
     * @param currentIndex the index used to compare against the desired index
     * @param index the desired index, the index being searched for
     * @return calls self if indexes do not match, otherwise
     * returns the data, type T, of the removed node
     */
    public T getRecursiveHelper(Node node, int currentIndex, int index) {
        // Nonnull base case:
         if(currentIndex == index) {
             return node.data;
         }

         return getRecursiveHelper(node.next, currentIndex + 1, index);
    }
}
// https://www.youtube.com/watch?v=fEtnKeaLZDE