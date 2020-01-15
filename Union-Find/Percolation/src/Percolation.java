import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation 
{
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
    	theSite = new boolean[n][n];
    	for(boolean[] line: theSite)
    	{
    		for(boolean element: line)
    		{
    			element = false;
    			System.out.println(element);
    		}
    	} 	
    }
    
    /*// opens the site (row, col) if it is not open already
    public void open(int row, int col)

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)

    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()
	*/
    // test client (optional)
    public static void main(String[] args)
    {
    	Percolation percolation = new Percolation(10);
    	
    }
    private boolean[][] theSite;
}
