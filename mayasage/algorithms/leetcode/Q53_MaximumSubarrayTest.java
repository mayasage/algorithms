package mayasage.algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.*;

class Q53_MaximumSubarrayTest {

        @org.junit.jupiter.api.Test
        void on() {
                runTest(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);
                runTest(new int[]{5, 4, -1, 7, 8}, 23);
                runTest(new int[]{1}, 1);
                runTest(new int[]{-1, 1, -2, 2}, 2);
                runTest(new int[]{-1, -1, -2, 2}, 2);
                runTest(new int[]{-1, -1, -2, -4}, -1);
        }

        void runTest(int[] nums, int expected) {
                int maxSum = Q53_MaximumSubarray.on(nums);
                assertEquals(expected, maxSum);
        }
}