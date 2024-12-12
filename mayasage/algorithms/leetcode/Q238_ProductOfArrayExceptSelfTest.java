package mayasage.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q238_ProductOfArrayExceptSelfTest {
        record TestCase(int[] nums, int[] answers) {
        }

        List<TestCase> getTestCases() {
                List<TestCase> testCases = new ArrayList<>();
                testCases.add(new TestCase(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}));
                testCases.add(new TestCase(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}));
                testCases.add(new TestCase(new int[]{-1, -1}, new int[]{-1, -1}));
                testCases.add(new TestCase(new int[]{0, -1}, new int[]{-1, 0}));
                testCases.add(new TestCase(new int[]{-1, 0}, new int[]{0, -1}));
                testCases.add(new TestCase(new int[]{0, 0}, new int[]{0, 0}));
                return testCases;
        }

        @Test
        void two_loops() {
                for (TestCase testCase : getTestCases()) {
                        int[] answers = Q238_ProductOfArrayExceptSelf.two_loops(testCase.nums);
                        for (int i = 0; i < testCase.answers.length; i++) {
                                assertEquals(answers[i], testCase.answers[i]);
                        }
                }
        }
}