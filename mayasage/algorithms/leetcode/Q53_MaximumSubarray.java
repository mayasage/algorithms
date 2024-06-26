/*
53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the subarray with the largest sum, and
return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

package mayasage.algorithms.leetcode;

public class Q53_MaximumSubarray {
  /**
   * Walk left to right O(N) with 2 variables: currentSum and totalSum.
   * @param nums min length should be 1
   * @return sum
   */
  public static int on(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    int r = nums[0];
    int c = nums[0];
    for (int i = 1; i < n; i += 1) {
      int x = nums[i];
      if (c < 0) c = 0;
      c += x;
      if (c > r) r = c;
    }
    return r;
  }
}
