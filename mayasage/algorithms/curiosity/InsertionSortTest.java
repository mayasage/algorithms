package mayasage.algorithms.curiosity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
  @Test
  public void test() {
    int[] test;
    int[] sorted;

    // ReturnNewArray

    test = new int[1];
    sorted = InsertionSort.returnNewArray(test);
    assertArrayEquals(new int[]{0}, sorted);

    test = new int[1];
    test[0] = 1;
    sorted = InsertionSort.returnNewArray(test);
    assertArrayEquals(new int[]{1}, sorted);

    test = new int[2];
    test[0] = 1;
    sorted = InsertionSort.returnNewArray(test);
    assertArrayEquals(new int[]{0, 1}, sorted);

    test = new int[2];
    test[1] = 1;
    sorted = InsertionSort.returnNewArray(test);
    assertArrayEquals(new int[]{0, 1}, sorted);

    test = new int[5];
    test[0] = 4;
    test[1] = 3;
    test[2] = 0;
    test[3] = 2;
    test[4] = 1;
    sorted = InsertionSort.returnNewArray(test);
    assertArrayEquals(new int[]{0,1,2,3,4}, sorted);

    // SortInPlace

    test = new int[1];
    InsertionSort.sortInPlace(test);
    assertArrayEquals(new int[]{0}, test);

    test = new int[1];
    test[0] = 1;
    InsertionSort.sortInPlace(test);
    assertArrayEquals(new int[]{1}, test);

    test = new int[2];
    test[0] = 1;
    InsertionSort.sortInPlace(test);
    assertArrayEquals(new int[]{0, 1}, test);

    test = new int[2];
    test[1] = 1;
    InsertionSort.sortInPlace(test);
    assertArrayEquals(new int[]{0, 1}, test);

    test = new int[5];
    test[0] = 4;
    test[1] = 3;
    test[2] = 0;
    test[3] = 2;
    test[4] = 1;
    InsertionSort.sortInPlace(test);
    assertArrayEquals(new int[]{0,1,2,3,4}, test);
  }
}