/**
 * E1132:
 * Histogram. Suppose that the standard input stream is a sequence of double
 * values. Write a program that takes an integer N and two double values l and r
 * from the command line and uses StdDraw to plot a histogram of the count of
 * the numbers in the standard input stream that fall in each of the N
 * intervals defined by dividing (l , r) into N equal-sized intervals.
 *
 * @Comeback
 * When you know how to create a Histogram.
 */

package mayasage.algorithms.one.one;

import java.util.Arrays;
import java.util.Scanner;

public class E1132 {
  public static void run(String[] args) throws Exception {
    int intervalCount = Integer.parseInt(args[0]);
    double start = Double.parseDouble(args[1]);
    double end = Double.parseDouble(args[2]);

    if (start > end) {
      throw new Exception("start must be less than end.");
    }

    double intervalSize = (end - start) / intervalCount;
    int arrayLen = intervalCount + 1;
    double[] histogram = new double[arrayLen];

    System.out.println("Input double values!");
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextDouble()) {
      double d = sc.nextDouble();
      if (d < start || d > end) continue;

      /*
       * start = 0.2, end = 0.10, intervalSize = 0.2
       * find position of 0.5
       * 0.2 + 0.2x = 0.5
       * 0.2x = 0.3
       * x = 0.3/0.2
       * ceil it
       * x = 2
       * Formula -> Math.ceil((d - start) / intervalSize)
       */
      int dIndex = (int) Math.ceil((d - start) / intervalSize);
      histogram[dIndex] += 1;
    }

    System.out.println("histogram array: " + Arrays.toString(histogram));
  }
}
