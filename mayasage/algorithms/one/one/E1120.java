/**
 * E1120:
 * Write a recursive static method that computes the value of ln (N !)
 */

package mayasage.algorithms.one.one;

public class E1120 {
  private double lgnf(int n) {
    if (n == 0) return 0;
    return Math.log(n) / Math.log(2) + lgnf(n - 1);
  }

  public static double run(int n) {
    return new E1120().lgnf(n);
  }
}
