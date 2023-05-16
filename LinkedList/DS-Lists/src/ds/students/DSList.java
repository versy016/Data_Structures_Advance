package ds.students;

import ds.interfaces.List;

/**
 * @author simont
 *
 */
public class DSList implements List 
{
	public Node head;
	private Node tail;

	//empty constructor
	public DSList() {
		
	}
	public DSList(Node head) {
		//setting node to head;
		this.head = head;
	}
	 
	//copy constructor to perform a deep copy of the list
	public DSList(DSList other) {  
		
		Node node = other.head;				// temp node to store the head of the list
	    
		//loop till the end of the list 
		while(node != null) {			
			
			//performing deep copy
	    	this.add(node.getToken());
	    	node = node.next;
	    }
	}
				
	//Remove the object at the specified index from the list, if it exists. 
	public Token remove(int index) {
		
		//thrwoing exception when index is out of range 
		if(get(index)==null && index>=size())throw new IndexOutOfBoundsException();
		
		Node item;  //node variable to store node item which has to be removed 
		
		//removing node if it is at first index
		if(index ==0) 
		{
			//removing the node at the given index
			//and adjusting the list by changing the node references
			item = head;
			head=head.next;
			item.next =null;
		
			return item.getToken();
		}
		
		//codition to remove a node if it is in the middle or at the end
		else
		{
			Node current = head;     //variable to store the current node
			int count = 0; 			 //variable to count the index and move forward
        
		//while loop which runs until it matches the index
		//it sets the count equal to the index 
		while(count!=index) 
		{
			current = current.next;
			count++;
		}
		//removing the node at the given index
		//and adjusting the list by changing the node references
		item = current;
		Node previous = current.prev;
		previous.next =current.next;
		current.next=null;
		   	  
		return item.getToken();
	}}
	
	//Returns the first index of the specified object, or -1 if the object does not exist
	public int indexOf(Token obj) {
		
		//return -1 when token object is null
		if(obj == null) 
		{
			return -1;
		}
		
		int index=0; 				//variable to store the index
		Node current = head; 		//variable to store the current node
		
		//while loop which runs till the end of the list
		//returns the index if its matches the given token 
		//returns -1 it it does not matches
		while(current!=null)
			{
			
			//condition to check if the object exists at the given index or not
			if(obj.equals(current.getToken()))
			{
				return index;
			}
				//pointing the current to the next node
				//and increasing the value of index
				current = current.next;
				index++;
				
		    }
			return -1;
		}
	
	//Returns the node at a given index, or else if not found returns null
	public Node getNode(int index) {
		
		//when index is out bounds return null
		if(index >= size() || index<0)
		{
			return null;
		}
			
		else 
		{ 
		Node current = head;	//variable to store the current node
		int count = 0;			//variable to count and store the index
		
		//loop to reach the index of the node to be returned
		while(count!=index)
		{	
			//pointing the current to the next node
			//and increasing the value of index
			current = current.next;		
			count+=1;  						
		} 
			//if node not found return null
		    if(current==null)
		    	return null;
		    else
		    {
		    	return current;	    	
		    }	    	
		}

	}

	//This method gets the object at the specified index, if it exists.
	public Token get(int index) {
		
		//return null when the index is out of bounds or null
		if(index >= size() || index<0)
		{
			return null;
		}	
		
		else { 
		Node current = head;			//variable to store the current node
		int count = 0;					//variable to count and store the index
		
		//loop to reach the index of the object to be returned
		while(count!=index) {
			
			//pointing the current to the next node
			//and increasing the value of index
			current = current.next;
			count+=1;
			
		} 
		    //if object not found return null
			if(current==null)
		    	return null;
		    else
		    	return current.getToken();
		}
		
	}
	//This method Returns true if this list contains no elements.
	public boolean isEmpty() {
		
		//if size is 0, then it obvious the list is empty
		if(size()==0)
			return true;
		else
			return false;
	}

