package mayasage.algorithms.princeton.one.Percolation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.algs4.StdRandom;

class PercolationTest {
  @Test
  public void test() {
    visualizePercolation();
    test2By2Grid();
    test1By1Grid();
    testStdRandom();
    testAllStraightLines();
    monteCarloSimulation();
  }

  private void visualizePercolation() {
    In in = new In("C:\\Users\\Aithea\\OneDrive\\aithea\\notes_inprogress" +
      "\\algorithms\\mayasage\\algorithms\\princeton\\one\\Percolation" +
      "\\input20.txt");

    int n = in.readInt();

    // turn on animation mode
    StdDraw.enableDoubleBuffering();

    // repeatedly read in sites to open and draw resulting system
    Percolation perc = new Percolation(n);

    PercolationVisualizer.draw(perc, n);

    StdDraw.show();
    StdDraw.pause(PercolationVisualizer.DELAY);

    while (!in.isEmpty()) {
      int i = in.readInt();
      int j = in.readInt();
      perc.open(i, j);

      PercolationVisualizer.draw(perc, n);

      StdDraw.show();
      StdDraw.pause(PercolationVisualizer.DELAY);
    }
  }

  private void test2By2Grid() {
    Percolation p = new Percolation(2);
    assertFalse(p.percolates());
    assertEquals(0, p.numberOfOpenSites());
    assertFalse(p.isOpen(1,1));
    p.open(1,1);
    assertFalse(p.percolates());
    assertEquals(1, p.numberOfOpenSites());
    assertTrue(p.isOpen(1,1));
    assertFalse(p.isOpen(2,2));
    p.open(2,2);
    assertTrue(p.isOpen(2,2));
    assertFalse(p.percolates());
    assertEquals(2, p.numberOfOpenSites());
    assertFalse(p.isOpen(1,2));
    p.open(1, 2);
    assertTrue(p.isOpen(1,2));
    assertEquals(3, p.numberOfOpenSites());
    assertTrue(p.percolates());
  }

  private void test1By1Grid() {
    Percolation p = new Percolation(1);
    assertFalse(p.isOpen(1, 1));
    assertFalse(p.percolates());
    assertEquals(0, p.numberOfOpenSites());
    p.open(1, 1);
    assertEquals(1, p.numberOfOpenSites());
    assertTrue(p.percolates());
  }

  /**
   * Just wrote to check if StdRandom.uniformInt() will ever include N itself.
   */
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