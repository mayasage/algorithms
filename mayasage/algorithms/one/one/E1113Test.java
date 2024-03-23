package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class E1113Test {
  private static void testInput(int[][] input, int rowCount,
                                int colCount, int[][] output) {
    int[][] res = E1113.run(input, rowCount, colCount);
    Assertions.assertArrayEquals(output, res);
  }

  @Test
  public void test() {
    testInput(
      new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
      },
      3,
      3,
      new int[][]{
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
      }
    );

    testInput(
      new int[][]{
        {2, 13},
        {-9, 11},
        {3, 17},
      },
      3,
      2,
      new int[][]{
        {2, -9, 3},
        {13, 11, 17},
      }
    );

    testInput(
      new int[][]{
        {1, 2, 3},
        {4, 5, 6},
      },
      2,
      3,
      new int[][]{
        {1, 4},
        {2, 5},
        {3, 6},
      }
    );

    testInput(
      new int[][]{
        {1},
      },
      1,
      1,
      new int[][]{
        {1},
      }
    );
  }
}