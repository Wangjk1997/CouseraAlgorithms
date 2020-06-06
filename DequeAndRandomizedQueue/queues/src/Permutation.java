import edu.princeton.cs.algs4.StdIn;
public class Permutation 
{
	public static void main(String[] args)
	{
		RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
		int k = StdIn.readInt(); // Number of strings to print
		while (StdIn.isEmpty()) 
		{
			String tmp = StdIn.readString();
			rQueue.enqueue(tmp);
		}
		while (!rQueue.isEmpty())
		{
			System.out.println(rQueue.dequeue());
		}
	}
}
