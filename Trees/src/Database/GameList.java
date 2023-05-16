package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to represent a single linked-list of Database.Game objects.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class GameList {

    public Game head;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
    
    //setting the head of the gamelist
	public GameList(Game head) {
		this.head = head;
    }

	/*method to print the gamelist in the required format 
	 *@games to store the games in the form of string
	 *@current to store the current game
	 *
	 * */
    @Override
	public String toString() {
    	
    	String games="";
    	Game current = head;
    	
    	if(head==null) {
    		return "Empty game list";
    	}
    	else {
    		
    	//loop until it reaches the game	
    	while(current != null) {
    		 
    		games += current.toString();
    		
    		//when next is null go to next line 
    		if(current.getNext() != null) {
    			games += "\n";
    		}
    		current = current.getNext();
    	}
		return games;
		}
    }
    
    /**
     * @current to store the current game 
     * method to add the game to end of the list
     */
	public void addGame(Game game) {
		
		if(game == null)throw new IllegalArgumentException();
		
		if(head == null) {
			head = game;
		}
		
		//when head is not null loop throught the list till the last game
		else {
			Game current = this.head;
			while(current.getNext()!= null) 
			{
				if(current.equals(game))
					return;
				
				current = current.getNext();
			}
			
			//now the current is pointing to the last game, so we set the next to game we want to add and then we set the games next to null 
				current.setNext(game);
				game.setNext(null);
				}
		}
		
	 /**
     * @param current  to store the current game 
     * method to return the game if it exist in the list'
     * @return game if found else null
     * 
     */
	public Game getGame(String string) {
		if(string == null)throw new IllegalArgumentException();
		
		else {
			Game current = this.head;
			
			//when head is not null loop throught the list till the last game 
			while(current !=null) 
			{	
				// if the game is found then we return it
				if(current.getName().equals(string))
				{
					return current;
				}
				current= current.getNext();
			}
		}
		return null;
	}

	 /**
     * @param current  to store the current game 
     * @param temp to store the temporary game which has to be removed
     * @param prev to store the prev game of the game to be removed
     * method to remove the game in the list when a string is passed as a parameter
     * 
     */
	public void removeGame(String string) {
		Game current = getGame(string);	
		if(current != null) {

			//if the game is at the head then firs to the head in temp set the head to its next and the set the temp to null
			if(current == this.head) {
				Game temp = this.head;
				head=head.getNext();
				temp = null;
			}
			
			//we run a while loop checking the prev game next to the game we want to remove 
			//when the game matches we set the prev's next to the games next and the we set the current to null 
			else {
				Game prev = head;
				while(prev.getNext() != current) {
					prev = prev.getNext();
				}
				prev.setNext(current.getNext());
				current.setNext(null);
	
			}
			}
		}
	
	/* method to remove the game in the list when a string is passed as a parameter
    */ 
	
	public void removeGame(Game g) {
		//here i just called the removeGame(string)mmethod and passed the game name as the parameter
		removeGame(g.getName());
	}
}
