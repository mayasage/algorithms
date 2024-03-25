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
  }
}
