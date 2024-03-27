package mayasage.algorithms.princeton.one.SocialNetworkConnectivity;

class UnionFind {
  private final int[] set;
  private final int[] children;
  private int connectedNodes;

  UnionFind(int n) {
    set = new int[n + 1]; // +1 for 0, I'm ignoring 0. Index starts at 1.
    children = new int[n + 1]; // Every el is a child of itself
    connectedNodes = 1; // Every node is connected to itself

    for (int i = 0; i < n + 1; i += 1) {
      set[i] = i;
      children[i] = 1;
    }
  }

  public int getConnectedNodes() {
    return connectedNodes;
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

        if (children[qRoot] > connectedNodes) {
          connectedNodes = children[qRoot];
        }
      } else {                      // p tree is larger or equal
        children[pRoot] += qCount;  // p tree has qCount more nodes
        set[qRoot] = pRoot;         // root of q tree becomes a child of pRoot

        if (children[pRoot] > connectedNodes) {
          connectedNodes = children[pRoot];
        }
      }
    }
  }
}
