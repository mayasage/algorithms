/**
 * E1121:
 * Write a program that reads in lines from standard input with each line
 * containing a name and two integers and then uses printf() to print a table
 * with a column of the names, the integers, and the result of dividing the
 * first by the second, accurate to three decimal places. You could use a
 * program like this to tabulate batting averages for baseball players or
 * grades for students.
 */

package mayasage.algorithms.one.one;

import java.util.ArrayList;
import java.util.Scanner;

public class E1121 {
  public static void run() {
    ArrayList<String> rows = new ArrayList<>();

    System.out.println("Input format (Name Number1 Number2).");
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(" ");
      String name = tokens[0];
      double num1 = Double.parseDouble(tokens[1]);
      double num2 = Double.parseDouble(tokens[2]);
      rows.add(
        name + " " +
          tokens[1] + " " +
          tokens[2] + " " +
          String.format("%.3f", num1 / num2) +
          System.lineSeparator()
      );
    }

    System.out.println("x y z r");
    for (String row : rows) {
      System.out.print(row);
    }
  }
}
