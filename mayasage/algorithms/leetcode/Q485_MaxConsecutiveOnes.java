/*
485. Max Consecutive Ones
https://leetcode.com/problems/max-consecutive-ones/description/

Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.
*/

package mayasage.algorithms.leetcode;

public class Q485_MaxConsecutiveOnes {
        public static int slidingWindow(int[] nums) {
                int n = nums.length;
                int maxWindowSizeSeen = 0;
                int windowStartIndex = 0;
                int windowEndIndex = 0;
                while (windowStartIndex < n) {
                        int windowStartElement = nums[windowStartIndex];
                        if (windowStartElement == 0) {
                                windowStartIndex++;
                                windowEndIndex++;
                        } else {
                                if (windowEndIndex == n) {
                                        maxWindowSizeSeen = Math.max(maxWindowSizeSeen, windowEndIndex - windowStartIndex);
                                        windowStartIndex = n;
                                } else {
                                        int windowEndElement = nums[windowEndIndex];
                                        if (windowEndElement == 0) {
                                                maxWindowSizeSeen = Math.max(maxWindowSizeSeen, windowEndIndex - windowStartIndex);
                                                windowStartIndex = windowEndIndex + 1;
                                        }
                                        windowEndIndex++;
                                }
                        }
                }
                return maxWindowSizeSeen;
        }

        public static int normalLoop(int[] nums) {
                int maxOneSeen = 0;
                int currentOneCount = 0;
                for (int num : nums) {
                        if (num == 1) {
                                currentOneCount++;
                        } else {
                                maxOneSeen = Math.max(maxOneSeen, currentOneCount);
                                currentOneCount = 0;
                        }
                }
                maxOneSeen = Math.max(maxOneSeen, currentOneCount);
                return maxOneSeen;
        }
}
