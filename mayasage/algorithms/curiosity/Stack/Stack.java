package mayasage.algorithms.curiosity.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
  @SuppressWarnings("unchecked")
  private Item[] i = (Item[]) new Object[10];
  private int p = -1;

  private void cp(Item[] n) {
    if (p + 1 >= 0) System.arraycopy(i, 0, n, 0, p + 1);
    i = n;
  }

  private void su() {
    Object[] o = new Object[i.length * 2];
    // noinspection unchecked
    cp((Item[]) o);
  }

  private void sd() {
    Object[] o = new Object[i.length / 2];
    // noinspection unchecked
    cp((Item[]) o);
  }

  public boolean isEmpty() {
    return p == -1;
  }

  public int size() {
    return i.length;
  }

  public void clear() {
    // noinspection unchecked
    i = (Item[]) new Object[10];
  }

  public Item peek() {
    return p == -1 ? null : i[p];
  }

  public void push(Item x) {
    if (p == i.length - 1) su();
    i[++p] = x;
  }

  @Override
  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  public Item pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Pop called on Empty Stack ❌");
    }
    if (p == i.length / 4) sd();
    return i[p--];
  }

  private class StackIterator implements Iterator<Item> {
    @Override
    public boolean hasNext() {
      return !isEmpty();
    }

    @Override
    public Item next() {
      return pop();
    }
  }
}
