/**
 * E115:
 * Write a code fragment that prints true if the double variables x and y are
 * both strictly between 0 and 1 and false otherwise.
 */

package mayasage.algorithms.one.one;

public class E115 {
  public static void run(double x, double y) {
    System.out.println(x > 0.0 && x < 1.0 && y > 0.0 && y < 1.0);
  }
}
