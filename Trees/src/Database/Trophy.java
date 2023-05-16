package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to represent a PlayStation game trophy. A trophy comes in
 * four ranks: bronze, silver, gold and platinum. The date the trophy was
 * earned and its respective game is also stored.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class Trophy {
    public enum Rank {
		BRONZE, GOLD, SILVER, PLATINUM
		}

	public enum Rarity {
		RARE, ULTRA_RARE, UNCOMMON, COMMON, VERY_RARE;
	}

	private String name;
	private Rank rank; 
	private Rarity rarity;
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
	private Calendar obtained = Calendar.getInstance();
	private Game game; 
	public Trophy() {}
	
	//copy constructor to initialize the name, rank, rarity ,date obtained, game 
    public Trophy(String name, Rank rank, Rarity rarity, Calendar obtained, Game game) {
    	this.name = name;
    	this.rank = rank;
    	this.rarity = rarity;
    	this.obtained = obtained;
    	this.game = game;
    }

    @Override
    //to string method to return the trophies in string format
	public String toString() {
		return  '"'+name+'"' +", rank: " + rank + ", rarity: " + rarity + ", obtained on: " + sdf.format(obtained.getTime());			 
				}

    public void setName(String name) {
		this.name = name;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public void setObtained(Calendar obtained) {
		this.obtained = obtained;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

    public String getName() {
		return this.name;
	}

	public Rank getRank() {
		return this.rank;
	}

	public Rarity getRarity() {
		return this.rarity;
	}

	public Calendar getObtained() {
		return this.obtained;
	}

	public Game getGame() {
		return this.game;
	}

}