	//This method return the size of list
	public int size() {
		
		int count =0;			//variable to count the size of the list
		Node current = head;	//node variable to store the current element
		
		//running the loop till the end of the list 
		//until the last node's next point null
		while(current!=null) {
			count++;
			current=current.next;
		}
		
		return count;
	}
	
	@Override
	
	// returns a string containing the list elements 
	public String toString() {
		
		String linklist = "";			//string variable to store the elements coneverted into string
		Node current = head;			//variable to store the current node
		
		//running the loop till the end of the list
		while(current != null)
		{
			//storing the token of the current node into the string
			linklist += current.getToken();
			
			//condition to add space
			if(current.next != null) {
				linklist += " ";
			}
			current = current.next;
		}
			return linklist;
	}
		
	//Method which adds the element to the end of the list
	public boolean add(Token obj) {
		
		//if object is null throw the exception
		if(obj == null)throw new NullPointerException();
		
		//if list is empty then insert at first postion 
		//head and tail are then set equal 
		if(head ==  null) {
			head = tail = new Node(null,null,obj);
			
			return true;
		}
		
		//adding the element at the end of the list
		else {
			Node current = head; 		//variable to store the current node
			
			//loop until the end of the list when last node's next point null
			while(current.next != null) 
			{
			    current =  current.next;
			}
			
			//adding the token obj to list and adjusting the pointers head and next
			current.next = new Node(null,current,obj);
			tail = current.next;
			return true;
		}		
	}
		
	//Inserts the specified element at the specified position in this list. 
	//Shifts the element currently at that position (if any) and any subsequent 
	//elements to the right (adds one to their indices).	
	public boolean add(int index, Token obj) {
		
		//when index is not in range throw exception
		if(index<0 || index>size())throw new IndexOutOfBoundsException();
		
		//when obj is null throw exception
		if(obj == null)throw new  NullPointerException();
		
		//head and tail are then set equal
		if(head == null) 
		{
			head = tail = new Node(null,null,obj);	
			return true;
		}
		
		//if index is equal to the size then add the element to the end of the
		//list by calling the add(token obj) method 
		if(index == size()) 
		{	
			add(obj);
			return true;
		}
		
		//when the token is added to the first position
		//return true when successully added
		if(index == 0) 
		{
			//inserting the object at the given object by adjusting the pointers(head, next, prev) of the node elements
			Node node = new Node(null,null,obj);
			node.next = head;
			head.prev = node;
			head = node;
			
			return true;	
		}
		
		//adding the token object at the given index
		else {
			  Node current = head;			//variable to store the current node
			  int count = 0;				//varaible to count the index
			  
			  //loop until the count matches the index where the
			  //object has to be inserted
			  while(count != index) {
				  current = current.next;
			      count++;
			  }
			  
			  //inserting the object at the given index by adjusting the 
			  //pointers(head, next, prev) of the node elements
			  //return true when successfully added
			  Node node = new Node(null,null,obj);
			  node.next = current;
			  node.prev = current.prev;
			  current.prev.next = node;
			  current.prev = node;
		      
			  return true;
		}
	}
	
	// This method returns true iff the given object is contained in the list. 
	public boolean contains(Token obj) {
		
		//throws excpetion if object is null
		if(obj == null)throw new NullPointerException();
		
		
		else
		{
			Node current = head;			//variable to store the current node
			
			//running the loop until the last node
			while(current!= null) 
			{
				//checking whether the object is equal 
				//to the object pointed by the given node
				if(obj.equals(current.getToken())) {
					return true;
				}
				current = current.next;
				
			}
			return false;
		}
	}

	//This method removes the given object 
	public boolean remove(Token obj) {
		
		//throw exception if obj is null
		if(obj == null)throw new NullPointerException();
		
		//if list is empty return true
		if(head == null) {
		return true;
		}
		//when list is not empty
		else 
		{	
			int index = indexOf(obj); 		//variable to store the returned index of the object
			
			//if the object is in the list the it is successfully removed 
			//if not throw exception
			if(index != -1) {
			remove(index);
			
            return true;
			} throw new NullPointerException();
		}
		     
		}

	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
