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

        // NOTE: Depends on other methods
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

        // NOTE: Depends on other methods
        testList.addFirst(3);
        testList.addLast(7);
        testList.addFirst(9);
        testList.addLast(14);

        assertThat(testList.isEmpty()).isFalse();

    }

    @Test
    /** Tests if isEmpty() returns false on a list with a single node containing String data. */
    public void isEmptySingleNodeStringListReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("Anita");

        assertThat(testList.isEmpty()).isFalse();
    }

    @Test
    /** Tests if isEmpty() returns false on a list with a single node containing Integer data. */
    public void isEmptySingleNodeIntegerListReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("Anita");

        assertThat(testList.isEmpty()).isFalse();
    }

    @Test
    /** Tests if isEmpty() returns false for a single node list containing null data. */
    public void isEmptySingleNodeListContainingNullDataReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(null);

        assertThat(testList.isEmpty()).isFalse();
    }

    @Test
    /** Tests if isEmpty() returns false for a nonempty list containing only null data. */
    public void isEmptyNonEmptyListContainingOnlyNullDataReturnsFalse() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(null);
        testList.addFirst(null);
        testList.addFirst(null);
        testList.addFirst(null);

        assertThat(testList.isEmpty()).isFalse();
    }
    // END: isEmpty() Test Suite

    // START: size() Test Suite
    @Test
    /** */
    public void sizeReturnsZeroIfListIsOnlySentinel() {
        Deque61B<String> justaLonelySentinel = new LinkedListDeque61B<>();

        assertThat(justaLonelySentinel.size()).isEqualTo(0);
    }

    @Test
    /** */
    public void sizeReturnsOneIfStringListIsSingleNode() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");

        assertThat(testList.size()).isEqualTo(1);
    }

    @Test
    /** */
    public void sizeReturnsOneIfIntegerListIsSingleNode() {
        Deque61B<Integer> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(101);

        assertThat(testList.size()).isEqualTo(1);
    }

    @Test
    /** */
    public void sizeReturnsTenOnStringListContainingTenNodes() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addFirst("spaghetti");
        testList.addLast("angel");
        testList.addFirst("radiatori");
        testList.addLast("trumpet");
        testList.addFirst("fusilli");
        testList.addLast("linguine");
        testList.addFirst("lasagna");
        testList.addLast("ziti");

        assertThat(testList.size()).isEqualTo(10);
    }

    @Test
    public void sizeReturnsTenOnIntegerListContainingTenNodes() {
        Deque61B<Integer> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(1);
        testList.addLast(2);
        testList.addFirst(3);
        testList.addLast(4);
        testList.addFirst(5);
        testList.addLast(6);
        testList.addFirst(7);
        testList.addLast(8);
        testList.addFirst(9);
        testList.addLast(10);

        assertThat(testList.size()).isEqualTo(10);
    }

    @Test
    /** */
    public void sizeReturnsThreeOnStringListContainingThreeNodes() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

            // NOTE: Depends on other methods
            testList.addFirst("rigatoni");
            testList.addLast("penne");
            testList.addFirst("spaghetti");

            assertThat(testList.size()).isEqualTo(3);
    }

    @Test
    public void sizeReturnsThreeOnIntegerListContainingThreeNodes() {
        Deque61B<Integer> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(1);
        testList.addLast(2);
        testList.addFirst(3);

        assertThat(testList.size()).isEqualTo(3);
    }

    @Test
    public void sizeReturnsFourOnStringListContainingOnlyNullData() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(null);
        testList.addLast(null);
        testList.addFirst(null);
        testList.addLast(null);

        assertThat(testList.size()).isEqualTo(4);
    }
    // ADD: Comments
    // END: size() Test Suite

    // START: get() Test Suite
    @Test
    /** Valid index */
    public void getReturnsExpectedDataForValidIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(5)).isEqualTo("trumpet");
    }

    @Test
    /** Index greater than size */
    public void getReturnsNullForIndexGreaterThanSize() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addFirst("spaghetti");
        testList.addLast("angel");
        testList.addFirst("radiatori");
        testList.addLast("trumpet");
        testList.addFirst("fusilli");
        testList.addLast("linguine");
        testList.addFirst("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(15)).isEqualTo(null);
    }

    @Test
    /** Negative */
    public void getReturnsNullForNegativeIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addFirst("spaghetti");
        testList.addLast("angel");
        testList.addFirst("radiatori");
        testList.addLast("trumpet");
        testList.addFirst("fusilli");
        testList.addLast("linguine");
        testList.addFirst("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(-1)).isEqualTo(null);
    }

    @Test
    /** Data returned is simply null */
    public void getReturnsNullForNodeWithNullData() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(null);
        testList.addLast(null);
        testList.addFirst(null);
        testList.addLast(null);

        assertThat(testList.get(2)).isEqualTo(null);
    }

    @Test
    /** Index zero */
    public void getReturnsExpectedDataForIndexZero() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(0)).isEqualTo("rigatoni");
    }

    @Test
    /** Index one */
    public void getReturnsExpectedDataForIndexOne() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(1)).isEqualTo("penne");
    }

    @Test
    /** Last index */
    public void getReturnsExpectedDataForLastIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.get(9)).isEqualTo("ziti");
    }
    // ADD: Update comments
    // END: get() Test Suite

    // START: getRecursive() Test Suite
    @Test
    /** Valid index */
    public void getRecursiveReturnsExpectedDataForValidIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(5)).isEqualTo("trumpet");
    }

    @Test
    /** Index greater than size */
    public void getRecursiveReturnsNullForIndexGreaterThanSize() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addFirst("spaghetti");
        testList.addLast("angel");
        testList.addFirst("radiatori");
        testList.addLast("trumpet");
        testList.addFirst("fusilli");
        testList.addLast("linguine");
        testList.addFirst("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(15)).isEqualTo(null);
    }

    @Test
    /** Negative */
    public void getRecursiveReturnsNullForNegativeIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addFirst("spaghetti");
        testList.addLast("angel");
        testList.addFirst("radiatori");
        testList.addLast("trumpet");
        testList.addFirst("fusilli");
        testList.addLast("linguine");
        testList.addFirst("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(-1)).isEqualTo(null);
    }

    @Test
    /** Data returned is simply null */
    public void getRecursiveReturnsNullForNodeWithNullData() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst(null);
        testList.addLast(null);
        testList.addFirst(null);
        testList.addLast(null);

        assertThat(testList.getRecursive(2)).isEqualTo(null);
    }

    @Test
    /** Index zero */
    public void getRecursiveReturnsExpectedDataForIndexZero() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(0)).isEqualTo("rigatoni");
    }

    @Test
    /** Index one */
    public void getRecursiveReturnsExpectedDataForIndexOne() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(1)).isEqualTo("penne");
    }

    @Test
    /** Last index */
    public void getRecursiveReturnsExpectedDataForLastIndex() {
        Deque61B<String> testList = new LinkedListDeque61B<>();

        // NOTE: Depends on other methods
        testList.addFirst("rigatoni");
        testList.addLast("penne");
        testList.addLast("spaghetti");
        testList.addLast("angel");
        testList.addLast("radiatori");
        testList.addLast("trumpet");
        testList.addLast("fusilli");
        testList.addLast("linguine");
        testList.addLast("lasagna");
        testList.addLast("ziti");

        assertThat(testList.getRecursive(9)).isEqualTo("ziti");
    }
    // ADD: Update comments
    // END: getRecursive() Test Suite
}