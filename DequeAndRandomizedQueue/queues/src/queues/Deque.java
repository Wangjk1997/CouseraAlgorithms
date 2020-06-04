package queues;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private class Node<Item>
	{
		Item item;
		Node next;
		Node previous;
	}
	
	private Node start;
	private Node end;
	private int sizeCounter = 0;
	
    // construct an empty deque
    public Deque()
    {
    	start = new Node();
    	end = new Node();
    	start.item = null;
    	start.previous = null;
    	start.next = end;
    	end.item = null;
    	end.previous = start;
    	end.next = null;
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
    	if(item == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	Node insert = new Node();
    	start.next.previous = insert;
        insert.item = item;
        insert.next = start.next;
        insert.previous = start;
        start.next  = insert;
        
        sizeCounter++;
    }
    // add the item to the back
    public void addLast(Item item)
    {
    	if(item == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	Node insert = new Node();
    	end.previous.next = insert;
        insert.item = item;
        insert.previous = end.previous;
        insert.next = end;
        end.previous  = insert;
        sizeCounter++;
    }
    // remove and return the item from the front
    public Item removeFirst()
    {
    	if(isEmpty() == true)
    	{
    		throw new java.util.NoSuchElementException ();
    	}
    	Item item = (Item) start.next.item;
    	start.next.next.previous = start;
    	start.next = start.next.next;
    	sizeCounter--;
    	return item;
    }
    // remove and return the item from the back
    public Item removeLast()
    {
    	if(isEmpty() == true)
    	{
    		throw new java.util.NoSuchElementException ();
    	}
    	Item item = (Item) end.previous.item;
    	end.previous.previous.next = end;
    	end.previous = end.previous.previous;
    	sizeCounter--;
    	return item;
    }
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
    	return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
    	private Node current = start.next;
    	
    	public boolean hasNext() { return current.next != null; }
    	public void remove() { throw new UnsupportedOperationException(); }
    	public Item next()
    	{
    		
    		Item item = (Item) current.item;
    		if(item == null)
    		{
    			throw new java.util.NoSuchElementException();
    		}
    		current = current.next;
    		return item;
    	}
    }
    // unit testing (required)
    public static void main(String[] args)
    {
    	Deque<String> theTest = new Deque();
    	theTest.addFirst("this");
    	theTest.addFirst("is");
    	theTest.addFirst("me");
    	theTest.addLast(",");
    	Iterator it = theTest.iterator();
    	while(it.hasNext())
    	{
    		System.out.println(it.next());
    	}
    }
}