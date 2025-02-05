package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

public class UnionFindTwo implements IUnionFind {
        private final int[] connectionId;
        private final int[] hiddenTreeSize;

        public UnionFindTwo(int networkSize) {
                this.connectionId = new int[networkSize];
                this.hiddenTreeSize = new int[networkSize];
                for (int i = 0; i < networkSize; i++) {
                        this.connectionId[i] = i;
                        this.hiddenTreeSize[i] = 1;
                }
        }

        @Override
        public void connectTwoNodes(int node1, int node2) {
                int root1 = this.findRoot(node1);
                int root2 = this.findRoot(node2);
                if (root1 != root2) {
                        int root1HiddenTreeSize = this.hiddenTreeSize[root1];
                        int root2HiddenTreeSize = this.hiddenTreeSize[root2];
                        if (root1HiddenTreeSize >= root2HiddenTreeSize) {
                                this.connectionId[root2] = root1;
                                this.hiddenTreeSize[root1] += root2HiddenTreeSize;
                                this.hiddenTreeSize[root2] = 0;
                        } else {
                                this.connectionId[root1] = root2;
                                this.hiddenTreeSize[root2] += root1HiddenTreeSize;
                                this.hiddenTreeSize[root1] = 0;
                        }
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
