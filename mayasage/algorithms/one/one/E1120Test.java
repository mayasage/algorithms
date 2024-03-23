package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E1120Test {
  private static void testInput(int n, int output) {
    double res = E1120.run(n);
    assertEquals(output, (int) res);
  }

  @Test
  public void test() {
    testInput(4, 4);
    testInput(10, 21);
    testInput(0, 0);
    testInput(1, 0);
    testInput(2, 1);
  }
}
