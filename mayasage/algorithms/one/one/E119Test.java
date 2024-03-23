package mayasage.algorithms.one.one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.*;

class E119Test {
  private static void testInput(int x, String stdOut) {
    OutputStream os = new ByteArrayOutputStream(1000);
    System.setOut(new PrintStream(os));

    E119.run(x);

    String result = os.toString().trim();
    assertEquals(stdOut, result);
  }

  @Test
  public void test() {
    testInput(10, "1010");
    testInput(0, "0");
  }
}