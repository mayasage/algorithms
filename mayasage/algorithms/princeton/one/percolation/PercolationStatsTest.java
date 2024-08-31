package mayasage.algorithms.princeton.one.percolation;

import org.junit.jupiter.api.Test;

class PercolationStatsTest {
  @Test
  public void test() {
    PercolationStats.main(new String[]{"whatever", 200 + "", 100 + ""});
    PercolationStats.main(new String[]{"whatever", 200 + "", 100 + ""});
    PercolationStats.main(new String[]{"whatever", 2 + "", 10000 + ""});
    PercolationStats.main(new String[]{"whatever", 2 + "", 10000 + ""});
  }
}