package mayasage.algorithms.princeton.one.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements IDeque<Item> {
        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size;

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
        public void addFirst(Item item) {
                if (item == null) throw new IllegalArgumentException();
                if (size == 0) {
                        head = new Node<>(item);
                        tail = head;
                } else {
                        Node<Item> oldHead = head;
                        Node<Item> newHead = new Node<>(item);
                        newHead.setNext(oldHead);
                        oldHead.setPrev(newHead);
                        head = newHead;
                }
                size++;
        }

        @Override
        public void addLast(Item item) {
                if (item == null) throw new IllegalArgumentException();
                if (size == 0) {
                        head = new Node<>(item);
                        tail = head;
                } else {
                        Node<Item> oldTail = tail;
                        Node<Item> newTail = new Node<>(item);
                        oldTail.setNext(newTail);
                        newTail.setPrev(oldTail);
                        tail = newTail;
                }
                size++;
        }

        @Override
        public Item removeFirst() {
                if (size == 0) throw new NoSuchElementException();
                Node<Item> first = head;
                head = head.getNext();
                if (head == null) tail = null;
                else head.setPrev(null);
                size--;
                return first.getItem();
        }

        @Override
        public Item removeLast() {
                if (size == 0) throw new NoSuchElementException();
                Node<Item> last = tail;
                tail = tail.getPrev();
                if (tail == null) head = null;
                else tail.setNext(null);
                size--;
                return last.getItem();
        }

        @Override
        public Iterator<Item> iterator() {
                return new DequeIterator<>(head);
        }

        private static class DequeIterator<Item> implements Iterator<Item> {
                private Node<Item> current;

                public DequeIterator(Node<Item> head) {
                        this.current = head;
                }

                @Override
                public boolean hasNext() {
                        return current != null;
                }

                @Override
                public Item next() {
                        if (current == null) throw new NoSuchElementException();
                        Node<Item> next = current;
                        current = current.getNext();
                        return next.getItem();
                }

                @Override
                public void remove() {
                        throw new UnsupportedOperationException();
                }
        }

        private static class Node<Item> {
                private final Item item;
                private Node<Item> next;
                private Node<Item> prev;

                public Node(Item item) {
                        this.item = item;
                        next = null;
                        prev = null;
                }

                public Item getItem() {
                        return item;
                }

                public Node<Item> getNext() {
                        return next;
                }

                public void setNext(Node<Item> next) {
                        this.next = next;
                }

                public Node<Item> getPrev() {
                        return prev;
                }

                public void setPrev(Node<Item> prev) {
                        this.prev = prev;
                }
        }
}
