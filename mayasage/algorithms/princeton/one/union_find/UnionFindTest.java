package mayasage.algorithms.princeton.one.union_find;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {
        void test(IUnionFind IUnionFind, int networkSize) {
                for (int i = 0; i < networkSize; i++) {
                        assertTrue(IUnionFind.areTwoNodesConnected(i, i)); // reflexive
                        for (int j = i + 1; j < networkSize; j++) {
                                assertFalse(IUnionFind.areTwoNodesConnected(i, j));
                                assertFalse(IUnionFind.areTwoNodesConnected(j, i)); // symmetric
                        }
                }
                for (int i = 0; i < networkSize - 2; i++) {
                        IUnionFind.connectTwoNodes(i, i + 1);
                        assertTrue(IUnionFind.areTwoNodesConnected(i, i + 1));
                        IUnionFind.connectTwoNodes(i + 1, i + 2);
                        assertTrue(IUnionFind.areTwoNodesConnected(i, i + 2)); // transitive
                }
        }

        @Test
        public void solutionOne() {
                for (int i = 0; i < 100; i += 1) {
                        IUnionFind IUnionFind = new UnionFindOne(i);
                        test(IUnionFind, i);
                }
                // Connecting nodes is an O(N ^ 2) operation.
                // IUnionFind IUnionFind = new UnionFindOne(10000000);
                // for (int i = 1; i < 10000000; i += 1) {
                //        IUnionFind.connectTwoNodes(i, i + 1);
                // }
        }

        @Test
        public void solutionTwo() {
                for (int i = 0; i < 100; i += 1) {
                        IUnionFind IUnionFind = new UnionFindTwo(i);
                        test(IUnionFind, i);
                }
                IUnionFind IUnionFind = new UnionFindTwo(10_000_000);
                for (int i = 0; i < 10_000_000 - 2; i++) {
                        IUnionFind.connectTwoNodes(i, i + 1);
                        IUnionFind.connectTwoNodes(i + 1, i + 2);
                }
                Instant start = Instant.now();
                for (int m = 0; m < 100; m += 1) {
                        for (int i = 0; i < 10_000_000 - 2; i++) {
                                assertTrue(IUnionFind.areTwoNodesConnected(i, i + 1));
                                assertTrue(IUnionFind.areTwoNodesConnected(i, i + 2)); // transitive
                        }
                }
                Instant end = Instant.now();
                Duration duration = Duration.between(start, end);
                assertTrue(duration.toSeconds() < 8);
                // Tree test
                int networkSize = 10_000_000;
                IUnionFind = new UnionFindTwo(networkSize);
                int logBase2NetworkSize = (int) (Math.log(networkSize) / Math.log(2));
                for (int i = 0; i < logBase2NetworkSize; i += 1) {
                        for (int j = 0; j < networkSize - (int) Math.pow(2, i) - 1; j += (int) Math.pow(2, i + 1)) {
                                IUnionFind.connectTwoNodes(j, j + (int) Math.pow(2, i));
                        }
                }
                for (int i = 0; i < (int) Math.pow(2, logBase2NetworkSize) - 1; i++) {
                        assertTrue(IUnionFind.areTwoNodesConnected(i, i + 1));
                }
        }
}