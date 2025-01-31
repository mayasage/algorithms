package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

public class SolutionOne implements Solution {
        private final int[] connectionIds;

        public SolutionOne(int networkSize) {
                connectionIds = new int[networkSize];
                for (int i = 0; i < networkSize; i++) {
                        connectionIds[i] = i;
                }
        }

        @Override
        public void connectTwoNodes(int node1Position, int node2Position) {
                if (this.areTwoNodesConnected(node1Position, node2Position)) return;
                int connectionId1 = connectionIds[node1Position];
                int connectionId2 = connectionIds[node2Position];
                for (int i = 0; i < connectionIds.length; i++) {
                        if (connectionIds[i] == connectionId2) {
                                connectionIds[i] = connectionId1;
                        }
                }
        }

        @Override
        public boolean areTwoNodesConnected(int node1Position, int node2Position) {
                int connectionId1 = connectionIds[node1Position];
                int connectionId2 = connectionIds[node2Position];
                return connectionId1 == connectionId2;
        }
}
