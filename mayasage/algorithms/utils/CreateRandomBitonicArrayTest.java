package mayasage.algorithms.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CreateRandomBitonicArrayTest {
  @Test
  void get() {
    for (int i = 0; i < 1_00_000; i += 1) {
      int[] arr = new CreateRandomBitonicArray(100, 100).get();
      Set<Integer> seen = new HashSet<>();
      for (int v : arr) {
        assertFalse(seen.contains(v));
        seen.add(v);
      }
    }
  }
}