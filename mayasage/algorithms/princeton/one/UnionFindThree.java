/*
 * Solution "Weighted Quick Union"
 *
 * You know, in the last "Quick Union" solution 1U2 probably built a different
 * tree than 2U1.
 * Data Structure wise, these operations were not equal.
 * 1U2 could have unbalanced tree, or maybe 2U1 would have.
 *
 * Can we do something about it ?
 * If we can make these 2 operations data structure wise equal, then what we'll
 * have is a "balanced" hidden tree.
 *
 * Think of it like this:
 *
 * - If the left tree is larger, and the right tree is smaller, we should
 * ideally put the right tree below the left tree, as this will keep the
 * depth of the tree the same.
 *
 * Example: Left tree has 1000 depth, and right tree has 200 depth. If we put
 *  left tree below right tree, the resulting tree depth will be 1001 (root
 * of right tree (1) + 1000 nodes of left tree below it).
 * If this keeps on going on the depth of the tree will keep on growing with
 * every union operation. So, if we perform enough union operations, we'll
 * have a long tree with depth = N nodes.
 * This mean root(p) becomes an O(N) operation.
 *
 * But now, what if we do the reverse.
 * Put right tree below left tree.
 * The depth doesn't change. It's still 1000.
 * No matter how many unions we do the depth will still be 1000.
 *
 * There however is one situation where depth will increase by 1, which is when
 * both left and right tree have the same number of nodes. Well someone has to
 * become the parent you know.
 *
 * But how far will this go ?
 * Well, in worst case you have 2 big trees, each having half the nodes in
 * the array.
 * So union on them will lead to a depth of N / 2 + 1.
 * This is the max depth of the tree.
 *
 * This effectively makes the root(p) into O(logN), i.e., only search half
 * the tree at max.
 *
 * So for M union operations, the *actual* running time complexity is
 * O (N + MLogN).
 * N is the time taken to read in the data.
 *
 * But just call it O(logN) for short.
 *
 * How does halving of nodes translate to logN ?
 * In short, everytime depth increases by 1, number of nodes nearly doubles.
 * Example:
 * union of 2 nodes : depth 2
 * union of 4 nodes : depth 3
 * union of 8 nodes : depth 4
 * union of 16 nodes : depth 5
 */

package mayasage.algorithms.princeton.one;

public class UnionFindThree {
  private final int[] set;
  private final int[] children;

  UnionFindThree(int n) {
    this.set = new int[n + 1];
    this.children = new int[n + 1];

    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
      children[i] = 1;
    }
  }

  private int root(int p) {
    int current = p;
    int parent = set[p];

    while (current != parent) {
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

      if (pCount < qCount) {        // q tree is larger
        children[qRoot] += pCount;  // q tree has pCount more nodes
        set[pRoot] = qRoot;         // root of p tree becomes a child of qRoot
      } else {                      // p tree is larger or equal
        children[pRoot] += qCount;  // p tree has qCount more nodes
        set[qRoot] = pRoot;         // root of q tree becomes a child of pRoot
      }
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

  int children(int p) {
    return children[p];
  }
}
