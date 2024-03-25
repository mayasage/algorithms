package mayasage.algorithms.princeton.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindThreeTest {
  @Test
  public void test() {
    UnionFindThree uf = new UnionFindThree(5);
    assertEquals(5, uf.count());

    assertFalse(uf.connected(2, 4));
    uf.union(2, 4);
    assertTrue(uf.connected(2, 4));
    assertEquals(2, uf.children(2));
    assertEquals(1, uf.children(4));

    assertFalse(uf.connected(1, 5));
    uf.union(1, 5);
    assertTrue(uf.connected(1, 5));
    assertEquals(2, uf.children(1));
    assertEquals(1, uf.children(5));

    assertFalse(uf.connected(4, 5));
    uf.union(4, 5);
    assertTrue(uf.connected(4, 5));
    assertTrue(uf.connected(1, 5));
    assertTrue(uf.connected(2, 5));
    assertTrue(uf.connected(5, 5));
    assertEquals(1, uf.children(4));
    assertEquals(1, uf.children(5));
    assertEquals(4, uf.children(2));
    assertEquals(2, uf.children(1));

    assertEquals(2, uf.find(1));
    assertEquals(2, uf.find(2));
    assertEquals(3, uf.find(3));
    assertEquals(2, uf.find(4));
    assertEquals(1, uf.find(5));

    /*
     * None of the choking will work here.
     * Watch.
     */
    int n = 10_000_000;

    /*
     * Front-Back Choke
     */
    uf = new UnionFindThree(n);
    for (int i = 1; i < n; i += 1) {
      uf.union(i, i + 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n, n);
    }

    /*
     * Back-Front Choke
     */
    uf = new UnionFindThree(n);
    for (int i = n; i > 1; i -= 1) {
      uf.union(i - 1, i);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n, n);
    }

    /*
     * It won't work because the trees are balanced, no matter what you do.
     * You can't unbalance them.
     */
  }
}
