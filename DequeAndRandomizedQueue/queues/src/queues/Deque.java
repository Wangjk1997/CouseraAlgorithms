package queues;

public class Deque<Item> implements Iterable<Item> {

	private class Node<Item>
	{
		Item item;
		Node next;
		Node previous;
	}
	
	private Node start;
	private int sizeCounter = 0;
	
    // construct an empty deque
    public Deque()
    {
    	start.item = null;
    	start.next = null;
    	start.previous = null;
    	sizeCounter = 0;
    }
    // is the deque empty?
    public boolean isEmpty()
    {
    	return (sizeCounter == 0);
    }
    // return the number of items on the deque
    public int size()
    {
    	return sizeCounter;
    }
    // add the item to the front
    public void addFirst(Item item)
    {
    	Node oldStart = start;
    	start.item = item;
    	start.next = oldStart;
    	start.previous = null;
    	oldStart.previous  = start;
    	sizeCounter++;
    }
    // add the item to the back
    public void addLast(Item item)
    {
    	Node oldStart = start;
    	start.item = item;
    	start.previous = oldStart;
    	start.next = null;
    	oldStart.next  = start;
    	sizeCounter++;
    }
    // remove and return the item from the front
    public Item removeFirst()
    {
    	
    }
    // remove and return the item from the back
    public Item removeLast()

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}