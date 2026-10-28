import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class StealinTests {
    @Test
    public void add_first_from_empty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("My name is LZWcc.");
        assertThat(lld1.toList()).containsExactly("My name is LZWcc.").inOrder();
    }

    @Test
    public void add_last_from_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(67);
        assertThat(lld1.toList()).containsExactly(67).inOrder();
    }

    @Test
    public void add_first_nonempty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        assertThat(lld1.toList()).containsExactly("yqq", "zyq").inOrder();
    }

    @Test
    public void add_last_nonempty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addLast("zyq");
        lld1.addLast("yqq");
        assertThat(lld1.toList()).containsExactly("zyq", "yqq").inOrder();
    }

    @Test
    public void size() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.size()).isEqualTo(0);
        lld1.addLast(20);
        lld1.addLast(30);
        lld1.addLast(40);
        assertThat(lld1.size()).isEqualTo(3);
    }

    @Test
    public void is_empty_true() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void is_empty_false() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(30);
        assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    public void get_valid() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
    }

    @Test
    public void get_oob_large() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
        assertThat(lld1.get(100010)).isNull();
    }

    @Test
    public void get_oob_neg() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
        assertThat(lld1.get(-101021)).isNull();
    }

    @Test
    public void get_recursive_valid() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
    }

    @Test
    public void get_recursive_oob_large() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
        assertThat(lld1.getRecursive(100010)).isNull();
    }

    @Test
    public void get_recursive_oob_neg() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
        assertThat(lld1.getRecursive(-101021)).isNull();
    }

    @Test
    public void remove_first() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(20, 30).inOrder();
    }

    @Test
    public void size_after_remove_from_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.removeFirst();
        lld1.removeLast();
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void to_list_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.toList()).isEmpty();
    }

    @Test
    public void add_first_after_remove_to_empty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        lld1.removeLast();
        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly().inOrder();
        assertThat(lld1.isEmpty()).isTrue();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        assertThat(lld1.toList()).containsExactly("yqq", "zyq").inOrder();
        assertThat(lld1.size()).isEqualTo(2);
    }

    @Test
    public void resizingTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        for (int i = 0; i < 23; i++) {
            lld1.addLast(i);
        }
        assertThat(lld1.size()).isEqualTo(23);
        assertThat(lld1.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22).inOrder();
    }

    @Test
    public void resizingDownTest() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        for (int i = 0; i < 32; i++) {
            deque.addLast(i);
        }
        assertThat(deque.size()).isEqualTo(32);
        for (int i = 0; i < 28; i++) {
            deque.removeFirst();
        }
        assertThat(deque.size()).isEqualTo(4);
        assertThat(deque.toList()).containsExactly(28, 29, 30, 31).inOrder();
    }
}