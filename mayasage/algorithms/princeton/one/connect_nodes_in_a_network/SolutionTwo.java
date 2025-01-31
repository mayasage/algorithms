package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

// #TODO Add findMax.
public class SolutionTwo implements Solution {
        private final int[] connectionId;

        public SolutionTwo(int networkSize) {
                connectionId = new int[networkSize];
                for (int i = 0; i < networkSize; i++) {
                        connectionId[i] = i;
                }
        }

        @Override
        public void connectTwoNodes(int node1, int node2) {
                if (!this.areTwoNodesConnected(node1, node2)) {
                        this.connectionId[node1] = node2;
                }
        }

        @Override
        public boolean areTwoNodesConnected(int node1, int node2) {
                int root1 = this.findRoot(node1);
                int root2 = this.findRoot(node2);
                return root1 == root2;
        }

        private int findRoot(int node) {
                if (node >= connectionId.length) {
                        throw new ArrayIndexOutOfBoundsException();
                }
                int myConnectionId;
                while (node != (myConnectionId = this.connectionId[node])) {
                        this.connectionId[node] = this.connectionId[myConnectionId];
                        node = myConnectionId;
                }
                return node;
        }
}
