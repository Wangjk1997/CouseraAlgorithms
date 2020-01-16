import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation 
{
    private boolean[][] theSite;
    private int[][] theSiteID;
    private int numberOfOpenSites = 0;
    private int size = 0;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
    	size = n;
    	theSite = new boolean[n][n];
    	for(boolean[] line: theSite)
    	{
    		for(boolean element: line)
    		{
    			element = false;
    		}
    	} 	
    	theSiteID = new int[n][n];
    	int counter = 0;
    	for(int i = 0; i< n; i++)
    	{
        	for(int j = 0; j< n; j++)
        	{
        		theSiteID[i][j] = counter++;
        	}
    	}
    	for(int num = 0; num < n; num ++)
    	{
    		theSiteID[0][num] = 0;
    		//theSiteID[n - 1][num] = -2;
    	}

    	for(int[] line: theSiteID)
    	{
    		for(int element: line)
    		{
    			//System.out.println(element);
    		}
    	}
    }
    
    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
    	theSite[row - 1][col - 1] = true;
    	//without weightedUnion
    	if(row < size)
    	{
    		if(isOpen(row + 1, col))
    		{
    	    	int currentRootRow = rootOfSite(row, col) / size + 1;
    			int currentRootCol = rootOfSite(row, col) % size + 1;
    			int neighborRootRow = rootOfSite(row + 1, col) / size + 1;
    			int neighbotRootCol = rootOfSite(row + 1, col) % size + 1;
    			theSiteID[currentRootRow - 1][currentRootCol - 1] = theSiteID[neighborRootRow - 1][neighbotRootCol - 1];
    		}
    	}
    	if(col < size)
    	{
    		if(isOpen(row, col + 1))
    		{
    	    	int currentRootRow = rootOfSite(row, col) / size + 1;
    			int currentRootCol = rootOfSite(row, col) % size + 1;
    			int neighborRootRow = rootOfSite(row, col + 1) / size + 1;
    			int neighbotRootCol = rootOfSite(row, col + 1) % size + 1;
    			theSiteID[currentRootRow - 1][currentRootCol - 1] = theSiteID[neighborRootRow - 1][neighbotRootCol - 1];
    		}
    	}
    	if(row > 1)
    	{
    		if(isOpen(row - 1, col))
    		{
    	    	int currentRootRow = rootOfSite(row, col) / size + 1;
    			int currentRootCol = rootOfSite(row, col) % size + 1;
    			int neighborRootRow = rootOfSite(row - 1, col) / size + 1;
    			int neighbotRootCol = rootOfSite(row - 1, col) % size + 1;
    			theSiteID[currentRootRow - 1][currentRootCol - 1] = theSiteID[neighborRootRow - 1][neighbotRootCol - 1];
    		}
    	}
    	if(col > 1)
    	{
    		if(isOpen(row, col - 1))
    		{
    	    	int currentRootRow = rootOfSite(row, col) / size + 1;
    			int currentRootCol = rootOfSite(row, col) % size + 1;
    			int neighborRootRow = rootOfSite(row, col - 1) / size + 1;
    			int neighbotRootCol = rootOfSite(row, col - 1) % size + 1;
    			theSiteID[currentRootRow - 1][currentRootCol - 1] = theSiteID[neighborRootRow - 1][neighbotRootCol - 1];
    		}
    	}
    	numberOfOpenSites ++;
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
    	return theSite[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
    	return isOpen(row, col) && (rootOfSite(row, col) == rootOfSite(1,1));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
    	return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates()
    {
    	for(int num = 0; num < size; num ++)
    	{
    		if(theSiteID[size - 1][num] == 0)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    // test client (optional)
    public static void main(String[] args)
    {
    	/*Percolation percolation = new Percolation(10);
    	percolation.open(1,5);
    	System.out.println(percolation.rootOfSite(2,5));
    	percolation.open(2,5);
    	System.out.println(percolation.rootOfSite(1,5));
    	System.out.println(percolation.rootOfSite(2,5));
    	System.out.println(percolation.rootOfSite(2,6));
    	percolation.open(2,6);
    	System.out.println(percolation.rootOfSite(2,6));
    	percolation.open(2,10);
    	System.out.println(percolation.rootOfSite(2,10));
    	percolation.open(2,9);
    	percolation.open(2,7);
    	percolation.open(2,8);
    	
    	System.out.println(percolation.rootOfSite(2,10));
    	System.out.println(percolation.rootOfSite(2,9));
    	System.out.println(percolation.isFull(2, 10));
    	System.out.println(percolation.rootOfSite(1,5));
    	System.out.println(percolation.rootOfSite(1,1));
    	System.out.println(percolation.rootOfSite(2,6));
    	System.out.println(percolation.rootOfSite(2,7));
    	System.out.println(percolation.rootOfSite(2,8));*/

    	
    }
    public int rootOfSite(int row, int col)
    {
    	int realNum = (row - 1) * size + (col - 1);
    	if(theSiteID[row - 1][col - 1] != realNum)
    	{
    		int rootRow = theSiteID[row - 1][col - 1] / size + 1;
    		int rootCol = theSiteID[row - 1][col - 1] % size + 1;
    		return rootOfSite(rootRow, rootCol);
    	}
    	else
    	{
    		return realNum;
    	}
    }

}
