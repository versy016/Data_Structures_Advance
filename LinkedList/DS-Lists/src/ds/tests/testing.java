package ds.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import ds.interfaces.Queue;
import ds.students.Calculator;
import ds.students.DSList;
import ds.students.DSQueue;
import ds.students.Node;
import ds.students.Token;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DSList ds = new DSList();
		Token t = new Token(0);
		Token t1 = new Token("lol");
		DSQueue dq = new DSQueue();
		 
		 Calculator calc = new Calculator();
		//ds.add(t);
	/*	
		ds.add(t1);
		ds.add(new Token(3));
		//ds.add(new Token("lmao"));
		System.out.println(ds.size());
        //System.out.println(ds.add(1,new Token(6.0))); 
		System.out.println(ds.toString());
        //System.out.println(ds.indexOf(new Token(0)));
		
		//ds.add(2, new Token(2));
		//Token n = ds.get(2);
		//System.out.println("List.add(int, Token) should insert the specified token at the specified index."+ new Token(2)+ n);
		//System.out.println(ds.contains(new Token("lmao")));
		
		
		//System.out.println(ds.indexOf(new Token("lmao")));
		System.out.println("removed "+"'"+ds.remove(1)+"'");
		System.out.println(ds.size());
		System.out.println(ds.toString());
*/
		//System.out.println(ds.get(2));
       
		ds.add(new Token(1));
		ds.add(new Token(2));
		ds.add(new Token(3));
		//System.out.println(ds.contains(new Token(4)));
	    System.out.println(ds.remove(1));
	    //ds.add(1, new Token(1));
	    //ds.add(4, new Token(5));
		//System.out.println("List.indexOf() should return the correct index"+ 0 + ds.indexOf(new Token(1)));
	    /*
		
		Node c31 = new Node(null, null, new Token(1));
		Node c32 = new Node(null, null, new Token(2));
		Node c33 = new Node(null, null, new Token(3));

		Node chain3 = c31;
		c31.next = c32; c32.prev = c31;
		c32.next = c33; c33.prev = c32;
		

		DSList l = new DSList(chain3);
		int s = l.size();
		
		System.out.println(new DSList(chain3));
		//int s = l.size();
		System.out.println("List.size() should be working for this test"+ 3+ s);
		
		// remember 0 indexing. 
		*/
		/*
		System.out.println(dq.offer(new Token(2)));
		System.out.println(dq.offer(new Token(3)));		
		System.out.println(dq.list.toString());
		System.out.println(dq.list.size());
	*/
		 
	//dq.offer(new Token(4));
	
	//dq.offer(new Token(2.0));
	//dq.offer(new Token("/"));

	
	
//	System.out.println(calc.evaluatePostfix(dq));
	
	
	}}
