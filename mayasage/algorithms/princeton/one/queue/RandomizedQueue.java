package mayasage.algorithms.princeton.one.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements IRandomizedQueue<Item> {
        private Item[] items = (Item[]) new Object[1];
        private int size = 0;
        private int startIndex = 0;
        private int endIndex = 0;
        private int peakSize = 0;

        public static void main(String[] args) {
        }

        @Override
        public boolean isEmpty() {
                return size == 0;
        }

        @Override
        public int size() {
                return size;
        }

        @Override
        public void enqueue(Item item) {
                if (item == null) throw new IllegalArgumentException();
                if (endIndex == items.length - 1) resizeItems(items.length * 2);
                items[++endIndex] = item;
                peakSize = Math.max(peakSize, ++size);
        }

        @Override
        public Item dequeue() {
                if (isEmpty()) throw new NoSuchElementException();
                int randomIndex = StdRandom.uniformInt(startIndex, endIndex + 1);
                Item item = items[randomIndex];
                items[randomIndex] = null;
                swap(startIndex++, randomIndex);
                size--;
                if (size < items.length / 4) resizeItems(items.length / 2);
                return item;
        }

        @Override
        public Item sample() {
                if (isEmpty()) throw new NoSuchElementException();
                int randomIndex = StdRandom.uniformInt(startIndex, endIndex + 1);
                return items[randomIndex];
        }

        @Override
        public Iterator<Item> iterator() {
                return new RandomizedQueueIterator<>(items, startIndex, size);
        }

        private void swap(int index1, int index2) {
                Item temp = items[index1];
                items[index1] = items[index2];
                items[index2] = temp;
        }

        private void resizeItems(int newLength) {
                Item[] newItems = (Item[]) new Object[newLength];
                System.arraycopy(items, startIndex, newItems, 0, size);
                startIndex = 0;
                endIndex = size - 1;
                items = newItems;
        }

        private static class RandomizedQueueIterator<Item> implements Iterator<Item> {
                private final Item[] items;
                private final int endIndex;
                private int size;
                private int startIndex = 0;

                public RandomizedQueueIterator(Item[] items, int startIndex, int size) {
                        this.size = size;
                        this.items = (Item[]) new Object[size];
                        System.arraycopy(items, startIndex, this.items, 0, size);
                        this.endIndex = size - 1;
                }

                @Override
                public boolean hasNext() {
                        return size > 0;
                }

                @Override
                public Item next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        int randomIndex = StdRandom.uniformInt(startIndex, endIndex + 1);
                        Item item = items[randomIndex];
                        swap(startIndex, randomIndex);
                        startIndex++;
                        size--;
                        return item;
                }

                @Override
                public void remove() {
                        throw new UnsupportedOperationException();
                }

                private void swap(int index1, int index2) {
                        Item temp = items[index1];
                        items[index1] = items[index2];
                        items[index2] = temp;
                }
        }
}
