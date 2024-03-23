package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class E1132Test {
  private static void testInput(String[] args, String stdIn, String stdOut) throws Exception {
    InputStream is = new ByteArrayInputStream(stdIn.getBytes());
    System.setIn(is);
    OutputStream os = new ByteArrayOutputStream(1000);
    System.setOut(new PrintStream(os));

    E1132.run(args);

    String result = os.toString();
    assertEquals(stdOut, result);
  }

  @Test
  public void test() throws Exception {
    String ls = System.lineSeparator();

    testInput(
      new String[]{"4", "0.2", "1.0"},
      "0.39 0.75",
      "Input double values!" + ls +
        "histogram array: [0.0, 1.0, 0.0, 1.0, 0.0]" + ls
    );

    testInput(
      new String[]{"4", "0.2", "1.0"},
      "0.39 0.75 0.1 2.0",
      "Input double values!" + ls +
        "histogram array: [0.0, 1.0, 0.0, 1.0, 0.0]" + ls
    );
  }
}
