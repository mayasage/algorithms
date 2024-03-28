package mayasage.algorithms.curiosity;

public class BinaryInsertionSort {
  private static int binarySearch(int[] numbers, int start, int end, int val) {
    if (start > end) {
      return start;
    }

    int mid = (int) Math.floor((double) (start + end) / 2);
    int midVal = numbers[mid];

    if (midVal == val) {
      return mid;
    } else if (midVal > val) { // go left
      return binarySearch(numbers, start, mid - 1, val);
    } else { // go right
      return binarySearch(numbers, mid + 1, end, val);
    }
  }

  public static int[] returnNewArray(int[] numbers) {
    int[] sorted = new int[numbers.length];

    for (int inserted = 0; inserted < numbers.length; inserted += 1) {
      int el = numbers[inserted];

      int curPos = binarySearch(sorted, 0, inserted - 1, el);

      /*
       * Shift to right
       *
       * Here I'm doing <= inserted.
       * Why ?
       *
       * Imagine this:
       *
       * Before Insertion = [ 1, 3 ]
       * After Insertion = [ 1, 2, 3 ]
       *
       * Here,
       * el = 2
       * insertion = 2 because it's the 3rd element in the given numbers array
       * (0 based index of course)
       *
       * Before insertion, there are only 2 elements in the sorted array (0, 1).
       * So, after insertion, another element will be added into the sorted
       * array, right ?
       * Good, then the total number of element will become 3.
       *
       * What is 3 here ?
       * 3 is the length of the new array, but what is the actual index of
       * the 3rd element ?
       * It's (3 - 1) because we're using 0-based index.
       * It's exactly same as how we say "length of array = N", but the
       * "actual index = (0, N-1)"
       *
       * The (N - 1) there is the (3 - 1) here.
       * And what's (3 - 1) ?
       * It's "inserted".
       *
       * So, the last element of our sorted list (whose length went from 2 to
       * 3) went from (2 - 1 = 1) to (3 - 1 = 2 <- this is inserted).
       */
      int hovering = el;
      while (curPos <= inserted) {
        int temp = sorted[curPos];
        sorted[curPos] = hovering;
        hovering = temp;
        curPos += 1;
      }
    }

    return sorted;
  }

  static void sortInPlace(int[] numbers) {
    for (int inserted = 0; inserted < numbers.length; inserted += 1) {
      int el = numbers[inserted];

      int curPos = binarySearch(numbers, 0, inserted - 1, el);

      /*
       * Shift to right
       *
       * Here I'm doing <= inserted.
       * Why ?
       *
       * Imagine this:
       *
       * Before Insertion = [ 1, 3 ]
       * After Insertion = [ 1, 2, 3 ]
       *
       * Here,
       * el = 2
       * insertion = 2 because it's the 3rd element in the given numbers array
       * (0 based index of course)
       *
       * Before insertion, there are only 2 elements in the sorted array (0, 1).
       * So, after insertion, another element will be added into the sorted
       * array, right ?
       * Good, then the total number of element will become 3.
       *
       * What is 3 here ?
       * 3 is the length of the new array, but what is the actual index of
       * the 3rd element ?
       * It's (3 - 1) because we're using 0-based index.
       * It's exactly same as how we say "length of array = N", but the
       * "actual index = (0, N-1)"
       *
       * The (N - 1) there is the (3 - 1) here.
       * And what's (3 - 1) ?
       * It's "inserted".
       *
       * So, the last element of our sorted list (whose length went from 2 to
       * 3) went from (2 - 1 = 1) to (3 - 1 = 2 <- this is inserted).
       */
      int hovering = el;
      while (curPos <= inserted) {
        int temp = numbers[curPos];
        numbers[curPos] = hovering;
        hovering = temp;
        curPos += 1;
      }
    }
  }
}
