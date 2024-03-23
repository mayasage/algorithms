/**
 * E1119:
 * What is the largest value of N for which this program takes less 1 hour to
 * compute the value of F(N)? Develop a better implementation of F(N) that
 * saves computed values in an array.
 */

package mayasage.algorithms.one.one;

public class E1119 {
  private long fibonacci1(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci1(n-1) + fibonacci1(n-2);
  }

  private void fibonacci2(int n, long[] cache) {
    if (n == 0) cache[0] = 0;
    else if (n == 1) cache[1] = 1;
    else cache[n] = cache[n - 1] + cache[n - 2];
  }

  public static long[] run(int n, int version) {
    long[] res = new long[n];

    if (version == 1) {
      for (int i = 0; i < n; i++) {
        res[i] = new E1119().fibonacci1(i);
      }
    } else {
      for (int i = 0; i < n; i++) {
        new E1119().fibonacci2(i, res);
      }
    }

    return res;
  }
}
