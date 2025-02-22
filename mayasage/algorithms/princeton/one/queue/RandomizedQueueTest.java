package mayasage.algorithms.princeton.one.queue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {
        @Test
        public void sizeTest() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                for (int i = 0; i < 10; i++) {
                        rQueue.enqueue(i);
                        assertEquals(i + 1, rQueue.size());
                }
                for (int i = 0; i < 10; i++) {
                        rQueue.dequeue();
                        assertEquals(10 - (i + 1), rQueue.size());
                }
                assertEquals(0, rQueue.size());
                for (int i = 0; i < 10; i++) rQueue.enqueue(i);
                for (int i = 0; i < 100; i++) rQueue.enqueue(i);
                for (int i = 0; i < 10; i++) rQueue.enqueue(i);
                assertEquals(120, rQueue.size());
        }

        @Test
        public void throwsExceptionOnEmptyDeque() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                assertThrows(NoSuchElementException.class, rQueue::dequeue);
        }

        @Test
        public void resizeTest() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                        rQueue.enqueue(i);
                        set.add(i);
                }
                for (int i = 0; i < 10; i++) assertTrue(set.contains(rQueue.dequeue()));
                for (int i = 0; i < 10; i++) rQueue.enqueue(i);
                for (int i = 0; i < 10; i++) assertTrue(set.contains(rQueue.dequeue()));
        }

        @Test
        public void parallelIterators() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 5; i++) {
                        rQueue.enqueue(i);
                        set.add(i);
                }
                Set<Integer> seen1 = new HashSet<>();
                Set<Integer> seen2 = new HashSet<>();
                Iterator<Integer> it1 = rQueue.iterator();
                Iterator<Integer> it2 = rQueue.iterator();
                for (int i = 0; i < 5; i++) {
                        Integer next1 = it1.next();
                        Integer next2 = it2.next();
                        assertTrue(set.contains(next1));
                        assertTrue(set.contains(next2));
                        assertFalse(seen1.contains(next1));
                        assertFalse(seen2.contains(next2));
                        seen1.add(next1);
                        seen2.add(next2);
                }
                assertEquals(seen1.size(), seen2.size());
        }

        @Test
        public void enqueueDequeueTest() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                rQueue.enqueue(387);
                assertEquals(1, rQueue.size());
                assertEquals(387, rQueue.dequeue());
                rQueue.enqueue(397);
                assertEquals(397, rQueue.dequeue());
                assertEquals(0, rQueue.size());
                for (int i = 0; i < 100; i++) {
                        rQueue.enqueue(i);
                        rQueue.dequeue();
                }
                assertEquals(0, rQueue.size());
                for (int i = 0; i < 10; i++) rQueue.enqueue(i);
                Iterator<Integer> it = rQueue.iterator();
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                        Integer next = it.next();
                        assertFalse(seen.contains(next));
                        seen.add(next);
                }
        }

        @Test
        public void noDuplicatesInIteratorTest() {
                RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
                for (int i = 0; i < 10; i++) rQueue.enqueue(i);
                Iterator<Integer> it = rQueue.iterator();
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                        Integer next = it.next();
                        assertFalse(seen.contains(next));
                        seen.add(next);
                }
        }
}