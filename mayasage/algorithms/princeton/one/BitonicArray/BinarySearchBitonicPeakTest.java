package mayasage.algorithms.princeton.one.BitonicArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchBitonicPeakTest {
  @Test
  void search() {
    assertEquals(-1, BinarySearchBitonicPeak.search(new int[]{1}));
    assertEquals(-1, BinarySearchBitonicPeak.search(new int[]{1, 2}));

    assertEquals(
      -1,
      BinarySearchBitonicPeak.search(new int[]{1, 2, 3})
    );

    assertEquals(
      2,
      BinarySearchBitonicPeak.search(new int[]{1, 2, 3, 1})
    );

    assertEquals(
      1,
      BinarySearchBitonicPeak.search(new int[]{1, 2, 1})
    );

    assertEquals(
      -1,
      BinarySearchBitonicPeak.search(new int[]{1, 1, 1})
    );
  }
}