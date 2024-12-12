/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/description/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

package mayasage.algorithms.leetcode;

public class Q238_ProductOfArrayExceptSelf {
        public static int[] two_loops(int[] nums) {
                int[] answers = new int[nums.length];
                int prefix = 1;
                answers[0] = 1;
                for (int i = 1; i < nums.length; i++) {
                        prefix *= nums[i - 1];
                        answers[i] = prefix;
                }
                int suffix = 1;
                for (int i = nums.length - 2; i >= 0; i--) {
                        suffix *= nums[i + 1];
                        answers[i] *= suffix;
                }
                return answers;
        }
}
