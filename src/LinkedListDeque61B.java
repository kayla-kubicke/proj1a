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
        // Also, I'll be Your Mirror makes me kinda sad too but in an extremely sweet, loving way.
        // In a hopeful, resilient way.
    }

    /**
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // Let's just start by simply instantiating the new node with the given data.
        Node first = new Node(null, null, x);

        // I know first's prev needs to point to sentinel.
        // This will always be the case, given it is the first node in the list.
        first.prev = sentinel;

        // And I know first's next needs to point to whatever sentinel's next is pointing to.
        first.next = sentinel.next;

        // So, first should be all set to go.
        // Now I need to deal with repointing sentinel's prev and next.

        // sentinel's next is obvious; it just needs to point at first.
        // I'm just going to go ahead and set that.
        sentinel.next = first;

        // But sentinel's prev should point to...
        // the last node in the list, obviously.
        // And one can access that by...

        // Was my original thinking correct?
        // sentinel's prev only needs to be updated if sentinel is the only node in the list.
        if(sentinel.prev == sentinel) {
            sentinel.prev = first;
        }
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
        List<T> returnList = new ArrayList<>();

        Node node = sentinel.next;

        // Ah, moved the guiding node before I should have.
        // https://giphy.com/gifs/thesimpsons-smrt-im-smart-i-am-so-oOggzV7YqOw1UpLTIY
        while(node != sentinel) {
            // append to returnList.
            returnList.add(node.data);

            // update node.
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