package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class E1119Test {
  private static void testInput(int n, int version, long[] output) {
    assertTimeoutPreemptively(Duration.ofMillis(100000), () -> {
//      long startTime = System.nanoTime();
      long[] res = E1119.run(n, version);
//      long stopTime = System.nanoTime();
//      System.out.println(stopTime - startTime);
      assertArrayEquals(output, res);
    });
  }

  @Test
  public void test() {
//    testInput(49, 1, new long[]{
//      0,
//      1,
//      1,
//      2,
//      3,
//      5,
//      8,
//      13,
//      21,
//      34,
//      55,
//      89,
//      144,
//      233,
//      377,
//      610,
//      987,
//      1597,
//      2584,
//      4181,
//      6765,
//      10946,
//      17711,
//      28657,
//      46368,
//      75025,
//      121393,
//      196418,
//      317811,
//      514229,
//      832040,
//      1346269,
//      2178309,
//      3524578,
//      5702887,
//      9227465,
//      14930352,
//      24157817,
//      39088169,
//      63245986,
//      102334155,
//      165580141,
//      267914296,
//      433494437,
//      701408733, // 25 seconds
//      1134903170, // 30 seconds
//      1836311903, // 35 seconds
//      2971215073L, // 40 seconds
//      4807526976L, // 65 seconds
////      7778742049L, // 100+ seconds (too long)
//    });

    testInput(50, 2, new long[]{
      0,
      1,
      1,
      2,
      3,
      5,
      8,
      13,
      21,
      34,
      55,
      89,
      144,
      233,
      377,
      610,
      987,
      1597,
      2584,
      4181,
      6765,
      10946,
      17711,
      28657,
      46368,
      75025,
      121393,
      196418,
      317811,
      514229,
      832040,
      1346269,
      2178309,
      3524578,
      5702887,
      9227465,
      14930352,
      24157817,
      39088169,
      63245986,
      102334155,
      165580141,
      267914296,
      433494437,
      701408733,
      1134903170,
      1836311903,
      2971215073L,
      4807526976L,
      7778742049L,
    });
  }
}
