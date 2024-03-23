package mayasage.algorithms.one.one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.*;

class E1111Test {
  private static void testInput(boolean[][] array, String stdOut) {
    OutputStream os = new ByteArrayOutputStream(1000);
    System.setOut(new PrintStream(os));

    E1111.run(array);

    String result = os.toString();
    assertEquals(stdOut, result);
  }

  @Test
  public void test() {
    boolean[][] a = {
      {true, true},
      {false, false}
    };
    testInput(a,
      "  1 2" + System.lineSeparator() +
        "1 * *" + System.lineSeparator() +
        "2    " + System.lineSeparator()
    );

    a = new boolean[][]{
      {true, false},
      {false, true}
    };
    testInput(a,
      "  1 2" + System.lineSeparator() +
        "1 *  " + System.lineSeparator() +
        "2   *" + System.lineSeparator()
    );
  }
}