package mayasage.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q485_MaxConsecutiveOnesTest {
        @Test
        void slidingWindow() {
                TestCase[] testCases = new TestCase[]{
                        new TestCase(new int[]{1, 1, 0, 1, 1, 1}, 3),
                        new TestCase(new int[]{1, 0, 1, 1, 0, 1}, 2),
                        new TestCase(new int[]{1, 0, 0, 0, 0, 0}, 1),
                        new TestCase(new int[]{0, 0, 0, 0, 0, 1}, 1),
                        new TestCase(new int[]{1}, 1),
                        new TestCase(new int[]{0}, 0)
                };
                runTestsOnSlidingWindow(testCases);
                runTestsOnNormalLoop(testCases);
        }

        void runTestsOnSlidingWindow(TestCase[] testCases) {
                for (TestCase testCase : testCases) {
                        int answer = Q485_MaxConsecutiveOnes.slidingWindow(testCase.binaryArray);
                        assertEquals(testCase.expected, answer);
                }
        }

        void runTestsOnNormalLoop(TestCase[] testCases) {
                for (TestCase testCase : testCases) {
                        int answer = Q485_MaxConsecutiveOnes.normalLoop(testCase.binaryArray);
                        assertEquals(testCase.expected, answer);
                }
        }

        record TestCase(int[] binaryArray, int expected) {
        }
}