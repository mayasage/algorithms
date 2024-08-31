package mayasage.algorithms.princeton.one.successor_delete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccessorDeleteTest {
  private void test1(int n, UnionFind uf) {
    SuccessorDelete sd = new SuccessorDelete(n, uf);

    assertEquals(-1, sd.getSuccessor(4));

    // Delete 0 (first element)
    assertEquals(1, sd.getSuccessor(0));
    sd.delete(0);
    assertEquals(1, sd.getSuccessor(0));

    // Delete 3
    assertEquals(3, sd.getSuccessor(2));
    sd.delete(3);
    assertEquals(4, sd.getSuccessor(2));
    assertEquals(4, sd.getSuccessor(3));

    // Delete 4 (last element)
    assertEquals(4, sd.getSuccessor(2));
    assertEquals(4, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));
    sd.delete(4);
    assertEquals(-1, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    // Delete the remaining 1 and 2
    assertEquals(1, sd.getSuccessor(0));
    sd.delete(1);
    assertEquals(2, sd.getSuccessor(0));
    sd.delete(2);
    assertEquals(-1, sd.getSuccessor(0));

    // Check all
    assertEquals(-1, sd.getSuccessor(0));
    assertEquals(-1, sd.getSuccessor(1));
    assertEquals(-1, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));
  }

  private void test2(int n, UnionFind uf) {
    SuccessorDelete sd = new SuccessorDelete(n, uf);

    assertEquals(1, sd.getSuccessor(0));
    assertEquals(2, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(4, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(0);

    assertEquals(1, sd.getSuccessor(0));
    assertEquals(2, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(4, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(1);

    assertEquals(2, sd.getSuccessor(0));
    assertEquals(2, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(4, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(4);

    assertEquals(2, sd.getSuccessor(0));
    assertEquals(2, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(2);

    assertEquals(3, sd.getSuccessor(0));
    assertEquals(3, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(1);

    assertEquals(3, sd.getSuccessor(0));
    assertEquals(3, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(1);
    sd.delete(0);
    sd.delete(2);
    sd.delete(4);

    assertEquals(3, sd.getSuccessor(0));
    assertEquals(3, sd.getSuccessor(1));
    assertEquals(3, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));

    sd.delete(3);

    assertEquals(-1, sd.getSuccessor(0));
    assertEquals(-1, sd.getSuccessor(1));
    assertEquals(-1, sd.getSuccessor(2));
    assertEquals(-1, sd.getSuccessor(3));
    assertEquals(-1, sd.getSuccessor(4));
  }

  @Test
  public void test() {
    int n = 5;

    test1(n, new UnionFindOne(n + 1));
    test1(n, new UnionFindTwo(n + 1));

    test2(n, new UnionFindOne(n + 1));
    test2(n, new UnionFindTwo(n + 1));
  }
}