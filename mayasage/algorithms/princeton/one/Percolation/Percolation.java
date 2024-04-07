/*
 * You are given an N*N grid.
 * Initially, every element in the grid is black.
 * Randomly, elements in the grid will go white.
 *
 * A system "Percolates" if any element in the top row is connected to the
 * bottom row through these whites.
 *
 * Imagine a 5 * 5 grid, but in array format.
 *
 * [0 1 2 3 4   5 6 7 8 9   10 11 12 13 14   15 16 17 18 19   20 21 22 23 24]
 *
 * First of all I need something to store these whites & blacks.
 * A boolean array will be good.
 * - black = false
 * - white = true
 */

package mayasage.algorithms.princeton.one.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private final boolean[][] grid;
  private final WeightedQuickUnionUF uf;
  private int openCount = 0;
  private final int n;
  private final int topVirtualNodeIndex;
  private final int bottomVirtualNodeIndex;

  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("Invalid grid dimensions");
    }

    this.n = n;
    topVirtualNodeIndex = n * n;
    bottomVirtualNodeIndex = n * n + 1;

    grid = new boolean[n][n];

    /*
     * 2 extra for top and bottom virtual nodes.
     */
    uf = new WeightedQuickUnionUF(n * n + 2);

    for (int i = 0; i < n; i += 1) {
      uf.union(topVirtualNodeIndex, i);
    }

    for (int i = n * n - 1; i >= n * n - n; i -= 1) {
      uf.union(bottomVirtualNodeIndex, i);
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    // Our matrix is 0-based, user input is 1-based.
    row -= 1;
    col -= 1;
    validate(row, col);

    if (grid[row][col]) return;
    grid[row][col] = true;
    openCount += 1;

    int index = turnRowColToIndex(row, col);
    int leftBoundary = row * n;
    int rightBoundary = leftBoundary + n - 1;
    
    int left = index - 1;
    int right = index + 1;
    int top = index - n;
    int bottom = index + n;

    if (left >= leftBoundary && grid[row][col - 1]) {
      uf.union(index, left);
    }

    if (right <= rightBoundary && grid[row][col + 1]) {
      uf.union(index, right);
    }

    if (top >= 0 && grid[row - 1][col]) {
      uf.union(index, top);
    }

    if (bottom < n * n && grid[row + 1][col]) {
      uf.union(index, bottom);
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    row -= 1;
    col -= 1;
    validate(row, col);
    return grid[row][col];
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    row -= 1;
    col -= 1;
    validate(row, col);
    int index = turnRowColToIndex(row, col);
    return grid[row][col] && uf.find(topVirtualNodeIndex) == uf.find(index);
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return openCount;
  }

  // does the system percolate?
  public boolean percolates() {
    return uf.find(topVirtualNodeIndex) == uf.find(bottomVirtualNodeIndex);
  }

  private void validate(int row, int col) {
    if (row < 0 || row >= n) {
      throw new IllegalArgumentException("row out of bounds");
    }

    if (col < 0 || col >= n) {
      throw new IllegalArgumentException("col out of bounds");
    }
  }

  private int turnRowColToIndex(int row, int col) {
    return row * n + col;
  }
}
