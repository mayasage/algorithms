/*
 * Solution "Quick Union" (Lazy approach)
 * Lazy approach means don't do the work unless you really have to. Postpone
 * and party until the end semester like a College student!
 *
 * Here we follow the same approach, but we change our data structure a little.
 *
 * Say, what if instead of trying to change every single ID using loop (which
 * was the reason for O(N) time complexity during the union operation), we
 * instead just store the leftID in the right element ?
 *
 * Imagine this:
 * [0 1 2 3 4 5] index
 * [0 1 2 3 4 5] id
 *
 * In beginning every element has the same ID as its index.
 *
 * Now, 1U3 (union)
 * 1 becomes the parent of 3.
 * Result: [0 1 2 1 4 5]
 *
 * Suppose we do, 4U1
 * 4 becomes the parent of 1.
 * Result: [0 4 2 1 4 5]
 *
 * But then we do, 2U1
 * Now 2 can't be a parent of 1 because 4 is the parent of 1.
 * I hid something.
 * The actual algorithm is something like this:
 * When we do (p U q) what we'll actually do is (root(p) U root(q))
 * Since we're going to the root (a root has no parent), we won't have any
 * trouble. Just make left root parent of right root.
 *
 * In our case, the result will be
 * root(2) = 2
 * root(1) = 4
 * So, 2 becomes the parent of 4.
 * Result: [0 4 2 1 2 5]
 *
 * I am just trying to build a hidden tree here.
 *
 * Finding 1C4 is as simple as root(1) == root(4), i.e., if both element belong
 * to the same tree, they are connected.
 *
 * There is 1 problem with this hidden tree thing.
 * If we connect a lot of elements, it is possible that our tree will become
 * long like O(N) array. So, when we try to find an element in the tree (we'll
 * have to traverse to root for every operation you know), then it's the same
 * O(N^2) but worse, because now even connected() requires traversal.
 *
 * In some situations where your tree won't be big, when you don't have a lot of
 * connections, or you have cleverly built the tree, which is likely not
 * (cleverly means instead rotating the union values, for example, instead of
 * doing 1U2 and making 1 the parent of 2, you reverse it and say 2U1 to make
 * 2 the parent of 1, because the 2 is a bigger tree than 1), you'll have
 * better performance with this algorithm. How much better, depends on the
 * length of the tree.
 *
 * The next algorithm will give us some guarantee to the length of the tree.
 */

package mayasage.algorithms.princeton.one.UnionFind;

public class UnionFindTwo {
  private final int[] set;

  UnionFindTwo(int n) {
    this.set = new int[n + 1];
    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
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
