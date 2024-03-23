/**
 * E119:
 * Write a code fragment that puts the binary representation of a positive
 * integer N into a String s.
 */

package mayasage.algorithms.one.one;

public class E119 {
  public static void run(int n) {
    if (n == 0) {
      System.out.println("0");
    }

    StringBuilder result = new StringBuilder();

    int temp = n;
    while (temp != 0) {
      int remainder = temp % 2;
      result.append(remainder);
      temp = temp / 2;
    }

    System.out.println(result.reverse());
  }
}
