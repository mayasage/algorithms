/**
 * E1113:
 * Write a code fragment to print the transposition (rows and columns changed)
 * of a two-dimensional array with M rows and N columns.
 */

package mayasage.algorithms.one.one;

public class E1113 {
  /**
   * @util
   */
//  public static void printMatrix(int[][] array) {
//    for (int[] rows : array) {
//      for (int col : rows) {
//        System.out.print(col + " ");
//      }
//      System.out.println();
//    }
//  }

  public static int[][] run(int[][] array, int m, int n) {
    int[][] res = new int[n][m];

    for (int row = 0; row < n; row += 1) {
      for (int col = 0; col < m; col += 1) {
        res[row][col] = array[col][row];
      }
    }

    return res;
  }
}
