package mayasage.algorithms.utils;

public class BinarySearchAscending {
  public static int search(int[] array, int left, int right, int value) {
    int n = array.length;
    if (n == 0) return -1;
    if (left < 0 || right >= n) return -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int midVal = array[mid];

      if (midVal == value) {
        return mid;
      }

      // Ascending array means higher on right, lower on left.
      if (midVal < value) {
        // Go right
        left = mid + 1;
      } else {
        // Go left
        right = mid - 1;
      }
    }

    return -1;
  }

  public static int search(int[] array, int value) {
    return search(array, 0, array.length - 1, value);
  }
}
