/*
152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/description/

Given an integer array nums, find a subarray that has the largest product, and
return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
integer.
 */

package mayasage.algorithms.leetcode;

public class Q152_MaximumProductSubarray {
  /**
   * Triple loops. Calculate every subarray.
   *
   * @param nums range -10 to +10
   * @return Integer.MIN_VALUE if length == 0
   */
  public static int on3(int[] nums) {
    int n = nums.length;
    int r = Integer.MIN_VALUE;
    for (int i = 0; i < n; i += 1) {
      for (int j = i; j < n; j += 1) {
        int p = 1;
        for (int k = i; k <= j; k += 1) {
          p *= nums[k];
        }
        r = Math.max(r, p);
      }
    }
    return r;
  }

  /**
   * Double loops. O(1) calculation by caching previous result.
   *
   * @param nums range -10 to +10
   * @return Integer.MIN_VALUE if length == 0
   */
  public static int on2(int[] nums) {
    int n = nums.length;
    double r = Integer.MIN_VALUE;
    for (int i = 0; i < n; i += 1) {
      double p = 1;
      for (int j = i; j < n; j += 1) {
        p *= nums[j];
        r = Math.max(r, p);
      }
    }
    return (int) r;
  }

  /**
   * Calculate maxSuffix and maxPrefix.
   * If there are no -ve, both will be equal and the answer.
   * If there are even number of -ve, both will be equal and the answer.
   * BUT, if there are odd number of -ve, one of them will be greater and the
   * answer.
   *
   * @param nums range -10 to +10
   * @return Integer.MIN_VALUE if length == 0
   */
  public static int on(int[] nums) {
    int n = nums.length;
    double r = Integer.MIN_VALUE;
    double c = 1;
    for (int i = 0; i < n; i += 1) {
      int x = nums[i];
      c *= x;
      r = Math.max(r, c);
      if (x == 0) c = 1;
    }
    c = 1;
    for (int i = n - 1; i >= 0; i -= 1) {
      int x = nums[i];
      c *= x;
      r = Math.max(r, c);
      if (x == 0) c = 1;
    }
    return (int) r;
  }

  /**
   * Intermediate answers are meaningless, but after the end of the loop, I'll
   * have my answer.
   *
   * @param nums range -10 to +10
   * @return Integer.MIN_VALUE if length == 0
   */
  public static int on_single_loop(int[] nums) {
    int n = nums.length;
    double res = Integer.MIN_VALUE;
    double p = 1;
    double s = 1;
    for (int i = 0; i < n; i += 1) {
      int l = nums[i];
      int r = nums[n - 1 - i];
      p *= l;
      s *= r;
      res = Math.max(res, Math.max(p, s));
      if (l == 0) p = 1;
      if (r == 0) s = 1;
    }
    return (int) res;
  }
}
