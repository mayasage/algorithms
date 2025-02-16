package mayasage.algorithms.princeton.one.percolation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PercolationStatsTest {

        @Test
        void runs() {
                for (int runs = 0; runs < 10; runs++) {
                        PercolationStats percolationStats = new PercolationStats(200, 100);
                        assertTrue(percolationStats.mean() > 0.58);
                        assertTrue(percolationStats.mean() < 0.6);
                        assertTrue(percolationStats.stddev() > 0.006);
                        assertTrue(percolationStats.stddev() < 0.013);
                        assertTrue(percolationStats.confidenceLo() > 0.58);
                        assertTrue(percolationStats.confidenceLo() < 0.6);
                        assertTrue(percolationStats.confidenceHi() > 0.58);
                        assertTrue(percolationStats.confidenceHi() < 0.6);
                }
        }

        @Test
        void testMainMethod() {
                String[] args = {"20", "10"};
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
                PercolationStats.main(args);
        }
}