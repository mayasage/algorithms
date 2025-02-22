package mayasage.algorithms.princeton.one.queue;

import java.util.Iterator;

interface IDeque<Item> extends Iterable<Item> {
        boolean isEmpty();

        int size();

        void addFirst(Item item);

        void addLast(Item item);

        Item removeFirst();

        Item removeLast();

        Iterator<Item> iterator();
}
