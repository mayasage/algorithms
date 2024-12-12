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

        public static int triple_loops(int[] nums) {
                int max = nums[0];
                for (int startIndex = 0; startIndex < nums.length; startIndex++) {
                        int product = 1;
                        for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                                for (int i = startIndex; i <= endIndex; i++) {
                                        product *= nums[i];
                                }
                                max = Math.max(max, product);
                                product = 1;
                        }
                }
                return max;
        }

        public static int double_loops(int[] nums) {
                int max = nums[0];
                for (int startIndex = 0; startIndex < nums.length; startIndex++) {
                        int product = 1;
                        for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                                product *= nums[endIndex];
                                max = Math.max(max, product);
                        }
                }
                return max;
        }

        public static int two_loops(int[] nums) {
                int max = nums[0];
                int productLeftToRight = 1;
                for (int x : nums) {
                        productLeftToRight *= x;
                        max = Math.max(max, productLeftToRight);
                        if (productLeftToRight == 0) productLeftToRight = 1;
                }
                int productRightToLeft = 1;
                for (int i = nums.length - 1; i >= 0; i--) {
                        int x = nums[i];
                        productRightToLeft *= x;
                        max = Math.max(max, productRightToLeft);
                        if (productRightToLeft == 0) productRightToLeft = 1;
                }
                return max;
        }

        /**
         * It looks like this will run worse than the 2 loops one.
         * I read somewhere that someone between compiler, os, calculation hardware will run better if it can anticipate
         * where it has to jump next.
         */
        public static int two_loops_into_one(int[] nums) {
                int max = nums[0];
                int productLeftToRight = 1;
                int productRightToLeft = 1;
                for (int i = 0; i < nums.length; i++) {
                        int leftValue = nums[i];
                        int rightValue = nums[nums.length - 1 - i];
                        productLeftToRight *= leftValue;
                        productRightToLeft *= rightValue;
                        max = Math.max(max, productLeftToRight);
                        max = Math.max(max, productRightToLeft);
                        if (productRightToLeft == 0) productRightToLeft = 1;
                        if (productLeftToRight == 0) productLeftToRight = 1;
                }
                return max;
        }

        public static int one_loop(int[] nums) {
                int max = nums[0];
                int minValueTillNow = nums[0];
                int maxValueTillNow = nums[0];
                for (int i = 1; i < nums.length; i++) {
                        int x = nums[i];
                        int minX = minValueTillNow * x;
                        int maxX = maxValueTillNow * x;
                        minValueTillNow = Math.min(x, Math.min(minX, maxX));
                        maxValueTillNow = Math.max(x, Math.max(minX, maxX));
                        max = Math.max(max, maxValueTillNow);
                }
                return max;
        }
}
