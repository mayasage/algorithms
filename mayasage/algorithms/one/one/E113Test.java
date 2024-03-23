package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class E113Test {
  private static void testInput(String stdIn, String stdOut) {
    InputStream is = new ByteArrayInputStream(stdIn.getBytes());
    System.setIn(is);
    OutputStream os = new ByteArrayOutputStream(15);
    System.setOut(new PrintStream(os));

    E113.run();

    String ls = System.lineSeparator();
    String result = os.toString().trim().split(ls)[1];
    assertEquals(stdOut, result);
  }

  @Test
  public void test() {
    E113Test.testInput("1 2 3\n", "Not Equal");
    E113Test.testInput("1 1 1\n", "Equal");
    E113Test.testInput("1\n", "Not Equal");
    E113Test.testInput("1 1\n", "Not Equal");
    E113Test.testInput("\n", "Not Equal");
    E113Test.testInput("1 2 3 4 5\n", "Not Equal");
    E113Test.testInput("1 1 1 4 5\n", "Equal");
  }
}
