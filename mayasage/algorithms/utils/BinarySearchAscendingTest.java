package mayasage.algorithms.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchAscendingTest {
  @Test
  void search() {
    int[] arr;

    assertEquals(BinarySearchAscending.search(new int[]{}, 0), -1);

    arr = new int[]{1};
    assertEquals(BinarySearchAscending.search(arr, 0), -1);
    assertEquals(BinarySearchAscending.search(arr, 1), 0);
    assertEquals(BinarySearchAscending.search(arr, 2), -1);

    arr = new int[]{1, 2, 3, 4};
    assertEquals(BinarySearchAscending.search(arr, 5), -1);
    assertEquals(BinarySearchAscending.search(arr, 1), 0);
    assertEquals(BinarySearchAscending.search(arr, 2), 1);
    assertEquals(BinarySearchAscending.search(arr, 3), 2);
    assertEquals(BinarySearchAscending.search(arr, 4), 3);

    // Partial low, high
    arr = new int[]{1, 2, 3, 4};
    assertEquals(
      BinarySearchAscending.search(arr, 0, 0, 1),
      0
    );
    assertEquals(
      BinarySearchAscending.search(arr, 1, 1, 2),
      1
    );
    assertEquals(
      BinarySearchAscending.search(arr, 2, 2, 3),
      2
    );
    assertEquals(
      BinarySearchAscending.search(arr, 3, 3, 4),
      3
    );
    // Fail
    assertEquals(
      BinarySearchAscending.search(arr, 1, 1, -1),
      -1
    );
    assertEquals(
      BinarySearchAscending.search(arr, 2, 2, -1),
      -1
    );
    assertEquals(
      BinarySearchAscending.search(arr, 3, 3, -1),
      -1
    );
    assertEquals(
      BinarySearchAscending.search(arr, 4, 4, -1),
      -1
    );
  }
}