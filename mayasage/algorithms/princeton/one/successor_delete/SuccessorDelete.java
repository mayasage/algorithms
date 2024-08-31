/*
 * Read this:
 *
 * Question 3: Successor with delete.
 *
 * Given a set of n integers S = { 0 to N - 1} and a sequence of requests of
 * the following form:
 *
 * - Remove x from S
 * - Find the successor of x: the smallest y in S such that y >= x.
 *
 * design a data type so that all operations (except construction) take
 * logarithmic time or better in the worst case.
 *
 * Solution
 *
 * I did it using 2 methods:
 * 1. Weighted Union Find + Path Compression + Store Max Tree Value
 * 2. Union Find + Path Compression + Larger is always Root Skewing
 *
 * I created a class "SuccessorDelete".
 * This class will maintain an int[] next, such that next[0] => successor of
 * element 0.
 * Initialized it to [1 to N - 1, -1]. Yes, the last element = -1 to signify
 * that it has no successor.
 *
 * This class exposes just 2 operations.
 * - public void delete(int x)
 * - public int getSuccessor(int x)
 *
 * Before trying to understand these methods, let's first imagine the data
 * structures.
 * [SuccessorDelete] next = [0 to N-1, -1]
 * [UnionFind] set = [0 to N]
 *
 * Initially, every element in the set is its own tree. That is, If I want to
 * find root of any number in the set, it will be itself only.
 *
 * So, why do we need a set (or UnionFind for that matter) ?
 *
 * You see when I try to delete an element from the Set, I will have to update
 * every previous element in next that was previously pointing to this element
 * I just deleted. Why ? Because the previous elements are claiming this deleted
 * element to be their successor, but this element is deleted, so now all those
 *  elements that are claiming that this element is their successor have to be
 *  updated. I must tell them that this element is dead, and now their successor
 * is the element, that this dead element was pointing to (next[dead_element]).
 * This will be O(N).
 *
 * Why O(N) ?
 * If I deleted 10 - 1 million elements, then all the (9 to 1 million) elements
 * will be pointing right now at (1 million+1)th element.
 * Now if I delete this (1 million + 1)th element, then I have to update all the
 * previous (9 to 1 million) element to point to (1 million + 2)th element,
 * instead of (1 million)th element.
 * This is O(N).
 *
 * If we can apply Path Compression + Union Find to this, we can literally get
 * this done in O(1).
 * How ?
 * Let's dig deeper.
 *
 * Instead of updating every element in the array (the first lecture of this
 * section was this only), we'll instead create a hidden tree.
 * And we'll just point (next[x] to next[x - 1]), meaning if I deleted 3, I'll
 * do a union of whatever the 3 was pointing to with whatever the previous
 * element was pointing to.
 * That is, union(next[3], next[2]) = union(4,3)
 *
 * What if the previous element got deleted ?
 * If we delete 2, then we'll do union(next[2], next[1]).
 *
 * When I try to find a successor I'll just find the (next[x]) and do a root of
 * it.
 * If there is a hidden tree, then I'll reach the root (if you went the solution
 * 1 way, then root is always max, else in solution 2 you'll have to ask the max
 * element of the set of the x from the stored location) of it, else, I'll just
 * have next[x] as the answer.
 *
 * So, getSuccessor(3) = uf.getSetMax(next[x]) = uf.getSetMax(4) = 4 (4 is the
 * only node in its set/tree)
 *
 * getSuccessor(2) = uf.getSetMax(next[x]) = uf.getSetMax(3) = 4 (3 was deleted,
 * and it now points to 4, as we did 3 union 4)
 *
 * getSuccessor(1) = uf.getSetMax(next[x]) = uf.getSetMax(2) = 2 (2 is the only
 * node in its set/tree)
 */

package mayasage.algorithms.princeton.one.successor_delete;

public class SuccessorDelete {
  final private int[] next;

  final private UnionFind uf;

  SuccessorDelete(int n, UnionFind uf) {
    next = new int[n];

    for (int i = 0; i < n; i += 1) {
      next[i] = i + 1;
    }

    this.uf = uf;
  }

  public void delete(int x) {
    if (x > 0) {
      uf.union(next[x], next[x - 1]);
    }
  }

  public int getSuccessor(int x) {
    int successor = uf.getSetMax(next[x]);

    if (successor == next.length) {
      successor = -1;
    }

    return successor;
  }
}
