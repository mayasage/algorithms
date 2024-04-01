/*
 * Solution "Quick Union with Path Compression"
 *
 * The running time complexity of this algorithm is O(N + MLogN).
 *
 * In short, we just updated the root() function to do path compression.
 *
 * This is technically slower than "Weighted Quick Union with Path Compression",
 * because in there, the time complexity is O(N + MLog*N), meaning you can
 * waveringly treat Log*N as O(1), making the time complexity O(N + M).
 */

package mayasage.algorithms.princeton.one.UnionFind;

public class UnionFindFive {
  private final int[] set;

  UnionFindFive(int n) {
    this.set = new int[n + 1];
    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
    }
  }

  private int root(int p) {
    int current = p;
    int parent = set[p];

    while (current != parent) {
      int grandParent = set[parent];
      set[current] = grandParent;

      current = parent;
      parent = set[current];
    }

    return current;
  }

  void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);

    if (pRoot != qRoot) {
      set[qRoot] = pRoot;
    }
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  int find(int p) {
    return set[p];
  }

  int count() {
    return set.length - 1;
  }
}
