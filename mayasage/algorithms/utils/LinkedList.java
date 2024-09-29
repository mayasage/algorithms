package mayasage.algorithms.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    private Node<Item> head = null;
    private Node<Item> tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head); // new Node's next
            head.setPrev(newNode); // next Node's prev
            head = newNode;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail); // new Node's prev
            tail.setNext(newNode); // prev Node's next
            tail = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = head.getVal();
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = tail.getVal();
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        if (isEmpty()) throw new NoSuchElementException();
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node<Item> cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = cur.getVal();
            cur = cur.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<Item> {
        private final Item val;
        private Node<Item> next;
        private Node<Item> prev;

        public Node(Item val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Item getVal() {
            return val;
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

