
public class Percolation 
{
    private boolean[][] theSite;
    private int[][] theSiteID;
    private int numberOfOpenSites = 0;
    private int size = 0;
    // creates n-by-n grid, with all sites initially blocked
    // add Exception
    public Percolation(int n)
    {
    	size = n;
    	if(n <= 0)
    	{
    		throw new IllegalArgumentException();
    	}
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
    		theSiteID[n - 1][num] = n * n - 1;
    	}
    }
    
    // opens the site (row, col) if it is not open already
    // add Exception
    public void open(int row, int col)
    {
    	if(outOfRange(row, col) == true)
    	{
    		throw new IllegalArgumentException();
    	}
    	if(!isOpen(row, col))
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
    }
    // is the site (row, col) open?
    // add Exception
    public boolean isOpen(int row, int col)
    {
    	if(outOfRange(row, col) == true)
    	{
    		throw new IllegalArgumentException();
    	}
    	return theSite[row - 1][col - 1];
    }

    // is the site (row, col) full?
    // add Exception
    public boolean isFull(int row, int col)
    {
    	if(outOfRange(row, col) == true)
    	{
    		throw new IllegalArgumentException();
    	}
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
    	if(rootOfSite(size, size) == rootOfSite(1, 1))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}	
    }
    // test client (optional)
    public static void main(String[] args)
    {
    	Percolation percolation = new Percolation(2);

    }
    private int rootOfSite(int row, int col)
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
    private boolean outOfRange(int row, int col)
    {
    	if(row < 1||row > size)
    	{
    		return true;
    	}
    	if(col < 1||col > size)
    	{
    		return true;
    	}
    	return false;
    }
}
