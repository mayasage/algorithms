package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class E1121Test {
  private static void testInput(String stdIn, String stdOut) {
    InputStream is = new ByteArrayInputStream(stdIn.getBytes());
    System.setIn(is);
    OutputStream os = new ByteArrayOutputStream(1000);
    System.setOut(new PrintStream(os));

    E1121.run();

    String result = os.toString();
    assertEquals(stdOut, result);
  }

  @Test
  public void test() {
    String ls = System.lineSeparator();

    testInput(
      "M 2 5" + ls + "S 7 9" + ls,
      "Input format (Name Number1 Number2)." + ls +
        "x y z r" + ls +
        "M 2 5 0.400" + ls +
        "S 7 9 0.778" + ls
    );
  }
}
