package mayasage.algorithms.princeton.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindOneTest {
  @Test
  public void test() {
    UnionFindOne uf = new UnionFindOne(5);

    assertFalse(uf.connected(1, 3));

    uf.union(1, 3);

    assertTrue(uf.connected(1, 3));
    assertEquals(1, uf.find(1));
    assertEquals(1, uf.find(3));

    uf.union(4, 1);

    assertEquals(4, uf.find(1));
    assertEquals(4, uf.find(3));
    assertEquals(4, uf.find(4));

    assertEquals(5, uf.count());

    // This will take a long time.
//    uf = new UnionFindOne(10000000);
//    for (int i = 1; i < 10000000; i += 1) {
//      uf.union(i, i + 1);
//    }
  }
}