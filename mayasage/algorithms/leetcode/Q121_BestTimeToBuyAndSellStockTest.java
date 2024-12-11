package mayasage.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q121_BestTimeToBuyAndSellStockTest {

        @Test
        void on() {
                runTest(new int[]{7, 1, 5, 3, 6, 4}, 5);
                runTest(new int[]{7, 6, 4, 3, 1}, 0);
        }

        void runTest(int[] prices, int expected) {
                int maxProfit = Q121_BestTimeToBuyAndSellStock.on(prices);
                assertEquals(expected, maxProfit);
        }
}