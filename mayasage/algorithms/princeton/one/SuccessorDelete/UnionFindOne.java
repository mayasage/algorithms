/*
 * NOTE:- The UnionFinds in this package are 0-index based.
 * Means that set starts from 0.
 * This knowledge is needed for testing, not usage.
 *
 * Keep track of the max value in tree.
 *
 * Solution:
 * Weighted Union Find + Path Compression + Store Max Tree Value
 */

package mayasage.algorithms.princeton.one.SuccessorDelete;

import java.util.HashMap;

public class UnionFindOne implements UnionFind {
  final private int[] set;
  final private int[] children;

  final private HashMap<Integer, Integer> max = new HashMap<>();

  UnionFindOne(int n) {
    set = new int[n];
    children = new int[n];

    // Initially everyone is a root of themselves.
    for (int i = 0; i < n; i += 1) {
      set[i] = i;
      children[i] = 1; // Every node is a child of itself.
    }
  }

  int root(int x) {
    int current = x;
    int parent = set[x];

    while (current != parent) {
      // Path compression
      int grandparent = set[parent];

      if (grandparent != parent) {
        set[current] = grandparent;
        children[parent] -= 1;
      }

      current = parent;
      parent = grandparent;
    }

    return current;
  }

  public void union(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);

    if (rootP != rootQ) {
      int childrenRootP = children[rootP];
      int childrenRootQ = children[rootQ];
      int maxRootP = max.getOrDefault(rootP, p);
      int maxRootQ = max.getOrDefault(rootQ, q);
      int newMax = Math.max(maxRootP, maxRootQ);

      if (childrenRootP >= childrenRootQ) {
        set[rootQ] = rootP;                 // rootP becomes parent
        children[rootP] += childrenRootQ;
        max.put(rootP, newMax);
        max.remove(rootQ);
      } else {
        set[rootP] = rootQ;                 // rootQ becomes parent
        children[rootQ] += childrenRootP;
        max.put(rootQ, newMax);
        max.remove(rootP);
      }
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

  int children(int p) {
    return children[p];
  }

  public int getSetMax(int p) {
    return max.getOrDefault(root(p), p);
  }
}
