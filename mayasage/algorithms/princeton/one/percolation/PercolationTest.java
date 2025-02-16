package mayasage.algorithms.princeton.one.percolation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {
        void test(int n, IPercolation percolation) {
                for (int row = 1; row <= n; row++) {
                        for (int col = 1; col <= n; col++) {
                                assertFalse(percolation.isOpen(row, col));
                                assertFalse(percolation.isFull(row, col));
                                percolation.open(row, col);
                                assertTrue(percolation.isOpen(row, col));
                                assertTrue(percolation.isFull(row, col));
                                if (row < n) {
                                        assertFalse(percolation.percolates());
                                } else {
                                        assertTrue(percolation.percolates());
                                }
                        }
                }
        }

        @Test
        void testPercolation() {
                for (int n = 2; n <= 100; n++) {
                        test(n, new Percolation(n));
                        test(n, new PercolationBackWater(n));
                }
        }

        @Test
        void testBackWater() {
                for (int i = 0; i < 2; i++) {
                        IPercolation percolation = i == 0 ? new Percolation(3) : new PercolationBackWater(3);
                        percolation.open(1, 1);
                        percolation.open(2, 1);
                        percolation.open(3, 1);
                        assertTrue(percolation.percolates());
                        percolation.open(3, 3);
                        if (i == 0) {
                                assertTrue(percolation.isFull(3, 3)); // fails in Percolation
                        } else {
                                assertFalse(percolation.isFull(3, 3)); // succeeds in PercolationBackWater
                        }
                }
        }
}
