package mayasage.algorithms.princeton.one.bitonic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitonicArrayOneTest {
  @Test
  void bitonicArray() {
    assertEquals(
      -1,
      BitonicArrayOne.bitonicArray(new int[]{1}, 2)
    );

    assertEquals(
      -1, // not a bitonic array
      BitonicArrayOne.bitonicArray(new int[]{1, 2}, 2)
    );

    assertEquals(
      1,
      BitonicArrayOne.bitonicArray(new int[]{1, 2, 1}, 2)
    );

    assertEquals(
      1,
      BitonicArrayOne.bitonicArray(new int[]{1, 2, 3, 2, 1}, 2)
    );

    assertEquals(
      1,
      BitonicArrayOne.bitonicArray(new int[]{1, 10, 50, 20, 1}, 10)
    );

    assertEquals(
      2,
      BitonicArrayOne.bitonicArray(new int[]{1, 10, 50, 20, 1}, 50)
    );

    assertEquals(
      3,
      BitonicArrayOne.bitonicArray(new int[]{1, 10, 50, 20, 1}, 20)
    );

    assertEquals(
      0,
      BitonicArrayOne.bitonicArray(new int[]{1, 10, 50, 20, 1}, 1)
    );

    assertEquals(
      4,
      BitonicArrayOne.bitonicArray(new int[]{0, 10, 50, 20, 1}, 1)
    );
  }
}
