import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by sunilpatil on 9/10/16.
 */
public class Percolation {
    private static final int TOP = 0;

    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] opened;

    private int bottom;

    private int size;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Value of n cannot be <= 0");
        size = n;
        bottom = size * size + 1;

        weightedQuickUnionUF = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size)
            throw new IndexOutOfBoundsException("Index out of " +
                    "bound i ->" + i + ", j ->" + j);
        opened[i - 1][j - 1] = true;
        // When you open site in first row, connect it to imagniery top  element
        if (i == 1) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j), TOP);
        }

        // When you open site in last row, connect it to imaginery bottom element
        if (i == size) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j), bottom);
        }

        // If its not top most row connect to the element just above
        if (i != 1 && isOpen(i - 1, j)) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j),
                    getIndexInWeightedQF(i - 1, j));
        }

        // If its not bottom most row connect to the element just below
        if (i != size && isOpen(i + 1, j)) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j),
                    getIndexInWeightedQF(i + 1, j));
        }

        // If its not left most column connect to element on left
        if (j != 1 && isOpen(i, j - 1)) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j),
                    getIndexInWeightedQF(i, j - 1));
        }

        // If its not right most column connect to element on right
        if (j != size && isOpen(i, j + 1)) {
            weightedQuickUnionUF.union(getIndexInWeightedQF(i, j),
                    getIndexInWeightedQF(i, j + 1));
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size)
            throw new IndexOutOfBoundsException("Index out of bound i ->"
                    + i + ", j ->" + j);
        return opened[i - 1][j - 1];

    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {

        if (0 < i && i <= size && 0 < j && j <= size) {
            return weightedQuickUnionUF.connected(TOP, getIndexInWeightedQF(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(TOP, bottom);
    }

    private int getIndexInWeightedQF(int i, int j) {
        return size * (i - 1) + j;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);

        System.out.println("Is percolated " + percolation.percolates());
        percolation.open(1, 1);
        System.out.println("Is percolated " + percolation.percolates());
        percolation.open(2, 1);
        //     percolation.open(2,2);
        System.out.println("Is percolated " + percolation.percolates());
        percolation.open(3, 2);
        System.out.println("Is percolated " + percolation.percolates());
    }
}

