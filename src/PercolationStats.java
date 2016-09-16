import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by sunilpatil on 9/10/16.
 */
public class PercolationStats {

    private int experiments;
    private double[] numberOfOpenSites;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int gridSize, int experiments) {
        if (gridSize <= 0 || experiments <= 0)
            throw new IllegalArgumentException("Value of trials and n cannot be 0");
        this.experiments = experiments;
        Percolation percolation;
        numberOfOpenSites = new double[experiments];

        for (int t = 0; t < experiments; t++) {

            percolation = new Percolation(gridSize);
            double openSites = 0;
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(1, gridSize + 1);
                int j = StdRandom.uniform(1, gridSize + 1);
                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    openSites++;
                }


            }
            double fractionOfOpenSites = openSites / (gridSize * gridSize);
            numberOfOpenSites[t] = fractionOfOpenSites;
        }
    }

    // sample mean of percolation threshold
    public double mean() {

        return StdStats.mean(numberOfOpenSites);

    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(numberOfOpenSites);

    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(experiments));

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(experiments));


    }

    // test client (described below)
    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("Please set 2 arguments");
        int gridSize = Integer.parseInt(args[0]);
        int experiments = Integer.parseInt(args[1]);

        PercolationStats percolationStats =
                new PercolationStats(gridSize, experiments);

        String confidence = percolationStats.confidenceLo() + ", "
                + percolationStats.confidenceHi();
        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

}
