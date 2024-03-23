package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class E1115Test {
  private static void testInput(int[] a, int m, int[] output) {
    int[] res = E1115.run(a, m);
    assertArrayEquals(output, res);
  }

  @Test
  public void test() {
    testInput(new int[]{1, 2, 3}, 2, new int[]{0, 1});
    testInput(new int[]{0, 1, 2, 3}, 2, new int[]{1, 1});
    testInput(new int[]{0, 1, 2, 3}, 3, new int[]{1, 1, 1});
    testInput(new int[]{0}, 2, new int[]{1, 0});
    testInput(new int[]{0}, 3, new int[]{1, 0, 0});
  }
}
