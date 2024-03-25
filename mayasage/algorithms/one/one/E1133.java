/*
 * E1133:
 * Matrix library. Write a library Matrix that implements the following API:
 * public class Matrix
 * static   double      dot(double[] x, double[] y)       vector dot product
 * static   double[][]  mult(double[][] a, double[][] b)  matrix-matrix product
 * static   double[][]  transpose(double[][] a)           transpose
 * static   double[]    mult(double[][] a, double[] x)    matrix-vector product
 * static   double[]    mult(double[] y, double[][] a)    vector-matrix product
 * </table>
 */

package mayasage.algorithms.one.one;

public class E1133 {
  /*
   * Imagine [1 2 3] . [1
   *                    2
   *                    3]
   *
   * Res = (1*1) + (2*2) + (3*3)
   */
  public static double dot(double[] x, double[] y) {
    int n = x.length;
    if (n != y.length) throw new RuntimeException("Vector length not equal.");

    double sum = 0;

    for (int i = 0; i < n; i += 1) {
      sum += x[i] * y[i];
    }

    return sum;
  }

  /*
   * a = matrix a
   * b = matrix b
   * r = row count
   * c = col count
   *
   * Imagine:
   *
   * matrix 'a'     matrix 'b'
   * [              [
   *   [ 1 2 ]    .   [ 5 6 7 ]
   *   [ 3 4 ]        [ 7 8 9 ]
   * ]              ]
   * (2 * 2)        (2 * 3)
   * (m * n)        (n * o)
   *
   * Res: (2 * 3)
   *      (m * o)
   *
   * [
   *   (1*5)+(2*7) (1*6)+(2*8) (1*7)+(2*9)
   *   (3*5)+(4*7) (3*6)+(4*8) (3*7)+(4*9)
   * ]
   *
   * Try converting the above calculation into positional calculation like
   * this:
   * (1 * 5) = (a[0][0] * b[0][0])
   * (2 * 7) = (a[0][1] * b[1][0])
   *
   * After writing this for every element, see that every element in matrix 'a'
   * is getting used multiple times in multiple calculations.
   *
   * So, select every element in matrix 'a' one-by-one and use it in every
   * calculation.
   *
   * At the end, result array will be complete.
   *
   * Thinking with examples in the above case, lead to the generation of this
   * formula:
   *
   * for row = 0 -> row of matrix 'a'
   *   for col = 0 -> col of matrix 'a'
   *     elA = a[row][col];
   *     for i = 0 -> column of matrix 'b'
   *       res[row][i] += elA * b[col][i];
   *
   * Dry run was successful in multiple cases.
   */
  public static double[][] mult(double[][] a, double[][] b) {
    int ar = a.length;
    int ac = a[0].length;
    int br = b.length;
    int bc = b[0].length;

    if (ac != br) {
      throw new RuntimeException("columns of matrix 'a' must be equal to rows " +
        "in matrix 'b'");
    }

    double[][] res = new double[ar][bc];

    for (int row = 0; row < ar; row += 1) {
      for (int col = 0; col < ac; col += 1) {
        double el = a[row][col]; // just select every element in matrix 'a'

        // Now perform all operations that have to be performed using that
        // element.
        for (int i = 0; i < bc; i += 1) {
          res[row][i] += el * b[col][i];
        }
      }
    }

    return res;
  }

  /*
   * Imagine:
   * [
   *   [ 1 2 6 ]
   *   [ 3 4 7 ]
   * ]
   * (2 * 3)
   * (m * n)
   *
   * Transpose (Just reverse rows & columns.)
   *
   * (3 * 2)
   * [
   *   [ 1 3 ]
   *   [ 2 4 ]
   *   [ 6 7 ]
   * ]
   */
  public static double[][] transpose(double[][] a) {
    int m = a.length;
    int n = a[0].length;

    double[][] res = new double[n][m];

    for (int row = 0; row < m; row += 1) {
      for (int col = 0; col < n; col += 1) {
        double el = a[row][col];
        res[col][row] = el;
      }
    }

    return res;
  }

  /*
   * This is Matrix * Vector, as opposed to Vector * Matrix.
   * Both of these will generate different results.
   *
   * Imagine:
   *
   * matrix 'a'       vector 'b'
   * [                [
   *   [ 1 2 ]    .     6
   *   [ 3 4 ]          9
   * ]                ]
   * (2 * 2)          (2 * 1)
   *
   * Result: (2 * 1)
   * [
   *   24
   *   54
   * ]
   *
   * But on Vector * Matrix:
   *
   * vector 'a'         vector 'b'
   * [ 6 9 ]       .    [
   *                      [ 1 2 ]
   *                      [ 3 4 ]
   *                    ]
   * (1 * 2)          (2 * 2)
   *
   * Result: (1 * 2)
   * [ 33 48 ]
   */
  public static double[] mult(double[][] a, double[] x) {
    int m = a.length;
    int n = a[0].length;

    if (n != x.length) {
      throw new RuntimeException("Vector length must equal matrix column " +
        "length");
    }

    double[] res = new double[m];

    for (int row = 0; row < m; row += 1) {
      for (int col = 0; col <n; col += 1) {
        double el = a[row][col];

        res[row] += el * x[col];
      }
    }

    return res;
  }

  public static double[] mult(double[] y, double[][] a) {
    int m = a.length;
    int n = a[0].length;

    if (y.length != m) {
      throw new RuntimeException("Vector length must equal matrix row " +
        "length");
    }

    double[] res = new double[n];

    for (int row = 0; row < m; row += 1) {
      for (int col = 0; col <n; col += 1) {
        double el = a[row][col];

        res[col] += el * y[row];
      }
    }

    return res;
  }
}
