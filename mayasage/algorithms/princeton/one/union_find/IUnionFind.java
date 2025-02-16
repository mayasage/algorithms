package mayasage.algorithms.princeton.one.union_find;

public interface IUnionFind {
        void connectTwoNodes(int node1Position, int node2Position);

        boolean areTwoNodesConnected(int node1Position, int node2Position);
}
