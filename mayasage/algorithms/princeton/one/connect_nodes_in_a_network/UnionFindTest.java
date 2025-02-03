package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {
        void test(UnionFind unionFind, int networkSize) {
                for (int i = 0; i < networkSize; i++) {
                        assertTrue(unionFind.areTwoNodesConnected(i, i)); // reflexive
                        for (int j = i + 1; j < networkSize; j++) {
                                assertFalse(unionFind.areTwoNodesConnected(i, j));
                                assertFalse(unionFind.areTwoNodesConnected(j, i)); // symmetric
                        }
                }
                for (int i = 0; i < networkSize - 2; i++) {
                        unionFind.connectTwoNodes(i, i + 1);
                        assertTrue(unionFind.areTwoNodesConnected(i, i + 1));
                        unionFind.connectTwoNodes(i + 1, i + 2);
                        assertTrue(unionFind.areTwoNodesConnected(i, i + 2)); // transitive
                }
        }

        @Test
        public void solutionOne() {
                for (int i = 0; i < 100; i += 1) {
                        UnionFind unionFind = new UnionFindOne(i);
                        test(unionFind, i);
                }
                // Connecting nodes is an O(N ^ 2) operation.
                UnionFind unionFind = new UnionFindOne(10000000);
                for (int i = 1; i < 10000000; i += 1) {
                        unionFind.connectTwoNodes(i, i + 1);
                }
        }

        @Test
        public void solutionTwo() {
                for (int i = 0; i < 100; i += 1) {
                        UnionFind unionFind = new UnionFindTwo(i);
                        test(unionFind, i);
                }
                UnionFind unionFind = new UnionFindTwo(10_000_000);
                for (int i = 0; i < 10_000_000 - 2; i++) {
                        unionFind.connectTwoNodes(i, i + 1);
                        unionFind.connectTwoNodes(i + 1, i + 2);
                }
                Instant start = Instant.now();
                for (int m = 0; m < 100; m += 1) {
                        for (int i = 0; i < 10_000_000 - 2; i++) {
                                assertTrue(unionFind.areTwoNodesConnected(i, i + 1));
                                assertTrue(unionFind.areTwoNodesConnected(i, i + 2)); // transitive
                        }
                }
                Instant end = Instant.now();
                Duration duration = Duration.between(start, end);
                assertTrue(duration.toSeconds() < 8);
                // Tree test
                int networkSize = 10_000_000;
                unionFind = new UnionFindTwo(networkSize);
                int logBase2NetworkSize = (int) (Math.log(networkSize) / Math.log(2));
                for (int i = 0; i < logBase2NetworkSize; i += 1) {
                        for (int j = 0; j < networkSize - (int) Math.pow(2, i) - 1; j += (int) Math.pow(2, i + 1)) {
                                unionFind.connectTwoNodes(j, j + (int) Math.pow(2, i));
                        }
                }
                for (int i = 0; i < (int) Math.pow(2, logBase2NetworkSize) - 1; i++) {
                        assertTrue(unionFind.areTwoNodesConnected(i, i + 1));
                }
        }
}