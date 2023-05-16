package ds.students;

import java.util.EmptyStackException;

import ds.interfaces.Stack;

/**
 * @author simont
 *
 */
public class DSStack extends Stack {

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	//empty constructor
	public DSStack() {
	}
	
	//copy constructor to perform a deep copy of the list
	public DSStack(DSStack other) {
		
		Node node = other.list.head; // temp node to store the head of the list
	   
		//loop till the end of the list 
		while(node != null) {
			
			//performing deep copy
	    	this.push(node.getToken());
	    	node = node.next;
	}
	    }
	//this method adds the object to the top of the stack
	public Token push(Token obj) {
		
		//adding the object to the top of the stack by calling the add method from DSList
		list.add(obj);
		
		return obj;
	}

	//this method return the token object at the top
	public Token peek() {

		//calling the get method from DSList to return the object at the top of the stack
		return list.get(list.size()-1);
		}
	
	//this method removes and returns the element at the top of the stack
	public Token pop() {
		
		//if list is null throw exception
		if(list == null) throw new EmptyStackException();
		 
		//removing and returning the top element of the stack by calling remove method from DSLIST 
		return list.remove((list.size()-1));
		}

	//this method checks if the stack is empty or not
	public boolean isEmpty() {
		return list.isEmpty();
	}

	//this method returns the size of the stack 
	public int size() {
		return list.size();
	}
	
	@Override
	//this method returns the stack in the form of a string
	public String toString() {
		return list.toString();
	}
	


}
