package mayasage.algorithms.princeton.one.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationBackWater implements IPercolation {
        private final int n;
        private final int virtualTop;
        private final int virtualBottom;
        private final boolean[][] grid;
        private final WeightedQuickUnionUF ufForPercolation;
        private final WeightedQuickUnionUF ufForIsFull;
        private int numberOfOpenSites = 0;

        public PercolationBackWater(int n) {
                if (n < 1) throw new IllegalArgumentException();
                this.n = n;
                grid = new boolean[n][n];
                ufForPercolation = new WeightedQuickUnionUF(n * n + 2);
                ufForIsFull = new WeightedQuickUnionUF(n * n + 1);
                virtualTop = n * n;
                virtualBottom = n * n + 1;
        }

        @Override
        public void open(int row, int col) {
                validateRowCol(row, col);
                int r = row - 1;
                int c = col - 1;
                if (!grid[r][c]) {
                        numberOfOpenSites += 1;
                        grid[r][c] = true;
                        connectNeighbours(r, c);
                }
        }

        @Override
        public boolean isOpen(int row, int col) {
                validateRowCol(row, col);
                return grid[row - 1][col - 1];
        }

        @Override
        public boolean isFull(int row, int col) {
                validateRowCol(row, col);
                return ufForIsFull.find((row - 1) * n + col - 1) == ufForIsFull.find(virtualTop);
        }

        @Override
        public int numberOfOpenSites() {
                return numberOfOpenSites;
        }

        @Override
        public boolean percolates() {
                return ufForPercolation.find(virtualTop) == ufForPercolation.find(virtualBottom);
        }

        private void validateRowCol(int row, int col) {
                if (row < 1 || row > n) {
                        throw new IllegalArgumentException("row out of bounds");
                }
                if (col < 1 || col > n) {
                        throw new IllegalArgumentException("col out of bounds");
                }
        }

        private void connectNeighbours(int r, int c) {
                int p = r * n + c;
                if (r == 0) {
                        ufForPercolation.union(p, virtualTop);
                        ufForIsFull.union(p, virtualTop);
                }
                if (r == n - 1) {
                        ufForPercolation.union(p, virtualBottom);
                }
                if (r > 0 && grid[r - 1][c]) {
                        int top = (r - 1) * n + c;
                        ufForPercolation.union(p, top);
                        ufForIsFull.union(p, top);
                }
                if (r < n - 1 && grid[r + 1][c]) {
                        int bottom = (r + 1) * n + c;
                        ufForPercolation.union(p, bottom);
                        ufForIsFull.union(p, bottom);
                }
                if (c > 0 && grid[r][c - 1]) {
                        int left = p - 1;
                        ufForPercolation.union(p, left);
                        ufForIsFull.union(p, left);
                }
                if (c < n - 1 && grid[r][c + 1]) {
                        int right = p + 1;
                        ufForPercolation.union(p, right);
                        ufForIsFull.union(p, right);
                }
        }
}
