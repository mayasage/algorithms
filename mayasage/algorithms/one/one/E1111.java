/**
 * E1111:
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using * to represent true and a space to represent false. Include row
 * and column numbers.
 */

package mayasage.algorithms.one.one;

public class E1111 {
  public static void run(boolean[][] array) {
    int rowCount = array.length;
    int colCount = 0;
    for (boolean[] row : array) {
      colCount = Math.max(colCount, row.length);
    }

    // Print first row
    System.out.print("  ");
    for (int i = 0; i < colCount; i += 1) {
      System.out.print(i + 1);

      // don't print " " after last element in row
      if (i != colCount - 1) {
        System.out.print(" ");
      }
    }
    System.out.println();

    // Print rest of the rows
    for (int row = 0; row < rowCount; row += 1) {
      int currentColCount = array[row].length;
      System.out.print(row + 1 + " ");

      for (int col = 0; col < currentColCount; col += 1) {
        boolean el = array[row][col];
        System.out.print(el ? "*" : " ");

        // don't print " " after last element in row
        if (col != currentColCount - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
