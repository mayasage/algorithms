package mayasage.algorithms.princeton.one.union_find;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindFiveTest {
  @Test
  public void test() {
    // Take N = 5
    UnionFindFive uf = new UnionFindFive(5);
    assertEquals(5, uf.count());

    // Connect 1 & 2
    assertFalse(uf.connected(1, 2));
    uf.union(1, 2);
    assertTrue(uf.connected(1, 2));

    // Connect 3 & 4
    assertFalse(uf.connected(3, 4));
    uf.union(3, 4);
    assertTrue(uf.connected(3, 4));

    // Connect 2 & 4
    assertFalse(uf.connected(2, 4));
    uf.union(2, 4);
    assertTrue(uf.connected(2, 4));

    assertTrue(uf.connected(1, 4));
    assertTrue(uf.connected(3, 4));

    // parent check
    assertEquals(1, uf.find(1));
    assertEquals(1, uf.find(2));
    assertEquals(1, uf.find(3));
    assertEquals(1, uf.find(4));
    assertEquals(5, uf.find(5));

    /*
     * None of the previous choking will work here.
     * Watch.
     */

    int n = 900_000_000;
    long startTime;
    long endTime;
    String output;

    /*
     * Front Choke - 1.02s
     */
    startTime = System.nanoTime();
    uf = new UnionFindFive(n);
    for (int i = 1; i < n; i += 1) {
      uf.union(i, i + 1);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n, n);
    }
    endTime = System.nanoTime();
    output = String.format(
      "Front Choke = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * Back Choke - 2.48s
     */
    uf = new UnionFindFive(n);
    for (int i = n; i > 1; i -= 1) {
      uf.union(i - 1, i);
    }
    for (int i = 0; i < n; i += 1) {
      uf.connected(n, n);
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
     * startOfCurrentList U startOfNextList = 1.31s
     */
    startTime = System.nanoTime();
    uf = new UnionFindFive(n);
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j <= n; ) {
        int startOfCurrentList = j;
        int startOfNextList = Math.min(
          (lengthOfList + startOfCurrentList),
          n
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(startOfCurrentList, startOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n);
    }
    for (int i = 1; i <= n; i += 1) {
      uf.connected(n, n);
    }
    endTime = System.nanoTime();
    output = String.format(
      "startOfCurrentList U startOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * startOfCurrentList U endOfNextList = 1.89s
     */
    startTime = System.nanoTime();
    uf = new UnionFindFive(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j <= n; ) {
        int startOfCurrentList = j;
        int endOfNextList = Math.min(
          (lengthOfList * 2 + startOfCurrentList - 1),
          n
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(startOfCurrentList, endOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n);
    }
    for (int i = 1; i <= n; i += 1) {
      uf.connected(n, n);
    }
    endTime = System.nanoTime();
    output = String.format(
      "startOfCurrentList U endOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * endOfCurrentList U startOfNextList = 1.88s
     */
    startTime = System.nanoTime();
    uf = new UnionFindFive(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j <= n; ) {
        int startOfCurrentList = j;
        int endOfCurrentList = Math.min(
          (lengthOfList + startOfCurrentList - 1),
          n
        );
        int startOfNextList = Math.min(
          (lengthOfList + startOfCurrentList),
          n
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(endOfCurrentList, startOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n);
    }
    for (int i = 1; i <= n; i += 1) {
      uf.connected(n, n);
    }
    endTime = System.nanoTime();
    output = String.format(
      "endOfCurrentList U startOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
     * endOfCurrentList U endOfNextList = 1.74s
     */
    startTime = System.nanoTime();
    uf = new UnionFindFive(n);
    lengthOfList = 1;
    for (int i = 0; i <= l; i += 1) {
      for (int j = 0; j <= n; ) {
        int startOfCurrentList = j;
        int endOfCurrentList = Math.min(
          (lengthOfList + startOfCurrentList - 1),
          n
        );
        int endOfNextList = Math.min(
          (lengthOfList * 2 + startOfCurrentList - 1),
          n
        );
        int startOfNextToNextList = (lengthOfList * 2 + startOfCurrentList);
        uf.union(endOfCurrentList, endOfNextList);
        j = startOfNextToNextList;
      }
      lengthOfList = Math.min(lengthOfList * 2, n);
    }
    for (int i = 1; i <= n; i += 1) {
      uf.connected(n, n);
    }
    endTime = System.nanoTime();
    output = String.format(
      "endOfCurrentList U endOfNextList = %.2f s",
      (endTime - startTime) * 1e-9
    );
    System.out.println(output);

    /*
      Results - Four Vs Five

      N = 199_999_999

      Five

      Front Choke = 1.94 s
      Back Choke = 4.79 s
      startOfCurrentList U startOfNextList = 2.47 s
      startOfCurrentList U endOfNextList = 2.81 s
      endOfCurrentList U startOfNextList = 3.61 s
      endOfCurrentList U endOfNextList = 3.37 s

      Four

      Front Choke = 2.53 s
      Back Choke = 4.62 s
      startOfCurrentList U startOfNextList = 3.16 s
      startOfCurrentList U endOfNextList = 3.60 s
      endOfCurrentList U startOfNextList = 4.62 s
      endOfCurrentList U endOfNextList = 3.91 s

      N = 299_999_999

      Five

      Front Choke = 2.90 s
      Back Choke = 7.22 s
      startOfCurrentList U startOfNextList = 3.91 s
      startOfCurrentList U endOfNextList = 5.23 s
      endOfCurrentList U startOfNextList = 5.36 s
      endOfCurrentList U endOfNextList = 5.05 s

      Four

      Front Choke = 3.55 s
      Back Choke = 6.64 s
      startOfCurrentList U startOfNextList = 4.84 s
      startOfCurrentList U endOfNextList = 5.97 s
      endOfCurrentList U startOfNextList = 6.92 s
      endOfCurrentList U endOfNextList = 5.94 s

      N = 399_999_999

      Five

      Front Choke = 3.85 s
      Back Choke = 9.53 s
      startOfCurrentList U startOfNextList = 4.80 s
      startOfCurrentList U endOfNextList = 5.66 s
      endOfCurrentList U startOfNextList = 7.22 s
      endOfCurrentList U endOfNextList = 6.66 s

      Front Choke = 3.88 s
      Back Choke = 9.74 s
      startOfCurrentList U startOfNextList = 4.82 s
      startOfCurrentList U endOfNextList = 5.69 s
      endOfCurrentList U startOfNextList = 7.32 s
      endOfCurrentList U endOfNextList = 6.87 s
      Back Choke = 10.59 s

      Four

      Front Choke = 4.57 s
      Back Choke = 8.63 s
      startOfCurrentList U startOfNextList = 6.36 s
      startOfCurrentList U endOfNextList = 7.96 s
      endOfCurrentList U startOfNextList = 9.15 s
      endOfCurrentList U endOfNextList = 8.04 s

      Front Choke = 5.13 s
      Back Choke = 9.45 s
      startOfCurrentList U startOfNextList = 6.60 s
      startOfCurrentList U endOfNextList = 8.26 s
      endOfCurrentList U startOfNextList = 9.14 s
      endOfCurrentList U endOfNextList = 7.83 s
      Back Choke = 11.43 s

      499_999_999

      Five

      Front Choke = 4.96 s
      Back Choke = 12.21 s
      startOfCurrentList U startOfNextList = 6.38 s
      startOfCurrentList U endOfNextList = 8.55 s
      endOfCurrentList U startOfNextList = 9.30 s
      endOfCurrentList U endOfNextList = 8.60 s
      Back Choke = 13.26 s

      900_000_000

      Five

      Front Choke = 8.88 s
      Back Choke = 21.36 s
      startOfCurrentList U startOfNextList = 11.14 s
      startOfCurrentList U endOfNextList = 15.37 s
      endOfCurrentList U startOfNextList = 15.92 s
      endOfCurrentList U endOfNextList = 14.99 s
      Back Choke = 23.35 s

      Total = 1 min 27 sec

      Four

      Heap overflow

      400_000_000

      Five

      Front Choke = 3.84 s
      Back Choke = 9.75 s
      startOfCurrentList U startOfNextList = 5.15 s
      startOfCurrentList U endOfNextList = 7.23 s
      endOfCurrentList U startOfNextList = 7.36 s
      endOfCurrentList U endOfNextList = 6.86 s
      Back Choke = 10.57 s

      Four

      Front Choke = 4.58 s
      Back Choke = 8.60 s
      startOfCurrentList U startOfNextList = 6.29 s
      startOfCurrentList U endOfNextList = 6.95 s
      endOfCurrentList U startOfNextList = 9.24 s
      endOfCurrentList U endOfNextList = 7.85 s
      Back Choke = 11.43 s

      N = 399_999_999 * 10

      Five
      5 min 35 s

      Four
      6 min 45 s

      Five is faster than 4 for some reason, even though it should've been the
      reverse.

      I'm hoping that Five will beat for when set is more than a billion because
      log*N will be constant, but logN will not be.
   */

    /*
     * Back Choke - 2.48s
     */
    uf = new UnionFindFive(n);
    for (int i = n; i > 1; i -= 1) {
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
}
