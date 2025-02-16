package mayasage.algorithms.princeton.one.percolation;

public interface IPercolation {
        void open(int row, int col);

        boolean isOpen(int row, int col);

        boolean isFull(int row, int col);

        int numberOfOpenSites();

        boolean percolates();
}
