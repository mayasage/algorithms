/**
 * E1111:
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using * to represent true and a space to represent false. Include row
 * and column numbers.
 */

package mayasage.algorithms.one.one;

public class E1111 {
  public static void run(boolean[][] array) {
    System.out.println("  1 2");
    for (int row = 0; row < 2; row += 1) {
      System.out.print(row + 1 + " ");
      for (int col = 0; col < 2; col += 1) {
        boolean el = array[row][col];
        if (el) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        if (col != 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
