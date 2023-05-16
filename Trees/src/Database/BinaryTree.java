package Database;

import java.util.ArrayList;

import Database.Trophy.Rank;


/**
 * Uses a binary search tree to store a database of
 * PlayStation users. Nodes are ordered by user unique key (see the
 * User class for more detail).
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class BinaryTree {

	public User root;				//variable to store the root node of the tree 
	private User parent = root; 	//variable to store the parent node
	User max = root;				// variable to store the node with most platinums


	/**
	 * Making new friends is great. This method should add your new
	 * bestie to your database (tree). Remember that they should be
	 * added according to their key.
	 * @param friend The friend to be added
	 * @return true if  successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean beFriend(User friend) throws IllegalArgumentException {
		if(friend == null)throw new IllegalArgumentException();

		//when the tree is empty we set the root to the friend
		if(root == null) {
			root = friend;
			return true;
		}
		
		//if the tree is not empty we call Insert(root,friend) method
		else {
			return Insert(this.root, friend);
		}

	}

	/**
	 * @param target to store the target node at which we want to insert the friend
	 * 
	 *  this method is called recursively  to insert the friend follwing the rules of BST
	 * */
	private boolean Insert(User target,User friend) {
		
		//when target is null return false
		if(target == friend)
			return false;

		//when the friend's key is less than targets key then we go on the left of the tree as per the BST rules
		if(friend.getKey() < target.getKey()){

			//if the targets left is null then we successfully sets the target left child as friend 
			if(target.getLeft()==null) {
				target.setLeft(friend);
				target.getLeft().setParent(target);
				return true;
			}

			else
				//if the targets left is not null then we recurse through the method
				return Insert(target.getLeft(), friend);
		}
		//when the friend's key is greater than targets key then we go on the right of the tree as per the BST rules
		else{
			//if the targets right is null then we successfully sets the target right child as friend 
			if(target.getRight()==null) {
				target.setRight(friend);
				target.getRight().setParent(target);
				return true;
			}
			else
				//if the targets right is not null then we recurse through the method
				return Insert(target.getRight(), friend);
		}
	}

	/**
	 * Sometimes friendships don't work out. In those cases it's best
	 * to remove that "friend" altogether. This method should remove
	 * all trace of that "friend" in the database (tree).
	 * @param friend the "friend" to remove
	 * @return true if successfully removed, false for all error cases
	 * @throws IllegalArgumentException if "friend" is null
	 */
	public boolean deFriend(User friend) throws IllegalArgumentException {
		if(friend == null)throw new IllegalArgumentException();

		//when tree is empty return false
		if(root == null)
			return false;

		//if tree is not empty then we check that if the friend even exists by calling the search method
		if(search(friend,this.root) == null) {
			return false;
		}
		//if the freind exist, we want to end this friendship so we call the delete(target,friend) method
		else {
			return delete(this.root, friend);
		}
	}
	/**
	 * @param target to store the target node at which we want to insert the friend
	 * 
	 *  this method is called recursively  to remove the friend follwing the rules of BST
	 * */
	private boolean delete(User target, User friend) {
		
		//when the friend's key is less than targets key then we recurse on the left of the tree 
		if(friend.getKey() < target.getKey()){
			parent = target;
			return delete(target.getLeft(), friend);
		}
		//when the friend's key is greater than targets key then we recurse on the right of the tree 
		else if(friend.getKey() > target.getKey()) {
			parent = target;
			return delete(target.getRight(), friend);
		}
		else if(target != friend) {
			return false;
		}
		//when the target matches the friend 
		else if(target == friend)
		{
			//if target doesnt have any child we simply remove it  
			if(target.getLeft() == null && target.getRight() == null) {
				
				//we just set parent left null if the target is  left child of the parent  
				if(parent.getLeft() == target) {
					parent.setLeft(null);
					return true;
				}
				else {

					//we just set parent right null if the target is  right child of the parent  
					parent.setRight(null);
					return true;
				}

			}
			//if target doesnt have one left child but has a right child we remove the target and set its child to parents left   
			else if(target.getLeft() == null) {

				//if parents left child is target we just set parent left to the target's right child   
				if(parent.getLeft() == target) {
					parent.setLeft(target.getRight());
					return true;
				}
				else {
					//if parents right child is target we just set parent right to the target's right child of  
					parent.setRight(target.getRight());
					return true;
				}
			}

			//if target doesnt have right child but has a left child we remove the target and set its child to parents left
			else if(target.getRight()== null) {

				//if parents left child is target we just set parent left to the target's left child   
				if(parent.getLeft() == target) {
					parent.setLeft(target.getLeft());
					return true;
				}
				//if parents right child is target we just set parent left to the target's left child   
				else {
					parent.setRight(target.getLeft());
					return true;
				}
			}
			
			//when target has both the left and right child
			else if(target.getLeft() != null && target.getRight() != null){
				
				//we call the maxvalue method to return the maximum value of the targets left tree
				User replacement = maxValue(target.getLeft());
				
				//if target is root 
				if(target == root) {
					
					//we first call the delete method to remove the max value so that it doesnt occurr twice in the tree 
					delete(root,replacement);
					
					//here we just set the roots left and right to replacement's left and right child 
					replacement.setRight(root.getRight());
					replacement.setLeft(root.getLeft());
					
					//we set the root to replacement and then set its left and right to replacement's left right child 
					root = replacement;
					root.setRight(replacement.getRight());
					root.setLeft(replacement.getLeft());
					return true;
				}
				
				else {
					// if the target is not the root and the targets parent left child is equal to target 
					if(parent.getLeft() == target) {
						// we take a temporary variable here and set it equal to the parent
						User temp = parent;
						
						//we call the delete method to remove the max value so that it doesnt occurr twice in the tree 
						delete(root,replacement);
						
						//here we just set the temp left to replacementd i.e we set the parents left to replacement
						temp.setLeft(replacement);
						
						//here we set replacement's left right to targets left and right 
						replacement.setRight(target.getRight());
						replacement.setLeft(target.getLeft()); 	
						return true;

					}
					// if the target is not the root and the targets parent right child is equal to target 
					else if(parent.getRight() == target) {
						// we take a temporary variable here and set it equal to the parent
						User temp = parent;
						
						//we call the delete method to remove the max value so that it doesnt occurr twice in the tree 
						delete(root,replacement);
						
						//here we just set the temp left to replacementd i.e we set the parents left to replacement
						temp.setRight(replacement);
						
						//here we set replacement's left right to targets left and right 
						replacement.setRight(target.getRight());
						replacement.setLeft(target.getLeft()); 	
						return true;
					}
				}
			}
		}

		return false;
	}
	
	/**
	 * method to calculate the value of a tree*/
	private User maxValue(User left) {
		
		if(left == null)throw new NullPointerException();
		
		if(left.getRight() == null) {
			return left;
		}
		else {
			return maxValue(left.getRight());
		}
	}

	/**
	 * In your quest to be the very best you need to know how many
	 * of your friends are ranked higher than you. This method should
	 * return the number of higher ranked users that the provided reference
	 * user, or zero if there are none (woot!).
	 * @param reference The starting point in the search
	 * @return Number of higher ranked users or -1 if user not found
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countBetterPlayers(User reference) throws IllegalArgumentException {

		if(reference == null)throw new IllegalArgumentException();
		
		//when root is  null just return -1;
		if(root == null )
			return -1;
		
		//we search for the user that is it even exist or not 
		else if(search(reference,this.root) == null) {
			return -1;
		}
		
		//if user exist we check its level with the root first so that if its less then the root we starightaway calculate the players on the right subtree of the root  
		else if(reference.getLevel() < root.getLevel()) {
			
			//we set referecne left to roots left and the call the countBetter method 
			reference.setLeft(root.getLeft());
			return 1 + countBetter(root.getLeft(),reference)  + countBetter(root.getRight(),reference);
		}
		else
			return countBetter(root.getRight(),reference);
	}

	private int countBetter(User target,User ref) {
		
		//here we check if the target's level is greater than ref's tthen we proceed further 
		if(target.getLevel() > ref.getLevel()) {
			
			//if the targets left and right are not null  we recursively call the method again for the left and right of the taregt and increase the no. of better players by 1
			if(target.getLeft()!= null && target.getRight()!=null)
				return 1 + countBetter(target.getLeft(),ref) + countBetter(target.getRight(),ref);  

			//else if the target's right is not null and left is null then we recurse the method for targets right and increase the no. of better players by 1
			else if(target.getRight()!=null) 
				return 1 + countBetter(target.getRight(),ref);

			else if(target.getLeft() != null)
				
				//else if the target's left is not null and right is null then we recurse the method for targets left and increase the no. of better players by 1 
				return 1 + countBetter(target.getLeft(), ref);
			else 
				return 1;

		}
		// when the targets right level is greater then we also need to calculte targets right tree coz it contains all the better players then the target
		else if(target.getRight() != null && target.getRight().getLevel() > ref.getLevel())
			return countBetter(target.getRight(),ref);
		return 0;
	}

	/**
	 * method to search through the tree and return the user if found else return null
	 * @param find the user to be find
	 * @param target the targeted user
	 * */
	private User search(User find, User target) {

		//when the target matches the user to be found we return the user
		if(find == target) {
			return find;
		}
		
		//if user to be found key is less than the targets ket we go on the left tree of the of target
		else if(find.getKey() < target.getKey()){
			
			//if the targets left is not null we recurse through targets left node
			if(target.getLeft()!=null) {
				return search(find,target.getLeft());
			}
		}
		//if user to be found key is greater than the targets ket we go on the right tree of the of target		
		else if(find.getKey() > target.getKey()){
			
			//if the targets right is not null we recurse through targets right node
			if(target.getRight()!=null) {
				return search(find,target.getRight());
			}
		}
		else {
			return null;
		}
		return null;
	}

	/**
	 * Bragging rights are well earned, but it's good to be sure that you're actually
	 * better than those over whom you're lording your achievements. This method
	 * should find all those friends who have a lower level than you, or zero if
	 * there are none (you suck).
	 * @param reference The starting point in the search
	 * @return Number of lower ranked users
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countWorsePlayers(User reference) throws IllegalArgumentException {
		if(reference == null)throw new IllegalArgumentException();
		
		//when root is  null just return -1;
		if(root == null )
			return -1;
		
		//we search for the user that is it even exist or not 
		else if(search(reference,this.root) == null) {
			return -1;
		}
		//if user exist we check its level with the root first so that if its greater then the root we starightaway calculate the players on the left subtree of the root  
		else if(reference.getLevel() > root.getLevel()) {
			reference.setRight(root.getRight());
			return 1 + countWorse(root.getLeft(),reference)  + countWorse(root.getRight(),reference);
		}
		else
			return countWorse(root.getLeft(),reference);
	}

	private int countWorse(User target,User ref) {
		
		//here we check if the target level is less than ref's tthen we proceed further 
		if(target.getLevel() < ref.getLevel()) {
			
			//if the targets left and right are not null  we recursively call the method again for the left and right of the taregt and increase the no. of worst players by 1
			if(target.getLeft()!= null && target.getRight()!=null)
				return 1 + countWorse(target.getLeft(),ref) + countWorse(target.getRight(),ref);  

			//else if the target's right is not null and left is null then we recurse the method for targets right and increase the no. of worst players by 1
			else if(target.getRight()!=null) 
				return 1 + countWorse(target.getRight(),ref);

			//else if the target's left is not null and right is null then we recurse the method for targets left and increase the no. of worst players by 1 
			else if(target.getLeft() != null)
				return 1 + countWorse(target.getLeft(), ref);
			else 
				return 1;

		}
		// when the targets left level is less then we also need to calculte targets left tree coz it contains all the worst players then the target
		else if(target.getLeft() != null && target.getLeft().getLevel() < ref.getLevel())
			return countWorse(target.getLeft(),ref);
		return 0;
	}



	/**
	 * The best player may not necessarily be measured by who has the highest level.
	 * Platinum trophies are the holy grail, so it would be good to know who has the
	 * most. This method should return the user with the highest number of platinum trophies.
	 * @return the user with the most platinum trophies, or null if there are none
	 */
	public User mostPlatinums() {
		if(root == null) {
			return null;
		}
		
		return checkPlatinums(root, root);
	}

	/**
	 * 
	 * Method to calculate the players which have most platinums
	 *  @param countplat to count platinums
		@param countplat1  to count platinums
		 @param countgold to count gold trophies 
		 @param countgold1 to count gold trophies
		 @param countbronze to count silver trophies
		 @param countbronze1 to count silver trophies
		 @param countsilver to count silver trophies
		 @param ountsilver1 to count silver trophies
	 * */
	private User checkPlatinums(User player, User player2) {
		int countplat = 0;
		int countplat1 = 0;
		int countgold = 0;
		int countgold1 =0;
		int countbronze =0;
		int countbronze1 =0;
		int countsilver =0;
		int countsilver1 =0;
		
		//calculating the player's trophies
		for(int i = 0; i<player.getTrophies().size(); i++) {
			if(player.getTrophies().get(i).getRank() == Rank.PLATINUM) 
				countplat++;

			if(player.getTrophies().get(i).getRank() == Rank.GOLD) 
				countgold++; 

			if(player.getTrophies().get(i).getRank() == Rank.SILVER) 
				countsilver++; 

			if(player.getTrophies().get(i).getRank() == Rank.BRONZE) 
				countbronze++; 
		}
		//calulating the player2's trophiees
		for(int i = 0; i < player2.getTrophies().size(); i++) {
			if(player2.getTrophies().get(i).getRank() == Rank.PLATINUM) 
				countplat1++; 

			if(player2.getTrophies().get(i).getRank() == Rank.GOLD) 
				countgold1++; 


			if(player2.getTrophies().get(i).getRank() == Rank.SILVER) 
				countsilver1++; 

			if(player2.getTrophies().get(i).getRank() == Rank.BRONZE) 
				countbronze1++; 

		}
			// both players are root max's left to roots left adn right to roots right
			if(player == root && player2 == root) {
				max = root;
				max.setRight(root.getRight());
				max.setLeft(root.getLeft());
			}
			// checking which player has more platinums then set the player to max
			if(countplat > countplat1) {
				max = player;
				max.setRight(player.getRight());
				max.setLeft(player.getLeft());
			}
			// checking which player has more platinums then set the player to max
			else if(countplat < countplat1){
				max = player2;
				max.setRight(player2.getRight());
				max.setLeft(player2.getLeft());
			}
			// checking which player has more gold then set the player to max
			else if(countgold > countgold1)
			{
				max = player;
				max.setRight(player.getRight());
				max.setLeft(player.getLeft());
			}

			// checking which player has more gold then set the player to max
			else if(countgold < countgold1){
				max = player2;
				max.setRight(player2.getRight());
				max.setLeft(player2.getLeft());
			}

			// checking which player has more silver then set the player to max
			else if(countsilver > countsilver1)
			{
				max = player;
				max.setRight(player.getRight());
				max.setLeft(player.getLeft());
			}

			// checking which player has more silver then set the player to max
			else if(countsilver < countsilver1){
				max = player2;
				max.setRight(player2.getRight());
				max.setLeft(player2.getLeft());
			}
			// checking which player has more bronze then set the player to max
			else if(countbronze > countbronze1)
			{
				max = player;
				max.setRight(player.getRight());
				max.setLeft(player.getLeft());
			}

			// checking which player has more bronze then set the player to max
			else if(countbronze < countbronze1){
				max = player2;
				max.setRight(player2.getRight());
				max.setLeft(player2.getLeft());
			}
		//if the left and right of the player is not null the the check the platinums for players right and left
		if(player.getLeft()!= null && player.getRight()!=null) {
			checkPlatinums(player.getLeft(),max);
			checkPlatinums(player.getRight(),max);
		}  
		
		//if the right of the player is not null the the check the platinums for players right 
		else if(player.getRight()!=null) 
			checkPlatinums(player.getRight(),max);

		//if the left of the player is not null the the check the platinums for players left
		else if(player.getLeft() != null)
			checkPlatinums(player.getLeft(),max);
		
		return max;


	}


	/**
	 * You or one of your friends bought a new game! This method should add it to their
	 * GameList.
	 * @param username The user who has bought the game
	 * @param game The game to be added
	 */
	public void addGame(String username, Game game) throws IllegalArgumentException {
		if(username == null || game == null)throw new IllegalArgumentException();

		//calling the add method the add the game
		add(root,username,game);
	}

	public void add(User target,String username, Game game) {

		//if the username is equal to target's username then check if the game exists in targets game collection
		//if not then add the game to targets collection
		if(username == target.getUsername()) {
			if(target.getGames().getGame(game.toString())==null)
				target.getGames().addGame(game);}

		else {
			//if the left and right of the target is not null the the check that if the the username is equal to target right and left's username 
			if(target.getLeft()!= null && target.getRight()!=null) {
				add(target.getLeft(),username,game);
				add(target.getRight(),username,game);}  

			//if the right of the player is not null the the check that if the the username is equal to target right 
			else if(target.getRight()!=null) 
				add(target.getRight(),username,game);

			//if the left of the player is not null the the check that if the the username is equal to target's left
			else if(target.getLeft() != null)
				add(target.getLeft(),username, game);
		}
	}

	/**
	 * You or one of your friends achieved a new trophy! This method should add it to
	 * their trophies.
	 * @param username The user who has earned a new trophy
	 * @param trophy The trophy to be added   
	 */
	public void addTrophy(String username, Trophy trophy) throws IllegalArgumentException {
		if(username == null || trophy == null)throw new IllegalArgumentException();
		
		//calling the add1 method to the add the trophy
		add1(root,username,trophy);

	}
	public void add1(User target,String username, Trophy trophy) {
		
		//if the username is equal to target's username then check if the trophy exists in targets trophy collection
		//if not then add the trophy to targets collection
		if(username == target.getUsername()) {
			if(target.getTrophies().contains(trophy)==true) 
				return;	
			else
				target.getTrophies().add(trophy);
		}
		else {
			//if the left and right of the target is not null the the check that if the the username is equal to target right and left's username 
			if(target.getLeft()!= null && target.getRight()!=null) {
				add1(target.getLeft(),username,trophy);
				add1(target.getRight(),username,trophy);}  

			//if the right of the player is not null the the check that if the the username is equal to target right 
			else if(target.getRight()!=null) 
				add1(target.getRight(),username,trophy);

			//if the left of the player is not null the the check that if the the username is equal to target's left
			else if(target.getLeft() != null)
				add1(target.getLeft(),username, trophy);
		}
	}


	/**
	 * You or one of your friends has gained one level! This is great news, except that
	 * it may have ruined your tree structure! A node move may be in order.
	 * @param username The user whose level has increased
	 */
	public void levelUp(String username) throws IllegalArgumentException {
		if(username == null)throw new IllegalArgumentException();
		
		//calling the level method to levelup
		level(root,username);
	}

	private User level(User target,String username) {

		//if the username is equal to target's username then increase the targets level by 1
		if(username == target.getUsername()) {
			
			//after increasing targets level the tree is now against BST rule so we defriend target and add again to maintain BST rule as breaking rules is bad
			target.setLevel(target.getLevel()+1);
			deFriend(target);
			Insert(root, target);
			return target;
		}
		else {
			
			//if the left and right of the target is not null the the check that if the the username is equal to target right and left's username 
			if(target.getLeft()!= null && target.getRight()!=null) {
				level(target.getLeft(),username);
				level(target.getRight(),username);}  

			//if the right of the player is not null the the check that if the the username is equal to target right 
			else if(target.getRight()!=null) 
				level(target.getRight(),username);

			//if the left of the player is not null the the check that if the the username is equal to target's left
			else if(target.getLeft() != null)
				level(target.getLeft(),username);
		}
		return null;
	}

	/**
	 * As your friends list grows, adding with regular binary tree rules will
	 * result in an unbalanced and inefficient tree. One approach to fix this
	 * is to implement an add method that uses AVL balancing. This method should
	 * work in the same way as beFriend, but maintain a balanced tree according to
	 * AVL rules.
	 * @param friend The friend to be added
	 * @return true if  successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean addAVL(User friend) throws IllegalArgumentException {
		if(friend == null)throw new IllegalArgumentException();
		
		//when root is empty set root to friend
		if(root == null) {
			root = friend;
			return true;
		}
		
		//to add the freind we call the insertAVL method
		if(insertAVL(this.root,friend) != null)
			return true;
		else 
			return false;
			
	}
	/**
	 * method toinsert the friend according to bst rule and also balance the tree while adding
	 * @param target the target where friend has to be added
	 * @param friend the friend to be added
	 * @param bal the tree balance
	 * @param the left right balance of a parent node 
	 * */
	private User insertAVL(User target, User friend) {

		//calling insert to add the friend to the treee
		Insert(target, friend);
		
		int bal = Balance(root); // calculating the balance
		
		//if root baance is not equal to 2 then we again check for the balance of friend's parent parent
		if(bal != 2)
			bal = Balance(friend.getParent().getParent());
		
		int balLR = Balance(friend.getParent()); //get the left right balance of the friend's parent
				
		//when the bal is -2 and friend's bakLR  is -1 we rotate the tree right of friend's parent 
		if(bal == -2  && balLR == -1) {
			rotateRight(friend.getParent());
			
			//calculating the balance again to check if everythings is balanced 
			balLR = Balance(friend.getParent());
		}
		
		//when the bal is -2 and friend's balLR  is 1 we first rotate friend's parent's parent left and the the tree right of friend's parent 
		if(bal == -2  && balLR == 1) {
			rotateleft(friend.getParent().getParent());
			rotateRight(friend.getParent());
			
		}
		
		//when the bal is 2 and friend's bakLR  is 1 we rotate the tree left of friend's parent 
		 if(bal == 2  && balLR == 1) {
			rotateleft(friend.getParent().getParent());
			
			//calculating the balance again to check if everythings is balanced 
			 balLR = Balance(friend.getParent());
			}
		 
		//when the bal is 2 and friend's balLR  is -1 we rotate the tree right of friend's parent's parent and then rotate left of the friend''s parent 
		if(bal == 2  && balLR == -1) {
			
			
			rotateRight(friend.getParent());
			rotateleft(root);
		}
		
		return target;
	}

	/**
	 * method to rotate right
	 * @param temp , temporary user */
	private void rotateRight(User user) {

		if(user== null)
			return;
		
		//first we set temp = user's left child
		User temp = user.getLeft();
		
		//then we set temp left and right child equal to user's left right child
		temp.setLeft(user.getLeft().getLeft());
		temp.setRight(user.getLeft().getRight());
		
		//then we set user's left to temps right
		user.setLeft(temp.getRight());
		
		//and finally we set user to temps right
		temp.setRight(user);
		
		//then we set temp's parent equal to  user'parent
		temp.setParent(user.getParent());
		
		//then we set temp's left and right child parent to temp 
		temp.getLeft().setParent(temp);
		temp.getRight().setParent(temp);
		
		//if temp's parent = rot then root is temp
		if(temp.getParent() == null) {
			root = temp;	
		}
		//otherwise set temp's parent right to temp 
		else	
			temp.getParent().setRight(temp);


		}

	private void rotateleft(User user) {
		
		if(user == null) {
			return;
		}
		//first we set temp = user's right child
		User temp = user.getRight();
		
		//then we set temp left and right child equal to user's left right child
		temp.setLeft(user.getRight().getLeft());
		temp.setRight(user.getRight().getRight());
		
		//then we set user's right to temps left
		user.setRight(temp.getLeft());
		
		//then we set user to temps left
		temp.setLeft(user);
		
		//then we set temp's parent equal user's parent 
		temp.setParent(user.getParent());

		//then we set temp's left and right child parent to temp 
		temp.getLeft().setParent(temp);
		temp.getRight().setParent(temp);
		
		//if temp's parent = rot then root is temp
		if(temp.getParent() == null) {
			root = temp;	
		}
		else	
			//otherwise set temp's parent right to temp 
			temp.getParent().setRight(temp);
	
	}

	//method to calculate the height of left subtree
	private int calHeightLeft(User user) {
		if(user == null) {
			return 0;
		}
		
		if(user.getLeft() == null) {
			return 0;
		}
		
		else
		return 1 + calHeightLeft(user.getLeft());
	}
		//method to calculate the height of right subtree
		private int calHeightRight(User user) {
		if(user == null) {
			return 0;
		}
		
		if(user.getRight() == null) {
			return 0;
		}
		else
		return 1 + calHeightRight(user.getRight());
	}
	
	//method to calculate the balance of user 
	private int Balance(User user) {
		if(user == null) {
			return 0;
		}
		else return  calHeightRight(user) - calHeightLeft(user);
	}
	/**
	 * A nice, neat print-out of your friends would look great in the secret scrap-book
	 * that you keep hidden underneath your pillow. This method should print out the
	 * details of each user, traversing the tree in order.
	 * @return A string version of the tree
	 */
	public String toString() {
		
		//declaring a stringbuilder to store the nodes converted into string
		StringBuilder sb = new StringBuilder();
		
		//calling string method to get the string version of tree
		string(root,sb);
		
		int last = sb.lastIndexOf("\n");		//variable to calculate the last index "\n"
		sb.delete(last, sb.length());			//delete the last index of "\n" to remove the extra line at the end
		return sb.toString();
	}

	private void string(User node, StringBuilder sb) {
		if(node == null) 
			return;
		else {
			//recursiively calling the left of node till it reaches the last node on left subtree
			string(node.getLeft(),sb);
			
			//after reaching the last node on the left subtree append it to the string builder
			sb.append(node.toString());
			sb.append("\n");
			
			//now we recursiively call the right of node till it reaches the last node on right subtree
			string(node.getRight(),sb);
		}
	}


}
