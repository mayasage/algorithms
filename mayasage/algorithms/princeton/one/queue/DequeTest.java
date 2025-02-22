package mayasage.algorithms.princeton.one.queue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
        @Test
        public void loopTestIterator() {
                Deque<Integer> deque = new Deque<>();
                int[] arr = new int[10];
                for (int i = 0; i < 10; i++) {
                        deque.addLast(i);
                        arr[i] = i;
                }
                testIterator(deque, arr);
        }

        @Test
        public void iteratorErrorOnRemove() {
                Deque<Integer> deque = new Deque<>();
                Iterator<Integer> it = deque.iterator();
                assertThrows(UnsupportedOperationException.class, it::remove);
        }

        @Test
        public void addRemoveIterator() {
                Deque<Integer> deque = new Deque<>();
                deque.addFirst(1);
                testIterator(deque, new int[]{1});
                deque.addFirst(2);
                testIterator(deque, new int[]{2, 1});
                deque.removeLast();
                testIterator(deque, new int[]{2});
        }

        @Test
        public void sizeTest() {
                Deque<Integer> deque = new Deque<>();
                for (int i = 0; i < 10; i++) {
                        deque.addLast(i);
                        assertEquals(i + 1, deque.size());
                }
                for (int i = 0; i < 10; i++) {
                        deque.removeLast();
                        assertEquals(10 - (i + 1), deque.size());
                }
        }

        @Test
        public void firstLastTest() {
                Deque<Integer> deque = new Deque<>();
                deque.addFirst(1);
                assertEquals(1, deque.size());
                assertEquals(1, deque.removeLast());
                assertEquals(0, deque.size());
                deque.addLast(1);
                assertEquals(1, deque.size());
                assertEquals(1, deque.removeFirst());
                assertEquals(0, deque.size());
        }

        @Test
        public void throwsExceptionOnEmptyDeque() {
                Deque<Integer> deque = new Deque<>();
                assertThrows(NoSuchElementException.class, deque::removeFirst);
                assertThrows(NoSuchElementException.class, deque::removeLast);
        }

        @Test
        public void resizeTest() {
                Deque<Integer> deque = new Deque<>();
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                        deque.addFirst(i);
                        set.add(i);
                }
                for (int i = 0; i < 10; i++) {
                        assertTrue(set.contains(deque.removeFirst()));
                }
                for (int i = 0; i < 10; i++) {
                        deque.addLast(i);
                }
                for (int i = 0; i < 10; i++) {
                        assertTrue(set.contains(deque.removeLast()));
                }
        }

        private void testIterator(Deque<Integer> deque, int[] expected) {
                Iterator<Integer> it = deque.iterator();
                for (int j : expected) {
                        assertTrue(it.hasNext());
                        assertEquals(j, it.next());
                }
                assertFalse(it.hasNext());
        }
}