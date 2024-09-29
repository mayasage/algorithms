package mayasage.algorithms.utils;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void ignite() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst("a");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        assertTrue(list.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> list.addLast(null));
        assertTrue(list.isEmpty());
        list.addFirst("a");
        assertFalse(list.isEmpty());
        list.addFirst("b");
        assertFalse(list.isEmpty());
        list.removeFirst();
        assertFalse(list.isEmpty());
        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        assertEquals(0, list.size());
        assertThrows(IllegalArgumentException.class, () -> list.addLast(null));
        assertEquals(0, list.size());
        list.addFirst("a");
        assertEquals(1, list.size());
        list.addFirst("b");
        assertEquals(2, list.size());
        list.removeFirst();
        assertEquals(1, list.size());
        list.removeFirst();
        assertEquals(0, list.size());
    }

    @Test
    void addFirst() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        list.addFirst("a");
        Iterator<String> itr = list.iterator();
        assertEquals("a", itr.next());
        list.addFirst("b");
        itr = list.iterator();
        assertEquals("b", itr.next());
        assertEquals("a", itr.next());
        list.addFirst("c");
        itr = list.iterator();
        assertEquals("c", itr.next());
        assertEquals("b", itr.next());
        assertEquals("a", itr.next());
    }

    @Test
    void addLast() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        list.addLast("a");
        Iterator<String> itr = list.iterator();
        assertEquals("a", itr.next());
        list.addLast("b");
        itr = list.iterator();
        assertEquals("a", itr.next());
        assertEquals("b", itr.next());
        list.addLast("c");
        itr = list.iterator();
        assertEquals("a", itr.next());
        assertEquals("b", itr.next());
        assertEquals("c", itr.next());
    }

    @Test
    void testRemoveFirst() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, list::removeFirst);
        list.addFirst("a");
        assertEquals("a", list.removeFirst());
        assertThrows(NoSuchElementException.class, list::removeFirst);
        list.addFirst("a");
        list.addFirst("b");
        assertEquals("b", list.removeFirst());
        assertEquals("a", list.removeFirst());
        assertThrows(NoSuchElementException.class, list::removeFirst);
    }

    @Test
    void removeLast() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, list::removeLast);
        list.addFirst("a");
        assertEquals("a", list.removeLast());
        assertThrows(NoSuchElementException.class, list::removeLast);
        list.addFirst("a");
        list.addFirst("b");
        assertEquals("a", list.removeLast());
        assertEquals("b", list.removeLast());
        assertThrows(NoSuchElementException.class, list::removeLast);
    }

    @Test
    void iterator() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("a");
        Iterator<String> itr = list.iterator();
        assertEquals("a", itr.next());
        list.addFirst("b");
        list.addFirst("c");
        itr = list.iterator();
        assertEquals("c", itr.next());
        assertEquals("b", itr.next());
        assertEquals("a", itr.next());
        assertThrows(UnsupportedOperationException.class, itr::remove);
    }
}