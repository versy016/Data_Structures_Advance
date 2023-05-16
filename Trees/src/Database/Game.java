package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to represent a PlayStation game.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class Game {

	private String name;											//string variable to store the game name
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");	//simple date format to print in the date in the required format
	private Calendar released = Calendar.getInstance();				//variable calender to store the date
	private Game next; 												//obje to store the reference of next game
	private int totalTrophies;										//variable to store the total trophies
    public Game() {}												//array list to store the games
    
   
    @Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((released == null) ? 0 : released.hashCode());
		result = prime * result + ((sdf == null) ? 0 : sdf.hashCode());
		result = prime * result + totalTrophies;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (released == null) {
			if (other.released != null)
				return false;
		} else if (!released.equals(other.released))
			return false;
		if (sdf == null) {
			if (other.sdf != null)
				return false;
		} else if (!sdf.equals(other.sdf))
			return false;
		if (totalTrophies != other.totalTrophies)
			return false;
		return true;
	}
	
	//counstrutor to initialize the game name, date relaeased and totaltrophies
	public Game(String name, Calendar released, int totalTrophies) {
    	this.name = name;
    	this.released = released; 
    	this.totalTrophies = totalTrophies;
    }

	//method to print the string in the required format
    @Override
	public String toString() {
		return '"'+ name +'"' + ", released on: "  + sdf.format(released.getTime()) ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReleased(Calendar released) {
		this.released = released;
	}

	public void setTotalTrophies(int totalTrophies) {
		this.totalTrophies = totalTrophies;
	}

	public Calendar getReleased()
	{
		return this.released;
	}

	public int getTotalTrophies() 
	{
		return this.totalTrophies;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setNext(Game game) 
	{
		this.next = game;
	}

	public Game getNext() {
		return this.next;
	}
}
