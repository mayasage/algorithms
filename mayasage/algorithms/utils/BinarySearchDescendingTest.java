package mayasage.algorithms.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchDescendingTest {
  @Test
  void search() {
    int[] arr;

    assertEquals(BinarySearchDescending.search(new int[]{}, 0), -1);

    arr = new int[]{1};
    assertEquals(BinarySearchDescending.search(arr, 0), -1);
    assertEquals(BinarySearchDescending.search(arr, 1), 0);
    assertEquals(BinarySearchDescending.search(arr, 2), -1);

    arr = new int[]{4, 3, 2, 1};
    assertEquals(BinarySearchDescending.search(arr, 5), -1);
    assertEquals(BinarySearchDescending.search(arr, 1), 3);
    assertEquals(BinarySearchDescending.search(arr, 2), 2);
    assertEquals(BinarySearchDescending.search(arr, 3), 1);
    assertEquals(BinarySearchDescending.search(arr, 4), 0);

    // Partial low, high
    arr = new int[]{4, 3, 2, 1};
    assertEquals(
      BinarySearchDescending.search(arr, 3, 3, 1),
      3
    );
    assertEquals(
      BinarySearchDescending.search(arr, 2, 2, 2),
      2
    );
    assertEquals(
      BinarySearchDescending.search(arr, 1, 1, 3),
      1
    );
    assertEquals(
      BinarySearchDescending.search(arr, 0, 0, 4),
      0
    );
    // Fail
    assertEquals(
      BinarySearchDescending.search(arr, 1, 1, -1),
      -1
    );
    assertEquals(
      BinarySearchDescending.search(arr, 2, 2, -1),
      -1
    );
    assertEquals(
      BinarySearchDescending.search(arr, 3, 3, -1),
      -1
    );
    assertEquals(
      BinarySearchDescending.search(arr, 4, 4, -1),
      -1
    );
  }
}