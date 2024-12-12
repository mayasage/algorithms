package mayasage.algorithms.leetcode;

public class Q189_RotateArray {
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
