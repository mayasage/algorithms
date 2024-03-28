package mayasage.algorithms.curiosity;

public class InsertionSort {
  static int[] returnNewArray(int[] numbers) {
    int[] sorted = new int[numbers.length];

    for (int inserted = 0; inserted < numbers.length; inserted += 1) {
      int el = numbers[inserted];

      // Find position in list
      int curPos = 0;
      while (curPos < inserted && sorted[curPos] <= el) {
        curPos += 1;
      }

      // Shift to right
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

      // Find position

      int curPos = 0;
      while (curPos < inserted && numbers[curPos] <= el) {
        curPos += 1;
      }

      // Shift to right
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
