/*
 * Solution "Weighted Quick Union With Path Compression"
 *
 * I'm doing just 1 extra thing here.
 * I'm trying to make the hidden tree "flat".
 *
 * How ?
 *
 * I call the root(p) method all the time.
 * Inside this method I try to find the root of p by looping up the parent.
 * So what if, in loop, I set the current p to its parent's parent ?
 *
 * Imagine this tree:
 *          1
 *      2       3
 *            4   5
 *
 * When we try to find root(4) (can be during union or connected), we'll set
 * 4's parent as 1 (3's parent).
 *
 * Now even if the tree is deeply nested, root() called enough times, will
 * flatten it up one step at a time (lazily, only when we need it).
 *
 * In due time, there will be no nesting at all.
 * Every node's parent will be the root node.
 *
 * There is another way of doing this.
 * - You normally find the root.
 * - Then you iterate over every element you just looked, and make 'em point to
 *   the root you just found.
 * - Don't get mistaken and think this makes the algorithm O(N^2)! First time
 *   you run root(1000), it will surely be O(N^2) (actually you will never have
 *   this situation in the first place, because we would have already called the
 *   root enough times by now, so that it is already flattened, you know...
 *   think of it like this: to build root(1000) you would have already called
 *   root at least 999 times, and that means 999 times, the tree has already
 *   been flattened). But, after this very first call to root(), the tree is
 *   already flat. In the previous method, where I was trying to do the
 *   parent's parent thing, it wouldn't have flatted down the tree in
 *   one-shot... it would have required multiple root calls (as it does it
 *   one-step at a time).
 *
 * The actual running time-complexity of this algorithm is O(N + MLog*N).
 * Don't ask me what the * is.
 * Well ok, here it is:
 * "number of times the log function must be iteratively applied before the
 * result is less than or equal to 1"
 *
 * What does it mean ?
 * It's like this:
 * log(log(log(...log(N))))
 * The number of times you had to log, is the answer.
 * For practical purposes, consider this value 5.
 *
 *       N          log*N
 *       1            0
 *       2            1
 *       4            2
 *      16            3
 *     65536          4
 *    2^65536         5
 *
 * And actually the running time complexity can be further improved to something
 * called O(N + M<alpha_symbol>(M, N)).
 * This is called "Ackermann function".
 *
 * MASSIVELY beyond our scope.
 *
 * In short, you can treat Log*N as O(1).
 * Making the overall time-complexity O(N + M).
 */

package mayasage.algorithms.princeton.one;

public class UnionFindFour {
  private final int[] set;
  private final int[] children;

  UnionFindFour(int n) {
    this.set = new int[n + 1];
    this.children = new int[n + 1]; // Every el is a child of itself

    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
      children[i] = 1;
    }
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
