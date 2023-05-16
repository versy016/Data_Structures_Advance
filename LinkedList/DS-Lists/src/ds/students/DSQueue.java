package ds.students;

import ds.interfaces.Queue;

/**
 * @author simont
 *
 */
public class DSQueue extends Queue {
	
	//copy constructor to perform a deep copy of the list
	public DSQueue(Queue s) {

		Node node = s.list.head;	// temp node to store the head of the list
	    
		//loop till the end of the list 
		while(node != null) {
			
			//performing deep copy
	    	this.offer(node.getToken());
	    	node = node.next;
	    }
	}

	//empty constructor
	public DSQueue() {
	}

	//Method to add the token objects to the end of the list
	public boolean offer(Token t) {
		//thow exception is obj is null
		if(t == null) throw new NullPointerException();

		//calling add method from DSList to add the object to the on the queue
		return list.add(t);
			
	}

	@Override
	//This method removes and returns the head of the Queue. 
	public Token poll() {
		
		//calling the remove(index) method from DSList to remove the head of the queue
		return list.remove(list.indexOf(list.head.getToken()));
	}

	@Override
	//This is method returns then token pointed by the head of the queue
	public Token peek() {
		
		//if list is null return null
		if(list == null)
		return null;
	    
		//calling the gettoken to return the token at the head
		else {
			return list.head.getToken();
		}
	}

	@Override
	//this method returns the queue in the form of string
	public String toString() {
		return list.toString();
	}

	@Override
	//this method returns the size of the queue
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
