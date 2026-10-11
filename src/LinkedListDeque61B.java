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
        // Wait, no. Is what I did correct?
        // I am not confident.

        // My original:
        // this.sentinel = new Node(sentinel, null, null);

        // So, the previous node points to sentinel.
        // sentinel itself points to the entire object.
        // So, when the previous node points at sentinel...
        // One still can access sentinel.next, but it just points to null.

        // Now:
        this.sentinel = new Node(sentinel, sentinel, null);
        // This intuitively seems more circular. Both previous and next point back to
        // the sentinel object...
        // But the diagram implies the next node points to the previous.
        // Clearly, I am not sure. What I am sure of is that is configuration does not
        // cause a NullPointerException.
    }

    // Don't be foolish, make a beer bread poolish.
    // https://youtu.be/uz_xDXKjspw?t=178
    // I'm trying the Alaskan Smoked Porter ('24) with King Arthur whole wheat and white today...
    // Hm... I shall see. Had a few sips, should be damn tasty.

    // Also, some time this morning my tragus piercing fell out and I only can find the stud which looks... squished???
    // I feel very underdressed, almost gross. Missing a body part. Why is this so distressing?
    // Maybe it reminds me of when my ex-husband would remove my helix piercing while I was sleeping and then
    // claim that it was just falling out. Nope, that's not how the earring works buddy.
    // And... Deep Roots in Bellevue closed so now I need to go to Rowan.
    // Maybe a walk around the silly mall will be good for me.

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
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