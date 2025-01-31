package mayasage.algorithms.princeton.one.connect_nodes_in_a_network;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
        void test(Solution solution, int networkSize) {
                for (int i = 0; i < networkSize; i++) {
                        assertTrue(solution.areTwoNodesConnected(i, i)); // reflexive
                        for (int j = i + 1; j < networkSize; j++) {
                                assertFalse(solution.areTwoNodesConnected(i, j));
                                assertFalse(solution.areTwoNodesConnected(j, i)); // symmetric
                        }
                }
                for (int i = 0; i < networkSize - 2; i++) {
                        solution.connectTwoNodes(i, i + 1);
                        assertTrue(solution.areTwoNodesConnected(i, i + 1));
                        solution.connectTwoNodes(i + 1, i + 2);
                        assertTrue(solution.areTwoNodesConnected(i, i + 2)); // transitive
                }
        }

        @Test
        public void solutionOne() {
                for (int i = 0; i < 100; i += 1) {
                        Solution solution = new SolutionOne(i);
                        test(solution, i);
                }
                // Connecting nodes is an O(N ^ 2) operation.
                Solution solution = new SolutionOne(10000000);
                for (int i = 1; i < 10000000; i += 1) {
                        solution.connectTwoNodes(i, i + 1);
                }
        }

        @Test
        public void solutionTwo() {
                for (int i = 0; i < 100; i += 1) {
                        Solution solution = new SolutionTwo(i);
                        test(solution, i);
                }
                Solution solution = new SolutionTwo(10000000);
                for (int i = 0; i < 10000000 - 2; i++) {
                        solution.connectTwoNodes(i, i + 1);
                        solution.connectTwoNodes(i + 1, i + 2);
                }
                double totalTime = 0.0;
                for (int m = 0; m < 1000; m += 1) {
                        Instant start = Instant.now();
                        for (int i = 0; i < 10000000 - 2; i++) {
                                assertTrue(solution.areTwoNodesConnected(i, i + 1));
                                assertTrue(solution.areTwoNodesConnected(i, i + 2)); // transitive
                        }
                        Instant end = Instant.now();
                        Duration duration = Duration.between(start, end);
                        double timeTaken = duration.toMillis() / 1000.0;
                        totalTime += timeTaken;
                        if (m == 0) {
                                assertTrue(timeTaken < 4, "Initial execution took too long: " + timeTaken + " seconds");
                        } else {
                                assertTrue(timeTaken < 0.1, "Subsequent executions took too long: " + timeTaken + " seconds");
                        }
                        if (m == 99) {
                                assertTrue(totalTime < 11, "Total time for first 100 iterations exceeded limit: " + totalTime + " seconds");
                        }
                        if (m == 999) {
                                assertTrue(totalTime < 120, "Total time for first 1000 iterations exceeded limit: " + totalTime + " seconds");
                        }
                }
        }
}