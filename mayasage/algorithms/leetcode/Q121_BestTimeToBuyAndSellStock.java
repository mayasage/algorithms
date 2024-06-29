/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

You are given an array prices where prices[i] is the price of a given stock
on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and
choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot
achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must
buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */

package mayasage.algorithms.leetcode;

public class Q121_BestTimeToBuyAndSellStock {
  /**
   * Walk left to right O(N) with 2 variables: profit and lastCheapestPrice.
   * @param prices .
   * @return profit
   */
  public int on(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int r = 0;
    int m = prices[0];
    for (int i = 1; i < n; i += 1) {
      int x = prices[i];
      int p = x - m;
      if (p > r) r = p;
      if (x < m) m = x;
    }
    return r;
  }
}
