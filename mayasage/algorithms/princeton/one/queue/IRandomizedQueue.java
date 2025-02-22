package mayasage.algorithms.princeton.one.queue;

import java.util.Iterator;

interface IRandomizedQueue<Item> extends Iterable<Item> {
        boolean isEmpty();

        int size();

        void enqueue(Item item);

        Item dequeue();

        Item sample();

        Iterator<Item> iterator();
}
