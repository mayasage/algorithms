/*
 * The goal is to create a ThreeSum implementation with time complexity of N^2.
 *
 * Solution:
 *
 * 1. Sort the array. [2 3 1 5 4] -> [1 2 3 4 5]
 *
 * 2. From left to right start picking elements one-by-one (O(N))
 *    I have the current element (cur).
 *    I know the target element (target).
 *    If I subtract the two, I'll know the remaining sum, that I need to have
 *    for the remaining 2 numbers (remaining).
 *
 * 3. To calculate this sum, I use 2 pointers (left and right).
 *    I calculate the sum (array[left] + array[right])
 *    If its equal to target, we're done.
 *    Else if it's less than the target, then the left pointer needs to
 *    increment.
 *    Else if it's more than the target, then the right pointer needs to
 *    decrement.
 *    The left pointer must always be less than the right pointer, and
 *    vice-versa.
 *
 * 4. If we don't find our indices by the end of the outer for loop, they
 *    just aren't there in the array.
 *    We close this chapter and move on with our lives.
 *
 * Time complexity = O(N^2) to Sort the Array
 *                   + (O(N) for outer loop * O(N) in worst case for inner loop)
 *                 = O(N^2)
 */

package mayasage.algorithms.princeton.one.three_sum;

import java.util.Arrays;

public class ThreeSumOne {
  public static int[] run(int[] numbers, int target) {
    int n = numbers.length;

    if (n < 3) {
      throw new RuntimeException("Array length can't be less than 3!");
    }

    Arrays.sort(numbers);

    for (int i = 0; i < n; i += 1) {
      int current = numbers[i];
      int remaining = target - current;

      // 2 pointers
      int l = i + 1;
      int r = n - 1;

      while (l < r) {
        int lVal = numbers[l];
        int rVal = numbers[r];
        int sum = lVal + rVal;

        if (sum == remaining) {
          return new int[]{i, l, r};
        } else if (sum < remaining) {
          l += 1;
        } else {
          r -= 1;
        }
      }
    }

    return new int[]{-1, -1, -1};
  }
}
