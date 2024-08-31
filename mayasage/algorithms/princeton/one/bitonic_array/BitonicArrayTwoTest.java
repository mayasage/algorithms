package mayasage.algorithms.princeton.one.bitonic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitonicArrayTwoTest {
  void testA(int[] a, boolean nf) {
    for (int i = 0; i < a.length; i += 1) {
      int v = nf ? Integer.MAX_VALUE : a[i];
      assertEquals(nf ? -1 : i, new BitonicArrayTwo(v, a).find());
    }
  }

  void testA(int[] a) {
    testA(a, false);
  }

  @Test
  void targetFound() {
    testA(new int[]{1});
    testA(new int[]{0, 10, 20, 50, 30, 25, 5});
  }

  @Test
  void targetNotFound() {
    testA(new int[]{1}, true);
    testA(new int[]{0, 10, 20, 50, 30, 25, 5}, true);
  }

  @Test
  void emptyArray() {
    assertEquals(
      -1,
      new BitonicArrayTwo(-1, new int[]{}).find()
    );
  }
}
