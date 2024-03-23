/**
 * E1114:
 * Write a static method lg() that takes an int value N as argument and returns
 * the largest int not larger than the base-2 logarithm of N. Do not use Math.
 */

package mayasage.algorithms.one.one;

public class E1114 {
  private int lg(int n, int base) {
    int pow = 0;
    int prod = 1;

    while (prod <= n) {
      prod *= base;
      pow += 1;
    }

    return pow - 1;
  }

  public static int run(int n, int base) {
    return new E1114().lg(n, base);
  }
}
