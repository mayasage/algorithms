package mayasage.algorithms.princeton.one.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation implements IPercolation {
        private final boolean[][] grid;
        private int numberOfOpenSites = 0;
        private final WeightedQuickUnionUF uf;
        private final int topNodeIndex;
        private final int bottomNodeIndex;

        public Percolation(int n) {
                if (n < 1) throw new IllegalArgumentException();
                grid = new boolean[n][n];
                uf = new WeightedQuickUnionUF(n * n + 2);
                topNodeIndex = n * n;
                bottomNodeIndex = n * n + 1;
        }

        @Override
        public void open(int row, int col) {
                validate(row, col);
                row--;
                col--;
                if (grid[row][col]) return;
                grid[row][col] = true;
                numberOfOpenSites++;
                connectTopBottom(row, col);
                connectUpDownLeftRight(row, col);
        }

        @Override
        public boolean isOpen(int row, int col) {
                validate(row, col);
                row--;
                col--;
                return grid[row][col];
        }

        @Override
        public boolean isFull(int row, int col) {
                validate(row, col);
                row--;
                col--;
                return uf.find(topNodeIndex) == uf.find(findPositionInUf(row, col));
        }

        @Override
        public int numberOfOpenSites() {
                return numberOfOpenSites;
        }

        @Override
        public boolean percolates() {
                return uf.find(topNodeIndex) == uf.find(bottomNodeIndex);
        }

        private void validate(int... rowOrCols) {
                for (int value : rowOrCols) {
                        if (value < 1 || value > grid.length) {
                                throw new IllegalArgumentException("Invalid row or column: " + value);
                        }
                }
        }

        private void connectTopBottom(int row, int col) {
                int positionInUf = findPositionInUf(row, col);
                if (row == 0) {
                        uf.union(topNodeIndex, positionInUf);
                }
                if (row == grid.length - 1) {
                        uf.union(bottomNodeIndex, positionInUf);
                }
        }

        private void connectUpDownLeftRight(int row, int col) {
                int positionInUf = findPositionInUf(row, col);
                if (row - 1 >= 0 && grid[row - 1][col]) {
                        uf.union(positionInUf, findPositionAboveInUf(row, col));
                }
                if (row + 1 < grid.length && grid[row + 1][col]) {
                        uf.union(positionInUf, findPositionBelowInUf(row, col));
                }
                if (col - 1 >= 0 && grid[row][col - 1]) {
                        uf.union(positionInUf, findPositionToLeftInUf(row, col));
                }
                if (col + 1 < grid.length && grid[row][col + 1]) {
                        uf.union(positionInUf, findPositionToRightInUf(row, col));
                }
        }

        private int findPositionInUf(int row, int col) {
                return row * grid.length + col;
        }

        private int findPositionAboveInUf(int row, int col) {
                return (row - 1) * grid.length + col;
        }

        private int findPositionBelowInUf(int row, int col) {
                return (row + 1) * grid.length + col;
        }

        private int findPositionToLeftInUf(int row, int col) {
                return row * grid.length + col - 1;
        }

        private int findPositionToRightInUf(int row, int col) {
                return row * grid.length + col + 1;
        }
}
