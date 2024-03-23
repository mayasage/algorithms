package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E1114Test {
  private static void testInput(int n, int base, int output) {
    int res = E1114.run(n,base);
    assertEquals(output, res);
  }

  @Test
  public void test() {
    testInput(7, 2, 2);
    testInput(8, 2, 3);
    testInput(69, 3, 3);
    testInput(699, 10, 2);
    testInput(0, 10, -1);
  }
}