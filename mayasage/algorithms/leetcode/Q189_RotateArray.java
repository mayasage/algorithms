package mayasage.algorithms.leetcode;

public class Q189_RotateArray {
        /**
         * If k = 2, then swap in the correct values for the first 2 elements.
         * i = 0, j = n - k
         * The last 2 elements here will replace the 1st 2 elements.
         * Then do it for the next 2 and so on.
         * Your j pointer will run out of bound, so you'll need to reset it.
         * You reset it based on how much "bubble" exists in the remaining array.
         * When k = 2, and the last swaps made before j ran out was 1, then you only reset j to n - 1 (lastSwapCount).
         */
        public static void on(int[] nums, int k) {
                int n = nums.length;
                k = k % n;
                if (k == 0) return;
                int i = 0;
                int j = n - k;
                int swapCount = 0;
                int startJ = j;
                while (i < j) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        swapCount++;
                        i++;
                        j++;
                        if (j == n) {
                                j = n - swapCount;
                                swapCount = 0;
                                startJ = j;
                        }
                        if (i == startJ) {
                                swapCount = 0;
                                startJ = j;
                        }
                }
        }
}
