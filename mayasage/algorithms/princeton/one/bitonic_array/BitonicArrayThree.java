package mayasage.algorithms.princeton.one.bitonic_array;

import mayasage.algorithms.utils.BinarySearchAscending;
import mayasage.algorithms.utils.BinarySearchDescending;

public class BitonicArrayThree {
  private static int bitonicRecursiveSearch(int[] array, int start, int end,
                                            int target) {
    int n = array.length;
    if (start > end) return -1;

    int mid = (start + end) / 2;
    int midVal = array[mid];
    if (midVal == target) return mid;

    // If mid is Peak...
    boolean isPeak = (
      mid - 1 >= 0 &&                 // is not first element
        mid + 1 < n &&                // is not last element
        midVal >= array[mid - 1] &&   // is greater than the previous element
        midVal >= array[mid + 1]      // is greater than the next element
    );
    if (isPeak) {
      // Binary Search Ascending on the Left...
      int left = BinarySearchAscending.search(array, start, mid - 1, target);
      if (left >= 0) return left;

      // Binary Search Descending on the Right...
      int right = BinarySearchDescending.search(array, mid + 1, end, target);
      if (right >= 0) return right;

      // And we're done.
      return -1;
    }

    // mid is not a Peak

    // If mid is in Ascending part...
    boolean isInAsc = (
      mid - 1 >= 0 &&             // is not the first element
        midVal >= array[mid - 1]  // is greater than the previous element
    );
    if (isInAsc) {
      int leftVal = array[mid - 1];

      if (target > leftVal) {
        // Target cannot be on the left.
        return bitonicRecursiveSearch(array, mid + 1, end, target);
      } else {
        // Target can be on the either left or right.

        // Bitonic Search on the Left...
        int left = bitonicRecursiveSearch(array, start, mid - 1, target);
        if (left >= 0) return left;

        // Bitonic Search on the Right...
        int right = bitonicRecursiveSearch(array, mid + 1, end, target);
        if (right >= 0) return right;
      }

      return -1;
    }

    // mid is not peek
    // min is not in Asc

    // If mid is in Descending part...
    boolean isInDesc = (
      mid - 1 >= 0 &&             // is not the first element
        midVal <= array[mid - 1]  // is smaller than the previous element
    );
    if (isInDesc) {
      int rightVal = array[mid + 1];

      if (target > rightVal) {
        // Target cannot be on the right.
        return bitonicRecursiveSearch(array, start, mid - 1, target);
      } else {
        // Target can be on the either left or right.

        // Bitonic Search on the Left...
        int left = bitonicRecursiveSearch(array, start, mid - 1, target);
        if (left >= 0) return left;

        // Bitonic Search on the Right...
        int right = bitonicRecursiveSearch(array, mid + 1, end, target);
        if (right >= 0) return right;
      }
    }

    return -1;
  }

  public static int bitonicArray(int[] array, int start, int end, int target) {
    int n = array.length;
    if (n < 3) return -1;

    return bitonicRecursiveSearch(array, start, end, target);
  }

  public static int bitonicArray(int[] array, int target) {
    return bitonicArray(array, 0, array.length - 1, target);
  }
}
