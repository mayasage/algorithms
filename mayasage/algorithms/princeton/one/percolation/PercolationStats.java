package mayasage.algorithms.princeton.one.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
        private final double mean;
        private final double stdDev;
        private final double confidenceLo;
        private final double confidenceHi;

        public PercolationStats(int n, int trials) {
                if (n < 1 || trials < 1) {
                        throw new IllegalArgumentException();
                }
                double[] openSitesToTotalSites = new double[trials];
                for (int i = 0; i < trials; i++) {
                        openSitesToTotalSites[i] = (double) runTrial(n) / (n * n);
                }
                mean = StdStats.mean(openSitesToTotalSites);
                stdDev = StdStats.stddev(openSitesToTotalSites);
                confidenceLo = mean - ((1.96 * stdDev) / Math.sqrt(trials));
                confidenceHi = mean + ((1.96 * stdDev) / Math.sqrt(trials));
        }

        public static void main(String[] args) {
                int n = Integer.parseInt(args[0]);
                int trials = Integer.parseInt(args[1]);
                PercolationStats ps = new PercolationStats(n, trials);
                System.out.printf("%-25s = %.18f%n", "mean", ps.mean());
                System.out.printf("%-25s = %.18f%n", "stddev", ps.stddev());
                System.out.printf("%-25s = [%.18f, %.18f]%n", "95% confidence interval",
                        ps.confidenceLo(), ps.confidenceHi());
        }

        public double mean() {
                return mean;
        }

        public double stddev() {
                return stdDev;
        }

        public double confidenceLo() {
                return confidenceLo;
        }

        public double confidenceHi() {
                return confidenceHi;
        }

        private int runTrial(int n) {
                Percolation percolation = new Percolation(n);
                while (!percolation.percolates()) {
                        int row = StdRandom.uniformInt(1, n + 1);
                        int col = StdRandom.uniformInt(1, n + 1);
                        percolation.open(row, col);
                }
                return percolation.numberOfOpenSites();
        }
}
