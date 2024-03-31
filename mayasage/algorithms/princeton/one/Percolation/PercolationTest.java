package mayasage.algorithms.princeton.one.Percolation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.algs4.StdRandom;

class PercolationTest {
  @Test
  public void test() {
    testStdRandom();
    testAllStraightLines();
    monteCarloSimulation();
  }

  private void testStdRandom() {
    int n = 2;

    boolean x = false;

    for (int i = 0; i < 1_000_000; i += 1) {
      int row = StdRandom.uniformInt(0, n);
      int col = StdRandom.uniformInt(0, n);

//      System.out.println(row + " " + col);
      if (row == 2 || col == 2) {
        x = true;
        break;
      }
    }

    System.out.println("result " + x);
  }

  private void testAllStraightLines() {
    /*
     * When n = 1, assertTrue(p.percolates());
     * This is the only difference.
     */
    int n = 1;
    for (int col = 1; col <= n; col += 1) {
      Percolation p = new Percolation(n);
      assertTrue(p.percolates());

      for (int row = 1; row <= n; row += 1) {
        assertFalse(p.isOpen(row, col));
        assertFalse(p.isFull(row, col));
        p.open(row, col);
        assertTrue(p.isOpen(row, col));
        assertTrue(p.isFull(row, col));
      }

      assertTrue(p.percolates());
    }

    testStraightLine(2);
    testStraightLine(3);
    testStraightLine(4);
    testStraightLine(5);
  }

  private void testStraightLine(int n) {
    for (int col = 1; col <= n; col += 1) {
      Percolation p = new Percolation(n);
      assertFalse(p.percolates());

      for (int row = 1; row <= n; row += 1) {
        assertFalse(p.isOpen(row, col));
        assertFalse(p.isFull(row, col));
        p.open(row, col);
        assertTrue(p.isOpen(row, col));
        assertTrue(p.isFull(row, col));

        if (row != n) {
          assertFalse(p.percolates());
        } else {
          assertTrue(p.percolates());
        }
      }
    }
  }

  private void monteCarloSimulation() {
    int n = 20;
    int c = 10;
    for (int i = 0; i < c; i += 1) {
      Percolation p = new Percolation(n);

      while (!p.percolates()) {
        int row = StdRandom.uniformInt(1, n + 1);
        int col = StdRandom.uniformInt(1, n + 1);
        p.open(row, col);
      }

      System.out.println("System Percolated at " + p.numberOfOpenSites() + "th " +
        "site.");
    }
  }
}