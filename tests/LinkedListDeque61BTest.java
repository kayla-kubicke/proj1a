import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    // START: isEmpty() Test Suite
    // An empty list; just the sentinel node
    @Test
    /** Tests if isEmpty() returns true on a list only containing a sentinel. */
    public void isEmptyEmptyListReturnsTrue() {
         Deque61B<String> justaLonelySentinel = new LinkedListDeque61B<>();

         assertThat(justaLonelySentinel.isEmpty()).isTrue();
    }

    @Test
    /** Tests if isEmpty() returns false on a list with four nodes containing String data. */
    public void isEmptyNonEmptyStringListReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        testList.addFirst("Anita");
        testList.addLast("Roger");
        testList.addFirst("Pongo");
        testList.addLast("Perdita");

        assertThat(testList.isEmpty()).isFalse();

    }

    @Test
    /** Tests if isEmpty() returns false on a list with four nodes containing Integer data. */
    public void isEmptyNonEmptyIntegerListReturnsFalse() {
        Deque61B<Integer> testList = new LinkedListDeque61B<>();

        testList.addFirst(3);
        testList.addLast(7);
        testList.addFirst(9);
        testList.addLast(14);

        assertThat(testList.isEmpty()).isFalse();

    }

    // NO.
    // null; "true empty"
    // Nope, just will just throw NullPointerException.
    // Can't call isEmpty() on null cause it's not a Deque61B object.
    // null is not a primative or object, it's null.
    // @Test
    // public void isEmptyReturnsTrueForNull() {
        // Deque61B<String> testList = new LinkedListDeque61B<>();
        // testList = null;

        // assertThis.(testList.isEmpty()).isTrue();
    // }
    // NO.

    // Oh, wait, I can check that it throws the error. But I think that is beyond the scope of the
    // given project.

    @Test
    /** Tests if isEmpty() returns false on a list with a single node containing String data. */
    public void isEmptySingleNodeStringListReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        testList.addFirst("Anita");

        assertThat(testList.isEmpty()).isFalse();
    }

    @Test
    /** Tests if isEmpty() returns false on a list with a single node containing Integer data. */
    public void isEmptySingleNodeIntegerListReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        testList.addFirst("Anita");

        assertThat(testList.isEmpty()).isFalse();
    }

    // One node with null data
    @Test
    /** Tests if isEmpty() returns false for a single node list containing null data. */
    public void isEmptySingleNodeListContainingNullDataReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        testList.addFirst(null);

        assertThat(testList.isEmpty()).isFalse();
    }

    @Test
    /** Tests if isEmpty() returns false for a nonempty list containing only null data. */
    public void isEmptyNonEmptyListContainingOnlyNullDataReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        testList.addFirst(null);
        testList.addFirst(null);
        testList.addFirst(null);
        testList.addFirst(null);

        assertThat(testList.isEmpty()).isFalse();

    }
    // END: isEmpty() Test Suite

    // size() Test Suite
}