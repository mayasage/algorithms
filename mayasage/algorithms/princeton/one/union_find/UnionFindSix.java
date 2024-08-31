/*
 * Added findConnectedMax() method.
 *
 * I just used a HashMap to save the max element every root (and ONLY root).
 * If I make every second element the root, then the max space complexity will
 * go to O(LogN).
 * If I make every element a root (which is the default), I'm not using any
 * extra space.
 *
 * Now, when I merge 2 root, I ensure that only 1 of the 2 roots remain in
 * memory.
 * How ?
 * I delete the max of the tree that is getting merged in the other tree.
 * The other tree (which is now the only tree between the 2 trees, and is the
 * parent now) will have its max updated into the HashMap.
 *
 * The above occurs during the Union operation.
 *
 * Now when anyone tries to find the maxConnected for an element, I'll just
 * try to find the root of the tree, and find its max.
 * If it doesn't exist, then the node is its own tree (it hasn't been merged
 * with any other tree), so I just return the node itself.
 *
 * Time Complexity is the same as connected.
 * O(Log*N) because the most expensive operation is root(), which gets
 * reduced down due to path compression.
 */

package mayasage.algorithms.princeton.one.union_find;

import java.util.HashMap;

public class UnionFindSix {
  private final int[] set;
  private final int[] children;
  private final HashMap<Integer, Integer> max;

  UnionFindSix(int n) {
    this.set = new int[n + 1];
    this.children = new int[n + 1]; // Every el is a child of itself

    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
      children[i] = 1;
    }

    max = new HashMap<>();
  }

  private int root(int p) {
    int current = p;
    int parent = set[p];

    while (current != parent) {
      int grandParent = set[parent];
      set[current] = grandParent;

      if (parent != grandParent) {
        children[parent] -= 1;
      }

      current = parent;
      parent = set[current];
    }

    return current;
  }

  void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);

    if (pRoot != qRoot) {
      int pCount = children[pRoot];
      int qCount = children[qRoot];

      int maxPRoot = max.getOrDefault(pRoot, p);
      int maxQRoot = max.getOrDefault(qRoot, q);
      int maxInConnected = Math.max(maxPRoot, maxQRoot);

      if (pCount < qCount) {        // q tree is larger
        children[qRoot] += pCount;  // q tree has pCount more nodes
        set[pRoot] = qRoot;         // root of p tree becomes a child of qRoot
        max.put(qRoot, maxInConnected);
        max.remove(pRoot);
      } else {                      // p tree is larger or equal
        children[pRoot] += qCount;  // p tree has qCount more nodes
        set[qRoot] = pRoot;         // root of q tree becomes a child of pRoot
        max.put(pRoot, maxInConnected);
        max.remove(qRoot);
      }
    }
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  int find(int p) {
    return set[p];
  }

  int findConnectedMax(int p) {
    return max.getOrDefault(root(p), p);
  }

  int count() {
    return set.length - 1;
  }

  int children(int p) {
    return children[p];
  }
}
