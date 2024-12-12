package mayasage.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q189_RotateArrayTest {
        record TestCase(int[] nums, int k, int[] answer) {
        }

        List<TestCase> getTestCases() {
                List<TestCase> testCases = new ArrayList<>();
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 1, new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 2, new int[]{11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3, new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 4, new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 5, new int[]{8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 6, new int[]{7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 7, new int[]{6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 8, new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 9, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 10, new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 11, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));

                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 13, new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 14, new int[]{11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 15, new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 16, new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 17, new int[]{8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 18, new int[]{7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 19, new int[]{6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 20, new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 21, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 22, new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 23, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1}));
                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 24, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));

                testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}));
                testCases.add(new TestCase(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}));
                return testCases;
        }

        @Test
        void on() {
                for (TestCase testCase : getTestCases()) {
                        int[] clone = testCase.nums.clone();
                        Q189_RotateArray.on(clone, testCase.k);
                        for (int i = 0; i < testCase.answer.length; i++) {
                                assertEquals(testCase.answer[i], clone[i]);
                        }
                }
        }
}