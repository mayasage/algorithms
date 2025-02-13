package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

public interface IUnionFind {
        void connectTwoNodes(int node1Position, int node2Position);

        boolean areTwoNodesConnected(int node1Position, int node2Position);
}
