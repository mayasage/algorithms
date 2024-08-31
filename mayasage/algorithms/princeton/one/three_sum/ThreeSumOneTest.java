package mayasage.algorithms.princeton.one.three_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumOneTest {
  @Test
  public void test() {
    // throw error
    for (int i = 0; i < 3; i += 1) {
      final int _i = i;
      assertThrows(RuntimeException.class, () ->
        ThreeSumOne.run(new int[_i], 69)
      );
    }

    // simple no
    assertArrayEquals(
      new int[]{-1, -1, -1},
      ThreeSumOne.run(new int[]{1, 2, 3, 4}, 69)
    );

    // simple yes
    assertArrayEquals(
      new int[]{0, 2, 4},
      ThreeSumOne.run(new int[]{1, 2, 3, 4, 5}, 9)
    );
    assertArrayEquals(
      new int[]{0, 2, 4},
      ThreeSumOne.run(new int[]{2, 3, 4, 1, 5}, 9)
    );

    // edging
    assertArrayEquals(
      new int[]{0, 1, 2},
      ThreeSumOne.run(new int[]{1, 1, 1}, 3)
    );
    assertArrayEquals(
      new int[]{0, 1, 2},
      ThreeSumOne.run(new int[]{-1, -1, -1}, -3)
    );
    assertArrayEquals(
      new int[]{0, 1, 2},
      ThreeSumOne.run(new int[]{-1, -1, 1}, -1)
    );
    assertArrayEquals(
      new int[]{0, 1, 2},
      ThreeSumOne.run(new int[]{0, -1, 0}, -1)
    );
    assertArrayEquals(
      new int[]{0, 1, 2},
      ThreeSumOne.run(new int[]{0, 0, 0}, 0)
    );
  }
}