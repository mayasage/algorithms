package mayasage.algorithms.princeton.one.deque;

import mayasage.algorithms.utils.LinkedList;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private final LinkedList<Item> deque = new LinkedList<>();

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public void addFirst(Item item) {
        deque.addFirst(item);
    }

    public void addLast(Item item) {
        deque.addLast(item);
    }

    public Item removeFirst() {
        return deque.removeFirst();
    }

    public Item removeLast() {
        return deque.removeLast();
    }

    @Override
    public Iterator<Item> iterator() {
        return deque.iterator();
    }

    public static void main(String[] args) {}
}
