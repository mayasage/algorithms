/*
 * NOTE: All these UnionFind on the outside treats array to start from 1.
 * So, there is no 0 element.
 * Its [ 1 ... N ].
 *
 * The problem we have:
 *
 * I have millions of nodes in a system.
 * These nodes can be connected to each other.
 * I want to connect nodes & check if the nodes are already connected.
 *
 * Solution "Quick Find":
 *
 * I have N nodes in the system.
 * So, I create an array to represent them & their positions.
 * Example: N=5 [0 1 2 3 4 5] (length 6, 0 is ignored)
 *
 * Now to keep track of which node is connected to which, I use the ID
 * approach.
 * 2 nodes with same ID are connected.
 * The ID will just be the index of one of the connected nodes.
 *
 * Imagine this:
 * [0 1 2 3 4 5] index
 * [0 1 2 3 4 5] id
 *
 * In beginning every element has the same ID as its index.
 *
 * Now, 1U3 (union)
 * The ID of 1 & 3 will change to 1 (just picking the left ID consistently, the
 * right one can also be picked consistently).
 *
 * Result: [0 1 2 1 4 5]
 *
 * When I try to do 1C3 (connected)
 * The answers is True (because both have same IDs)
 *
 * Suppose we do 4U1
 * Then updating just set[1] to 4 is not enough.
 * We need to update every 1 in set to 4, because 1C3 & 4C1 => 3C4. (O(N))
 * This makes the time complexity of this algorithm O(N^2).
 *
 * Result: [0 4 2 4 4 5]
 */

package mayasage.algorithms.princeton.one.UnionFind;

public class UnionFindOne {
  private final int[] set;

  UnionFindOne(int n) {
    this.set = new int[n + 1];
    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
    }
  }

  void union(int p, int q) {
    if (connected(p, q)) return;

    int pID = set[p];
    int qID = set[q];

    for (int i = 0; i < set.length; i += 1) {
      int id = set[i];

      if (id == qID) {
        set[i] = pID;
      }
    }
  }

  boolean connected(int p, int q) {
    return set[p] == set[q];
  }

  int find(int p) {
    return set[p];
  }

  int count() {
    return set.length - 1;
  }
}
