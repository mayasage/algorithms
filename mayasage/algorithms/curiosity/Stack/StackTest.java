package mayasage.algorithms.curiosity.Stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
  @Test
  void test() {
    Stack<Integer> s = new Stack<>();
    assertEquals(10, s.size());
    assertTrue(s.isEmpty());
    assertNull(s.peek());
    assertThrows(NoSuchElementException.class, s::pop);
  }

  @Test
  void clear() {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 9; i += 1) s.push(i);
    assertEquals(10, s.size());
    assertEquals(8, s.peek());
    s.clear();
    assertNull(s.peek());
    assertEquals(10, s.size());
  }

  @Test
  void resize() {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i += 1) s.push(i);
    assertEquals(10, s.size());
    s.push(10);
    assertEquals(20, s.size());
    for (int i = 0; i < 5; i += 1) s.pop();
    assertEquals(20, s.size());
    s.pop();
    assertEquals(10, s.size());
  }

  @Test
  void peek() {
    Stack<Integer> s = new Stack<>();
    assertNull(s.peek());
    s.push(1);
    assertEquals(1, s.peek());
    s.clear();
    assertNull(s.peek());
  }

  @Test
  void iterator() {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i += 1) s.push(i);
    int v = 9;
    for (int i : s) assertEquals(v--, i);
  }
}