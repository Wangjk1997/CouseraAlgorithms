import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> 
{

	private Item[] rQueue;
	private int N = 0;
    // construct an empty randomized queue
    public RandomizedQueue()
    {
    	resize(1);
    }
    // is the randomized queue empty?
    public boolean isEmpty()
    {
    	return (N == 0);
    }
    // return the number of items on the randomized queue
    public int size()
    {
    	return N;
    }
    // resize the queue
    private void resize(int capacity)
    {
    	Item[] copy = (Item[]) new Object[capacity];
    	for(int i = 0; i < N; i++)
    	{
    		copy[i] = rQueue[i];
    	}
    	rQueue = copy;
    }
    // add the item
    public void enqueue(Item item)
    {
    	if(item == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	if(N == rQueue.length)
    	{
    		resize(2 * rQueue.length);
    	}
    	rQueue[N++] = item;
    }
    // remove and return a random item
    public Item dequeue()
    {
    	if(isEmpty())
    	{
    		throw new java.util.NoSuchElementException();
    	}
    	int number = StdRandom.uniform(N);
    	Item item = rQueue[number];
    	rQueue[number] = rQueue[--N];
    	rQueue[N] = null;
    	if (N > 0 && N == rQueue.length/4)
    	{
    		resize(rQueue.length/2);
    	}
    	return item;
    }
    // return a random item (but do not remove it)
    public Item sample()
    {
    	if(isEmpty())
    	{
    		throw new java.util.NoSuchElementException();
    	}
    	return rQueue[StdRandom.uniform(N)];
    }
    // return an independent iterator over items in random order
	public Iterator<Item> iterator() 
	{
		 return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		int current = 0;
		public boolean hasNext()
		{
			return (current != N);
		}
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next()
		{
			if(current >= N)
			{
				throw new java.util.NoSuchElementException();
			}
			return (rQueue[current++]);
		}
	}
    // unit testing (required)
    public static void main(String[] args)
    {
    	RandomizedQueue<Integer> test = new RandomizedQueue<Integer>();
    	test.enqueue(20);
    	test.enqueue(15);
    	test.enqueue(30);
    	test.enqueue(20);
		/*
		 * while(!test.isEmpty()) { System.out.println(test.dequeue()); }
		 */
    	Iterator<Integer> it = test.iterator();
    	while(it.hasNext())
    	{
    		System.out.println(it.next());
    	}
    }
}