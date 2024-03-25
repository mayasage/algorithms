package mayasage.algorithms.princeton.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTwoTest {
  @Test
  public void test() {
    UnionFindTwo uf = new UnionFindTwo(5);
    assertEquals(5, uf.count());

    assertFalse(uf.connected(2, 4));
    uf.union(2, 4);
    assertTrue(uf.connected(2, 4));

    assertFalse(uf.connected(1, 5));
    uf.union(1, 5);
    assertTrue(uf.connected(1, 5));

    assertFalse(uf.connected(4, 5));
    uf.union(4, 5);
    assertTrue(uf.connected(4, 5));
    assertTrue(uf.connected(1, 5));
    assertTrue(uf.connected(2, 5));
    assertTrue(uf.connected(5, 5));

    assertEquals(2, uf.find(1));
    assertEquals(2, uf.find(2));
    assertEquals(3, uf.find(3));
    assertEquals(2, uf.find(4));
    assertEquals(1, uf.find(5));

    /*
     * This will generate a "Flat" Tree.
     * 1 U 2 => 1 p 2
     * 2 U 3 => 1 U 3 => 1 p 3
     * 3 U 4 => 1 U 4 => 1 p 4
     *
     * It is generating a "Flat" Tree because I have written in the union
     * condition that p will ALWAYS be the parent.
     *
     * Then, here we go from left to right, and left will always be the parent,
     * and thus it generates, the "Flat" Tree.
     *
     * However, if we start going in reverse, then we'll see some choking.
     */
    uf = new UnionFindTwo(10000000);
    for (int i = 1; i < 10000000; i += 1) {
      uf.union(i, i + 1);
    }

    /*
     * Let be build the tree by reversing the union operation.
     * This will still not chock because it is growing linearly.
     * Wait for the next loop and you'll see.
     *
     * This one is fast compared to UnionFindOne
     * We're not accessing the entire array immediately for every union here.
     * Accessing will grow linearly to N.
     * 1U2 (search 2 elements)
     * 2U3 (search 4 elements)
     * As apposed to searching 10000000 every union call.
     */
    int n = 10000000;
    uf = new UnionFindTwo(n);
    for (int i = n; i > 1; i -= 1) {
      uf.union(i - 1, i);
    }

    /*
     * Gotta choke 'em down !
     *
     * We're essentially iterating through the entire set twice (once for p,
     * once for q) for a single connected operation.
     *
     * This is even worse than UnionFindOne union (there we were only
     * scanning the set once for the union operation, and zero times for
     * connected).
     */
    for (int i = 0; i < n; i += 1) {
      uf.connected(n, n);
    }
  }
}
