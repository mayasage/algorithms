package mayasage.algorithms.princeton.one.bitonic_array;

import mayasage.algorithms.utils.BinarySearchAscending;
import mayasage.algorithms.utils.BinarySearchDescending;

public class BitonicArrayOne {
  public static int bitonicArray(int[] array, int target) {
    int n = array.length;
    if (n < 3) return -1;

    // Find peak in ~ lg(N)
    int peak = BinarySearchBitonicPeak.search(array);
    if (peak == -1) return -1;
    if (array[peak] == target) return peak;

    // Find target in 0 to (peak - 1) in ~ lg(N)
    int left = BinarySearchAscending.search(
      array,
      0,
      peak - 1,
      target
    );
    if (left >= 0) return left;

    // Find target in (peak + 1) to (n - 1) in ~ lg(N)
    int right = BinarySearchDescending.search(
      array,
      peak + 1,
      n - 1,
      target
    );
    if (right >= 0) return right;

    // Thus Total Time Complexity = ~ 3 lg(N)

    return -1;
  }
}
