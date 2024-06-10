package mayasage.algorithms.princeton.one.BitonicArray;

public class BinarySearchBitonicPeak {
  /**
   * @param array Expects a bitonic array.
   */
  public static int search(int[] array, int left, int right) {
    int n = array.length;
    if (n == 0) return -1;
    if (left < 0 || right >= n) return -1;
    if (right - left + 1 < 3) return -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int midVal = array[mid];

      if (mid - 1 < 0) {
        // "mid" is the first value.
        // So, it can't be a peak.
        left = mid + 1;
        continue;
      }

      if (mid + 1 == n) {
        // "mid" is the last value.
        // So, it can't be a peak.
        right = mid - 1;
        continue;
      }

      int leftVal = array[mid - 1];
      int rightVal = array[mid + 1];

      if (midVal > leftVal && midVal > rightVal) {
        // Is a peak.
        return mid;
      }

      // midVal is not a peak

      if (midVal >= leftVal) {
        // midVal is in ascending part.
        // So, peak is to the right.
        left = mid + 1;
      } else {
        // midVal is in descending part.
        // So, peak is to the left.
        right = mid - 1;
      }
    }

    return -1;
  }

  public static int search(int[] array) {
    return search(array, 0, array.length - 1);
  }
}
