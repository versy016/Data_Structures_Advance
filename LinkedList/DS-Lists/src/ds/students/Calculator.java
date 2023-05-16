package ds.students;

import ds.students.Token.Type;

/**
 * @author simont
 *
 */
public class Calculator {

	//using Shunting Yards Algortihm to convert infix expression to postix
	public DSQueue infixToPostfix(DSQueue infix) {
		
		//Instantiating a new stack to store the poped tokens
		DSStack stack = new DSStack();   
		
		//Instantiating a new queue to store the output
		DSQueue output = new DSQueue();
		Node current = infix.list.head;			//node variable to store the current node
		
		//running the while loop until the end of the queue
		while(current != null) 
		{
			
			//condition when token is equal to operand it is added to the output queue
			if(current.getToken().type.equals(Type.OPERAND))
			{
				output.offer(current.getToken());
			}
				
			//condition when token is equal is to operator 
			if(current.getToken().type.equals(Type.OPERATOR)) 
			{    
				//codition if the top of the stack is null 
				if(stack.peek() != null)
				{
					//condition comparing the precedence of the o1 and o2
					if(current.getToken().getPrecedence() <= stack.peek().getPrecedence()) 
					{
						//running the while loop until stack is empty and if the precedence of o1 is less than equal to o2
						while(stack.peek()!=null && current.getToken().getPrecedence() <= stack.peek().getPrecedence()) 
						{
							output.offer(stack.pop());						
						}
					}
					
				}
				
				//pushing the token to the top of the stack
				stack.push(current.getToken());
				
				//when the operator is left bracket push o1 into stack
				if(current.getToken().getOperator() == "(") 
				{
					stack.push(current.getToken());							
				}
				
				//when the operator is right bracket 
				if(current.getToken().getOperator() == ")") 
				{
					//running the loop until the operator is equal to left bracket
					//and adding the poped element into the output
					while(stack.peek().getOperator() != "(") 
					{
						output.offer(stack.pop());
					}
					stack.pop();
				}
			}
			
			//pointing the node to next node
            current = current.next;
            }
		
			//running the loop until stack is empty
			while(stack.peek() != null) 
			{	
				//condition when token is a parenthesis print it is an error
				if(stack.peek().getOperator() == "(" || stack.peek().getOperator() == ")" )
					System.out.println("input error Unmatched Parenthesis");
				
				//poping and adding the poped element to the output queue
				output.offer(stack.pop());
			}		
		return output;
	}

	//method to evaluate the postfix expression
	public double evaluatePostfix(DSQueue exp)
	{
		//Instantiating a new stack to store the pushed tokens
		DSStack stack = new DSStack();   
		Node current = exp.list.head;  			//node variable to store the current node
		
		double result = 0.0;					//variable to store the result
		
		//running while loop till the end of the expression
		while(current != null)	
		{
			//condition when token is equal to operand push the token into the stack
			if(current.getToken().type.equals(Type.OPERAND))
			{
				stack.push(current.getToken());
			}
			
			//condition when token is equal to operator
			if(current.getToken().type.equals(Type.OPERATOR))
			{
				Token E2 = stack.pop();				//temporary token2 to store the poped token
				Token E1 = stack.pop();				//temporary token1 to store the poped token	
				
				//swithc case to evalute the expression
				switch(current.getToken().getOperator()) 
				{
					//when the operator is "*"
					case "*":
					{ 	
						result = E1.getOperand()*E2.getOperand();
						
						//pushing the result into the stack 
						stack.push(new Token(result));
						break;
					}
					
					//when the operator is "*"
					case "/":
					{		
						result = E1.getOperand()/E2.getOperand();
						
						//pushing the result into the stack 
						stack.push(new Token(result));
						break;
					}
					
					//when the operator is "*"
					case "+":
					{	
						result = E1.getOperand()+E2.getOperand();
						
						//pushing the result into the stack 
						stack.push(new Token(result));
						break;
					}
					
					//when the operator is "*"
					case "-":
					{		
						result = E1.getOperand()-E2.getOperand();
						
						//pushing the result into the stack
						stack.push(new Token(result));
						break;
					}				
				} 
			}
			//pointing the node to next node
			current = current.next;
		}
		return result;
	}
}
