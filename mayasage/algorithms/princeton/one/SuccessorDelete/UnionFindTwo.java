/*
 * Skew the matrix to make larger element root.
 *
 * Solution:
 * Union Find + Path Compression + Larger is always Root Skewing
 *
 * This seems to run way faster than the other UnionFindOne in this package.
 * Even though the actual time complexity of that algorithm is less than this
 * one. Maybe it triggers at high numbers. I'm running out of RAM.
 *
 * The reason is that root() becomes O(1) in some time.
 * So, it all boils down the number of O(1) operations.
 * And this algorithm has few operations, which UnionFindOne has to maintain
 * the hashMap, and another children array atop the set array.
 * This straightforwardly means higher number of operations in comparison.
 * Thus, the running time is higher.
 *
 * If I could find some sort of operations such that I am doing root(), but
 * path compression is useless, and then I take a huge array (billions), and
 * perform the operations, then maybe, UnionFindOne will outshine UnionFindTwo.
 */

package mayasage.algorithms.princeton.one.SuccessorDelete;

public class UnionFindTwo implements UnionFind {
  final private int[] set;

  UnionFindTwo(int n) {
    set = new int[n];

    // Initially everyone is a root of themselves.
    for (int i = 0; i < n; i += 1) {
      set[i] = i;
    }
  }

  public int root(int x) {
    int current = x;
    int parent = set[x];

    while (current != parent) {
      // Path compression
      int grandparent = set[parent];

      if (grandparent != parent) {
        set[current] = grandparent;
      }

      current = parent;
      parent = grandparent;
    }

    return current;
  }

  public void union(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);

    if (rootP > rootQ) {
      set[rootQ] = rootP;         // rootP is parent
    } else if (rootP < rootQ) {
      set[rootP] = rootQ;         // rootQ is parent
    }
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public int parent(int p) {
    return set[p];
  }

  int count() {
    return set.length - 1;
  }

  public int getSetMax(int p) {
    return root(p);
  }
}
