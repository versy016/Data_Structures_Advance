package Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class to represent a PlayStation user.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class User {
	private String username;							//variable to store the username of the user
	private int level;									//variabe to store the level	
	private double key;									//variabel for key
	private User parent;								//variable to store a nodes parent node
	private ArrayList<Trophy> trophies; 				//arraylist to store the trophies
	private GameList games; 							//games to store the games
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy"); 
	private Calendar dob = Calendar.getInstance();
	private User left; 									//variable to store the left child of the parent
	private User right;									//variable to store the right child of the parent
	
	//copy constructor to initalize the username, dob and level
	public User(String username, Calendar dob, int level) {
		this.dob = dob;
		this.level = level;
		this.username = username;
		
    }

    /**
     * DO NOT MODIFY THIS METHOD
     * This method uses the username and level to create a unique key.
     * As we don't want the username's hash to increase the level, it's first converted
     * to a floating point, then added to the level.
     * @return the unique key
     */
    public double calculateKey() {
        int hash = Math.abs(username.hashCode());
        // Calculate number of zeros we need
        int length = (int)(Math.log10(hash) + 1);
        // Make a divisor 10^x
        double divisor = Math.pow(10, length);
        // Return level.hash
        return level + hash / divisor;
    }

    //method to return the a string which store the users data
	public String toString() {
    	String trophystr="\n";
    	String str="";
    	
    	//loop to store all the trophies in trophytr
    	for(int i =0; i<getTrophies().size(); i++)
			trophystr +=  getTrophies().get(i).toString()+"\n";
    		
    	str +="User: "+ username + "\n\n"+ "Trophies: "+ trophystr +"\n" + "Games: \n"+ games.toString() + "\n\nBirth Date: " + sdf.format(dob.getTime());		
    	return str;
	} 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getKey() {
		return calculateKey();
	}

	public void setTrophies(ArrayList<Trophy> trophies) {
		this.trophies = trophies;
	}

	public ArrayList<Trophy> getTrophies() {
		return trophies;
	}

	public void setGames(GameList games) {
		this.games = games;
	}

	public GameList getGames() {
		return games;
	}
	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public User getLeft() {
		return left;
	}

	public void setLeft(User left) {
		this.left = left;
	}

	public User getRight() {
		return right;
	}

	public void setRight(User right) {
		this.right = right;
	}

	public User getParent() {
		return this.parent;
	}

	public void setParent(User user) {
		this.parent = user;
			}

	
}
