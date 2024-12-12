package mayasage.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q152_MaximumProductSubarrayTest {
        record TestCase(int[] nums, int max) {
        }

        List<TestCase> getTestCases() {
                List<TestCase> testCases = new ArrayList<>();
                testCases.add(new TestCase(new int[]{2, 3, -2, 4}, 6));
                testCases.add(new TestCase(new int[]{-2, 0, -1}, 0));
                testCases.add(new TestCase(new int[]{-2}, -2));
                testCases.add(new TestCase(new int[]{1, 2}, 2));
                testCases.add(new TestCase(new int[]{0, 2}, 2));
                return testCases;
        }

        @Test
        void triple_loops() {
                List<TestCase> testCases = getTestCases();
                for (TestCase testCase : testCases) {
                        int max = Q152_MaximumProductSubarray.triple_loops(testCase.nums());
                        assertEquals(testCase.max(), max);
                }
        }

        @Test
        void double_loops() {
                List<TestCase> testCases = getTestCases();
                for (TestCase testCase : testCases) {
                        int max = Q152_MaximumProductSubarray.double_loops(testCase.nums());
                        assertEquals(testCase.max(), max);
                }
        }

        @Test
        void two_loops() {
                List<TestCase> testCases = getTestCases();
                for (TestCase testCase : testCases) {
                        int max = Q152_MaximumProductSubarray.two_loops(testCase.nums());
                        assertEquals(testCase.max(), max);
                }
        }

        @Test
        void two_loops_into_one() {
                List<TestCase> testCases = getTestCases();
                for (TestCase testCase : testCases) {
                        int max = Q152_MaximumProductSubarray.two_loops_into_one(testCase.nums());
                        assertEquals(testCase.max(), max);
                }
        }

        @Test
        void one_loop() {
                List<TestCase> testCases = getTestCases();
                for (TestCase testCase : testCases) {
                        int max = Q152_MaximumProductSubarray.one_loop(testCase.nums());
                        assertEquals(testCase.max(), max);
                }
        }
}