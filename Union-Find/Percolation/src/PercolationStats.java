import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats {
    // perform independent trials on an n-by-n grid
	private int size = 0;
	private int trials = 0;
	private double[] threshold;
    public PercolationStats(int n, int trials)
    {
    	size = n;
    	this.trials = trials;
    	threshold = new double [trials];
    	if(n <= 0)
    	{
    		throw new IllegalArgumentException();
    	}
    	if(trials <= 0)
    	{
    		throw new IllegalArgumentException();
    	}
    	for(int i = 0; i < trials; i++)
    	{
    		Percolation percolation = new Percolation(n);
    		while(!percolation.percolates())
    		{
    			int openRow = StdRandom.uniform(1,n + 1);
    			int openCol = StdRandom.uniform(1,n + 1);
    			percolation.open(openRow, openCol);
    		}
    		double upNum = percolation.numberOfOpenSites();
    		double downNum = size * size;
    		threshold[i] = upNum/downNum;
    		//System.out.println(threshold[i]);
    	}
    }

    // sample mean of percolation threshold
    public double mean()
    {
    	return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
    	return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
    	return (mean() - 1.96 * stddev() / Math.sqrt(trials));
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
    	return (mean() + 1.96 * stddev() / Math.sqrt(trials));
    }

   // test client (see below)
   public static void main(String[] args)
   {
	   PercolationStats percolationStats = new PercolationStats(200,100);
	   System.out.println(percolationStats.mean());
	   System.out.println(percolationStats.stddev());
   }
}
