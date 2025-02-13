package mayasage.algorithms.princeton.one.successor_delete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindOneOGTest {
  private void loadTest() {

    /*
     * None of the previous choking will work here.
     * Watch.
     */

    UnionFindOne uf;
    int n = 10_000_000;
    long startTime;
    long endTime;
    String output;

    /*
     * Front Choke - 1.22s
     */
    startTime = System.nanoTime();
    uf = new UnionFindOne(n);
    for (int i = 1; i < n - 1; i += 1) {
      uf.union(i, i + 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "Front Choke = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * Back Choke - 2.33s
     */
    uf = new UnionFindOne(n);
    for (int i = n - 1; i > 0; i -= 1) {
      uf.union(i - 1, i);
    }
    for (int i = 0; i < n - 1; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "Back Choke = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * It won't work because the trees are balanced, no matter what you do.
     * You can't unbalance them.
     */

    /*
     * endOfCurrentList U endOfNextList = 3s-
     * endOfCurrentList U startOfNextList = 3s-
     * startOfCurrentList U startOfNextList = 2s-
     * startOfCurrentList U endOfNextList = 2s+
     *
     * It doesn't choke, but is still slow.
     *
     * What I'm trying to do in the following code is divide the set into
     * small trees of equal size, and keep on merging 2 equal sized trees, till
     * there's only 1 long tree.
     *
     * Imagine it like this:
     *
     * 0 1 2 3 4 5
     *
     * i = 1:
     * - 1 U 2
     * - 3 U 4
     * - 5 U 5
     *
     * Result: 0 12 34 5
     *
     * i = 2:
     * - 2 U 4 <- this is the reason for slowness (had I done 1 U 3, it would
     *   have been just fine, but with this, we're essentially traversing
     *   half the set for every union operation... 2 U 4 => root(2) U root(4)
     *   , and when 4 is nested, as it will be in due time, we'll be
     *   traversing 50_000_000 elements for 1 union operation).
     * - 5 U 5
     *
     * i = 3:
     * - 1 U 5
     */

    int l = (int) Math.ceil((double) n / 2);
    int lengthOfList = 1;

    /*
     * startOfCurrentList U startOfNextList = 1.65s
     */
    startTime = System.nanoTime();
    uf = new UnionFindOne(n);
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j < n; ) {
        int startOfCurrentList = j;
        int startOfNextList = Math.min(
          (lengthOfList + startOfCurrentList),
          n - 1
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(startOfCurrentList, startOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n - 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "startOfCurrentList U startOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * startOfCurrentList U endOfNextList = 1.97s
     */
    startTime = System.nanoTime();
    uf = new UnionFindOne(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j < n; ) {
        int startOfCurrentList = j;
        int endOfNextList = Math.min(
          (lengthOfList * 2 + startOfCurrentList - 1),
          n - 1
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(startOfCurrentList, endOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n - 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "startOfCurrentList U endOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * endOfCurrentList U startOfNextList = 2.63s
     */
    startTime = System.nanoTime();
    uf = new UnionFindOne(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j < n; ) {
        int startOfCurrentList = j;
        int endOfCurrentList = Math.min(
          (lengthOfList + startOfCurrentList - 1),
          n - 1
        );
        int startOfNextList = Math.min(
          (lengthOfList + startOfCurrentList),
          n - 1
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(endOfCurrentList, startOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n - 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "endOfCurrentList U startOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * endOfCurrentList U endOfNextList = 2.08s
     */
    startTime = System.nanoTime();
    uf = new UnionFindOne(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j < n; ) {
        int startOfCurrentList = j;
        int endOfCurrentList = Math.min(
          (lengthOfList + startOfCurrentList - 1),
          n - 1
        );
        int endOfNextList = Math.min(
          (lengthOfList * 2 + startOfCurrentList - 1),
          n - 1
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(endOfCurrentList, endOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n - 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n - 1, n - 1);
    }
    endTime = System.nanoTime();
    output = String.format(
      "endOfCurrentList U endOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * Back Choke - 2.48s
     */
    uf = new UnionFindOne(n);
    for (int i = n - 1; i > 0; i -= 1) {
      uf.union(i - 1, i);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(i, i);
    }
    endTime = System.nanoTime();
    output = String.format(
      "Back Choke = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);
  }

  @Test
  public void test() {
    // Take N = 5
    int n = 5;

    UnionFindOne uf = new UnionFindOne(n);
    assertEquals(4, uf.count());
    for (int i = 0; i < n; i += 1) {
      assertEquals(i, uf.getSetMax(i));
    }

    // Connect 0 & 1
    assertEquals(0, uf.getSetMax(0));
    assertEquals(1, uf.getSetMax(1));

    assertFalse(uf.connected(0, 1));
    uf.union(0, 1);
    assertTrue(uf.connected(0, 1));

    assertEquals(2, uf.children(0));
    assertEquals(1, uf.children(1));

    assertEquals(1, uf.getSetMax(0));
    assertEquals(1, uf.getSetMax(1));

    // Connect 2 & 3
    assertEquals(2, uf.getSetMax(2));
    assertEquals(3, uf.getSetMax(3));

    assertFalse(uf.connected(2, 3));
    uf.union(2, 3);
    assertTrue(uf.connected(2, 3));

    assertEquals(2, uf.children(2));
    assertEquals(1, uf.children(3));

    assertEquals(3, uf.getSetMax(2));
    assertEquals(3, uf.getSetMax(3));

    // Connect 1 & 3
    assertEquals(1, uf.getSetMax(0));
    assertEquals(1, uf.getSetMax(1));
    assertEquals(3, uf.getSetMax(2));
    assertEquals(3, uf.getSetMax(3));

    assertFalse(uf.connected(1, 3));
    uf.union(1, 3);
    assertEquals(1, uf.children(3));

    assertTrue(uf.connected(1, 3));
    assertEquals(1, uf.children(3));

    assertTrue(uf.connected(1, 3));
    assertTrue(uf.connected(3, 3));

    assertEquals(3, uf.getSetMax(0));
    assertEquals(3, uf.getSetMax(1));
    assertEquals(3, uf.getSetMax(2));
    assertEquals(3, uf.getSetMax(3));

    // children count
    assertEquals(4, uf.children(0));
    assertEquals(1, uf.children(1));
    assertEquals(1, uf.children(2));
    assertEquals(1, uf.children(3));
    assertEquals(1, uf.children(4));

    // parent check
    assertEquals(0, uf.parent(0));
    assertEquals(0, uf.parent(1));
    assertEquals(0, uf.parent(2));
    assertEquals(0, uf.parent(3));
    assertEquals(4, uf.parent(4));

    // max check
    assertEquals(3, uf.getSetMax(0));
    assertEquals(3, uf.getSetMax(1));
    assertEquals(3, uf.getSetMax(2));
    assertEquals(3, uf.getSetMax(3));
    assertEquals(4, uf.getSetMax(4));

    loadTest();
  }
}