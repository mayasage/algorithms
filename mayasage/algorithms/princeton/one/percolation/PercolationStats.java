package mayasage.algorithms.princeton.one.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private static final double CONFIDENCE_95 = 1.96;

  private final double[] numOpenSites;
  private final int trials;

  // perform independent trials on an n-by-n grid
  public PercolationStats(int n, int trials) {
    if (n <= 0) {
      throw new IllegalArgumentException("Grid size must be more than 0!");
    }

    if (trials <= 0) {
      throw new IllegalArgumentException("Trial number must be more than 0!");
    }

    numOpenSites = new double[trials];
    this.trials = trials;

    for (int i = 0; i < trials; i += 1) {
      Percolation p = new Percolation(n);

      while (!p.percolates()) {
        int row = StdRandom.uniformInt(1, n + 1);
        int col = StdRandom.uniformInt(1, n + 1);
        p.open(row, col);
      }

      numOpenSites[i] = p.numberOfOpenSites() / (double) (n * n);
    }
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(numOpenSites);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(numOpenSites);
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    double mean = this.mean();
    double standardDeviation = this.stddev();

    return mean - ((CONFIDENCE_95 * standardDeviation) / Math.sqrt(trials));
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    double mean = this.mean();
    double standardDeviation = this.stddev();

    return mean + ((CONFIDENCE_95 * standardDeviation) / Math.sqrt(trials));
  }

  // test client (see below)
  public static void main(String[] args) {
    int n = Integer.parseInt(args[1]);
    int trials = Integer.parseInt(args[2]);

    PercolationStats ps = new PercolationStats(n, trials);

    System.out.printf("%-25s = %.18f%n", "mean", ps.mean());
    System.out.printf("%-25s = %.18f%n", "stddev", ps.stddev());
    System.out.printf("%-25s = [%.18f, %.18f]%n", "95% confidence interval",
      ps.confidenceLo(), ps.confidenceHi());
  }
}
