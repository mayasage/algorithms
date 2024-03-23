/**
 * E113:
 * Write a program that takes three integer command-line arguments and prints
 * equal if all three are equal, and not equal otherwise.
 */

package mayasage.algorithms.one.one;

import java.util.Scanner;

public class E113 {
  public static void run() {
    System.out.println("Enter 3 integers: ");
    int count = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("[ \n]");
    while(count < 3 && sc.hasNextInt()) {
      if (count == 0) i1 = sc.nextInt();
      if (count == 1) i2 = sc.nextInt();
      if (count == 2) {
        i3 = sc.nextInt();
      }
      count += 1;
    }
    if (count == 3 && i1 == i2 && i2 == i3) {
      System.out.println("Equal");
    } else {
      System.out.println("Not Equal");
    }
  }
}
