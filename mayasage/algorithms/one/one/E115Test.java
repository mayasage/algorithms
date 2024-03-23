package mayasage.algorithms.one.one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.*;

class E115Test {
  private static void testInput(double x, double y, String stdOut) {
    OutputStream os = new ByteArrayOutputStream(15);
    System.setOut(new PrintStream(os));

    E115.run(x, y);

    String result = os.toString().trim();
    assertEquals(stdOut, result);
  }

  @Test
  public void test() {
    testInput(0.000001, 0.00000000000001, "true");
    testInput(Double.MIN_VALUE, 0.00000000000001, "true");
    testInput(0.000001, Double.MAX_VALUE, "false");
    testInput(Double.MIN_VALUE, Double.MAX_VALUE, "false");
  }
}